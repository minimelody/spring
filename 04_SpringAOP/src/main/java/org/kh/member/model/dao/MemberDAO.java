package org.kh.member.model.dao;

import java.sql.Connection;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberDAO {
	Member selectOneMember(JdbcTemplate jdbcTemplate, Member vo);
}
