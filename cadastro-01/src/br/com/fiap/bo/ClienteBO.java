package br.com.fiap.bo;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.dao.ClienteDAO;

public class ClienteBO {
	
	private ClienteDAO cd = null;
	
	public int cadastroCliente(ClienteBEAN cliB) {
		
		cd = new ClienteDAO();
		return cd.insert(cliB);
	}
	

}
