package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.DBConnectionManager();

		ClienteBEAN cli = new ClienteBEAN();
		cli = new Teste().select(3, con);
		System.out.println("Nome cliente : " + cli.getNome());
		System.out.println("Telefone cliente : " + cli.getTelefone());

		
//		List<ClienteBEAN> lista = new Teste().select(con);
//		
//		for (ClienteBEAN cli : lista) {
//			System.out.println("Nome cliente : " + cli.getNome());
//			System.out.println("Telefone cliente : " + cli.getTelefone());
//		}
		
	}

	

	public List<ClienteBEAN> select(Connection con) {
		
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClienteBEAN> lista = null;
		ClienteBEAN cli = null;
		
		try {
			//Construir a instrução SQL
			sql = "SELECT * FROM TBL_CLIENTE ORDER BY ID_CLI";
			
			//Criando a conexão
			ps = con.prepareStatement(sql);
			
			//Executar a instrução SQL e receber o conteúdo da seleção.
			rs = ps.executeQuery();
			
			//Implementando a lista para receber os objetos da seleção.
			lista = new ArrayList<ClienteBEAN>();
			
			//Criando a estrutura para popular a lista com os objetos que retornaram
			// da Seleção/consulta.
			while (rs.next()) {
				//Construindo um novo objeto a cada nova iteração.
				cli = new ClienteBEAN();
				//Populando o objeto com os dados do result set
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

	public ClienteBEAN select(int idCli, Connection con) {
		
		//Criando os objetos que serão utilizados para a consulta por ID.
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ClienteBEAN cli = null;
		
		try {
			
			//Criando a instrução SQL
			sql = "SELECT * FROM TBL_CLIENTE WHERE ID_CLI = ?";
			
			//Criando a conexão
			ps = con.prepareStatement(sql);
			
			//Passar o parâmetro para a instrução
			ps.setInt(1, idCli);
			
			//Executar a instrução SQL e receber o conteúdo da seleção.
			rs = ps.executeQuery();
			
			//Criando a estrutura para popular a lista com os objetos que retornaram
			// da Seleção/consulta.
			while (rs.next()) {
				//Construindo um novo objeto a cada nova iteração.
				cli = new ClienteBEAN();
				//Populando o objeto com os dados do result set
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

	
}


//ClienteBEAN cliB = new ClienteBEAN();
//cliB.setNome("Fernanda");
//cliB.setSobrenome("Luisa");
//
//Calendar c = Calendar.getInstance();
//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//
//c.setTime(sf.parse("1989-04-27"));
//cliB.setDataNasc(c.getTime());
//
//cliB.setGenero("f");
//cliB.setTelefone("11987659876");
//
//try {
//	// Criando a instrução SQL, usando a funçao TO_DATE(? , 'yyyy-MM-dd') para
//	// parsear a data em String.
//	String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
//
//	PreparedStatement ps = con.prepareStatement(sql);
//
//	// Populando a query com o Objeto BEAN.
//	ps.setString(1, cliB.getNome());
//	ps.setString(2, cliB.getSobrenome());
//				
//	SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
//	ps.setString(3, sff.format(cliB.getDataNasc()));
//	
//	ps.setString(4, cliB.getGenero());
//	ps.setLong(5, Long.parseLong(cliB.getTelefone()));
//	
//	ps.execute();
//	
//	ps.close();
//	con.close();
//	
//
//	
//} catch (SQLException e) {
//	e.printStackTrace();
//}