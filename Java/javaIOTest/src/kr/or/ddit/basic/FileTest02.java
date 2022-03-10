package kr.or.ddit.basic;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		File f1 = new File("d:/d_other/text.txt");
		
		System.out.println(f1.getName() + "의 크기  : "+ f1.length());
		System.out.println("path : " + f1.getPath());
		System.out.println("absolutPath : " + f1.getAbsolutePath());
		
		File f2 = new File(".");
		System.out.println("path : " + f2.getPath());
		System.out.println("absolutPath : " + f2.getAbsolutePath());
	}
}
