package br.com.vinibuffalo.dao;

import br.com.vinibuffalo.model.Cliente;
import br.com.vinibuffalo.model.Produto;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }
}
