package com.jenu.gt.familytree.relation;

import org.junit.Assert;
import org.junit.Test;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;
import com.jenu.gt.familytree.core.FamilyTree;
import com.jenu.gt.familytree.test.util.TestDataProvider;

public class FatherTest {

	private static final Father FATHER = new Father();

	@Test
	public void when_fatherExists_return_father() {
		final FamilyTree ftree = TestDataProvider.getFamilyTree();
		final Member member = ftree.getMember("Chit");
		final Member father = FATHER.findRelation(member);

		Assert.assertNotNull("Father exists. Hence should not be null", father);
		Assert.assertEquals("King Shan", father.getName());
		Assert.assertEquals(Gender.MALE, father.getGender());
		Assert.assertTrue(father.getChildren().containsKey("Chit"));
	}

	@Test
	public void when_fatherNotExist_return_null() {
		final FamilyTree ftree = TestDataProvider.getFamilyTree();
		final Member member = ftree.getMember("Jaya");
		final Member father = FATHER.findRelation(member);

		Assert.assertNull("Father doesn't exists. Hence should be null", father);
	}

}
