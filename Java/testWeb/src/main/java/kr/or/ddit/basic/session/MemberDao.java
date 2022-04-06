package kr.or.ddit.basic.session;

public class MemberDao {
	private static MemberDao dao;
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(dao==null) dao =new MemberDao();
		return dao;
	}
	
	public M
	
}
