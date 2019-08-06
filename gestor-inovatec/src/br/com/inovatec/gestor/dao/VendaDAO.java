package br.com.inovatec.gestor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.inovatec.gestor.modelo.ClienteModel;
import br.com.inovatec.gestor.modelo.OsModel;
import br.com.inovatec.gestor.modelo.VendaModel;

@Repository
public class VendaDAO {
	public void incluir(VendaModel vendas) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(vendas);
		manager.getTransaction().commit();

		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<VendaModel> listar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT p FROM VendaModel p ORDER BY p.id desc").setMaxResults(10).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<VendaModel> buscarId(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT p FROM VendaModel p where venda_id =" + id).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<VendaModel> buscarCNPJ_CPF(String cnpj_cpf) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		if (cnpj_cpf != "") {
			return manager.createQuery("SELECT p FROM VendaModel p where cliente.cnpj_cpf LIKE" + "'%" + cnpj_cpf + "%'")
					.getResultList();
		} else {
			return manager.createQuery("SELECT p FROM VendaModel p ORDER BY p.id desc").getResultList();
		}

	}

	public void excluir(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("DELETE FROM VendaModel WHERE venda_id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}

	public void alterar(VendaModel venda) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(venda);
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
