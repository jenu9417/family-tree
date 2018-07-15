package com.jenu.gt.familytree.relex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;

public class SimpleRelationExtractor implements RelationExtractor {

	@Override
	public Member father(Member member) {
		return member.getParent().getGender() == Gender.MALE ? member.getParent() : member.getParent().getSpouse();
	}

	@Override
	public Member mother(Member member) {
		return member.getParent().getGender() == Gender.FEMALE ? member.getParent() : member.getParent().getSpouse();
	}

	@Override
	public Member spouse(Member member) {
		return member.getSpouse();
	}

	@Override
	public List<Member> children(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return new ArrayList<>(parent.getChildren().values());
	}

	@Override
	public List<Member> sons(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return parent.getChildren().values().stream().filter(x -> (x.getGender() == Gender.MALE))
				.collect(Collectors.toList());
	}

	@Override
	public List<Member> daughters(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return parent.getChildren().values().stream().filter(x -> (x.getGender() == Gender.FEMALE))
				.collect(Collectors.toList());
	}

	@Override
	public List<Member> brothers(Member member) {
		final Predicate<Member> filterPredicate = member.getGender() == Gender.MALE
				? x -> (x.getGender() == Gender.MALE && !x.getName().equals(member.getName()))
				: x -> (x.getGender() == Gender.MALE);
		return member.getParent().getChildren().values().stream().filter(filterPredicate).collect(Collectors.toList());
	}

	@Override
	public List<Member> sisters(Member member) {
		final Predicate<Member> filterPredicate = member.getGender() == Gender.FEMALE
				? x -> (x.getGender() == Gender.FEMALE && !x.getName().equals(member.getName()))
				: x -> (x.getGender() == Gender.FEMALE);
		return member.getParent().getChildren().values().stream().filter(filterPredicate).collect(Collectors.toList());
	}

	@Override
	public List<Member> grandDaughters(Member member) {
		final Member parent = member.getChildren().isEmpty() ? member.getSpouse() : member;
		return parent.getChildren().values().stream().map(x -> x.getChildren().values()).flatMap(Collection::stream)
				.filter(x -> x.getGender() == Gender.FEMALE).collect(Collectors.toList());
	}

	@Override
	public List<Member> cousins(Member member) {
		final Member parent = member.getParent().getChildren().isEmpty() ? member.getParent().getSpouse()
				: member.getParent();
		final Member grandParent = parent.getParent().getChildren().isEmpty() ? parent.getParent().getSpouse()
				: parent.getParent();
		return grandParent.getChildren().values().stream().filter(x -> !x.getName().equals(parent.getName()))
				.map(x -> x.getChildren().values()).flatMap(Collection::stream).collect(Collectors.toList());
	}

	@Override
	public List<Member> brotherInLaw(Member member) {
		return member.getParent() == null ? brothers(member.getSpouse())
				: sisters(member).stream().map(Member::getSpouse).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public List<Member> sisterInLaw(Member member) {
		return member.getParent() == null ? sisters(member.getSpouse()) : brothers(member).stream()
				.map(Member::getSpouse).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public List<Member> maternalAunt(Member member) {
		final Member mother = mother(member);
		return mother.getParent() == null ? sisterInLaw(mother) : sisters(mother);
	}

	@Override
	public List<Member> paternalAunt(Member member) {
		final Member father = father(member);
		return father.getParent() == null ? sisterInLaw(father) : sisters(father);
	}

	@Override
	public List<Member> maternalUncle(Member member) {
		final Member mother = mother(member);
		return mother.getParent() == null ? brotherInLaw(mother) : brothers(mother);
	}

	@Override
	public List<Member> paternalUncle(Member member) {
		final Member father = father(member);
		return father.getParent() == null ? brotherInLaw(father) : brothers(father);
	}

}
