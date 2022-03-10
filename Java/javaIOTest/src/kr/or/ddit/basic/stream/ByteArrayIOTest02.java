package kr.or.ddit.basic.stream;

import java.io.*;
import java.util.*;

public class ByteArrayIOTest02 {
	// 입력 스트림 사용법
	public static void main(String[] args) {
		byte[] insrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outsrc = null;
		
		byte[] temp = new byte[4];

		// 입력용 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(insrc);
		// 출력용 스트림 객체 생성
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			/*
			//available()메서드 ==> 읽어올 수 있는 데이터 수를 반환
			while(input.available() > 0) {
//				input.read(temp);
//				output.write(temp);
				
				//실제 읽어온 byte수를 반환한다.
				int len = input.read(temp);
				
				//temp배열의 내용 중에서 0번째부터 len개만틈 출력한다.
				output.write(temp,0,len);
				System.out.println("반복문 안에서 temp => "+ Arrays.toString(temp));
			}
			*/
			int len = 0;
			while((len = input.read(temp))>0) {
				//////////////////////////////////////////////////////////////
				output.write(temp);
			}
			System.out.println();
			outsrc = output.toByteArray();
			
			System.out.println("insrc = "+ Arrays.toString(insrc));
			System.out.println("outsrc = "+ Arrays.toString(outsrc));
			
			input.close();
			output.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
