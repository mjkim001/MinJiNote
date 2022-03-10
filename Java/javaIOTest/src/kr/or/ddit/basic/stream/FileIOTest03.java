package kr.or.ddit.basic.stream;

import java.io.FileReader;

public class FileIOTest03 {
	public static void main(String[] args) {
		//문자기반 스트림을 이용한 파일내용 읽기
		try {
			//문자기반 파일 입력용 스츠림 객체 생성
			FileReader fr =  new FileReader("d:/d_other/text.txt");
			int c;
			
			while((c=fr.read())!=-1) {
				//읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
