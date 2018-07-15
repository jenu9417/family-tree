package com.jenu.gt.familytree.relation;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

@Relative(value = "brothers")
public class Brothers extends AbstractMultiMemberRelation {

	@Override
	protected List<Member> findRelation(Member member) {
		final Predicate<Member> filterPredicate = member.getGender() == Gender.MALE
				? x -> (x.getGender() == Gender.MALE && !x.getName().equals(member.getName()))
				: x -> (x.getGender() == Gender.MALE);
		return member.getParent().getChildren().values().stream().filter(filterPredicate).collect(Collectors.toList());
	}

}
