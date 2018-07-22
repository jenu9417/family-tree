package com.jenu.gt.familytree.relation;

import java.util.Collections;
import java.util.List;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

/**
 * The Class MaternalAunts. Denotes mother's sisters or mother's sister-in-laws.
 * 
 * @author janardhanan.s
 */
@Relative(value = "maternalAunts")
public class MaternalAunts extends AbstractMultiMemberRelation {

	private static final Mother MOTHER = new Mother();
	private static final Sisters SISTERS = new Sisters();
	private static final SisterInLaws SISTERS_IN_LAWS = new SisterInLaws();

	@Override
	protected List<Member> findRelation(Member member) {
		final Member mother = MOTHER.findRelation(member);
		if (mother == null) {
			return Collections.emptyList();
		}
		return mother.getParent() == null ? SISTERS_IN_LAWS.findRelation(mother) : SISTERS.findRelation(mother);
	}

}
