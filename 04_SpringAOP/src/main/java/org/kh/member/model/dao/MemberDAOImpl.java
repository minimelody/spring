package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member selectOneMember(JdbcTemplate jdbc, Member vo) {
		//query 메소드는 인자값은 2개 혹은 3개
		// 2개 => 쿼리문, RowMapper
		// 3개 => 쿼리문, 쿼리문Parameter, RowMapper
		// 쿼리문 : 말 그대로 SQL 구문
		// RowMapper : 작동한 쿼리문에 대한 결과값을 처리하는 것이 명시된 객체
		// 쿼리문Parameter : 쿼리문에 ?가 있을 경우에 사용되는 인자값
		
		//쿼리문
		String query = "select * from member where user_id=? and user_pw=?";
		
		//쿼리문Parameter (Object형 배열)
		Object [] params = {vo.getUserId(),vo.getUserPw()}; //test1, 1234
		
		List list = jdbc.query(query, params, new MemberRowMapper());

		if(!list.isEmpty()) {
			return (Member)list.get(0);
		}else {
			return null;
		}
	}

	public int updateMember(JdbcTemplate jdbcTemplate, Member vo) {
		String query = "update member set user_pw = ?, user_phone = ? where user_id = ?";
		Object [] params = {vo.getUserPw(),vo.getUserPhone(),vo.getUserId()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public int insertMember(JdbcTemplate jdbcTemplate, Member vo) {
		String query = "insert into member values(?,?,?,?)";
		Object [] params = {vo.getUserId(),vo.getUserPw(),vo.getUserName(),vo.getUserPhone()};
		int result = jdbcTemplate.update(query,params);
		/*
		int result = jdbcTemplate.update(query,
					vo.getUserId(),
					vo.getUserPw(),
					vo.getUserName(),
					vo.getUserPhone()
				);	
		*/
		return result;
	}

	public int deleteMember(JdbcTemplate jdbcTemplate, Member m) {
		String query = "delete from member where user_id=?";
		Object [] params = {m.getUserId()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public ArrayList<Member> allMember(JdbcTemplate jdbcTemplate) {
		String query = "select * from member";
		List list = jdbcTemplate.query(query,new MemberRowMapper());
		if(!list.isEmpty()) {
			return (ArrayList<Member>)list;	
		}else {
			return null;
		}		
		
	}
	

}
