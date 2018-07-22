package com.jenu.gt.familytree.relation;

import org.junit.Assert;
import org.junit.Test;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.relation.core.FamilyTree;
import com.jenu.gt.familytree.test.util.TestDataProvider;

public class MotherTest {

	private static final Mother MOTHER = new Mother();

	@Test
	public void when_motherExists_return_mother() {
		final FamilyTree ftree = TestDataProvider.getFamilyTree();
		final Member member = ftree.getMember("Chit");
		final Member mother = MOTHER.findRelation(member);

		Assert.assertNotNull("Mother exists. Hence should not be null", mother);
		Assert.assertEquals("Queen Anga", mother.getName());
		Assert.assertEquals(Gender.FEMALE, mother.getGender());
	}

	@Test
	public void when_motherNotExist_return_null() {
		final FamilyTree ftree = TestDataProvider.getFamilyTree();
		final Member member = ftree.getMember("Jaya");
		final Member mother = MOTHER.findRelation(member);

		Assert.assertNull("Mother doesn't exists. Hence should be null", mother);
	}

}
