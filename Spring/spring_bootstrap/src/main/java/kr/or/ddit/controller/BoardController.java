package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.command.SearchCriteria;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.dto.BoardVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;

	@RequestMapping("/main")
	public String main() throws Exception {
		String url = "board/main";
		return url;
	}

	@RequestMapping("/list")
	public String list(SearchCriteria cri, Model model) throws Exception {

		String url = "board/list";

		Map<String, Object> dataMap = boardService.getBoardList(cri);
		model.addAttribute("dataMap", dataMap);

		return url;
	}

	@RequestMapping("/registForm")
	public String registForm() {
		String url = "board/regist";
		return url;
	}

	@RequestMapping("/regist")
	public String regist(BoardVO board, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/board/list";

		board.setTitle((String) request.getAttribute("XSStitle"));

		board.setWriter("mimi");

		boardService.regist(board);

		rttr.addFlashAttribute("from", "regist");
		// rttr.addFlashAttribute("board",board);

		return url;
	}
	
	@RequestMapping("/detail")
	public String detail(int bno,@RequestParam(defaultValue = "")String from, HttpServletRequest request,ModelAndView mnv ) throws SQLException{
		String url = "board/detail";
		
		BoardVO board = null;
		
		if(!from.equals("list")) {			
			board = boardService.getBoardForModify(bno);
		}else {
			board = boardService.getBoard(bno);
			url="redirect:/board/detail.do?bno="+bno;
		}
		mnv.addObject("board", board);
		mnv.setViewName(url);
		
		return url;
		
	}
	
	@RequestMapping("/modifyForm")
	public String modifyForm(int bno, ModelAndView mnv) throws Exception{
		String url = "board/modify";
		
		BoardVO board = boardService.getBoardForModify(bno);
		mnv.addObject("board", board);
		mnv.setViewName(url);
		
		return url;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO board, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/board/detail.do";
		
		//notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		board.setTitle((String)request.getAttribute("XSStitle"));
		
		boardService.modify(board);
		
		rttr.addAttribute("bno", board.getBno());
		rttr.addFlashAttribute("from", "modify");
		
		return url;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(int bno, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/board/detail.do";
		
		boardService.remove(bno);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("bno", bno);
		
		return url;
	}
	
}
