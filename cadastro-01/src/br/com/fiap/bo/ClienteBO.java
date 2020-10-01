package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.dao.ClienteDAO;

public class ClienteBO {
	
	private ClienteDAO cd = null;
	
	public int cadastroCliente(ClienteBEAN cliB) {
		
		cd = new ClienteDAO();
		return cd.insert(cliB);
	}
	
	public List<ClienteBEAN> listagemCliente(){
		cd = new ClienteDAO();
		return cd.select();
	}

	public ClienteBEAN listagemCliente(int idCli){
		cd = new ClienteDAO();
		return cd.select(idCli);
	}

}
