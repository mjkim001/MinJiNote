package kr.or.ddit.basic.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {
	public static void main(String[] args) {
		// 객체 파일에 저장하는 객체

		// Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "서울");
		Member mem3 = new Member("홍길남", 40, "인천");
		Member mem4 = new Member("홍길북", 50, "강릉");

		try {
			// 객체를 파일로 저장하기
			FileOutputStream fout = new FileOutputStream("d:/d_other/memobj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);

			// 쓰기 작업
			System.out.println("객체 저장하기 시작..");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);

			System.out.println("객체 저장 작업 끝...");

			oout.close(); // 스트림 닫기

		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println("--------------------------------");
		// --------------------------------------------
		ObjectInputStream oin = null;
		// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
		try {
			// 입력용 스트림 객체 생성
			oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/d_other/memobj.bin")));
			Object obj; // 읽어온 객체를 저장할 변수

			System.out.println("객체 읽기 작업 시작");

			// readObject()메서드가 데이터를 끝까지 읽어오면
			// EOFException이 발생된다.
			while ((obj = oin.readObject()) != null) {
				// 읽어온 데이터를 원래의 객체형으로 형변환한 후에 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("--------------------------------");
			}
			System.out.println();
			oin.close();
		} catch (EOFException e) {
			System.out.println("객체 읽기 작업 끝...");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oin != null) {
				try {
					oin.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}

		}

	}
}

//데이터 저장용 클래스 작성
class Member implements Serializable {
	private String name;
	private int age;
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}