package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;







import VO.addApartmentVO;
import VO.addResidentVO;
import VO.loginVO;
import VO.paymentVO;


public class addResidentDAO {
	public int addResident(addResidentVO addResidentVO) 
	{
		int resident_id = -1;
	try
	{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(addResidentVO);
			resident_id = addResidentVO.getResident_id();
			transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return resident_id;
	}
	
	public int addPayment(paymentVO paymentVO) 
	{
		int resident_id = -1;
	try
	{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(paymentVO);
			resident_id = paymentVO.getPayment_id();
			transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return resident_id;
	}
	
	public static List fetchid(addResidentVO addResidentVO)
	{
		// TODO Auto-generated method stub
		List<loginVO> list_of_user=new ArrayList<loginVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addResidentVO where resident_id='"+addResidentVO.getResident_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	
	public List<addResidentVO> search_all_residents() 
	{
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_all_residents=new ArrayList<addResidentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addResidentVO where user_type='resident'");
		
			list_of_all_residents=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_residents;	
		
	}
	public List<paymentVO> search_all_payments() 
	{
		// TODO Auto-generated method stub
		List<paymentVO> list_of_all_payments=new ArrayList<paymentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from paymentVO");
		
			list_of_all_payments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_payments;	
		
	}
	public List<paymentVO> search_all_payment(String user_name) 
	{
		// TODO Auto-generated method stub
		List<paymentVO> list_of_all_payments=new ArrayList<paymentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from paymentVO where status='paid' and addResidentVO.user_id = '"+user_name+"' order by payment_id desc");
		
			list_of_all_payments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_payments;	
		
	}
	public List<paymentVO> search_all_payment1(String user_name) 
	{
		// TODO Auto-generated method stub
		List<paymentVO> list_of_all_payments=new ArrayList<paymentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from paymentVO where status='pending' or status='failed' and addResidentVO.user_id = '"+user_name+"'");
		
			list_of_all_payments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_payments;	
		
	}
	public List<addResidentVO> edit_residents(addResidentVO addResidentVO) {
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_residents=new ArrayList<addResidentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addResidentVO where resident_id='"+addResidentVO.getResident_id()+"'");
		
			list_of_residents=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_residents;
	}
	public void update_resident(addResidentVO addResidentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update addResidentVO set first_name = '"+addResidentVO.getFirst_name()+"', last_name='"+addResidentVO.getLast_name()+"', email_id='"+addResidentVO.getEmail_id()+"', phone_no='"+addResidentVO.getPhone_no()+"', user_id='"+addResidentVO.getUser_id()+"', password='"+addResidentVO.getPassword()+"' where resident_id='"+addResidentVO.getResident_id()+"'");
		int result = q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public void update_payment(paymentVO paymentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update paymentVO set status = '"+paymentVO.getStatus()+"',payment_date='"+paymentVO.getPayment_date()+"' where payment_id='"+paymentVO.getPayment_id()+"'");
		q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public void update_payment1(paymentVO paymentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update paymentVO set status = '"+paymentVO.getStatus()+"' where payment_id='"+paymentVO.getPayment_id()+"'");
		q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public void update_rental_status(addResidentVO addResidentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update addApartmentVO set rental_status='rented' where apartment_id='"+addResidentVO.getAddApartmentVO().getApartment_id()+"'");
		int result = q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	
	public void update_resident1(addResidentVO addResidentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update addResidentVO set first_name = '"+addResidentVO.getFirst_name()+"', last_name='"+addResidentVO.getLast_name()+"', phone_no='"+addResidentVO.getPhone_no()+"', address='"+addResidentVO.getAddress()+"' where resident_id='"+addResidentVO.getResident_id()+"'");
		int result = q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public void delete_resident(addResidentVO addResidentVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(addResidentVO);
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void updatePassword(addResidentVO addResidentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update addResidentVO set password = '"+addResidentVO.getPassword()+"' where user_id='"+addResidentVO.getUser_id()+"'");
		int result = q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public List authentication(addResidentVO addResidentVO)
	{
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_user=new ArrayList<addResidentVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addResidentVO where resident_id='"+addResidentVO.getResident_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List getAddress(addApartmentVO addApartmentVO)
	{
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_user=new ArrayList<addResidentVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addResidentVO where apartment_id='"+addApartmentVO.getApartment_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List authentication1(addApartmentVO addApartmentVO)
	{
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_user=new ArrayList<addApartmentVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addApartmentVO where apartment_id='"+addApartmentVO.getApartment_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List authentication_email(addResidentVO addResidentVO)
	{
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_user=new ArrayList<addResidentVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addResidentVO where email_id='"+addResidentVO.getEmail_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List authentication_userid(addResidentVO addResidentVO)
	{
		// TODO Auto-generated method stub
		List<addResidentVO> list_of_user=new ArrayList<addResidentVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addResidentVO where user_id='"+addResidentVO.getUser_id()+"'");
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
