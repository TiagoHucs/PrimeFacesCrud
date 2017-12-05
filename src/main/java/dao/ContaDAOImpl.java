package dao;

import model.Conta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ContaDAOImpl implements ContaDAO {

    private EntityManager em;

    public ContaDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void salvar(Conta conta) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(conta);
        tx.commit();
    }

    public void alterar(Conta conta) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(conta);
        tx.commit();
    }

    public void remover(Conta conta) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(conta);
        tx.commit();
    }

    public Conta pesquisar(Long id) {
        Conta conta = em.find(Conta.class,id);
        return conta;
    }

    public List<Conta> recuperarTodos() {
        Query query = em.createQuery("from Conta c");
        List<Conta> contas = query.getResultList();
        return contas;
    }

}