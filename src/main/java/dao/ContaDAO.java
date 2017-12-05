package dao;

import model.Conta;
import java.util.List;

public interface ContaDAO {
    public void salvar(Conta conta);
    public void alterar(Conta conta);
    public void remover(Conta conta);
    public Conta pesquisar(Long id);
    public List<Conta> recuperarTodos();
}

