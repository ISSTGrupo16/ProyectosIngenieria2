package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import es.upm.dit.isst.webLab.dao.model.Contrato;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;

public class ContratoDAOImplementation implements ContratoDAO {
	
	private static ContratoDAOImplementation instance;
	private ContratoDAOImplementation() {};
	public static ContratoDAOImplementation getInstance() {
		if(null == instance) instance = new ContratoDAOImplementation();
		return instance;
	}


	@Override
	public void createContrato(Contrato contrato) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(contrato);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}
	

	@Override
	public Contrato readContrato(String title) {
		Contrato contrato = null;
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			contrato = session.get(Contrato.class, title);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return contrato;
	}
	

	@Override
	public void updateContrato(Contrato contrato) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(contrato);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}
	

	@Override
	public void deleteContrato(Contrato contrato) {
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			session.beginTransaction();
			session.delete(contrato);
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
	}

	

	@Override
	public List<Contrato> readAllContrato() {

		List<Contrato> contratos = new ArrayList<>();
		
		Session session = SessionFactoryService.get().openSession();
		
		try {
			
			session.beginTransaction();
			contratos.addAll(
					session.createQuery("from Contrato").list()
					);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return contratos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> readProyectos(Trabajador trabajador){
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			proyectos = session.createQuery("select p.proyecto from Contrato p where p.trabajador =:trabajador")
				.setParameter("trabajador", trabajador)
				.list();
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return proyectos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Trabajador> readTrabajador(Proyecto proyecto){
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			trabajadores = session.createQuery("select p.proyecto from Contrato p where p.proyecto =:proyecto")
				.setParameter("proyecto", proyecto)
				.list();
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return trabajadores;
	}
	
	@Override
	public Contrato readContrato(Trabajador trabajador, Proyecto proyecto) {
		Contrato contrato = new Contrato();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			contrato = (Contrato) session.createQuery("select p from Contrato p where p.proyecto =:proyecto and p.trabajador = :trabajador")
				.setParameter("proyecto", proyecto)
				.setParameter("trabajador", trabajador)
				.getSingleResult();
			session.getTransaction().commit();
		}
		catch (Exception e){
			
		}finally {
			session.close();
		}
		return contrato;
	}


}
