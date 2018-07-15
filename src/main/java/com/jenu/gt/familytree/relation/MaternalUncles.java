package com.jenu.gt.familytree.relation;

import java.util.Collections;
import java.util.List;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

@Relative(value = "maternalUncles")
public class MaternalUncles extends AbstractMultiMemberRelation {

	private static final Mother MOTHER = new Mother();
	private static final Brothers BROTHERS = new Brothers();
	private static final BrotherInLaws BROTHER_IN_LAWS = new BrotherInLaws();

	@Override
	protected List<Member> findRelation(Member member) {
		final Member mother = MOTHER.findRelation(member);
		if (mother == null) {
			return Collections.emptyList();
		}
		return mother.getParent() == null ? BROTHER_IN_LAWS.findRelation(mother) : BROTHERS.findRelation(mother);
	}

}
