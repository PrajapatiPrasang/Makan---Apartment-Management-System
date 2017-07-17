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
import VO.requestServiceVO;

public class requestServiceDAO {
	public int addService(requestServiceVO requestServiceVO) 
	{
		int service_id = -1;
	try
	{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			
			session.save(requestServiceVO);
			service_id = requestServiceVO.getService_id();
			transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return service_id;
	}
	public List<requestServiceVO> search_all_services() 
	{
		// TODO Auto-generated method stub
		List<requestServiceVO> list_of_all_services=new ArrayList<requestServiceVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from requestServiceVO");
		
			list_of_all_services=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_services;	
		
	}
	public List<requestServiceVO> search_service(requestServiceVO requestServiceVO) 
	{
		// TODO Auto-generated method stub
		List<requestServiceVO> list_of_all_services=new ArrayList<requestServiceVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("from requestServiceVO where service_id='"+requestServiceVO.getService_id()+"'");
		
			list_of_all_services=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_services;	
		
	}
	public List<addResidentVO> search_resident(addResidentVO addResidentVO) {
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
	public void delete_request(requestServiceVO requestServiceVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.delete(requestServiceVO);
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
