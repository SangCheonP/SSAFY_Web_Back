package controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BoardDTO;
import model.dto.MemberDTO;
import model.service.BoardService;
import model.service.MemberService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private BoardService boardService = new BoardService();
	private MemberService memberService = new MemberService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action.equals("loginForm")) {
			req.getRequestDispatcher("LoginForm.jsp").forward(req, resp);

		} else if (action.equals("writeForm")) {
			MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");
			if (loginInfo != null) {
				req.getRequestDispatcher("WriteForm.jsp").forward(req, resp);
			} else {
				req.setAttribute("alertMsg", "로그인 필요");
				req.setAttribute("redirectPath", "/day0320_board/board?action=loginForm");
				req.getRequestDispatcher("AlertMessage.jsp").forward(req, resp);
			}

		} else if (action.equals("login")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");

			MemberDTO loginInfo = memberService.login(id, pw);

			if (loginInfo != null) {
				HttpSession session = req.getSession();
				session.setAttribute("loginInfo", loginInfo);
				resp.sendRedirect("/day0320_board/");
			} else {
				resp.sendRedirect("/day0320_board/board?action=loginForm");
			}

		} else if (action.equals("write")) {
			MemberDTO loginInfo = (MemberDTO) req.getSession().getAttribute("loginInfo");

			if (loginInfo != null) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				BoardDTO board = new BoardDTO();
				board.setTitle(title);
				board.setContent(content);
				board.setWriter(loginInfo.getUserId());

				boardService.write(board);
				req.setAttribute("alertMsg", "작성완료 되었습니다.");
				req.setAttribute("redirectPath", "/day0320_board/");
				req.getRequestDispatcher("AlertMessage.jsp").forward(req, resp);
			} else {
				req.setAttribute("alertMsg", "로그인 이후에 사용 가능합니다.");
				req.setAttribute("redirectPath", "/day0320_board/board?action=loginForm");
				req.getRequestDispatcher("AlertMessage.jsp").forward(req, resp);
			}

		} else if (action.equals("logout")) {
			req.getSession().invalidate();

			resp.sendRedirect("/day0320_board/");
		} else if (action.equals("list")) {
			String pageParm = req.getParameter("page");
			
			int page = 1;
			if (pageParm != null && pageParm.length() > 0) {
				page = Integer.parseInt(pageParm);
			}

			req.setAttribute("pageInfo", boardService.makePage(page));

			req.getRequestDispatcher("List.jsp").forward(req, resp);
		} else if (action.equals("detail")) {
			int bno = Integer.parseInt(req.getParameter("bno"));

			BoardDTO boardDTO = new BoardDTO();
			boardDTO = boardService.selectOne(bno);

			req.setAttribute("detail", boardDTO);
			req.getRequestDispatcher("Detail.jsp").forward(req, resp);

		} else if (action.equals("delete")) {
			int bno = Integer.parseInt(req.getParameter("bno"));

			boardService.delete(bno);

			resp.sendRedirect("/day0320_board/");

		} else if (action.equals("modifyForm")) {
			int bno = Integer.parseInt(req.getParameter("bno"));

			BoardDTO boardDTO = new BoardDTO();
			boardDTO = boardService.selectOne(bno);
			
			req.setAttribute("detail", boardDTO);
			req.getRequestDispatcher("ModifyForm.jsp").forward(req, resp);
			
		}else if (action.equals("modify")) {
			int bno = Integer.parseInt(req.getParameter("bno"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			boardService.modify(bno, title, content);
			
			resp.sendRedirect("/day0320_board/board?action=detail&bno="+bno);
		}
	}
}
