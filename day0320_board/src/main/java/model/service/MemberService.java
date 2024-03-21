package model.service;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class MemberService {
	
	private MemberDAO memberDAO = new MemberDAO();
	
	public MemberDTO login(String id, String pw) {
		return memberDAO.selectOne(id, pw);
	}
	
}
