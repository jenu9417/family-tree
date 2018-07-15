package com.jenu.gt.familytree.relation;

import java.util.Collections;
import java.util.List;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

@Relative(value = "paternalUncles")
public class PaternalUncles extends AbstractMultiMemberRelation {

	private static final Father FATHER = new Father();
	private static final Brothers BROTHERS = new Brothers();
	private static final BrotherInLaws BROTHER_IN_LAWS = new BrotherInLaws();

	@Override
	protected List<Member> findRelation(Member member) {
		final Member father = FATHER.findRelation(member);
		if (father == null) {
			return Collections.emptyList();
		}
		return father.getParent() == null ? BROTHER_IN_LAWS.findRelation(father) : BROTHERS.findRelation(father);
	}

}
