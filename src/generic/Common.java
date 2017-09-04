package generic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Common {
	static SessionFactory sessionFactory=null;
	Session session=null;
	
public static SessionFactory getSessionFactory(){
	sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	return sessionFactory;
}
}
