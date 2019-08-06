package br.com.inovatec.gestor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.inovatec.gestor.modelo.ClienteModel;
import br.com.inovatec.gestor.modelo.OsModel;

@Repository
public class OsDAO {
	public void incluir(OsModel os) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(os);
		manager.getTransaction().commit();

		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<OsModel> listar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT p FROM OsModel p ORDER BY p.id desc").setMaxResults(10).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<OsModel> buscarId(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT p FROM OsModel p where os_id =" + id).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<OsModel> buscarCNPJ_CPF(String cnpj_cpf) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		if (cnpj_cpf != "") {
			return manager.createQuery("SELECT p FROM OsModel p where cliente.cnpj_cpf LIKE" + "'%" + cnpj_cpf + "%'")
					.getResultList();
		} else {
			return manager.createQuery("SELECT p FROM OsModel p ORDER BY p.id desc").getResultList();
		}

	}

	public void excluir(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("DELETE FROM OsModel WHERE os_id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}

	public void alterar(OsModel os) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(os);
		manager.getTransaction().commit();

		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ClienteModel> pesquisarCNPJ_CPF(String cnpj_cpf) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		return manager.createQuery("SELECT p FROM ClienteModel p where cnpj_cpf =" + "'" + cnpj_cpf + "'")
				.getResultList();
	}

}
