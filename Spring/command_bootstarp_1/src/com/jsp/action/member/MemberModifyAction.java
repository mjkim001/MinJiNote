package com.jsp.action.member;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.controller.GetUploadPath;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MultipartHttpServletRequsetParser;

public class MemberModifyAction implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD	= 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE		= 1024 * 1024 * 1; // 1MB
	private static final int MAX_REQUEST_SIZE	= 1024 * 1024 * 2; // 2MB
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		// 화면
		String url = "redirect:/member/detail.do?";
		
		// 입력
		try{
			// request 변환
			MultipartHttpServletRequsetParser multi = new MultipartHttpServletRequsetParser(request, MEMORY_THRESHOLD,
					MAX_FILE_SIZE, MAX_REQUEST_SIZE);

			// 저장할 경로
			String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
			String uploadFileName = null;

			// 업로드된 이미지 저장
			FileItem[] items = multi.getFileItems("picture");
			List<File> uploadFiles = FileUploadResolver.fileUpload(items, uploadPath);

			String uploadPictureName = multi.getParameter("uploadPicture");
			if(uploadFiles == null) {// 파일을 수정하지 않을 경우
				uploadFileName = uploadPictureName;
			}else {
				uploadFileName = uploadFiles.get(0).getName();
				String oldPicture = multi.getParameter("uploadPicture"); 
				File oldFile = new File(uploadPath + File.separator + oldPicture); 
				if (oldFile.exists()) {
					oldFile.delete(); 
				}
			}

			String id = multi.getParameter("id");
			String pwd = multi.getParameter("pwd");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String phone = multi.getParameter("phone");
			url = url + "id=" +  id;

			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPwd(pwd);
			member.setName(name);
			member.setEmail(email);
			member.setPhone(phone);
			member.setPicture(uploadFileName);

			// 처리
			memberService.modify(member);
						
		} catch(Exception e) {
			e.printStackTrace();
			url = "/member/regist_fail";;
		}
		
		return url;
	}

}
