package com.jenu.gt.familytree;

import java.util.List;
import java.util.Scanner;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.core.FamilyTree;
import com.jenu.gt.familytree.relex.RelationExtractor;
import com.jenu.gt.familytree.relex.SimpleRelationExtractor;
import com.jenu.gt.familytree.util.DataLoader;

public class Main {

	public static void main(String[] args) {
		final FamilyTree ftree = DataLoader.loadDefaultFamilyTree();
		final RelationExtractor relEx = new SimpleRelationExtractor();

		try (Scanner scanner = new Scanner(System.in)) {

			while (doContinue(scanner)) {
				System.out.println("Enter Name (Case Sensitive)\n");
				final String name = scanner.next();
				final Member member = ftree.getMember(name);

				if (member == null) {
					System.out.println("Member not found!!\n");
					continue;
				}

				final String relation = getRelation(scanner);
				System.out.println("\nOutput:\n");

				findRelation(relEx, relation, member);
			}
		} catch (Exception e) {
			System.out.println("Error while finding relation." + e.getMessage());
		}
	}

	private static void findRelation(RelationExtractor relEx, String relation, Member member) {
		switch (relation) {
		case "1":
			final Member father = relEx.father(member);
			print(father);
			break;

		case "2":
			final Member mother = relEx.mother(member);
			print(mother);
			break;

		case "3":
			final Member spouse = relEx.spouse(member);
			print(spouse);
			break;

		case "4":
			final List<Member> children = relEx.children(member);
			print(children);
			break;

		case "5":
			final List<Member> sons = relEx.sons(member);
			print(sons);
			break;

		case "6":
			final List<Member> daughters = relEx.daughters(member);
			print(daughters);
			break;

		case "7":
			final List<Member> brothers = relEx.brothers(member);
			print(brothers);
			break;

		case "8":
			final List<Member> sisters = relEx.sisters(member);
			print(sisters);
			break;

		case "9":
			final List<Member> grandDaughters = relEx.grandDaughters(member);
			print(grandDaughters);
			break;

		case "10":
			final List<Member> cousins = relEx.cousins(member);
			print(cousins);
			break;

		case "11":
			final List<Member> brotherInLaw = relEx.brotherInLaws(member);
			print(brotherInLaw);
			break;

		case "12":
			final List<Member> sisterInLaw = relEx.sisterInLaws(member);
			print(sisterInLaw);
			break;

		case "13":
			final List<Member> maternalAunt = relEx.maternalAunts(member);
			print(maternalAunt);
			break;

		case "14":
			final List<Member> paternalAunt = relEx.paternalAunts(member);
			print(paternalAunt);
			break;

		case "15":
			final List<Member> maternalUncle = relEx.maternalUncles(member);
			print(maternalUncle);
			break;

		case "16":
			final List<Member> paternalUncle = relEx.paternalUncles(member);
			print(paternalUncle);
			break;

		default:
			System.out.println("Invalid Relation");
			break;
		}
	}

	private static boolean doContinue(Scanner scanner) {
		displayOptions();
		return scanner.nextInt() == 1;
	}

	private static void displayOptions() {
		System.out.println("\n------------------ Family Tree ------------------");
		System.out.println("Select a number");
		System.out.println("1. Find relative");
		System.out.println("2. Exit\n");
	}

	private static String getRelation(Scanner scanner) {
		displayRelations();
		return scanner.next();
	}

	private static void displayRelations() {
		System.out.println("\n--------- Select a relation number ---------");
		System.out.println("1. Father");
		System.out.println("2. Mother");
		System.out.println("3. Spouse");
		System.out.println("4. Children");
		System.out.println("5. Sons");
		System.out.println("6. Daughters");
		System.out.println("7. Brothers");
		System.out.println("8. Sisters");
		System.out.println("9. Grand Daughters");
		System.out.println("10. Grand Sons");
		System.out.println("11. Cousins");
		System.out.println("12. Brother-In-Laws");
		System.out.println("13. Sister-In-Laws");
		System.out.println("14. Maternal Aunts");
		System.out.println("15. Paternal Aunts");
		System.out.println("16. Maternal Uncles");
		System.out.println("17. Paternal Uncles");
		System.out.println();
	}

	private static void print(Member member) {
		if (member == null) {
			System.out.println("No relative found!!");
			return;
		}
		System.out.println(member.getName());
	}

	private static void print(List<Member> members) {
		if (members == null || members.isEmpty()) {
			System.out.println("No relative found!!");
			return;
		}
		members.forEach(x -> System.out.print(x.getName() + "  "));
	}

}
