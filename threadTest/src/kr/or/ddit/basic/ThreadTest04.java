package kr.or.ddit.basic;

public class ThreadTest04 {
	/*
	 * 
	 * 1~20억 까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와
	 * 여러개의 쓰래드가 협력해서 처리할 때의 경과시간을 비교해보자   
	 * 
	 */
	public static void main(String[] args) {
		//단독으로 처리하기
		SumThread smth = new SumThread(1L,2000000000L);
		
		long startTime = System.currentTimeMillis();
		smth.start();
		
		try {
			smth.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리했을 때 경과시간 : " + (endTime - startTime));
		System.out.println();
		System.out.println("--------------------------------------------------");
		
		//여럿의 쓰레드가 협력해서 처리하기 (4개의 쓰레드 이용하기)
		SumThread[] smths = new SumThread[] {
				new SumThread(         1L, 500000000L),
				new SumThread( 500000001L,1000000000L),
				new SumThread(1000000001L,1500000000L),
				new SumThread(1500000001L,2000000000L)
		};
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i <smths.length; i++) {
			smths[i].start();
		}

		for (SumThread sm : smths) {
			try {
				sm.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리했을 때 경과시간 : " + (endTime - startTime));
	}

}

//합계를 구하는 쓰레드 Class 작성
class SumThread extends Thread{
	//합계를 구할 영역의 시작값과 종료값을 저장할 변수
	private long min;
	private long max;
	
	public SumThread(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}