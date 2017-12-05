package dao;

import model.Pessoa;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PessoaDAOImpl implements PessoaDAO {

	private SessionFactory em;

	public PessoaDAOImpl(SessionFactory em) throws SQLException {
		this.em = em;
	}

	public void salvar(Pessoa pessoa) throws SQLException {
		Session session = em.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.persist(pessoa);
		tx.commit();
	}

	public void alterar(Pessoa pessoa) throws SQLException {
		Session session = em.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.merge(pessoa);
		tx.commit();
	}

	public void remover(Pessoa pessoa) throws SQLException {
		Session session = em.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.delete(pessoa);
		tx.commit();
	}

	public Pessoa pesquisar(String cpf) throws SQLException {
		Session session = em.openSession();
		Pessoa pessoa = (Pessoa) session.get(Pessoa.class, cpf);
		return pessoa;
	}

	public List<Pessoa> recuperarTodos() throws SQLException {
		Session session = em.openSession();
		Query query = session.createQuery("from Pessoa p");
		List<Pessoa> pessoas = query.list();
		return pessoas;
	}

	public List<Pessoa> pesquisarCondicional(Pessoa pessoa) throws SQLException {
		Session session = em.openSession();
		Query query = session.createQuery("from Pessoa p " + montarWherePasquisa(pessoa));
		List<Pessoa> pessoas = query.list();
		return pessoas;
	}

	private String montarWherePasquisa(Pessoa pessoa) throws SQLException {
		String where = null;
		Boolean isWhere = false;

		Integer condicoes = 0;

		if (!pessoa.getNome().isEmpty()) {
			where = " where nome like '%" + pessoa.getNome() + "%'";
			isWhere = true;
		}
		if (!pessoa.getIdade().equals(null)) {
			if(isWhere){
				where = " and idade = " + pessoa.getIdade() + "";
			}else{
				where = " where idade = " + pessoa.getIdade() + "";
			}
		}
		if (!pessoa.getSexo().isEmpty()) {
			if(isWhere){
				where = " and sexo = " + pessoa.getSexo() + "";
			}else{
				where = " where sexo = " + pessoa.getSexo() + "";
			}
		}
		if (!pessoa.getCpf().isEmpty()) {
			if(isWhere){
				where = " and sexo = " + pessoa.getCpf() + "";
			}else{
				where = " where sexo = " + pessoa.getCpf() + "";
			}
		}
		return where;

	}

}
