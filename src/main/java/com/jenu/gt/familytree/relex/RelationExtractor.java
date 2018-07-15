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

	List<Member> brotherInLaw(Member member);

	List<Member> sisterInLaw(Member member);

	List<Member> maternalAunt(Member member);

	List<Member> paternalAunt(Member member);

	List<Member> maternalUncle(Member member);

	List<Member> paternalUncle(Member member);
}
