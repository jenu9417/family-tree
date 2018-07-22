package com.jenu.gt.familytree.relation.type;

import java.util.logging.Logger;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.util.LogUtil;

/**
 * The Class AbstractSingleMemberRelation.
 * 
 * @author janardhanan.s
 */
public abstract class AbstractSingleMemberRelation implements Relation {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AbstractMultiMemberRelation.class.getName());

	/**
	 * Find relation. Returns null, if no member is found.
	 *
	 * @param member
	 *            the member
	 * @return the member
	 */
	protected abstract Member findRelation(Member member);

	@Override
	public void findAndDisplayRelation(Member member) {
		final Member singleMember = findRelation(member);
		displayRelation(singleMember);
	}

	/**
	 * Display relation.
	 *
	 * @param member
	 *            the member
	 */
	protected void displayRelation(Member member) {
		if (member == null) {
			LogUtil.logOutput(LOGGER, "No relative found !!");
			return;
		}

		LogUtil.logOutput(LOGGER, member.getName());
	}

}
