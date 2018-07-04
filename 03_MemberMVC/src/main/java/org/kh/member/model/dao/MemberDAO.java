package org.kh.member.model.dao;

import java.sql.Connection;

import org.kh.member.model.vo.Member;

public interface MemberDAO {
	Member selectOneMember(Connection conn, Member vo);
}
