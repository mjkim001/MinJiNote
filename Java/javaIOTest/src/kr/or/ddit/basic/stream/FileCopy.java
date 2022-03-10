package kr.or.ddit.basic.stream;

import java.io.*;

/*
 * 문제) d드라이브의 d_other폴더에 있는 '펭귄.jpg'파일을
 * 		d드라이브의 d_other폴더에 있는 '연습용'폴더에
 * 		'펭귄_복사본.jpg'파일로 복사하는 프로그램을 작성하시오
 */
public class FileCopy {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("d:/d_other/펭귄.JPG");
			int c; // 읽어온 데이터를 저장할 변수
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/펭귄_복사본.JPG");
			while ((c = fin.read()) != -1) {
				// 읽어온 데이터를 화면에 출력하기
				fout.write(c);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}

	}
}
