package kr.or.ddit.basic.args;

public class ArgsTest {
	
	/*
	 * 메서드를 호출할 때 사용되는 데이터의 개수가 실행될 때마다 다를 때..
	 * 
	 * 1. 배열을 이용한 메서드
	 * 예) 매게변수로 받은 정수들의 합계를 구하는 메서드
	 *     (이 정수의 개수는 상환에 따라 다르다.)
	 *      
	 */
//	public int sumArr(int[] data) {
//		int sum = 0;
//		
//		for(int i = 0; i < data.length; i++) {
//			sum+=data[i];
//		}
//		
//		return sum;
//	}
	
	/*
	 * 가변형인수 ==> 메서드의 매게변수의 개수가 실행될 때마다 다를 때 사용한다.
	 * 	- 가변형인수는 사용되는 매게변수는 메서드 안에서 배열로 처리한다.
	 * 	- 가변형인수는 한가지 자료형만 사용할 수 있다.
	 */
	
	public int sumArr(int...data) {
		int sum = 0;
		
		for(int i = 0; i < data.length; i++) {
			sum+=data[i];
		}
		
		return sum;
	}
	
	/*
	 * 가변형 인수와 일반적인 인수를 사용할 경우에는
	 * 가변형 인수를 제일 뒤쪽에 배치해야한다.
	 */
	
	public String sumArr2(String name, int...data) {
		int sum = 0;
		
		for(int i = 0; i < data.length; i++) {
			sum+=data[i];
		}
		
		return name + "씨 총점 : " + sum;
	}
	
	public void ttt(int a) {
		
	}
	
	public static void main(String[] args) {
		ArgsTest test = new ArgsTest();
		
		int[] nums = {100,200,300};
		
		int[] nums2;
		nums2 = new int[] {100,200,300};
		
		System.out.println(test.sumArr(nums));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5}));
		System.out.println("-----------------------");
		
		System.out.println(test.sumArr(100,200,300));
		System.out.println(test.sumArr(1,2,3,4,5));
		System.out.println("-----------------------");
		
		System.out.println(test.sumArr2("홍길동", 1,2,3,4,5,6));
		System.out.println();
		
		
		int k = 0;
		test.ttt(k);
		test.ttt(300);
		
		
	}
}
