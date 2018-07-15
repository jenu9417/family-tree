package com.jenu.gt.familytree.relation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

@Relative(value = "cousins")
public class Cousins extends AbstractMultiMemberRelation {

	@Override
	public List<Member> findRelation(Member member) {
		if (member.getParent() == null) {
			return Collections.emptyList();
		}
		final Member parent = member.getParent().getChildren().isEmpty() ? member.getParent().getSpouse()
				: member.getParent();
		final Member grandParent = parent.getParent().getChildren().isEmpty() ? parent.getParent().getSpouse()
				: parent.getParent();
		return grandParent.getChildren().values().stream().filter(x -> !x.getName().equals(parent.getName()))
				.map(x -> x.getChildren().values()).flatMap(Collection::stream).collect(Collectors.toList());
	}

}
