package br.com.inovatec.gestor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import br.com.inovatec.gestor.modelo.UsuarioModel;

@Repository
public class UsuarioDAO {
	@SuppressWarnings("unchecked")
	public List<UsuarioModel> existeUsuario(UsuarioModel usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Gestor");
		EntityManager manager = factory.createEntityManager();
		return manager.createQuery("SELECT u FROM UsuarioModel u where usuario = " + "'" + usuario.getUsuario() + "'"
				+ "and senha = " + "'" + usuario.getSenha() + "'").getResultList();

	}

}
