package br.com.vinibuffalo.testes;

import br.com.vinibuffalo.dao.CategoriaDao;
import br.com.vinibuffalo.dao.ProdutoDao;
import br.com.vinibuffalo.model.Categoria;
import br.com.vinibuffalo.model.Produto;
import br.com.vinibuffalo.util.JPAUtil;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[]args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        //buscarTodos
        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        //buscarPorNome
        List<Produto> produto = produtoDao.buscarPorNome("Iphone");
        produto.forEach(p2 -> System.out.println(p.getNome()));

        //buscarPorNomeDaCategoria
        List<Produto> produtosDaCat = produtoDao.buscarPorNomeDaCategoria("celulares");
        produtosDaCat.forEach(p2 -> System.out.println(p.getNome()));

        //buscarPrecoPorNome
        BigDecimal precoDoProduto = produtoDao.buscarPrecoPorNome("Iphone");
        System.out.println("Preço do produto: " + precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone","Apple",new BigDecimal("2000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
