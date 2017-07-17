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



public class addApartmentPhotosDAO {
	public int add_photos(addApartmentPhotosVO addApartmentPhotosVO) 
	{
		int photo_id = -1;
	try
	{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			
			session.save(addApartmentPhotosVO);
			photo_id = addApartmentPhotosVO.getPhoto_id();
			transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return photo_id;
	}
	public List<addApartmentPhotosVO> search_all_apartments_photos() 
	{
		// TODO Auto-generated method stub
		List<addApartmentPhotosVO> list_of_all_apartments_photos=new ArrayList<addApartmentPhotosVO>();
		try{
			
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from addApartmentPhotosVO");
			list_of_all_apartments_photos=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_all_apartments_photos;	
	}
	
	public void delete_apartment_photos(addApartmentPhotosVO addApartmentPhotosVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.delete(addApartmentPhotosVO);
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
