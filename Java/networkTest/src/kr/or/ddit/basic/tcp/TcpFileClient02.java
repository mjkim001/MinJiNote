package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.*;

import javax.swing.JFileChooser;

//open dialog를 이용하여 전송한 파일을 선택하여 서버로 전송한다.
//이때 파일 이름도 같이 전송한다.
public class TcpFileClient02 {
	
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
