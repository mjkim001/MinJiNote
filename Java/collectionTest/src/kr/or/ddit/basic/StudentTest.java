package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	문제) 학번, 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버별로 갖는 Student클래스를 만든다.
	    이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화한다.
	    이 클래스는 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준를 구현한다.
	    
	    이 Student객체는 List에 저장하여 관리한다.
	    
	    List에 저장된 Student객체를 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스도 작성하시오.
	    
	    (단, 등수는 List에 전체 데이터가 모두 저장된 후에 구한다.)
 */
public class StudentTest {
	// 등수를 구하는 메서드
	public void setRanking(List<Student> stdList){
		// 기준이 되는 데이터를 위한 반복문 ( 등수를 구할 값 )
		for(Student std1 : stdList) {
			int rank = 1; // 처음에는 등수를 1로 초기화 한다;
			
			// 비교대상을 찾기 위한 반복문
			for(Student std2 : stdList) {
				// 기준보다 큰 값을 만나면 rank값을 증가시킨다
				if(std1.getScore() < std2.getScore()) {
					rank++;
				}
			}
			
			std1.setRank(rank);
		}
	}
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();

		StudentTest test = new StudentTest();
		
		studentList.add(new Student(1, "홍길동", 60, 20, 40));
		studentList.add(new Student(3, "성춘향", 100, 20, 50));
		studentList.add(new Student(7, "강감찬", 40, 50, 50));
		studentList.add(new Student(5, "변학도", 100, 100, 90));
		studentList.add(new Student(2, "일지매", 93, 100, 100));
		studentList.add(new Student(4, "이순신", 60, 80, 50));
		studentList.add(new Student(6, "이몽룡", 40, 100, 50));
		
		// 등수를 구하는 메서드 호출
		//setRanking(studentList); //static이 없으면 인스턴스메서드이기때문에 사용불가
		test.setRanking(studentList);
		
		System.out.println("정렬전...");
		for(Student student : studentList) {
			System.out.println(student);
		}
		System.out.println();
		
		// 학번의 오름차순으로 정렬하기
		Collections.sort(studentList);
		
		System.out.println("학번의 오름차순 정렬후...");
		for(Student student : studentList) {
			System.out.println(student);
		}
		System.out.println();
		
		System.out.println("외부정렬기준(총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순)정렬");
		
		Collections.sort(studentList, new scoreDesc());
		for(Student student : studentList) {
			System.out.println(student);
		}
		
	}

}

class Student implements Comparable<Student>{
	private int num;
	
	private String name;
	
	private int kor;
	private int eng;
	private int math;
	private int score;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		score = kor + eng + math;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", score=" + score + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student stu) {
		//학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준
		return Integer.compare(num,stu.getNum());
		
	}
	
}

//Student객체를 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스

class scoreDesc implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getScore() > stu2.getScore()) {
			return -1;
		}else if(stu1.getScore() < stu2.getScore()){
			return 1;
		}else{
			return stu1.getName().compareTo(stu2.getName());
		}

	}
	
}