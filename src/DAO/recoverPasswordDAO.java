package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import VO.addResidentVO;


public class recoverPasswordDAO {
	public List authentication(addResidentVO addResidentVO) {
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_user=new ArrayList<addResidentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addResidentVO where email_id='"+addResidentVO.getEmail_id()+"' ");
			list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}

}
