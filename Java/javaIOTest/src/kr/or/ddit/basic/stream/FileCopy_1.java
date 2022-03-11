package kr.or.ddit.basic.stream;
/*
 	문제) D드라이브의 d_other폴더에 있는 '펭귄.jpg'파일을
 		 D드라이브의 d_other폴더에 있는 '연습용'폴더에
 		 '펭귄_복사본.jpg'파일로 복사하는 프로그램을 작성하시오
 */

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileCopy_1 {

	public static void main(String[] args) {
		FileCopy_1 fc = new FileCopy_1();

//		File file = new File("d:/d_other/펭귄.jpg");
		File file = fc.getSelectFile("OPEN");

		if (file == null) {
			System.out.println("선택된 원본 파일이 없습니다.");
			System.out.println("복사작업 끝...");
			return;
		}

		File targetFile = fc.getSelectFile("SAVE");
		if (targetFile == null) {
			System.out.println("선택된 대상 파일이 없습니다.");
			System.out.println("복사작업 끝...");
			return;
		}

//		if(!file.exists()) {
//			System.out.println(file.getName() + "파일이 없습니다");
//			System.out.println("복사작업을 중단합니다.");
//			return;
//		}

		try {
			// 복사할 파일 스트림 객체 생성
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fin);

			// 복사될 파일 스트림 객체 생성
//			FileOutputStream fout = new FileOutputStream("d:/d_other/펭귄_복사본.jpg");
			FileOutputStream fout = new FileOutputStream(targetFile);
			BufferedOutputStream bout = new BufferedOutputStream(fout);

			System.out.println("복사 시작...");
			int data = 0;
//		// fis.read()가 -1 이면 파일을 다 읽은것
//		while((data = fin.read()) != -1) {
//		    fout.write(data);
//		}
//		fout.flush();

			while ((data = bin.read()) != -1) {
				bout.write(data);
			}
			bout.flush();

			// 스트림 닫기
			bin.close();
			bout.close();

			System.out.println("복사 작업 끝...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일을 선택하여 선택한 파일을 반환하는 메서드
	public File getSelectFile(String option) {
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(true);
		chooser.setCurrentDirectory(new File("d:/d_other"));

		int result;
		if ("OPEN".equals(option)) {
			result = chooser.showOpenDialog(new Panel());
		} else if ("SAVE".equals(option)) {
			result = chooser.showSaveDialog(new Panel());
		} else {
			System.out.println("option이 잘못되었습니다");
			return null;
		}

		File selectedFile = chooser.getSelectedFile();
		System.out.println("선택한 파일 : " + selectedFile.getAbsolutePath());
		return selectedFile;
	}
}