package kr.or.ddit.basic.fileUpload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageSrcView.do")
public class ImageSrcView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String filename = request.getParameter("filename");
		
		String downloadPath = "d:/d_other/uploadFiles";
		String filePath = downloadPath + File.separator + filename;
		File file = new File(filePath);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// 출력용 스트림
			bos = new BufferedOutputStream(response.getOutputStream());
			
			//입력용 스트림
			bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			//byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림으로 출력한다.
			while((len=bis.read(temp))>0) {
				bos.write(temp,0,len);
			}
			bos.flush();
		} catch (IOException e) {
			System.out.println("입출력 오류 : "+e.getMessage());
		} finally {
			if(bis!=null) try {bis.close();} catch(IOException e) {}
			if(bos!=null) try {bos.close();} catch(IOException e) {}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
