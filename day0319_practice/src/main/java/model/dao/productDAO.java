package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.dto.productDTO;

public class productDAO {
	private productDAO() {};
	
	private static productDAO instance = new productDAO();
	
	public static productDAO getInstance() {
		return instance;
	}
	
	public List<productDTO> getList(){
	
		List<productDTO> dto = new ArrayList();
		
		String sql = "SELECT * FROM note";
		
		try(Connection conn = DBUtil.makeConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(); 
				)
		{
			while(rs.next()) {
				productDTO product = new productDTO();
				product.setNoteCode(rs.getString(1));
				product.setModel(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setCompany(rs.getString(4));
				
				dto.add(product);
			}
			
			System.out.println(dto);
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}
	
	public int addProduct(productDTO product) {
		int cnt = 0;
		
		String sql = "INSERT INTO note \n"
					+ "values(?, ?, ?, ?)";
		
		try(Connection con = DBUtil.makeConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, product.getNoteCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getCompany());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int deleteAll(String[] productNoteCodeList) {
		int cnt = 0;
		
		String sql = "DELETE FROM note\n"
					+ "where noteCode = ?";
		
		try(Connection con = DBUtil.makeConnection();){
			PreparedStatement pstmt = null;
			for(String code : productNoteCodeList) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, code);
				cnt += pstmt.executeUpdate();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
}
