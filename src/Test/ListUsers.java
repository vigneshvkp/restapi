package Test;

import java.util.ArrayList;
import java.util.List;

import dao.UserDetail;
import pojo.User;

public class ListUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<User> list=new UserDetail().listAllUser();
		List ls=list;
//		for(User ss: list){
//			System.out.println(ss);
//		}
		System.out.println(list);
	}

}
