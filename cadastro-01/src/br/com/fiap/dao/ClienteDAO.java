package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.connection.ConnectionFactory;

public class ClienteDAO {

	// Criando um atributo interno da classe do tipo
	// Connection para distribuir a conexão com o banco!
	private Connection con;

	public ClienteDAO() {
		// Instância da classe ConnectionFactory
		// Sempre que a classe DAO for instânciada vai ser gerada uma
		// nova conexão com o banco.
		ConnectionFactory cf = new ConnectionFactory();
		try {
			this.con = cf.DBConnectionManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ClienteBEAN> select() {
		
		return null;
	}

	public ClienteBEAN select(int idCli) {
		
		return null;
	}

	public int insert(ClienteBEAN cliB) {

		try {
			// Criando a instrução SQL, usando a funçao TO_DATE(? , 'yyyy-MM-dd') para
			// parsear a data em String.
			String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// Populando a query com o Objeto BEAN.
			ps.setString(1, cliB.getNome());
			ps.setString(2, cliB.getSobrenome());
			
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cliB.getDataNasc()));

			ps.setString(4, cliB.getGenero());
			ps.setLong(5, Long.parseLong(cliB.getTelefone()));
			
			//Declarando o status da operação.
			
			int status = ps.executeUpdate();

			ps.close();
			con.close();
			
			return status; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public boolean update(ClienteBEAN cliB) {
		
		return false;
	}

	public boolean delete(int idCli) {

		return false;
	}

}
