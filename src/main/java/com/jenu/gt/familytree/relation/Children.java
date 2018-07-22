package com.jenu.gt.familytree.relation;

import java.util.ArrayList;
import java.util.List;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

/**
 * The Class Children. Denotes direct descendents of a person.
 * 
 * @author janardhanan.s
 */
@Relative(value = "children")
public class Children extends AbstractMultiMemberRelation {

	@Override
	protected List<Member> findRelation(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return new ArrayList<>(parent.getChildren().values());
	}

}
