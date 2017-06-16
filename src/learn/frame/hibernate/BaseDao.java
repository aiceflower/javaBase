package learn.frame.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class BaseDao {
	private static Configuration s_oHibernateXMLCfg = null;
	private static SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void main(String[] args) {
		s_oHibernateXMLCfg = new Configuration();
		s_oHibernateXMLCfg.configure("hibernate.cfg.xml");
		sessionFactory = s_oHibernateXMLCfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println(session);
		System.out.println("hehe");
	}
}
