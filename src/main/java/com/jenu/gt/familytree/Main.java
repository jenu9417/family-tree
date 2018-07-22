package com.jenu.gt.familytree;

import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.core.FamilyTree;
import com.jenu.gt.familytree.relation.core.RelationManager;
import com.jenu.gt.familytree.relation.logger.LoggerManager;
import com.jenu.gt.familytree.relation.type.Relation;
import com.jenu.gt.familytree.util.DataLoader;
import com.jenu.gt.familytree.util.LogUtil;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	static {
		LoggerManager.initialize();
		RelationManager.initialize();
	}

	public static void main(String[] args) {
		final FamilyTree ftree = DataLoader.loadDefaultFamilyTree();
		LOGGER.info("Default family data set of 'King Shan' initialized");
		try (Scanner scanner = new Scanner(System.in).useDelimiter("\\n")) {

			while (doContinue(scanner)) {
				LOGGER.info("Enter Name (Case Sensitive)\n");
				final String name = scanner.next();
				final Member member = ftree.getMember(name);

				if (member == null) {
					LOGGER.warning("Member not found!!\n");
					continue;
				}

				LOGGER.info("Enter Relation (Case Sensitive)\n");
				final String relationChoice = scanner.next();
				final Optional<Relation> relation = RelationManager.getRelation(relationChoice);

				if (relation.isPresent()) {
					relation.get().findAndDisplayRelation(member);
				} else {
					LogUtil.logOutput(LOGGER, "Invalid relation. Please mention a valid relation!!");
				}

			}

			LOGGER.info("Exiting family tree !!");
		} catch (Exception e) {
			LOGGER.severe("Error while finding relation." + e.getMessage());
		}
	}

	private static boolean doContinue(Scanner scanner) {
		displayOptions();
		switch (scanner.nextInt()) {
		case 1:
			return true;

		case 2:
			displayRelaions();
			return doContinue(scanner);

		default:
			return false;
		}
	}

	private static void displayOptions() {
		LOGGER.info("\n\n------------------ Family Tree ------------------\n");
		LOGGER.info("# ----- Select a number ----- #");
		LOGGER.info("1. Find relative");
		LOGGER.info("2. List avaiable relations");
		LOGGER.info("3. Exit\n");
	}

	private static void displayRelaions() {
		final StringBuilder relationBuilder = new StringBuilder();
		relationBuilder.append("[ ");
		RelationManager.getAllRelationNames().stream().forEach(x -> {
			relationBuilder.append(x);
			relationBuilder.append(", ");
		});
		relationBuilder.append(" ]");

		LogUtil.logOutput(LOGGER, relationBuilder.toString());
	}

}
