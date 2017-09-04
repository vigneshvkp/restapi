package Test;

import java.util.ArrayList;
import java.util.List;

import dao.UserDetail;
import pojo.User;

public class ListUsersbyId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<User> list=new UserDetail().listUserById("13");

		for(User ss: list){
			System.out.println(ss.getPassWord());
			System.out.println(ss.getUserName());
		}

	}

}
