package Test;

import dao.UserDetail;
import pojo.User;

public class InsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("stated");
		UserDetail userdetail=new UserDetail();
		userdetail.insert(new User("user","pass"));
		System.out.println("completed");
	}

}
