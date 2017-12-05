package dao;

import model.Endereco;
import java.util.List;

/**
 * Classe DAO para objeto Endereco
 * @author Cleiton
 */
public interface EnderecoDAO {
    public void salvar(Endereco endereco);
    public void alterar(Endereco endereco);
    public void remover(Endereco endereco);
    public Endereco pesquisar(Long id);
    public List<Endereco> recuperarTodos();
}