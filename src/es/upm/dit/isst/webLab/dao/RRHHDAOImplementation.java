package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import es.upm.dit.isst.webLab.dao.model.RRHH;

public class RRHHDAOImplementation implements RRHHDAO{

	private static RRHHDAOImplementation instance;
	private RRHHDAOImplementation() {};
	public static RRHHDAOImplementation getInstance() {
		if(null== instance) instance = new RRHHDAOImplementation();
		return instance;
	}

	@Override
	public void createRRHH(RRHH rrhh) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(rrhh);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public RRHH readRRHH(String email) {
		// TODO Auto-generated method stub
		RRHH rrhh = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			rrhh = session.get(RRHH.class, email);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}finally {
			session.close();
		}
		return rrhh;
	}

	@Override
	public void updateRRHH(RRHH rrhh) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(rrhh);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteRRHH(RRHH rrhh) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(rrhh);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RRHH> readAllRRHH() {
		// TODO Auto-generated method stub
		List<RRHH> rrhhes = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			rrhhes.addAll(
					session.createQuery("from rrhh").list()
					);
			
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return rrhhes;
	}
	
	
	public RRHH loginRRHH(String email, String password) {
		// TODO Auto-generated method stub
		RRHH rrhh = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();

			rrhh = (RRHH) session.createQuery("select p from RRHH p where p.email =:email and p.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
			
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return rrhh;
	}

}



