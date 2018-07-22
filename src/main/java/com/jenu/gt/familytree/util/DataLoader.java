package com.jenu.gt.familytree.util;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.core.FamilyTree;

/**
 * The Util Class DataLoader. Provides the default data-set of 'King Shan'.
 * 
 * @author janardhanan.s
 */
public class DataLoader {

	/**
	 * Private constructor to avoid object instantiation.
	 */
	private DataLoader() {

	}

	/**
	 * Load default family tree. Instantiates a {@link FamlilyTree}, with 'King
	 * Shan' as family head and other and other members.
	 *
	 * @return the family tree
	 */
	public static FamilyTree loadDefaultFamilyTree() {
		final Member familyHead = new Member("King Shan", Gender.MALE, null);
		final FamilyTree ftree = new FamilyTree(familyHead);

		loadDefaultFamilyTree(ftree);

		return ftree;
	}

	/**
	 * Load default family tree.
	 *
	 * @param ftree
	 *            the ftree
	 */
	private static void loadDefaultFamilyTree(FamilyTree ftree) {

		ftree.addSpouse("Queen Anga", "King Shan");

		ftree.addChild("Ish", Gender.MALE, "King Shan");

		ftree.addChild("Chit", Gender.MALE, "King Shan");
		ftree.addSpouse("Ambi", "Chit");

		ftree.addChild("Vich", Gender.MALE, "King Shan");
		ftree.addSpouse("Lika", "Vich");

		ftree.addChild("Satya", Gender.FEMALE, "King Shan");
		ftree.addSpouse("Vyan", "Satya");

		ftree.addChild("Drita", Gender.MALE, "Chit");
		ftree.addSpouse("Jaya", "Drita");

		ftree.addChild("Vrita", Gender.MALE, "Chit");

		ftree.addChild("Jata", Gender.MALE, "Drita");

		ftree.addChild("Driya", Gender.FEMALE, "Drita");
		ftree.addSpouse("Mnu", "Driya");

		ftree.addChild("Vila", Gender.MALE, "Vich");
		ftree.addSpouse("Jnki", "Vila");

		ftree.addChild("Lavnya", Gender.FEMALE, "Vila");
		ftree.addSpouse("Gru", "Lavnya");

		ftree.addChild("Chika", Gender.FEMALE, "Vich");
		ftree.addSpouse("Kpila", "Chika");

		ftree.addChild("Satvy", Gender.FEMALE, "Satya");
		ftree.addSpouse("Asva", "Satvy");

		ftree.addChild("Savya", Gender.MALE, "Satya");
		ftree.addSpouse("Krpi", "Savya");

		ftree.addChild("Kroya", Gender.MALE, "Savya");

		ftree.addChild("Saayan", Gender.MALE, "Satya");
		ftree.addSpouse("Mina", "Saayan");

	}

}
