package kr.or.ddit.basic;

/*
 * Thread의 stop()메서드를 호출하면 해당 쓰레드가 바로 멈춘다.
 * 이때 이 쓰레드가 
 * 그래서 stop()메서드는 비추천으로 되어있다.
 */
public class ThreadTest11 {

	public static void main(String[] args) {
//		ThreadStopTest01 th1 = new ThreadStopTest01();
//		th1.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//		
//		//th1.stop();
//		th1.setStop(true);
		
		ThreadStopTest02 th2 = new ThreadStopTest02();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		th2.interrupt();
		

	}

}

//쓰레드를 멈추게하는 연습용 메서드
class ThreadStopTest01 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("쓰레드 실행중...");
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료");
		
	}
}

//interrupt()메서드를 이용하여 쓰레드를 멈추게 하는 연습용 쓰레드
class ThreadStopTest02 extends Thread{
	
	@Override
	public void run() {
//		//방법1 ==> interrupt()메서드와 sleep()메서드를 이요하는 방법
//		try {
//			while (true) {
//				System.out.println("Thread 실행중...");
//				Thread.sleep(1);
//			}
//		} catch (InterruptedException e) {
//			System.out.println("interrupt 발생");
//		}
		
		//방법2 ==>
		while(true) {
			System.out.println("Thread 실행중...");
			
			//interrupt()메서드가 호출되었는지 여부를 검사한다.
			
			//검사방법1 ==> Thread의 인스턴스 메서드인
			//			  isInterrupted()메서드를 이용하기
			// isInterrupted()메서드는 interrupt()메서드가 실행되면
			// true를 반환한다
			
			if(this.isInterrupted()) {
				break;
			}
			
			//검사방법2 ==> Thread의 정적 메서드인
			//			  interrupted()메서드를 이용하기
			// interrupted()메서드는 interrupt()메서드가 실행되면
			// true를 반환한다
			
			if(Thread.interrupted()) {
				break;
			}
			
		}
		
		
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료");
		
	}
}
 