package com.jenu.gt.familytree.relex;

import java.util.List;

import com.jenu.gt.familytree.bean.Member;

public interface RelationExtractor {

	Member father(Member member);

	Member mother(Member member);

	Member spouse(Member member);

	List<Member> children(Member member);

	List<Member> sons(Member member);

	List<Member> daughters(Member member);

	List<Member> brothers(Member member);

	List<Member> sisters(Member member);

	List<Member> grandDaughters(Member member);

	List<Member> cousins(Member member);

	List<Member> brotherInLaws(Member member);

	List<Member> sisterInLaws(Member member);

	List<Member> maternalAunts(Member member);

	List<Member> paternalAunts(Member member);

	List<Member> maternalUncles(Member member);

	List<Member> paternalUncles(Member member);
}
