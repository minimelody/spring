package org.kh.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.kh.member.common.Log4jAdvice;
import org.kh.member.common.LogAdvice;
import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Member selectOneMember(Member vo) {
		Connection conn = getConnection();
		System.out.println("비즈니스 로직 호출");
		Member m = memberDAO.selectOneMember(jdbcTemplate,vo);
		return m;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","spring","spring");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int updateMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.updateMember(jdbcTemplate,vo);
		return result;
	}



	public int insertMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.insertMember(jdbcTemplate,vo);
		return result;
	}



	public int deleteMember(Member m) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.deleteMember(jdbcTemplate,m);
		return result;
	}



	public ArrayList<Member> allMember() {
		System.out.println("비즈니스 로직 호출");
		ArrayList<Member> list = memberDAO.allMember(jdbcTemplate);
		return list;
	}

}
