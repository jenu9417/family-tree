package com.jenu.gt.familytree.core;

import java.util.Iterator;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;

public class FamilyTree {

	private final Member familyHead;

	public Member getFamilyHead() {
		return familyHead;
	}

	public FamilyTree(Member familyHead) {
		this.familyHead = familyHead;
	}

	public Member getMember(String name) {
		return getMemberRecursively(name, this.familyHead);
	}

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

	public Member addChild(String name, Gender gender, String parent) {
		final Member parentMember = getMember(parent);
		final Member member = new Member(name, gender, parentMember);
		parentMember.addChildren(member);

		return member;
	}

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
