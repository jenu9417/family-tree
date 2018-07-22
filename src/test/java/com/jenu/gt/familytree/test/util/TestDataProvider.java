package com.jenu.gt.familytree.test.util;

import com.jenu.gt.familytree.core.FamilyTree;
import com.jenu.gt.familytree.util.DataLoader;

public class TestDataProvider {

	private static final FamilyTree FTREE = DataLoader.loadDefaultFamilyTree();

	public static FamilyTree getFamilyTree() {
		return FTREE;
	}

}
