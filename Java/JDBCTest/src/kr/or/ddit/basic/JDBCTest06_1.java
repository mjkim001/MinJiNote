package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;


/*
 	회원을 관리하는 프로그램을 작성하시오.
 	(MYMEMBER 테이블 이용)
 	
 	아래 메뉴의 기능을 모두 구현하시오(CRUD기능 구현하기)
 	
	메뉴예시)
	---------------------------
		== 작업 선택 ==
	  1. 자료 추가				--> insert (C)
	  2. 자료 수정				--> update (U)
 	  3. 자료 삭제				--> delete (D)
 	  4. 전체 자료 출력			--> select (R)
 	  0. 작업 끝
 	---------------------------
 	
 	조건)
 	1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력받는다)
 	2) 자료 삭제는 '회원ID'를 입력받아서 처리한다.
 	3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 	
*/

public class JDBCTest06_1 {
	private Scanner scan = new Scanner(System.in);
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static void main(String[] args) {
		new JDBCTest06_1().start();
	}
	
	private int displayMenu() {
		System.out.println("---------------------------");
		System.out.println("	== 작업 선택 ==");
		System.out.println("  1. 자료 추가");
		System.out.println("  2. 전체 항목 수정");
		System.out.println("  3. 자료 삭제");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 수정");
		System.out.println("  0. 작업 끝");
		System.out.println("---------------------------");
		return scan.nextInt();
	}

	private void start() {
		while(true) {
			int input = displayMenu();
			switch (input) {
			case 1: insert(); break;	// 추가
			case 2: update(); break;	// 전체 항목 수정
			case 3: delete(); break;	// 삭제
			case 4: printAll(); break;	// 전체 출력
			case 5: update2(); break;	// 수정
			case 0:	// 작업 끝
				System.out.println("프로그램이 종료됩니다");
				System.exit(0);

			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
				break;
			}
			
			
			
		}
	}
	
	// 회원정보를 수정하는 메서드 ==> 원하는 항목만 선택해서 수정하기
	private void update2() {
		System.out.println("자료를 수정할 아이디를 입력해주세요");
		String id  = scan.next();
		
		int count = getMemberCount(id);
		if(count == 0) {
			System.out.println(id + "은(는) 없는 회원ID입니다.");
			return;
		}
		
		int num;
		String updateField = null;
		String updateTittle = null;
		do {
			System.out.println();
			System.out.println("수정할 항목을 입력하세요");
			System.out.println("1. 비밀번호  2. 회원이름  3. 전화번호  4. 회원주소");
			System.out.println("------------------------------------");
			System.out.print("수정항목 선택 >> ");
			num = scan.nextInt();
			
			switch (num) {
			case 1: updateField = "mem_pass";
					updateTittle = "비밀번호"; break;
			case 2: updateField = "mem_name";
					updateTittle = "회원이름"; break;
			case 3: updateField = "mem_tel";
					updateTittle = "전화번호"; break;
			case 4: updateField = "mem_addr";
					updateTittle = "회원주소"; break;
			default:
				System.out.println("수정 항목을 잘못 선택했습니다");
				System.out.println("다시 선택하세요");
				break;
			}
		}while(num < 1 || num > 5);
		
		System.out.println();
		System.out.print("새로운 " + updateTittle + " >> ");
		scan.nextLine();	//버퍼 비우기
		String updateData = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update mymember set " +
					updateField + " = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("수정 작업 성공");
			}else {
				System.out.println("수정 작업 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
			
		
	}

	// 전체 회원정보를 출력하는 메서드
	private void printAll() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println(" ID  비밀번호  이름   전화번호  주소");
		System.out.println("-----------------------------");
		try {
//			conn = DBUtil.getConnection();
//			conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("mem_id") + " | " + rs.getString("mem_pass") + " | " + rs.getString("mem_name") + " | " 
								 + rs.getString("mem_tel") + " | " + rs.getString("mem_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}

	private void delete() {
		System.out.println();
		System.out.println("삭제할 회원정보를 입력하세요");
		System.out.println("삭제할 회원ID >> ");
		String id = scan.next();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
	}

	private void update() {
		conn = DBUtil.getConnection();
		System.out.println("자료를 수정할 아이디를 입력해주세요");
		String id  = scan.next();
		
		String sql = "select count(*) cnt from mymember where mem_id = ?";
		
		int count = getMemberCount(id);
		if(count == 0) {
			System.out.println(id + "은(는) 없는 회원ID입니다.");
			return;
		}
		
		System.out.println("수정할 내용을 입력하세요");
	
		System.out.print("이름 입력 >");
		String name = scan.next();
		
		System.out.print("비밀번호 입력 >");
		String pw = scan.next();
		
		System.out.print("전화번호 입력 >");
		String tel = scan.next();

		scan.nextLine();
		System.out.print("주소 입력 >");
		String addr = scan.nextLine();
		
		try {
			sql = "update mymember set "
					+ "MEM_NAME = ?, "
					+ "MEM_PASS = ?, "
					+ "MEM_TEL = ?, "
					+ "MEM_ADDR = ?"
					+ "where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			pstmt.setString(5, id);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("수정이 성공적으로 완료되었습니다");
			}else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		
		
	}

	private int getMemberCount(String memId) {
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select count(*) cnt from mymember "
					+ " where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return count;
	}
	
	// 사용했던 자원을 반납하는 메서드
	private void disConnect() {
		if(rs != null) try { rs.close(); } catch(SQLException e){}
		if(stmt != null) try { stmt.close(); } catch(SQLException e){}
		if(pstmt != null) try { pstmt.close(); } catch(SQLException e){}
		if(conn != null) try {conn.close(); } catch(SQLException e){}
	}
	
	private void insert() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요");
		
		int count = 0;	// 입력한 회원ID의 개수가 저장될 변수
		String memId = "";	// 회원ID가 저장될 변수
		
		do {
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			// 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
			count = getMemberCount(memId);
			if(count>0) {
				System.out.println(memId + "는 이미 등록된 ID입니다.");
				System.out.println("다른 회원ID를 입력하세요");
			}
			
		}while(count > 0);
		
		
		System.out.print("회원이름 >>");
		String name = scan.next();
		
		System.out.print("비밀번호 >>");
		String pw = scan.next();
		
		System.out.print("전화번호 >>");
		String tel = scan.next();
		
		scan.nextLine();  //입력버퍼 비우기
		System.out.print("주소 >>");
		String addr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into mymember"
					+ "(mem_id, mem_pass, mem_name, mem_tel, mem_addr)"
					+ "values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("등록이 성공적으로 완료되었습니다");
			}else {
				System.out.println("등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}

}