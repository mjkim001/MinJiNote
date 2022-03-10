package kr.or.ddit.basic.stream;

import java.io.*;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		//입출력 향상을 위하여 Buffered 스트림을 사용한다.
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test_utf8.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout,5);
			for(char i='1'; i <='9'; i++) {
				bout.write(i);
			}
			bout.flush();
			//버퍼스트림을 close()는 버퍼의 내용을 모두 flush한 후에 닫아준다.
			bout.close();
			System.out.println("작업 끝..."); 
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
