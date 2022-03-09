package kr.or.ddit.basic;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map ==> key값과 value값을 한 쌍으로 관리하는 객체
		 *     -  key값은 중복을 허용하지 않고 순서가 없다.(Set의 특징)
		 *     -  value 값은 중복을 허용한다.
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//자료추가하기
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		
		//자료 수정하기 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		//자료 삭제하기
		//remove(key값) ==> 'key값'이 같은 자료를 찾아서 삭제한다.
		//		반환값 ==>삭제한 자료의 value값이 반환된다.
//		String delTel = map.remove("tel");
//		System.out.println("map => " + map);
//		System.out.println("삭제된 value값 : " + delTel);
		
		//자료읽기
		//get(key값) ==> 'key값'에 맞는 데이터를 찾아 value값을 반환한다.
		System.out.println("이름 : " + map.get("name"));
		System.out.println();
		
		//key값의 존재유무를 나타내는 메서드 : containsKey(key값)
		//	==> 해당 'key값'이 있으면 true,없으면 false를 반환한다.
		
		System.out.println("tel 키값 존재 여부 : " + map.containsKey("tel"));
		System.out.println("age 키값 존재 여부 : "+ map.containsKey("age"));
		
		//Map에 저장된 모든 데이터를 차례로 읽어와 처리하기
		
		//방법 1) 모든 key값을 가져와 처리하기 ==> keySet()메서드 이용
		//	keySet() ==> Map의 모든 key값들을 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
		
		//방법 1-1) iterator 이용하기
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " ==> " + value);
		}
		///////////////////////////////////////////////////////////////////////////////////////////
		//방법 1-2) 향상된 for문 이용하기
		for(String key : keySet) {
			String value = map.get(key);
			System.out.println(key + " ==> " + value);
		}
		System.out.println("-------------------------------------");
		
		//방법 2) value값만 가져와서 
		////////////////////////////////////////////////////////////////////////////////////
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------------");
		
		//방법 3) Map에는 Entry라는 내부 Class가 만들어져있다.
		//		이 Entry클래스는 key와 value라는 맴버변수로 구성되어있다.
		//		Map에서는 이 Entry클래스들을 Set형식으로 저장하여 관리한다.
		//		그래서, 이 Entry 객체 전체를 가져와서 처리하기
		//		(가져온 Entry객체들은 Set형식으로 저장되어있다.)
		//		==> entrySet() 메서드를 이용한다.
		
		//Entry라는 내부객체 전체 가져오기
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()) {
			//Entry객체 추가
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값 : " + entry.getKey());
			System.out.println("value값 : " + entry.getValue());
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
}
