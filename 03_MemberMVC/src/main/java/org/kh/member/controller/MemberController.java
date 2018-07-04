package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberController {
	String selectOneMember(HttpServletRequest request, String userId, String userPw);
}
