package com.jenu.gt.familytree.relation;

import java.util.Collections;
import java.util.List;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

/**
 * The Class PaternalAunts. Denotes father's sisters or father's sister-in-laws.
 * 
 * @author janardhanan.s
 */
@Relative(value = "paternalAunts")
public class PaternalAunts extends AbstractMultiMemberRelation {

	private static final Father FATHER = new Father();
	private static final Sisters SISTERS = new Sisters();
	private static final SisterInLaws SISTERS_IN_LAWS = new SisterInLaws();

	@Override
	protected List<Member> findRelation(Member member) {
		final Member father = FATHER.findRelation(member);
		if (father == null) {
			return Collections.emptyList();
		}
		return father.getParent() == null ? SISTERS_IN_LAWS.findRelation(father) : SISTERS.findRelation(father);
	}

}
