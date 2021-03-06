package dataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import domainModel.Fabricante;

public class FabricanteRepository {
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public FabricanteRepository(){
		factory = Persistence.createEntityManagerFactory("InteracoesMedicamentosas");
		manager = factory.createEntityManager();
	}
	public void Save(Fabricante obj) throws Exception{
		try{
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	public void Delete(Fabricante obj) throws Exception{
		try{
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	public Fabricante Open(int id)throws Exception{
		try{
			return manager.find(Fabricante.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getTop10ByName(){
		return manager.createQuery("select f from Fabricante f order by f.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getAllbyName(){
		return manager.createQuery("select f from Fabricante f order by f.nome")
		.getResultList();
	}
}
