package kr.or.ddit.basic.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	private ServerSocket server;
	private Socket socket;
	
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	
	private String saveDir = "d://d_other/down";
	private String fileName = "펭귄_전송본.jpg";

	public void serverStart() {
		File save = new File(saveDir);
		if(!save.exists()) {
			save.mkdirs(); //저장 폴더가 없으면 새로 생성한다.
		}
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비 되었습니다..");
			
			socket = server.accept(); //클라이언트의 요청을 기다린다.
			
			System.out.println("파일 다운로드 시작...");
			bis = new BufferedInputStream(socket.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(saveDir + File.separator + fileName)); 
			
			byte[] temp = new byte[1024];
			int len = 0;
			//소켓으로 받은 데이터를 파일로 저장하기
			while((len = bis.read(temp)) > 0) {
				bos.write(temp, 0, len);
			}
			bos.flush();
			
			System.out.println("파일 다운로드 완료...");
		} catch (Exception e) {
			System.out.println("파일 다운로드 실패!!");
			e.printStackTrace();
		} finally {
			//사용했던 자원들을 반납한다.
			if(bos != null) try{bos.close();}catch(IOException e) {}
			if(bis != null) try{bis.close();}catch(IOException e) {}
			if(socket != null) try{socket.close();}catch(IOException e) {}
			if(server != null) try{server.close();}catch(IOException e) {}
		}
		
	}
	public static void main(String[] args){
		
		new TcpFileServer().serverStart();
		
	}

}