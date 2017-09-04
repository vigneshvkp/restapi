package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import generic.Common;
import pojo.User;

public class UserDetail {

	static SessionFactory sessionfact=null;
	static Session session=null;
	static Transaction tx=null;
	
	public UserDetail(){
		sessionfact=Common.getSessionFactory();
		session=sessionfact.openSession();
	}

	public static void insert(User user){
		System.out.println("before insert ");
		System.out.println("usernae "+user.getUserName());
		System.out.println("passwof "+user.getPassWord());
		tx=session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
	
	
	public static boolean isExists(User user){
		tx=session.beginTransaction();
		User temp = (User) session.get(User.class, user.getUserName());
		if(temp.getPassWord().equals(user.getPassWord())){
			return true;
		}
		return false;
	}
	
	public static List listAllUser(){
		tx=session.beginTransaction();
		List<User> list = (List<User>) session.createQuery("from User").list();
		return list;
	}
	
	public static List listUserById(String id){
		tx=session.beginTransaction();
		List<User> list = (List<User>) session.createQuery("from User where username=:userid").setParameter("userid", id).list();
		return list;
	}
}
