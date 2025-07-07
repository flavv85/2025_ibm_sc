package com.unitbv.spring_boot_tutorial.service;

import com.unitbv.spring_boot_tutorial.entity.Member;
import com.unitbv.spring_boot_tutorial.enums.MemberStatus;
import com.unitbv.spring_boot_tutorial.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void save(Member member) {
        if (member.getReviews() != null && !member.getReviews().isEmpty()) {
            member.setStatus(MemberStatus.ACTIVE);
        } else {
            member.setStatus(null);
        }
        memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public List<Member>findByFitnessClassId(String fitnessClassId) {
        return memberRepository.findAllByFitnessClasses_Id(fitnessClassId);
    }

    public Optional<Member> updateNickname(String memberId, String newNickname) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        optionalMember.ifPresent(member -> {
            member.setNickname(newNickname);
            memberRepository.save(member);
        });
        return optionalMember;
    }

    public void deleteById(String memberId) {
        memberRepository.deleteById(memberId);
    }

    public void deleteAllMembersFromFitnessClass(String fitnessClassId) {
        List<Member> members = memberRepository.findAllByFitnessClasses_Id(fitnessClassId);

        for (Member member : members) {
            boolean hasReview = member.getReviews() != null && !member.getReviews().isEmpty();
            if (hasReview) {
                member.setStatus(MemberStatus.INACTIVE);
                memberRepository.save(member);
            } else {
                memberRepository.delete(member);
            }
        }
    }

}
