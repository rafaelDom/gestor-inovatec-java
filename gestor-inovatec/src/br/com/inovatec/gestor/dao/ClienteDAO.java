package br.com.inovatec.gestor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.inovatec.gestor.modelo.ClienteModel;

@Repository
public class ClienteDAO {
	public void incluir(ClienteModel cliente) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();

		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ClienteModel> listar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT p FROM ClienteModel p ORDER BY p.id desc").setMaxResults(10).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<ClienteModel> buscarId(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT p FROM ClienteModel p where id =" + id).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<ClienteModel> buscarCNPJ_CPF(String cnpj_cpf) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		if (cnpj_cpf != "") {
			return manager.createQuery("SELECT p FROM ClienteModel p where cnpj_cpf LIKE" + "'%" + cnpj_cpf + "%'")
					.getResultList();
		} else {
			return manager.createQuery("SELECT p FROM ClienteModel p ORDER BY p.id desc").getResultList();
		}

	}

	public void excluir(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("DELETE FROM ClienteModel WHERE id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}

	public void alterar(ClienteModel cliente) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(cliente);
		manager.getTransaction().commit();

		manager.close();
	}

	public boolean pesquisarCNPJ_CPF(String cnpj_cpf) {
		boolean ret = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT p FROM ClienteModel p where cnpj_cpf =" + "'" + cnpj_cpf + "'");

		if (!query.getResultList().isEmpty()) {
			ret = true;
		}
		return ret;
	}

	public boolean pesquisarVendaOsCliente(Long id) {
		boolean ret = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		Query queryVenda = manager.createQuery("select v from VendaModel v where cliente_id = " + id);
		Query queryOs = manager.createQuery("select o from OsModel o where cliente_id = " + id);

		if (!queryVenda.getResultList().isEmpty() || !queryOs.getResultList().isEmpty()) {
			ret = true;
		}
		return ret;
	}

}
