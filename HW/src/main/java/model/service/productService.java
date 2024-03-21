package model.service;

import java.util.List;

import model.dao.productDAO;
import model.dto.productDTO;

public class productService {
	
	productDAO dao = productDAO.getInstance();
	
	private productService() {}
	private static productService instance = new productService();
	public static productService getInstance() {
		return instance;
	}
	
	public List<productDTO> getList(){
		List<productDTO> dto = dao.getList();
		
		return dto;
	}
	
	public int addProduct(productDTO product) {
		return dao.addProduct(product);
	}
	
	public int deleteAll(String[] productNoteCodeList) {
		return dao.deleteAll(productNoteCodeList);
	}
}
