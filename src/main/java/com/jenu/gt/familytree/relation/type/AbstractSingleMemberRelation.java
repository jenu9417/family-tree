package com.jenu.gt.familytree.relation.type;

import java.util.logging.Logger;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.util.LogUtil;

public abstract class AbstractSingleMemberRelation implements Relation {

	private static final Logger LOGGER = Logger.getLogger(AbstractMultiMemberRelation.class.getName());

	protected abstract Member findRelation(Member member);

	@Override
	public void findAndDisplayRelation(Member member) {
		final Member singleMember = findRelation(member);
		displayRelation(singleMember);
	}

	protected void displayRelation(Member member) {
		if (member == null) {
			LogUtil.logOutput(LOGGER, "No relative found !!");
			return;
		}

		LogUtil.logOutput(LOGGER, member.getName());
	}

}
