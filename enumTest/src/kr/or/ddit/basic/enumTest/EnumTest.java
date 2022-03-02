package kr.or.ddit.basic.enumTest;
/*
 * - enum(열거형)
 * 		==> 서로 관련있는 상수들의 집합을 나타낸다.
 * 		==> 클래스처럼 보이게 하는 상수
 * 		==> 열거형은 클래스처럼 독립된 java파일로 만들수 있고,
 * 			하나의 java파일에 클래스와 같이 만들 수 있고,
 * 			클래스문 안에 내부 클래스처럼 만들수 있다.
 * 
 * - 열겨형의 속성 및 메소드
 * 	 1) name()		==> 열거형 상수의 이름을 문자열로 반환한다.
 *   2) ordinal()	==> 열거형 상수가 정의된 순서값(index값)을 반환한다.
 *   					(0부터 시작)
 *   3) valueOf("열거형 상수명")	==> 지정된 열거형에서 "열거형 상수명"과
 *   								일치하는 열거형 상수를 반환한다.
 *   4) 열거형이름.상수명	==> 해당 열거형 상수를 반환한다.
 *   						valueOf()메서드와 같은 결과를 나타낸다.
 *   5) 열거형이름.values()	==> 모든 상수들을 배열로 가져온다.
 *   
 * -열거형 선언하기
 *  방법1) 
 *  	enum 열거형이름 {상수명1, 상수명2, ...., 상수명n}
 */

public class EnumTest {
	public enum Color {
		RED, GREEN, BLUE
	}

	public enum Count {
		ONE, TWO, THREE
	}

	public static void main(String[] args) {
		/*
		System.out.println("RED : " + ConstTest.RED);
		System.out.println("THREE : " + ConstTest.THREE);

		if(ConstTest.RED == ConstTest.TWO) {
			System.out.println("같다...");
		}else {
			System.out.println("다르다...");
		}
		*/
		
		Color mycol = Color.valueOf("GREEN"); //Color.GREEN;과 같다
		Count mycnt = Count.THREE; //Count.valueOf("THREE");
		
		System.out.println("mycol : " + mycol.name());
		System.out.println("mycnt : " + mycnt.name());
		System.out.println();
		
		System.out.println("mycol : " + mycol.ordinal());
		System.out.println("mycnt : " + mycnt.ordinal());
		
		/*//서로 다른 종류의 열거형끼리의 비교는 불가하다.
		if (mycol == mycnt) {
			System.out.println("같다...");
		} else
			System.out.println("다르다...");
		*/
		
		if(mycol == Color.BLUE) {
			System.out.println("같다...");
		} else
			System.out.println("다르다...");
	}
}
