package com.jenu.gt.familytree.bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Bean Class Member. Holds necessary details to identify a family member.
 * 
 * @author janardhanan.s
 */
public class Member {

	private final String name;
	private final Gender gender;
	private Member parent;
	private Member spouse;
	private boolean married;
	private Map<String, Member> children;

	public Member(String name, Gender gender) {
		this(name, gender, null);
	}

	public Member(String name, Gender gender, Member parent) {
		this.name = name;
		this.gender = gender;
		this.parent = parent;
		this.children = new HashMap<>(4);
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Member getParent() {
		return parent;
	}

	public void setParent(Member parent) {
		this.parent = parent;
	}

	public Member getSpouse() {
		return spouse;
	}

	public void setSpouse(Member spouse) {
		this.spouse = spouse;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Map<String, Member> getChildren() {
		return children;
	}

	public void setChildren(Map<String, Member> children) {
		this.children = children;
	}

	public void addChildren(Member... children) {
		this.children.putAll(Arrays.stream(children).collect(Collectors.toMap(Member::getName, x -> x)));
	}

	/**
	 * The Enum Gender. Can be male or female.
	 */
	public enum Gender {
		MALE, FEMALE;
	}

}
