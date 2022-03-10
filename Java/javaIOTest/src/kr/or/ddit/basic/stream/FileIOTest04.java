package kr.or.ddit.basic.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest04 {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		try {
			//System.in => 콘솔(표준 입출력장치)의 입력스트림 객체
			//입력용 바이트기반 스트림을 문자기반 스트림으로 
			
			//반환하는 스트림 객체
			InputStreamReader isr = new InputStreamReader(System.in);
			//출력용 문자기반 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/text.txt");
			
			int c;
			System.out.println("아무내용이나 입력하세요 (입력의 끝은 'ctrl+z')");
			
			//콘솔에서 입력할 때 입력의 끝은 'ctrl+z'키를 누른다.
			while((c=isr.read())!=0) {
				fw.write(c);
			}

			isr.close();
			fw.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
