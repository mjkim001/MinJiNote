package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * 회원을 관리하는 프로그램을 작성하시오
 * (MYMEMBER 테이블 이용)
 * 
 * 아래 메뉴의 기능을 구현하시오(CRUD 기능 구현하기)
 * 
 * 메뉴 예시)
 * -------------------------
 *       == 작업 예시 ==      
 * 1. 자료 추가			-->insert (C)
 * 2. 자료 수정			-->update (U)
 * 3. 자료 삭제			-->delete (D)
 * 4. 전체 자료 출력		-->select (R)
 * 0. 작업 끝	
 * 
 * 조건)
 * 1) 자료 추가에서 '회원id'는 중복되지 않는다.(중복되면 다시 입력받는다.)
 * 2) 자료 삭제는 '회원id'를 입력받아서  처리한다.
 * 3) 자료 수정에서 '회원id'는 변경되지 않는다.
 */
public class JDBCTest06 {
	Scanner sc = new Scanner(System.in);

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		new JDBCTest06().start();
	}

	private void start() {
		while (true) {
			int input = printMenu();

			switch (input) {
			case 1: // 추가
				insert();
				break;
			case 2: // 수정
				update();
				break;
			case 3: // 삭제
				delete();
				break;
			case 4: // 출력
				printAll();
				break;
			case 5:
				update2();
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 회원 정보를 수정하는 메소드 ==> 원하는 항목만 선택해서 수정하기
	private void update2() {
		String memId = "";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			while (true) { // 입력받은 아이디 존재 여부 확인
				System.out.println("업데이트 할 ID를 입력해주세요");
				memId = sc.next();

				String sql = "SELECT count(*)" + "  	from MYMEMBER " + "    where MEM_ID = '" + memId + "'";

				rs = stmt.executeQuery(sql);
				rs.next();
				String temp = rs.getString(1);

				if (temp == "0") {
					System.out.println("존재하지 않는 아이디입니다. 아이디를 다시 입력해주세요");
					continue;
				} else
					break;
			}
			
			String memName;
			String memPass;
			String memTel;
			String memAddr;
			boolean temp = false;
			
			String sql2 = "UPDATE MYMEMBER" + "		  SET ";

			while (temp) {
				System.out.println("1.이름  2.비밀번호  3.전화번호  4.주소");
				System.out.println("업데이트 할 항목을 입력해주세요");

				String input = sc.next();

				stmt = conn.createStatement();

				switch (input) {
				case "1":
					System.out.println("이름 : ");
					memName = sc.next();
					sql2 += " MEM_NAME = " + memName + ",";
					break;
				case "2":
					System.out.println("비밀번호 : ");
					memPass = sc.next();
					sql2 += " MEM_PASS = " + memPass + ",";
					break;
				case "3":
					System.out.println("전화번호 : ");
					memTel = sc.next();
					sql2 += " MEM_TEL = " + memTel + ",";
					break;
				case "4":
					System.out.println("주소 : ");
					memAddr = sc.next();
					sql2 += " MEM_ADDR = " + memAddr + ",";
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					temp = true;
					break;
				}
			}
			sql2 +=  " where MEM_ID = '" + memId + "'";
			
			stmt.executeUpdate(sql2);

			System.out.println("수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {if (rs == null) {rs.close();}} catch (Exception e2) {}
			try {if (stmt == null) {stmt.close();}} catch (Exception e2) {}
			try {if (pstmt == null) {pstmt.close();}} catch (Exception e2) {}
			try {if (conn == null) {conn.close();}} catch (Exception e2) {}
		}

	}

	private int printMenu() {
		System.out.println("-------------------------");
		System.out.println("      == 작업 예시 ==      ");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝");
		System.out.println("-------------------------");
		System.out.print("메뉴를 선택해주세요. ");

		return sc.nextInt();
	}

	private void insert() { // 추가
		try {
			conn = DBUtil.getConnection();
			String memId = "";
			while (true) {
				// MYMEMBER
				// MEM_ID, MEM_NAME, MEM_PASS, MEM_TEL, MEM_ADDR
				System.out.println("아이디 : ");
				memId = sc.next();

				// 아이디 중복확인
				stmt = conn.createStatement();

				String sql = "SELECT count(*)" + "  	from MYMEMBER " + "    where MEM_ID = '" + memId + "'";

				rs = stmt.executeQuery(sql);

				String temp = "";
				rs.next();
				temp = rs.getString(1);
				System.out.println(temp);
				if (temp == "1") {
					System.out.println("아이디를 다시 입력해주세요");
					continue;
				} else
					break;
			}
			// ---------------------------------

			System.out.println("이름 : ");
			String memName = sc.next();

			System.out.println("비밀번호 : ");
			String memPass = sc.next();

			System.out.println("전화번호 : ");
			String memTel = sc.next();

			System.out.println("주소 : ");
			String memAddr = sc.next();

			// 추가
			String sql2 = "insert INTO MYMEMBER" + "    (MEM_ID, MEM_NAME, MEM_PASS, MEM_TEL, MEM_ADDR)"
					+ "		values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql2);

			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memPass);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);

			System.out.println("등록되었습니다.");
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {if (rs == null) {rs.close();}} catch (Exception e2) {}
			try {if (stmt == null) {stmt.close();}} catch (Exception e2) {}
			try {if (pstmt == null) {pstmt.close();}} catch (Exception e2) {}
			try {if (conn == null) {conn.close();}} catch (Exception e2) {}
		}
	}

	private void update() {
		String memId = "";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			while (true) { // 입력받은 아이디 존재 여부 확인
				System.out.println("업데이트 할 ID를 입력해주세요");
				memId = sc.next();

				String sql = "SELECT count(*)" + "  	from MYMEMBER " + "    where MEM_ID = '" + memId + "'";

				rs = stmt.executeQuery(sql);
				rs.next();
				String temp = rs.getString(1);

				if (temp == "0") {
					System.out.println("존재하지 않는 아이디입니다. 아이디를 다시 입력해주세요");
					continue;
				} else
					break;
			}

			System.out.println("이름 : ");
			String memName = sc.next();

			System.out.println("비밀번호 : ");
			String memPass = sc.next();

			System.out.println("전화번호 : ");
			String memTel = sc.next();

			System.out.println("주소 : ");
			String memAddr = sc.next();

			String sql2 = "UPDATE MYMEMBER" + "		  SET MEM_NAME = ?," + "			  MEM_PASS = ?,"
					+ "			  MEM_TEL = ?," + "			  MEM_ADDR = ?" + "		WHERE MEM_ID = '" + memId + "'";

			pstmt = conn.prepareStatement(sql2);

			pstmt.setString(1, memName);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);

			pstmt.executeUpdate();

			System.out.println("수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {if (rs == null) {rs.close();}} catch (Exception e2) {}
			try {if (stmt == null) {stmt.close();}} catch (Exception e2) {}
			try {if (pstmt == null) {pstmt.close();}} catch (Exception e2) {}
			try {if (conn == null) {conn.close();}} catch (Exception e2) {}
		}

	}

	private void delete() {
		String memId = "";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			while (true) { // 입력받은 아이디 존재 여부 확인
				System.out.println("삭제할 ID를 입력해주세요");
				memId = sc.next();

				String sql = "SELECT count(*)" + "  	from MYMEMBER " + "    where MEM_ID = '" + memId + "'";

				rs = stmt.executeQuery(sql);
				String temp = rs.getString(1);

				if (temp == "0") {
					System.out.println("존재하지 않는 아이디입니다. 아이디를 다시 입력해주세요");
					continue;
				} else
					break;
			}

			String sql2 = "DELETE FROM MYMEMBER WHERE MEM_ID = '" + memId + "'";

			pstmt = conn.prepareStatement(sql2);

			pstmt.executeUpdate();

			System.out.println("삭제되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {if (rs == null) {rs.close();}} catch (Exception e2) {}
			try {if (stmt == null) {stmt.close();}} catch (Exception e2) {}
			try {if (pstmt == null) {pstmt.close();}} catch (Exception e2) {}
			try {if (conn == null) {conn.close();}} catch (Exception e2) {}
		}

	}

	private void printAll() {
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from MYMEMBER";
			rs = stmt.executeQuery(sql);

			// MYMEMBER
			// MEM_ID, MEM_NAME, MEM_PASS, MEM_TEL, MEM_ADDR
			System.out.println("---------------------------------------");
			System.out.println("아이디\t이름\t비밀번호\t전화번호\t주소");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5));
			}
			System.out.println("---------------------------------------");

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {if (rs == null) {rs.close();}} catch (Exception e2) {}
			try {if (stmt == null) {stmt.close();}} catch (Exception e2) {}
			try {if (pstmt == null) {pstmt.close();}} catch (Exception e2) {}
			try {if (conn == null) {conn.close();}} catch (Exception e2) {}
		}
	}

}
