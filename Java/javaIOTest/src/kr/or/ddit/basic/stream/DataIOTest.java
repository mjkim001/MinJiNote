package kr.or.ddit.basic.stream;

import java.io.*;

public class DataIOTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test.dat");
			
			//자료형 단위로 출력할 보조스트림 객체 생성
			DataOutputStream dos = new DataOutputStream(fout);
			
			dos.writeInt(200); //정수형으로 출력
			dos.writeFloat(123.45f); //실수형(float)으로 출력
			dos.writeBoolean(true); //논리형으로 출력
			dos.writeUTF("ABCD1234");  //문자열형식으로 출력
			
			System.out.println("출력완료...");
			dos.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
