package com.jenu.gt.familytree.relex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jenu.gt.familytree.bean.Member;
import com.jenu.gt.familytree.bean.Member.Gender;

public class SimpleRelationExtractor implements RelationExtractor {

	@Override
	public Member father(Member member) {
		if (member.getParent() == null) {
			return null;
		}
		return member.getParent().getGender() == Gender.MALE ? member.getParent() : member.getParent().getSpouse();
	}

	@Override
	public Member mother(Member member) {
		if (member.getParent() == null) {
			return null;
		}
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
		if (member.getParent() == null) {
			return Collections.emptyList();
		}
		final Member parent = member.getParent().getChildren().isEmpty() ? member.getParent().getSpouse()
				: member.getParent();
		final Member grandParent = parent.getParent().getChildren().isEmpty() ? parent.getParent().getSpouse()
				: parent.getParent();
		return grandParent.getChildren().values().stream().filter(x -> !x.getName().equals(parent.getName()))
				.map(x -> x.getChildren().values()).flatMap(Collection::stream).collect(Collectors.toList());
	}

	@Override
	public List<Member> brotherInLaws(Member member) {
		return member.getParent() == null ? brothers(member.getSpouse())
				: sisters(member).stream().map(Member::getSpouse).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public List<Member> sisterInLaws(Member member) {
		return member.getParent() == null ? sisters(member.getSpouse()) : brothers(member).stream()
				.map(Member::getSpouse).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public List<Member> maternalAunts(Member member) {
		final Member mother = mother(member);
		if (mother == null) {
			return Collections.emptyList();
		}
		return mother.getParent() == null ? sisterInLaws(mother) : sisters(mother);
	}

	@Override
	public List<Member> paternalAunts(Member member) {
		final Member father = father(member);
		if (father == null) {
			return Collections.emptyList();
		}
		return father.getParent() == null ? sisterInLaws(father) : sisters(father);
	}

	@Override
	public List<Member> maternalUncles(Member member) {
		final Member mother = mother(member);
		if (mother == null) {
			return Collections.emptyList();
		}
		return mother.getParent() == null ? brotherInLaws(mother) : brothers(mother);
	}

	@Override
	public List<Member> paternalUncles(Member member) {
		final Member father = father(member);
		if (father == null) {
			return Collections.emptyList();
		}
		return father.getParent() == null ? brotherInLaws(father) : brothers(father);
	}

}
