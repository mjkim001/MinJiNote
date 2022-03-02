package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
	- Stack ==> 후입선출(LIFO)의 자료구조
	   
	- Queue ==> 선입선출(FIFO)의 자료구조
	
	Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
 */
public class StackQueueTest {

	public static void main(String[] args) {
	/*
	 	 Stack의 명령
	 1. 자료 입력 : push(입력값)
	 2. 자료 출력 : pop() ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제
	             peek() ==> 삭제없이 자료를 꺼내온다
	 */
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 stack : "+ stack);
		System.out.println();
		
		
		stack.push("성춘향");
		System.out.println("추가 후 stack : " + stack);
		System.out.println();
		
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 stack : " + stack);
		System.out.println();
		
		System.out.println("삭제없이 데이터를 꺼내온 값 : " + stack.peek());
		System.out.println("현재 stack : " + stack);
		System.out.println("-------------------------------------");
		System.out.println();
		
		/*
			Queue의 명령
		1. 자료 입력 : offer(입력값)
		2. 자료 출력 : poll() ==> 자료를 꺼내온 후 Queue에서 꺼내온 자료를 삭제한다.
		   	 		peek() ==> 삭제없이 자료를 꺼내온다.
		 */
		
		Queue<String> queue = new LinkedList<String>();  //queue는 인터페이스여서 직접 구현해야하기때문에  LinkedList를 사용한다
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue : " + queue);
		System.out.println();
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 queue : " + queue);
		System.out.println();
		
		queue.offer("성춘향");
		System.out.println("현재 queue : " + queue);
		System.out.println();
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재 queue : " + queue);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 값 : " + queue.peek());
		System.out.println("현재 queue : " + queue);
		
		//스택은 콜스택 외에도 이전작업으로 돌아가기(ctrl+z), 웹 브라우저에서 뒤로가기 앞으로가기 기능등 어떤 기록들을 남긴후 역순으로 처리하고 싶을때 사용된다
		//큐는 순서대로 프린트하기 등 명령을 입력받은 순서대로 처리해야하는 경우에 사용된다.
		
	}

}