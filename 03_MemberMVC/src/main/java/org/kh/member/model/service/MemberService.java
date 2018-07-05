package org.kh.member.model.service;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberService {
	public Member selectOneMember(Member vo);
}
