package com.jenu.gt.familytree.relation.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.reflections.Reflections;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.relation.type.Relation;

/**
 * The Class RelationManager. Works a factory of {@link Relative} annotated
 * classes. <br>
 * <br>
 * Scans {@link Relative} annotated classes at run time, and stores their
 * instances in a HashMap, with {@link Relative#value()} as the key.
 * 
 * @author janardhanan.s
 */
public class RelationManager {

	/** The Constant RELATION_MAP. */
	private static final Map<String, Relation> RELATION_MAP = new HashMap<>();

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(RelationManager.class.getName());

	/**
	 * Private constructor to avoid object instantiation.
	 */
	private RelationManager() {
		throw new IllegalAccessError("Access denied!!");
	}

	/**
	 * Initialize. <br>
	 * <br>
	 * Invokes {@link RelationManager#scanAndRegisterRelationships()} method.
	 * Incase of any exception, {@link System#exit(int)} is invoked, with a
	 * status of 0.
	 */
	public static void initialize() {
		try {
			scanAndRegisterRelationships();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while scanning relationships. Shutting down system.", e);
			System.exit(0);
		}
	}

	/**
	 * Scan and register relationships. Scans the classes annotated as
	 * {@link Relative} under the package 'com.jenu.gt.familytree.relation', and
	 * stores their instances in a HashMap.
	 *
	 * @throws InstantiationException
	 *             the instantiation exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 */
	private static void scanAndRegisterRelationships() throws InstantiationException, IllegalAccessException {
		LOGGER.info("Initiating scanning and registering of relationships.");
		final Reflections reflections = new Reflections("com.jenu.gt.familytree.relation");
		final Set<Class<? extends Object>> allClasses = reflections.getTypesAnnotatedWith(Relative.class);

		for (Class<? extends Object> c : allClasses) {
			final String key = c.getDeclaredAnnotation(Relative.class).value();
			final Relation value = (Relation) c.newInstance();

			RELATION_MAP.put(key, value);
		}

		LOGGER.info("Scanning and registering relationships completed.");
	}

	/**
	 * Gets the relation.
	 *
	 * @param relation
	 *            the relation
	 * @return the relation
	 */
	public static Optional<Relation> getRelation(String relation) {
		return Optional.ofNullable(RELATION_MAP.get(relation));
	}

	/**
	 * Gets all relation names.
	 *
	 * @return the all relation names
	 */
	public static Set<String> getAllRelationNames() {
		return RELATION_MAP.keySet();
	}

}
