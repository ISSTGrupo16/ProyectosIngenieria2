package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import es.upm.dit.isst.webLab.dao.model.Trabajador;

public class TrabajadorDAOImplementation implements TrabajadorDAO{

	private static TrabajadorDAOImplementation instance;
	private TrabajadorDAOImplementation() {};
	public static TrabajadorDAOImplementation getInstance() {
		if(null== instance) instance = new TrabajadorDAOImplementation();
		return instance;
	}

	@Override
	public void createTrabajador(Trabajador trabajador) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(trabajador);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public Trabajador readTrabajador(String email) {
		// TODO Auto-generated method stub
		Trabajador trabajador = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			trabajador = session.get(Trabajador.class, email);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			
		}finally {
			session.close();
		}
		return trabajador;
	}

	@Override
	public void updateTrabajador(Trabajador trabajador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(trabajador);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteTrabajador(Trabajador trabajador) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(trabajador);
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trabajador> readAllTrabajador() {
		// TODO Auto-generated method stub
		List<Trabajador> trabajadores = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			trabajadores.addAll(
					session.createQuery("from Trabajador").list()
					);
			
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return trabajadores;
	}
	
	
	public Trabajador loginTrabajador(String email, String password) {
		// TODO Auto-generated method stub
		Trabajador trabajador = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();

			trabajador = (Trabajador) session.createQuery("select p from Trabajador p where p.email =:email and p.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
			
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return trabajador;
	}

}



