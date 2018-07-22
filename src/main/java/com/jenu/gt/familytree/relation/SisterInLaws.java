package com.jenu.gt.familytree.relation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

/**
 * The Class SisterInLaws. Denotes spouse's sisters or wives of siblings.
 * 
 * @author janardhanan.s
 */
@Relative(value = "sisterInLaws")
public class SisterInLaws extends AbstractMultiMemberRelation {

	private static final Brothers BROTHERS = new Brothers();
	private static final Sisters SISTERS = new Sisters();

	@Override
	protected List<Member> findRelation(Member member) {
		return member.getParent() == null ? SISTERS.findRelation(member.getSpouse()) : BROTHERS.findRelation(member)
				.stream().map(Member::getSpouse).filter(Objects::nonNull).collect(Collectors.toList());
	}

}
