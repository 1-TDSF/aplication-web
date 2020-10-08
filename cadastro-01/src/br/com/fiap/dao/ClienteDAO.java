package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.connection.ConnectionFactory;
import jdk.nashorn.internal.objects.annotations.Where;

public class ClienteDAO {

	// Criando um atributo interno da classe do tipo
	// Connection para distribuir a conex�o com o banco!
	private Connection con;

	public ClienteDAO() {
		// Inst�ncia da classe ConnectionFactory
		// Sempre que a classe DAO for inst�nciada vai ser gerada uma
		// nova conex�o com o banco.
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
		
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClienteBEAN> lista = null;
		ClienteBEAN cli = null;
		
		try {
			//Construir a instru��o SQL
			sql = "SELECT * FROM TBL_CLIENTE ORDER BY ID_CLI";
			
			//Criando a conex�o
			ps = con.prepareStatement(sql);
			
			//Executar a instru��o SQL e receber o conte�do da sele��o.
			rs = ps.executeQuery();
			
			//Implementando a lista para receber os objetos da sele��o.
			lista = new ArrayList<ClienteBEAN>();
			
			//Criando a estrutura para popular a lista com os objetos que retornaram
			// da Sele��o/consulta.
			while (rs.next()) {
				//Construindo um novo objeto a cada nova itera��o.
				cli = new ClienteBEAN();
				//Populando o objeto com os dados do result set
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(rs.getNString("data_nasc_cli"));
				cli.setGenero(rs.getNString("genero_cli"));
				cli.setTelefone(rs.getNString("tel_cli"));
				
				//Adicionando o objeto na lista
				lista.add(cli);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public ClienteBEAN select(int idCli) {
		
		//Criando os objetos que ser�o utilizados para a consulta por ID.
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ClienteBEAN cli = null;
		
		try {
			
			//Criando a instru��o SQL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conex�o
			ps = con.prepareStatement(sql);
			
			//Passar o par�metro para a instru��o
			ps.setInt(1, idCli);
			
			//Executar a instru��o SQL e receber o conte�do da sele��o.
			rs = ps.executeQuery();
			
			//Criando a estrutura para popular a lista com os objetos que retornaram
			// da Sele��o/consulta.
			while (rs.next()) {
				//Construindo um novo objeto a cada nova itera��o.
				cli = new ClienteBEAN();
				//Populando o objeto com os dados do result set
				cli.setId(Integer.parseInt(rs.getNString("id_cli")));
				cli.setNome(rs.getNString("nome_cli"));
				cli.setSobrenome(rs.getNString("sobrenome_cli"));
				cli.setDataNasc(rs.getNString("data_nasc_cli"));
				cli.setGenero(rs.getNString("genero_cli"));
				cli.setTelefone(rs.getNString("tel_cli"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cli;
	}

	public int insert(ClienteBEAN cliB) {

		String sql = null;
		int status = 0;
		PreparedStatement ps = null;
		
		try {
			// Criando a instru��o SQL, usando a fun�ao TO_DATE(? , 'yyyy-MM-dd') para
			// parsear a data em String.
			sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
			
			//Criando a conex�o
			ps = con.prepareStatement(sql);

			// Populando a query com o Objeto BEAN.
			ps.setString(1, cliB.getNome());
			ps.setString(2, cliB.getSobrenome());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cliB.getDataNasc()));
			ps.setString(4, cliB.getGenero());
			ps.setString(5, cliB.getTelefone());
			
			//Declarando o status da opera��o.
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public int update(ClienteBEAN cliB) {
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
		//CRIANDO A INSTRU��O SQL
		sql = "UPDATE TBL_CLIENTE SET NOME_CLI = ?,SOBRENOME_CLI = ?,DATA_NASC_CLI = TO_DATE(?,'yyyy-MM-dd'),"
				+ "GENERO_CLI = ?,TEL_CLI = ? WHERE ID_CLI = ?";
		
		//Criando a conex�o
		ps = con.prepareStatement(sql);
		 
		//POPULANDO A CONEX�O COM O OBJETO
		ps.setString(1, cliB.getNome());
		ps.setString(2, cliB.getSobrenome());
		ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(cliB.getDataNasc()));
		ps.setString(4, String.valueOf(cliB.getGenero()));
		ps.setString(5, cliB.getTelefone());
		ps.setInt(6, cliB.getId());
		
		//Gerando o retorno para avalia��o
		status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public int delete(int idCli) {
		
		String sql = null;
		PreparedStatement ps = null;
		int status = 0;
		
		try {
			//Criando a instru��o SQL
			sql = "DELETE FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conex�o.
			ps = con.prepareStatement(sql);
			
			//Populando a Instru��o SQL com o par�metro.
			ps.setInt(1, idCli);
			
			//Recupera o resultado da opera��o.
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

}







