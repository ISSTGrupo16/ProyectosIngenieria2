package es.upm.dit.isst.webLab.dao;


import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.dao.model.Proyecto;

public class ProyectoDAOImplementation implements ProyectoDAO {
	
	private static ProyectoDAOImplementation instance;
	private ProyectoDAOImplementation() {};
	public static ProyectoDAOImplementation getInstance() {
		if(null == instance) instance = new ProyectoDAOImplementation();
		return instance;
	}


	@Override
	public void createProyecto(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.save(proyecto);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}
	

	@Override
	public Proyecto readProyecto(String title) {
		Proyecto proyecto = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			proyecto = session.get(Proyecto.class, title);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return proyecto;
	}
	

	@Override
	public void updateProyecto(Proyecto proyecto) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(proyecto);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}
	

	@Override
	public void deleteProyecto(Proyecto proyecto) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.delete(proyecto);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}

	

	@Override
	public List<Proyecto> readAllProyecto() {

		List<Proyecto> proyectos = new ArrayList<>();
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			
			session.beginTransaction();
			proyectos.addAll(
					session.createQuery("from Proyecto").list()
					);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return proyectos;
	}

}
