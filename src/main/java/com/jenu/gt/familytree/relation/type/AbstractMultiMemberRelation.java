package com.jenu.gt.familytree.relation.type;

import java.util.List;
import java.util.logging.Logger;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.util.LogUtil;

/**
 * The Class AbstractMultiMemberRelation.
 * 
 * @author janardhanan.s
 */
public abstract class AbstractMultiMemberRelation implements Relation {

	private static final Logger LOGGER = Logger.getLogger(AbstractMultiMemberRelation.class.getName());

	/**
	 * Find relation. Returns an empty list if no member is found.
	 *
	 * @param member
	 *            the member
	 * @return the list
	 */
	protected abstract List<Member> findRelation(Member member);

	@Override
	public void findAndDisplayRelation(Member member) {
		final List<Member> members = findRelation(member);
		displayRelation(members);

	}

	/**
	 * Display relation.
	 *
	 * @param members
	 *            the members
	 */
	protected void displayRelation(List<Member> members) {
		if (members == null || members.isEmpty()) {
			LogUtil.logOutput(LOGGER, "No relative found !!");
			return;
		}

		final StringBuilder logBuilder = new StringBuilder();
		logBuilder.append("[ ");
		members.forEach(x -> {
			logBuilder.append(x.getName());
			logBuilder.append(", ");
		});
		logBuilder.append(" ]");

		final String logMessage = logBuilder.toString();

		LogUtil.logOutput(LOGGER, logMessage);
	}

}
