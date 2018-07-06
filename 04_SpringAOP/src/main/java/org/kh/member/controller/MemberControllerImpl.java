package org.kh.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberControllerImpl implements MemberController{

	@Autowired
	@Qualifier(value="memberService")
	private MemberServiceImpl memberService;
	
	/*
	@RequestMapping(value="/login.do")
	@Override
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response) {
		//1. 값 추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		return null;
	}
	*/
	
	@RequestMapping(value="/login.do")
	@Override
	public String selectOneMember(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPw) {
		//1. 값 추출
		Member vo = new Member();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		
		//2. 비즈니스 로직 처리
		Member m = memberService.selectOneMember(vo);
		
		HttpSession session = request.getSession();
		
		//3. viewName 리턴
		// viewName을 처리할때 주의할점
		// viewName을 DispatcherServlet에게 돌려주고 자동으로
		// 처리 되도록 만들지만! DispatcherServlet에서는
		// 처리할때 무조건 forward 방식만을 사용함
		// (sendRedirect는 사용하지 않음)
		
		if(m!=null) {
			session.setAttribute("member", m);
			return "member/loginSuccess";
		}else {
			return "member/loginFailed";
		}
	}	
	
	@RequestMapping(value="/logout.do")
	public String logoutMember(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/index.jsp";
	}	
	
	@RequestMapping(value="/myInfo.do")
	public Object myPageMember(HttpSession session) {
		Member m = (Member)session.getAttribute("member");
		Member member = memberService.selectOneMember(m);
		ModelAndView view = new ModelAndView();
		if(member!=null) {
			view.addObject("mem",member);
			view.setViewName("member/myPage");
			return view;
		}else {
			view.setViewName("member/pageLoadFail");
			return view;
		}
	}
	
	@RequestMapping(value="/mUpdate.do")
	public String updateMember(Member vo, HttpSession session) {
		int result = memberService.updateMember(vo);
		if(result>0) {
			session.setAttribute("member", vo);
			return "member/mUpdateSuccess";
			//return "redirect : /myInfo.do";
		}else {
			return "member/mUpdateFail";
			//return "redirect : /myInfo.do";
		}
	}
	
	@RequestMapping(value="/joinus.do")
	public String joinusMember() {
		return "member/enroll";
	}
	
	@RequestMapping(value="/enroll.do")
	public String insertMember(Member vo) {
		int result = memberService.insertMember(vo);
		if(result>0) {
			return "member/insertSuccess";
		}else {
			return "member/insertFail";
		}
	}
	
	@RequestMapping(value="/delete.do")
	public String deleteMember(HttpSession session) {
		Member m = (Member)session.getAttribute("member");
		int result = memberService.deleteMember(m);
		if(result>0) {
			session.invalidate();
			return "member/deleteSuccess";
		}else {
			return "member/deleteFail";
		}

	}
	
	@RequestMapping(value="/allMember.do")
	public Object allMember() {
		ArrayList<Member> list = memberService.allMember();
		ModelAndView view = new ModelAndView();
		if(list!=null) {
			view.addObject("list",list);
			view.setViewName("member/allMember");
			return view;
		}else {
			view.setViewName("member/pageLoadFail");
			return view;
		}
	}
}
