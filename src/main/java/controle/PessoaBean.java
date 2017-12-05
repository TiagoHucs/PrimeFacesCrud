package controle;

import hibernate.HibernateUtil;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Pessoa;
import dao.PessoaDAO;
import dao.PessoaDAOImpl;

@ManagedBean(name = "PessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private PessoaDAO pessoaDao;
	private List<Pessoa> pessoas;
	private List<Pessoa> pessoasPesquisadas;
	private Integer quantidade;
	private String retorno;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	

	public List<Pessoa> getPessoasPesquisadas() {
		return pessoasPesquisadas;
	}


	public void setPessoasPesquisadas(List<Pessoa> pessoasPesquisadas) {
		this.pessoasPesquisadas = pessoasPesquisadas;
	}


	public PessoaBean() throws SQLException {
		pessoaDao = new PessoaDAOImpl(HibernateUtil.getSessionFactory());
		pessoa = new Pessoa();
		pessoas = pessoaDao.recuperarTodos();
		pessoasPesquisadas = null;
		setQuantidade(pessoas.size());
		setRetorno("");
	}

	public void salvar() throws SQLException {
		System.out.println("Salvar "+pessoa.getNome());
		
		Pessoa p2 = pessoaDao.pesquisar(pessoa.getCpf());
		if(!p2.equals(null)){
			setRetorno("Registro já existente no banco");
		}else{
			pessoaDao.salvar(pessoa);
			pessoas = pessoaDao.recuperarTodos();
			setQuantidade(pessoas.size());
			pessoa = new Pessoa();
			setRetorno("Registro cadastrado com sucesso");
		}
	}
	
	public String getRetorno() {
		return retorno;
	}


	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}


	public void editar(Pessoa p) throws SQLException {
		System.out.println("editar "+p.getNome());
		setPessoa(p);
	}
	
	public void remover(Pessoa p) throws SQLException {
		System.out.println("Remover "+p.getNome());
		pessoaDao.remover(p);
		pessoas = pessoaDao.recuperarTodos();
		setQuantidade(pessoas.size());
		pessoa = new Pessoa();
	}
	
	public void pesquisarCondicional() throws SQLException{
		System.out.println("chegou aqui");
		setPessoasPesquisadas(pessoas = pessoaDao.pesquisarCondicional(pessoa));
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}