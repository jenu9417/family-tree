package com.jenu.gt.familytree.relation;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.type.AbstractSingleMemberRelation;

/**
 * The Class Mother. Denotes female parent of a person.
 * 
 * @author janardhanan.s
 */
@Relative(value = "mother")
public class Mother extends AbstractSingleMemberRelation {

	@Override
	protected Member findRelation(Member member) {
		if (member.getParent() == null) {
			return null;
		}
		return member.getParent().getGender() == Gender.FEMALE ? member.getParent() : member.getParent().getSpouse();
	}

}
