package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "CadastroCtrl")
@SessionScoped
public class CadastroController {
	
	public void salvar(){
		System.out.println("bot�o salvar acionado");
	}

	public void excluir(){
		System.out.println("bot�o excluir acionado");
	}
	
}
