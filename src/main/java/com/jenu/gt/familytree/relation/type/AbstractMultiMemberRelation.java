package com.jenu.gt.familytree.relation.type;

import java.util.List;
import java.util.logging.Logger;

import com.jenu.gt.familytree.bean.Member;

public abstract class AbstractMultiMemberRelation implements Relation {

	private static final Logger LOGGER = Logger.getLogger(AbstractMultiMemberRelation.class.getName());

	protected abstract List<Member> findRelation(Member member);

	@Override
	public void findAndDisplayRelation(Member member) {
		final List<Member> members = findRelation(member);
		displayRelation(members);

	}

	protected void displayRelation(List<Member> members) {
		if (members == null || members.isEmpty()) {
			LOGGER.warning("No relative found!!");
			return;
		}

		final StringBuilder logBuilder = new StringBuilder();
		logBuilder.append("[ ");
		members.forEach(x -> {
			logBuilder.append(x.getName());
			logBuilder.append(",");
		});
		logBuilder.append(" ]");

		final String logMessage = logBuilder.toString();

		LOGGER.info(logMessage);
	}

}
