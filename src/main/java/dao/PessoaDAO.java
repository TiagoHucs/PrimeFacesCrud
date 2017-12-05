package dao;

import model.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe DAO para objeto Endereco
 * @author Cleiton
 */
public interface PessoaDAO {
    public void salvar(Pessoa pessoa) throws SQLException;
    public void alterar(Pessoa pessoa) throws SQLException;
    public void remover(Pessoa pessoa) throws SQLException;
    public Pessoa pesquisar(String cpf) throws SQLException;
    public List<Pessoa> recuperarTodos() throws SQLException;
    public List<Pessoa> pesquisarCondicional(Pessoa pessoa) throws SQLException;
}