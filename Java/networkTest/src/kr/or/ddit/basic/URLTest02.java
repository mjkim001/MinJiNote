package kr.or.ddit.basic;

import java.io.*;
import java.net.*;
import java.util.*;

public class URLTest02 {
	public static void main(String[] args) throws IOException {
		//URLConnection ==> 어플리케이션과 URL간의 통신을 위한 클래스
		
		//특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");
		
		//URLConnection객체 생성
		URLConnection urlCon = url.openConnection();
		
		//Header 정보 가져오기
		Map<String,List<String>> headerMap = urlCon.getHeaderFields();
		
		//HeaderMap의 키값과 value값 출력하기
		for(String headerKey: headerMap.keySet()) {
			headerMap.get(headerKey);
		}
		
		System.out.println("-----------------------------------");
		/*
		//URL주소에 연결된 문서내용 가져오기
		//방법1 ==> URLConnection객체를 이용하는 방법
		//연결된 문서를 읽어오기 위한 스트림 객체 생성
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//객체를 읽어와 출력하기
		String str = "";
		while((str = br.readLine())!=null) {
			System.out.println(str);
		}
		br.close(); //스트림 닫기
		*/
		
		//방법2 ==> URl객체의 openStream()메서드 이용하기
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//객체를 읽어와 출력하기
		String str = "";
		while((str = br.readLine())!=null) {
			System.out.println(str);
		}
		br.close(); //스트림 닫기
	}
}
