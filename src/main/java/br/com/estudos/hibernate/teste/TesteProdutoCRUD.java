package br.com.estudos.hibernate.teste;

import br.com.estudos.hibernate.dao.DAO;
import br.com.estudos.hibernate.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class TesteProdutoCRUD {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleestoque");
        EntityManager em = emf.createEntityManager();

        DAO<Produto> produtoDAO = new DAO<>();
        produtoDAO.setEntityManager(em);

        Produto panela = new Produto("Panela", "Panela de Pressão 10 Litros", new BigDecimal("56.80"));
        Produto cama = new Produto("Cama", "Cama de casal Big", new BigDecimal("450.68"));
        Produto caixaSom = new Produto("Caixa Som", "Caixa de Som JBL", new BigDecimal("160.00"));

        // Salvar produtos
        produtoDAO.salvar(panela);
        produtoDAO.salvar(cama);
        produtoDAO.salvar(caixaSom);

        // Buscar produto por ID (código 2)
        Produto produtoAtualizar = produtoDAO.buscarPorId(Produto.class, 2L);
        if (produtoAtualizar != null) {
            produtoAtualizar.setPreco(new BigDecimal("345.00"));
            produtoDAO.atualizar(produtoAtualizar);
        } else {
            System.out.println("Produto com código 2 não encontrado.");
        }

        // Excluir produto por ID (código 3)
        Produto produtoExcluir = produtoDAO.buscarPorId(Produto.class, 3L);
        if (produtoExcluir != null) {
            produtoDAO.excluir(produtoExcluir);
        } else {
            System.out.println("Produto com código 3 não encontrado.");
        }

        // Buscar produto por ID (código 1)
        Produto produtoEncontrado = produtoDAO.buscarPorId(Produto.class, 1L);
        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado:");
            System.out.println("Código: " + produtoEncontrado.getCod());
            System.out.println("Nome: " + produtoEncontrado.getNome());
            System.out.println("Descrição: " + produtoEncontrado.getDescricao());
            System.out.println("Preço: " + produtoEncontrado.getPreco());
        } else {
            System.out.println("Produto com código 1 não encontrado.");
        }

        // Buscar todos os produtos
        List<Produto> todosProdutos = produtoDAO.buscarTodos(Produto.class);

        System.out.println("\nTodos os produtos:");
        for (Produto produto : todosProdutos) {
            System.out.println("Código: " + produto.getCod());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("------------------------");

        }

        em.close();
        emf.close();
    }
}