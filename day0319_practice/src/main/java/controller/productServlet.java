package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.productDTO;
import model.service.productService;

import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class productServlet extends HttpServlet{
	
	private productService service = productService.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action.equals("list")) {
			executeList(req, resp);
		}else if (action.equals("addForm")) {
			executeAddForm(req, resp);
			
		}else if (action.equals("add")) {
			executeAdd(req, resp);
			
		}else if (action.equals("selectOne")) {
			
		}else if (action.equals("delete")) {
			executeDelete(req, resp);
		}
	}

	private void executeDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] productNoteCodeList = req.getParameterValues("product");
		
		service.deleteAll(productNoteCodeList);
		
		resp.sendRedirect("index.jsp");
		
	}

	private void executeAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		productDTO product = new productDTO();
		
		product.setNoteCode(req.getParameter("noteCode"));
		product.setModel(req.getParameter("model"));
		product.setPrice(Integer.parseInt(req.getParameter("price")));
		product.setCompany(req.getParameter("company"));
		
		service.addProduct(product);
		
		resp.sendRedirect("index.jsp");
	}

	private void executeAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("addForm.jsp").forward(req, resp);
	}

	private void executeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<productDTO> dto = service.getList();
		req.setAttribute("list", dto);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
	
}
