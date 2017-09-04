package service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.UserDetail;
import pojo.User;

@Path("/insert")
public class InsertService {
	
	UserDetail userDetail =new UserDetail();
	
	@POST
	@Path("/insertuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertUser(User user){
		System.out.println("insert called ni json");
		System.out.println("user "+user);
	//	System.out.println("username  "+user.getUserName());
		userDetail.insert(user);
	}
	
//	@POST
//	@Path("/insertuser")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public void insertUser(@FormParam("username") String un, @FormParam("password") String pw){
//		System.out.println("rev un "+un);
//		System.out.println("rec pw "+pw);
//		System.out.println("insert called 2 insert");
//	//	System.out.println("username  "+user.getUserName());
//		userDetail.insert(new User(un,pw));
//	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void login(@FormParam("username") String userName, @FormParam("password") String passWord){
		if(userDetail.isExists(new User(userName,passWord))){
			System.out.println("success--------");
		}
		else{
			System.out.println("failure ---------");
		}
	}
	
	@GET
	@Path("/listuser")
	@Consumes(MediaType.APPLICATION_XML)
	public List<User> listuser(){
		List<User> list=UserDetail.listAllUser();
		return list;
	}
	
	
	@POST
	@Path("/listuserbyid")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("application/json")
	public User listuserbyid(String id){
		List<User> list=UserDetail.listUserById(id);
		System.out.println("sending --- "+list);
//		return list;
		//return list;
		//Gson gson = new Gson();
		for(User us:list){
			return us;
		}
		return null;
		
	}
	
	
	@GET
	@Path("/showuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public List<User> showuser(){
		List<User> list=UserDetail.listAllUser();
		return list;
	}
	
	
}
