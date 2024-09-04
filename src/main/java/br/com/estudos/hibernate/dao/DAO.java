package br.com.estudos.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class DAO<T> {

    protected EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

public void salvar(T entidade) {
    entityManager.getTransaction().begin();
    entityManager.persist(entidade);
    entityManager.getTransaction().commit();
}

public void atualizar(T entidade) {
    entityManager.getTransaction().begin();
    entityManager.merge(entidade);
    entityManager.getTransaction().commit();
}

public void excluir(T entidade) {
    entityManager.getTransaction().begin();
    entityManager.remove(entityManager.merge(entidade));
    entityManager.getTransaction().commit();
}

public T buscarPorId(Class<T> clazz, Long id) {
    return entityManager.find(clazz, id);
}

public List<T> buscarTodos(Class<T> clazz) {
    return entityManager.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
}

}
