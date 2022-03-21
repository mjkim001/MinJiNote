package kr.or.ddit.basic;

/*
 * javaDoc 파일 만들기 예제
 * "/**" + enter
 */
/**
 * 
 * @author PC-08
 * @version 1.0
 * 
 * <p>
 * 파일명 : JavaDocTest.java<br>
 * 설명 : JavaDoc문서 작성을 위한 연습용 interface<br><br>
 * 
 * 수상이력<br>
 * ---------------------<br>
 * 수상일자 : 2020-03-21<br>
 * 작성자 : 홍길동<br>
 * 수상내용 : 최초생성<br>
 * ---------------------<br>
 *</p>
 */
public interface JavaDocTest {
	/**
	 * 메서드명 : methodTest<br>
	 * 설명 : 반환값이 없는 메서드<br>
	 * @param a 첫번째 매게변수(정수형)
	 * @param b 두번째 매게변수(정수형)
	 */
	public void methodTest(int a, int b);
	/**
	 * 메서드명 : methodAdd<br>
	 * 설명 :반환값이 있는 메서드<br>
	 * @param x 첫번째 매게변수(정수형)
	 * @param y 두번째 매게변수(정수형)
	 * @return 처리된 결과를 정수형으로 반환한다.
	 */
	public int methodAdd(int x, int y);
	/**
	 * 메서드명 : methodSub<br>
	 * 설명 :반환값이 있는 메서드<br>
	 * @return 처리된 결과를 정수형으로 반환한다.
	 */
	public int methodSub();
}
