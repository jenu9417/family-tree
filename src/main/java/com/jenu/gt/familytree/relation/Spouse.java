package com.jenu.gt.familytree.relation;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractSingleMemberRelation;

/**
 * The Class Spouse. Denotes marriage partner of a person.
 * 
 * @author janardhanan.s
 */
@Relative(value = "spouse")
public class Spouse extends AbstractSingleMemberRelation {

	@Override
	protected Member findRelation(Member member) {
		return member.getSpouse();
	}

}
