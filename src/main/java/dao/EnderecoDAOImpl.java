package dao;

import model.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class EnderecoDAOImpl implements EnderecoDAO {

    private EntityManager em;

    public EnderecoDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void salvar(Endereco endereco) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(endereco);
        tx.commit();
    }

    public void alterar(Endereco endereco) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(endereco);
        tx.commit();
    }

    public void remover(Endereco endereco) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(endereco);
        tx.commit();
    }

    public Endereco pesquisar(Long id) {
        Endereco endereco = em.find(Endereco.class,id);
        return endereco;
    }

    public List<Endereco> recuperarTodos() {
        Query query = em.createQuery("from Endereco e");
        List<Endereco> enderecos = query.getResultList();
        return enderecos;
    }
}