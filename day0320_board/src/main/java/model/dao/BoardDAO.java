package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.BoardDTO;

public class BoardDAO {
	
	/**
	 * 글작성
	 * @param boardDTO
	 * @return 적용된 컬럼 수
	 */
	public int insert(BoardDTO boardDTO) {
		
		int cnt = 0;
		String sql = "insert into board_tb(title, writer, write_date, content) \n"
				+ "values (?, ?, now(), ?)";
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getContent());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return cnt;
		
	}
	
	/**
	 * 모든 글의 수를 가져오는 함수
	 * @return 모든 글의 수
	 */
	public int selectTotalCount() {
		int cnt = 0;
		ResultSet rs = null;
		String sql = "select count(bno) from board_tb";
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			rs = pstmt.executeQuery();
			rs.next();
			
			cnt = rs.getInt(1);
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	/**
	 * 
	 * @param startRow
	 * @param count
	 * @return 시작 행부터 count개 행
	 */
	public List<BoardDTO> selectList(int startRow, int count){
		List<BoardDTO> boardDTOList = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select bno, title, writer, write_date, read_count \n"
					+ "from board_tb order by bno desc \n"
					+ "limit ?, ?";
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBno(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setWriter(rs.getString(3));
				dto.setWriteDate(rs.getString(4));
				dto.setReadCount(rs.getInt(5));
				
				boardDTOList.add(dto);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return boardDTOList;
	}
	
	public BoardDTO selectOne(int bno) {
		ResultSet rs = null;
		String sql = "select title, writer, content, write_date, read_count, bno \n"
					+ "from board_tb \n"
					+ "where bno = ?";
		
		BoardDTO dto = new BoardDTO();
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			dto.setTitle(rs.getString(1));
			dto.setWriter(rs.getString(2));
			dto.setContent(rs.getString(3));
			dto.setWriteDate(rs.getString(4));
			dto.setReadCount(rs.getInt(5));
			dto.setBno(rs.getInt(6));
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
	public int delete(int bno) {
		int cnt = 0;
		String sql = "delete from board_tb \n"
					+ "where bno = ?";
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, bno);
			
			cnt = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
				
		return cnt;
	}
	
	public int modify(int bno, String title, String content) {
		int cnt = 0;
		
		String sql = "update board_tb \n"
					+ "set title = ?, content = ? \n"
					+ "where bno = ?";
	
	try(Connection con = DBUtil.makeConnection();
		PreparedStatement pstmt = con.prepareStatement(sql)){
		
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, bno);
		
		cnt = pstmt.executeUpdate();
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
		return cnt;
	}
}


