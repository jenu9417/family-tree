package com.jenu.gt.familytree.relation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.core.FamilyTree;
import com.jenu.gt.familytree.test.util.TestDataProvider;

public class CousinsTest {

	private static final Cousins COUSINS = new Cousins();

	@Test
	public void when_cousinsExists_return_cousins() {
		final FamilyTree ftree = TestDataProvider.getFamilyTree();
		final Member member = ftree.getMember("Drita");
		final List<Member> cousins = COUSINS.findRelation(member);

		final List<String> expectedCousins = Arrays.asList("Vila", "Chika", "Satvy", "Savya", "Saayan");
		final List<String> availableCousins = cousins.stream().map(Member::getName).collect(Collectors.toList());

		Assert.assertNotNull("Cousins exists. Hence should not be null", cousins);
		Assert.assertTrue(expectedCousins.size() == availableCousins.size());
		Assert.assertTrue(expectedCousins.containsAll(availableCousins));
	}

	@Test
	public void when_cousinsNotExists_return_emptyArray() {
		final FamilyTree ftree = TestDataProvider.getFamilyTree();
		final Member member = ftree.getMember("Lavnya");
		final List<Member> cousins = COUSINS.findRelation(member);

		Assert.assertNotNull("Cousins should not be null", cousins);
		Assert.assertTrue(cousins.isEmpty());
	}

}
