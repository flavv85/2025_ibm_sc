package com.unitbv.spring_boot_tutorial.controller;

import com.unitbv.spring_boot_tutorial.entity.Member;
import com.unitbv.spring_boot_tutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/fitness-class/{id}")
    public ResponseEntity<List<Member>> getMembersByFitnessClassId(@PathVariable String id) {
        List<Member> members = memberService.findByFitnessClassId(id);
        return ResponseEntity.ok(members);
    }

    @PostMapping("/create")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        memberService.save(member);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/{id}/nickname")
    public ResponseEntity<Member> updateNickname(@PathVariable String id, @RequestBody String newNickname) {
        Optional<Member> updatedMember = memberService.updateNickname(id, newNickname);
        return updatedMember
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/by-fitness-class/{fitnessClassId}")
    public ResponseEntity<Void> deleteAllFromFitnessClass(@PathVariable String fitnessClassId) {
        memberService.deleteAllMembersFromFitnessClass(fitnessClassId);
        return ResponseEntity.noContent().build();
    }
}
