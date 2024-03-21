package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.MemberDTO;

public class MemberDAO {

	
	
	/**
	 * 사용자 한명 선택
	 * @param id 
	 * @param pw
	 * @return
	 */
	public MemberDTO selectOne(String id, String pw) {
		int cnt = 0;
		ResultSet rs = null;
		String sql = "select user_id, user_name from member_tb \n"
				+ "where user_id = ? and user_pw = ?";
		
		MemberDTO memberDTO = null;
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setUserId(rs.getString(1));
				memberDTO.setUserPw(rs.getString(2));
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return memberDTO;
	}
}
