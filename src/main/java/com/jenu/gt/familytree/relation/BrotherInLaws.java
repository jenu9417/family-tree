package com.jenu.gt.familytree.relation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.annotation.Relative;
import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.relation.type.AbstractMultiMemberRelation;

/**
 * The Class BrotherInLaws. Denotes Spouse's brothers or Husbands of siblings.
 * 
 * @author janardhanan.s
 */
@Relative(value = "brotherInLaws")
public class BrotherInLaws extends AbstractMultiMemberRelation {

	private static final Brothers BROTHERS = new Brothers();
	private static final Sisters SISTERS = new Sisters();

	@Override
	protected List<Member> findRelation(Member member) {
		return member.getParent() == null ? BROTHERS.findRelation(member.getSpouse()) : SISTERS.findRelation(member)
				.stream().map(Member::getSpouse).filter(Objects::nonNull).collect(Collectors.toList());
	}

}
