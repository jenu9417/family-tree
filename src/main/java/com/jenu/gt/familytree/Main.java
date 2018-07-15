package com.jenu.gt.familytree;

import java.util.List;
import java.util.Scanner;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.core.FamilyTree;
import com.jenu.gt.familytree.relex.RelationExtractor;
import com.jenu.gt.familytree.relex.SimpleRelationExtractor;
import com.jenu.gt.familytree.util.DataLoader;

public class Main {

	private static final Scanner IN = new Scanner(System.in);

	public static void main(String[] args) {
		final FamilyTree ftree = DataLoader.getLoadedFamilyTree();
		final RelationExtractor relEx = new SimpleRelationExtractor();

		while (doContinue()) {
			System.out.println("Enter name and relation");
			final String name = IN.next();
			final String relation = IN.next();
			final Member member = ftree.getMember(name);

			System.out.println("\nOutput:");
			switch (relation) {
			case "father":
				final String father = relEx.father(member).getName();
				System.out.println(father);
				break;

			case "mother":
				final String mother = relEx.mother(member).getName();
				System.out.println(mother);
				break;

			case "spouse":
				final String spouse = relEx.spouse(member).getName();
				System.out.println(spouse);
				break;

			case "children":
				final List<Member> children = relEx.children(member);
				children.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "sons":
				final List<Member> sons = relEx.sons(member);
				sons.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "daughters":
				final List<Member> daughters = relEx.daughters(member);
				daughters.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "brothers":
				final List<Member> brothers = relEx.brothers(member);
				brothers.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "sisters":
				final List<Member> sisters = relEx.sisters(member);
				sisters.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "grandDaughters":
				final List<Member> grandDaughters = relEx.grandDaughters(member);
				grandDaughters.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "cousins":
				final List<Member> cousins = relEx.cousins(member);
				cousins.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "brotherInLaw":
				final List<Member> brotherInLaw = relEx.brotherInLaw(member);
				brotherInLaw.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "sisterInLaw":
				final List<Member> sisterInLaw = relEx.sisterInLaw(member);
				sisterInLaw.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "maternalAunt":
				final List<Member> maternalAunt = relEx.maternalAunt(member);
				maternalAunt.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "paternalAunt":
				final List<Member> paternalAunt = relEx.paternalAunt(member);
				paternalAunt.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "maternalUncle":
				final List<Member> maternalUncle = relEx.maternalUncle(member);
				maternalUncle.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			case "paternalUncle":
				final List<Member> paternalUncle = relEx.paternalUncle(member);
				paternalUncle.forEach(x -> System.out.print(x.getName() + "  "));
				System.out.println();
				break;

			default:
				System.out.println("Invalid Relation");
				break;
			}
		}
	}

	private static boolean doContinue() {
		displayOptions();
		return IN.nextInt() == 1;
	}

	private static void displayOptions() {
		System.out.println("\n------------------ Family Tree ------------------");
		System.out.println("Select a number");
		System.out.println("1. Find relative");
		System.out.println("2. Exit");
	}

}
