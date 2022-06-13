package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.html.HTMLInputElement;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.NoticeModifyCommand;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/main")
	public String main() throws Exception{
		String url = "notice/main";
		return url;
	}

	@RequestMapping("/list")
	public String list(SearchCriteria cri, Model model) throws Exception {
		
		String url = "notice/list";
		
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		model.addAttribute("dataMap",dataMap);
		
		return url;
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "notice/regist";
		return url;
	}
	
	@RequestMapping("/regist")
	public String regist(NoticeVO notice,HttpServletRequest request,RedirectAttributes rttr) throws Exception {
		String url = "redirect:/notice/list";
		
		notice.setTitle((String)request.getAttribute("XSStitle"));
		
		notice.setWriter("mimi");
		
		noticeService.regist(notice);
		
		rttr.addFlashAttribute("from","regist");
		//rttr.addFlashAttribute("notice",notice);
		
		return url;
	}
	
	@RequestMapping("/detail")
	public String detail(int nno,@RequestParam(defaultValue = "")String from, HttpServletRequest request,ModelAndView mnv ) throws SQLException{
		String url = "notice/detail";
		
		NoticeVO notice = null;
		
		if(!from.equals("list")) {			
			notice = noticeService.getNoticeForModify(nno);
		}else {
			notice = noticeService.getNotice(nno);
			url="redirect:/notice/detail.do?nno="+nno;
		}
		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		
		return url;
		
	}
	
	@RequestMapping("/modifyForm")
	public String modifyForm(int nno, ModelAndView mnv) throws Exception{
		String url = "notice/modify";
		
		NoticeVO notice = noticeService.getNoticeForModify(nno);
		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		
		return url;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(NoticeVO notice, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/notice/detail.do";
		
		//notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		notice.setTitle((String)request.getAttribute("XSStitle"));
		
		noticeService.modify(notice);
		
		rttr.addAttribute("nno", notice.getNno());
		rttr.addFlashAttribute("from", "modify");
		
		return url;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(int nno, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/notice/detail.do";
		
		noticeService.remove(nno);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("nno", nno);
		
		return url;
	}
	
}