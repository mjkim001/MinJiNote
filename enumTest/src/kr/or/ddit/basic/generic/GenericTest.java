package kr.or.ddit.basic.generic;

/*
 * Generic 클래스를 만드는 방법
 * 형식)
 * 	class 클래스명<제네릭 타입 글자>{
 * 		private 제너릭타입글자 변수명; //변수 선언에 제네릭을 사용할 경우
 * 		---
 * 		
 * 		제네릭타입글자 메서드명(){
 * 			---
 * 			return 값;
 * 		}
 * 
 * 		void 메서드명(제네릭타입글자 변수명){ //메서드의 매게변수에 제네릭 사용
 * 			---
 * 		}
 * }
 * 
 * --제네릭타입글자--
 * T ==> Type
 * K ==> Key
 * V ==> Value
 * E ==> Element
 * 
 */

class MyGeneric<T>{
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}


class NonGeneric{
	private Object value;
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setValue("가나다라");
		
		NonGeneric ng2 = new NonGeneric();
		ng2.setValue(100);
		
		String rtnNg1 = (String)ng1.getValue();
		System.out.println("문자열 반환값 rtnNg1 = "+ rtnNg1);
		
		Integer irtnNg2 = (Integer)ng2.getValue();
		System.out.println("정수형 반환값 irtnNg2 = " + irtnNg2);
		System.out.println();
		System.out.println("--------------------------");
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		mg1.setValue("안녕하세요.");
		
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		mg2.setValue(500);
		
		//제네릭을 사용한 클래스에서 데이터를 꺼내올 때
		//형변환 없이 사용가능하다.
		String rtnMg1 = mg1.getValue();
		Integer irtnMg2 = mg2.getValue();
		
		System.out.println("제네릭 문자열 반환값 : " + rtnMg1);
		System.out.println("제네릭 정수형 반환값 : " + irtnMg2);
		
		//--------------------------------------------
		
		/*
		NonGeneric test = new NonGeneric();
		test.setValue("우리나라");
		//실행단계에서 오류가 발생된다.
		Integer num = (Integer)test.getValue();
		System.out.println("num : " + num);
		*/
		
		MyGeneric<String> test2 = new MyGeneric<>();
		test2.setValue("대한민국");
		//컴파일 단계에서 오류가 발생된다.
//		Integer num2 = test2.getValue();
		String num2 = test2.getValue();
		System.out.println("num2 : "+ num2);
		
	}
}
