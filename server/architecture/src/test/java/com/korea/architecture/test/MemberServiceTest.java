package com.korea.architecture.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.korea.architecture.di.test.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	@Autowired
	private MemberService memberService;
	
	@Test
	void memberJoinTest() {
		memberService.joinMember("김민수");
	}
}
