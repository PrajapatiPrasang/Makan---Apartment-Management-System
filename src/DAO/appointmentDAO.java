package DAO;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import VO.addApartmentVO;
import VO.addAppointmentVO;
import VO.addResidentVO;
import VO.loginVO;
import VO.rentalRequestVO;

public class appointmentDAO {

	public static int insertNewAppointment(addAppointmentVO addAppointmentVO) 
	{
		int appointment_id = -1;
	try
	{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(addAppointmentVO);
			appointment_id = addAppointmentVO.getAppointment_id();
			transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return appointment_id;
	}
	
	public static List<addAppointmentVO> searchAppointment(addAppointmentVO addAppointmentVO) {
		// TODO Auto-generated method stub
		List<addAppointmentVO> list_of_appointments=new ArrayList<addAppointmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addAppointmentVO where appointment_id='"+addAppointmentVO.getAppointment_id()+"'");
		
			list_of_appointments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointments;
	}
	public List<addAppointmentVO> searchAppointment2(addAppointmentVO addAppointmentVO) {
		// TODO Auto-generated method stub
		List<addAppointmentVO> list_of_appointments=new ArrayList<addAppointmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addAppointmentVO where appointment_id='"+addAppointmentVO.getAppointment_id()+"' and emaiid='"+addAppointmentVO.getEmaiid()+"'");
		
			list_of_appointments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointments;
	}
	public List<rentalRequestVO> searchRentalRequest(rentalRequestVO rentalRequestVO) {
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_appointments=new ArrayList<rentalRequestVO>();
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from rentalRequestVO where rental_request_id='"+rentalRequestVO.getRental_request_id()+"' and email_id='"+rentalRequestVO.getEmail_id()+"'");
			list_of_appointments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointments;
	}
	public List<addAppointmentVO> searchAppointment1(addAppointmentVO addAppointmentVO) {
		// TODO Auto-generated method stub
		List<addAppointmentVO> list_of_appointments=new ArrayList<addAppointmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addAppointmentVO where appointment_id='"+addAppointmentVO.getAppointment_id()+"'");
		
			list_of_appointments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointments;
	}
	public List<addAppointmentVO> updateAppointment(addAppointmentVO addAppointmentVO) {
		// TODO Auto-generated method stub
		List<addAppointmentVO> list_of_appointments=new ArrayList<addAppointmentVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from addAppointmentVO where appointment_id='"+addAppointmentVO.getAppointment_id()+"'");
		
			list_of_appointments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointments;
	}
	public List<rentalRequestVO> getRentalData(rentalRequestVO rentalRequestVO) {
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_appointments=new ArrayList<rentalRequestVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from rentalRequestVO where rental_request_id='"+rentalRequestVO.getRental_request_id()+"'");
		
			list_of_appointments=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointments;
	}
	public List fetch_appointment(addAppointmentVO addAppointmentVO)
	{
		// TODO Auto-generated method stub
		List<addAppointmentVO> list_of_appointment=new ArrayList<addAppointmentVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addAppointmentVO where appointment_id='"+addAppointmentVO.getAppointment_id()+"' and emaiid='"+addAppointmentVO.getEmaiid()+"'");
				list_of_appointment=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointment;
	}
	public List fetch_rental_request(rentalRequestVO rentalRequestVO)
	{
		// TODO Auto-generated method stub
		List<rentalRequestVO> list_of_appointment=new ArrayList<rentalRequestVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from rentalRequestVO where rental_request_id='"+rentalRequestVO.getRental_request_id()+"' and email_id='"+rentalRequestVO.getEmail_id()+"'");
				list_of_appointment=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_appointment;
	}
	public void update_appointment(addAppointmentVO addAppointmentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update addAppointmentVO set firstname = '"+addAppointmentVO.getFirstname()+"', lastname='"+addAppointmentVO.getLastname()+"', emaiid='"+addAppointmentVO.getEmaiid()+"', phoneno='"+addAppointmentVO.getPhoneno()+"', address='"+addAppointmentVO.getAddress()+"', date='"+addAppointmentVO.getDate()+"', slot='"+addAppointmentVO.getSlot()+"' where appointment_id='"+addAppointmentVO.getAppointment_id()+"'");
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
	public void delete_appointment(addAppointmentVO addAppointmentVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.delete(addAppointmentVO);
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void delete_rental(rentalRequestVO rentalRequestVO) {
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
	public List<addApartmentVO> all_apartments(addApartmentVO addApartmentVO) {
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
