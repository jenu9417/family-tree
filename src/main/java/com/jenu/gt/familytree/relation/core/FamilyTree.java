package com.jenu.gt.familytree.relation.core;

import java.util.Iterator;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;

/**
 * The Class FamilyTree. Holds the complete family-tree data. Provides methods
 * to access members or to add new members (Spouse or Children). <br>
 * <br>
 * Have to specify the {@link FamilyTree#familyHead} during instantiation.
 * 
 * @author janardhanan.s
 */
public class FamilyTree {

	private final Member familyHead;

	public Member getFamilyHead() {
		return familyHead;
	}

	public FamilyTree(Member familyHead) {
		this.familyHead = familyHead;
	}

	/**
	 * Gets the member.
	 *
	 * @param name
	 *            the name
	 * @return the member
	 */
	public Member getMember(String name) {
		return getMemberRecursively(name, this.familyHead);
	}

	/**
	 * Gets the member recursively.
	 *
	 * @param name
	 *            the name
	 * @param member
	 *            the member
	 * @return the member recursively
	 */
	private Member getMemberRecursively(String name, Member member) {
		if (member.getName().equals(name)) {
			return member;
		}
		if (member.isMarried()) {
			if (member.getSpouse().getName().equals(name)) {
				return member.getSpouse();
			}
			if (member.getChildren().containsKey(name)) {
				return member.getChildren().get(name);
			}
			final Iterator<Member> childIterator = member.getChildren().values().iterator();
			while (childIterator.hasNext()) {
				final Member result = getMemberRecursively(name, childIterator.next());
				if (result != null) {
					return result;
				}
			}
		}

		return null;
	}

	/**
	 * Adds the child.
	 *
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param parent
	 *            the parent
	 * @return the member
	 */
	public Member addChild(String name, Gender gender, String parent) {
		final Member parentMember = getMember(parent);
		final Member member = new Member(name, gender, parentMember);
		parentMember.addChildren(member);

		return member;
	}

	/**
	 * Adds the spouse.
	 *
	 * @param name
	 *            the name
	 * @param partner
	 *            the partner
	 * @return the member
	 */
	public Member addSpouse(String name, String partner) {
		final Member partnerMember = getMember(partner);
		final Gender gender = partnerMember.getGender() == Gender.MALE ? Gender.FEMALE : Gender.MALE;
		final Member spouse = new Member(name, gender);
		spouse.setSpouse(partnerMember);
		spouse.setMarried(true);

		partnerMember.setSpouse(spouse);
		partnerMember.setMarried(true);

		return spouse;
	}

}
