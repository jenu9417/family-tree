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

public class RelationManager {

	private static final Map<String, Relation> RELATION_MAP = new HashMap<>();

	private static final Logger LOGGER = Logger.getLogger(RelationManager.class.getName());

	private RelationManager() {
		throw new IllegalAccessError("Access denied!!");
	}

	public static void initialize() {
		try {
			scanAndRegisterRelationships();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error while scanning relationships. Shutting down system.", e);
			System.exit(0);
		}
	}

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

	public static Optional<Relation> getRelation(String relation) {
		return Optional.ofNullable(RELATION_MAP.get(relation));
	}

	public static Set<String> getAllRelationNames() {
		return RELATION_MAP.keySet();
	}

}
