package com.jenu.gt.familytree.relation;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.type.AbstractSingleMemberRelation;

/**
 * The Class Father. Denotes male parent of a person.
 * 
 * @author janardhanan.s
 */
@Relative(value = "father")
public class Father extends AbstractSingleMemberRelation {

	@Override
	public Member findRelation(Member member) {
		if (member.getParent() == null) {
			return null;
		}
		return member.getParent().getGender() == Gender.MALE ? member.getParent() : member.getParent().getSpouse();
	}

}
