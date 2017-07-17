package DAO;

import java.util.ArrayList;   
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import VO.addApartmentPhotosVO;
import VO.addApartmentVO;
import VO.loginVO;
import VO.rentalRequestVO;



public class addApartmentDAO {
	public int addApartment(addApartmentVO addApartmentVO) 
	{
		int apartment_id = -1;
	try
	{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			
			session.save(addApartmentVO);
			apartment_id = addApartmentVO.getApartment_id();
			transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return apartment_id;
	}
	public int addRentalRequest(rentalRequestVO rentalRequestVO) 
	{
		int rental_id=0;
	try
	{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(rentalRequestVO);
			transaction.commit();
			rental_id=rentalRequestVO.getRental_request_id();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return rental_id;
	}
	public List authentication(addApartmentVO addApartmentVO)
	{
		// TODO Auto-generated method stub
		List<loginVO> list_of_user=new ArrayList<loginVO>();
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
	public void updateApartment(addApartmentVO addApartmentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update addApartmentVO set address = '"+addApartmentVO.getAddress()+"', bedroom = '"+addApartmentVO.getBedroom()+"', bathroom='"+addApartmentVO.getBathroom()+"', aminities = '"+addApartmentVO.getAminities()+"', city='"+addApartmentVO.getCity()+"', state='"+addApartmentVO.getState()+"', zip_code='"+addApartmentVO.getZip_code()+"', price='"+addApartmentVO.getPrice()+"' where apartment_id='"+addApartmentVO.getApartment_id()+"'");
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
	public void denyRental(rentalRequestVO rentalRequestVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update rentalRequestVO set status = '"+rentalRequestVO.getStatus()+"' where rental_request_id='"+rentalRequestVO.getRental_request_id()+"'");
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
	public List<addApartmentVO> search_all_apartments() 
	{
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_all_apartments=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addApartmentVO where rental_status='available'");
			list_of_all_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_apartments;	
	}
	public List<addApartmentVO> search_all_apartments1() 
	{
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_all_apartments=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addApartmentVO");
			list_of_all_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_apartments;	
	}
	public static List<rentalRequestVO> search_all_rental_request() 
	{
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_all_apartments=new ArrayList<rentalRequestVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from rentalRequestVO where status = 'pending' and addApartmentVO.rental_status = 'available'");
			list_of_all_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_apartments;	
	}
	public List<rentalRequestVO> fetch_all_rental_request() 
	{
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_all_apartments=new ArrayList<rentalRequestVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from rentalRequestVO where status = 'pending'");
			list_of_all_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_apartments;	
	}
	public List<rentalRequestVO> search_all_rental_request1() 
	{
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_all_apartments=new ArrayList<rentalRequestVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from rentalRequestVO where status = 'pending' and addApartmentVO.rental_status = 'available'");
			list_of_all_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_apartments;	
	}
	public void delete_apartment(addApartmentVO addApartmentVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.delete(addApartmentVO);
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void delete_rental_request(rentalRequestVO rentalRequestVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.delete(rentalRequestVO);
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public List authentication_request(rentalRequestVO rentalRequestVO)
	{
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_rental_request=new ArrayList<rentalRequestVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from rentalRequestVO where email_id='"+rentalRequestVO.getEmail_id()+"' and addApartmentVO='"+rentalRequestVO.getAddApartmentVO().getApartment_id()+"'");
				list_of_rental_request=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_rental_request;
	}
	public List<addApartmentVO> edit_apartments(addApartmentVO addApartmentVO) {
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_apartments=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addApartmentVO where apartment_id='"+addApartmentVO.getApartment_id()+"'");
			list_of_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartments;
	}
	public List<rentalRequestVO> edit_rental_request(rentalRequestVO rentalRequestVO) {
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_apartments=new ArrayList<rentalRequestVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from rentalRequestVO where rental_request_id='"+rentalRequestVO.getRental_request_id()+"'");
			list_of_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartments;
	}
	public List<addApartmentPhotosVO> apartment_photos(addApartmentPhotosVO addApartmentPhotosVO) {
		// TODO Auto-generated method stub
		List<addApartmentPhotosVO> list_of_apartments=new ArrayList<addApartmentPhotosVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addApartmentPhotosVO where addApartmentVO='"+addApartmentPhotosVO.getAddApartmentVO().getApartment_id()+"'");
			list_of_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartments;
	}
	public List<addApartmentVO> fetchApartment(addApartmentVO addApartmentVO)
	{
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_apartment=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addApartmentVO where rental_status='available' order by apartment_id desc");
			list_of_apartment=q.list();
				System.out.println("list size" +list_of_apartment.size());
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartment;
	}
	public List<addApartmentVO> fetchApartment2(addApartmentVO addApartmentVO)
	{
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_apartment=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addApartmentVO where rental_status='available'");
			list_of_apartment=q.list();
				System.out.println("list size" +list_of_apartment.size());
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartment;
	}
	public List<addApartmentVO> fetchApartment1(addApartmentVO addApartmentVO)
	{
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_apartment=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addApartmentVO where rental_status='available' and bedroom='"+addApartmentVO.getBedroom()+"' and bathroom='"+addApartmentVO.getBathroom()+"'");
			list_of_apartment=q.list();
				System.out.println("list size" +list_of_apartment.size());
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartment;
	}
	public List<addApartmentVO> apartment_address(addApartmentVO addApartmentVO) {
		// TODO Auto-generated method stub
		List<addApartmentVO> list_of_apartments=new ArrayList<addApartmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addApartmentVO where apartment_id='"+addApartmentVO.getApartment_id()+"'");
			list_of_apartments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_apartments;
	}
}
