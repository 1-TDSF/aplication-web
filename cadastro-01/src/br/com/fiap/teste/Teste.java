package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		ConnectionFactory cf = new ConnectionFactory();
		
		Connection con = cf.DBConnectionManager();
		
		ClienteBEAN cliB = new ClienteBEAN();
		cliB.setNome("Fernanda");
		cliB.setSobrenome("Luisa");
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		c.setTime(sf.parse("1989-04-27"));
		cliB.setDataNasc(c.getTime());
		
		cliB.setGenero("f");
		cliB.setTelefone("11987659876");
		
		try {
			// Criando a instrução SQL, usando a funçao TO_DATE(? , 'yyyy-MM-dd') para
			// parsear a data em String.
			String sql = "INSERT INTO TBL_CLIENTE VALUES(SEQ_CLIENTE_A.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// Populando a query com o Objeto BEAN.
			ps.setString(1, cliB.getNome());
			ps.setString(2, cliB.getSobrenome());
						
			SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(3, sff.format(cliB.getDataNasc()));
			
			ps.setString(4, cliB.getGenero());
			ps.setLong(5, Long.parseLong(cliB.getTelefone()));
			
			ps.execute();
			
			ps.close();
			con.close();
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
