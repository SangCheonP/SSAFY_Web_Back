package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dto.BookDto;

public class BookDao {
	
	public BookDto selectOne(int isbn) {
		
		BookDto bookDto = null;
		ResultSet rs = null;
		String sql = "select * from book_tb where isbn = ?";
		
		try(Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, isbn);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			bookDto = new BookDto();
			
			bookDto.setIsbn(isbn);
			bookDto.setTitle(rs.getString(2));
			bookDto.setWriter(rs.getString(3));
			bookDto.setPrice(rs.getInt(4));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookDto;
	}
	
}
