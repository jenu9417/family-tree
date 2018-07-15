package com.jenu.gt.familytree.relation;

import java.util.List;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

@Relative(value = "daughters")
public class Daughters extends AbstractMultiMemberRelation {

	@Override
	protected List<Member> findRelation(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return parent.getChildren().values().stream().filter(x -> (x.getGender() == Gender.FEMALE))
				.collect(Collectors.toList());
	}

}
