package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BoardDAO;
import model.dto.BoardDTO;

public class BoardService {
	private BoardDAO boardDAO = new BoardDAO();
	
	public int write(BoardDTO boardDTO) {
		return boardDAO.insert(boardDTO);
	}
	
	public Map<String, Object> makePage(int curPage){
		Map<String, Object> map = new HashMap<>();
		
		map.put("curPage", curPage);
		
		// 11 ~ 20 -> 10 ~ 19로 만들고 0~9 -> 0
		int startPage = (curPage-1)/10*10+1;
		int endPage = startPage + 9;
		
		// 총 게시글 178개라 가정
		int totalCount = boardDAO.selectTotalCount();
		// 총 페이지 17
		int totalPage = totalCount/10;
		// 더 게시글이 있으면
		if(totalPage%10 > 0) {
			totalPage += 1;
		}
		
		// 실제 페이지보다 많으면
		if(totalPage < endPage) {
			endPage = totalPage;
		}
		
		// 1p:0 2p: 1
		int startRow = (curPage-1)*10;
		int count = 10;
		
		List<BoardDTO> boardList = boardDAO.selectList(startRow, count);
		
		map.put("curPage", curPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("boardList", boardList);
		
		return map;
	}
	
	public BoardDTO selectOne(int bno) {
		return boardDAO.selectOne(bno);
	}
	
	public int delete(int bno) {
		return boardDAO.delete(bno);
	}
	
	public int modify(int bno, String title, String content) {
		return boardDAO.modify(bno, title, content);
	}
}
