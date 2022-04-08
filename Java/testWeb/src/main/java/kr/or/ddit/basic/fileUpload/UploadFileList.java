package kr.or.ddit.basic.fileUpload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/uploadFileList.do")
public class UploadFileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 저장될 폴더가 없으면 생성한다.
		File fdir = new File(uploadPath);
		if(!fdir.exists()) {
			fdir.mkdirs();	
		}
		
		// upload한 해당 파일이 저장되는 폴더의 파일 목록을 가져와 List에 담는다.
		File[] allFiles = fdir.listFiles();
		//Upload 파일 목록이 저장될 list
		List<FileInfo> fileList = new ArrayList<FileInfo>();
		
		for(File f : allFiles) {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFileName(f.getName());
			fileInfo.setFileSize((int)Math.ceil(f.length()/1024.0));
			fileInfo.setStatus("Success");
			
			fileList.add(fileInfo);
		}
		
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/basic/upload/uploadFileList.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
