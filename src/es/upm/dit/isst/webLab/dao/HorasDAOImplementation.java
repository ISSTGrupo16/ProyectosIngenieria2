package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.dao.model.Horas;

public class HorasDAOImplementation implements HorasDAO {
	
	private static HorasDAOImplementation instance;
	private HorasDAOImplementation() {};
	public static HorasDAOImplementation getInstance() {
		if(null == instance) instance = new HorasDAOImplementation();
		return instance;
	}


	@Override
	public void createHoras(Horas horas) {
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(horas);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}
	

	@Override
	public Horas readHoras(String title) {
		Horas horas = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			horas = session.get(Horas.class, title);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return horas;
	}
	

	@Override
	public void updateHoras(Horas horas) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(horas);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}
	

	@Override
	public void deleteHoras(Horas horas) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.delete(horas);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}

	

	@Override
	public List<Horas> readAllHoras() {

		List<Horas> horas = new ArrayList<>();
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			
			session.beginTransaction();
			horas.addAll(
					session.createQuery("from Horas").list()
					);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return horas;
	}

}
