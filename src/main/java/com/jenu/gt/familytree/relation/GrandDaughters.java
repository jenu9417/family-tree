package com.jenu.gt.familytree.relation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

/**
 * The Class GrandDaughters. Denotes female children of descendents of a person.
 * 
 * @author janardhanan.s
 */
@Relative(value = "grandDaughters")
public class GrandDaughters extends AbstractMultiMemberRelation {

	@Override
	protected List<Member> findRelation(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return parent.getChildren().values().stream().map(x -> x.getChildren().values()).flatMap(Collection::stream)
				.filter(x -> x.getGender() == Gender.FEMALE).collect(Collectors.toList());
	}

}
