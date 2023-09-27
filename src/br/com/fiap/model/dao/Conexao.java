//Rodrigo Camargo 98373
package br.com.fiap.model.dao;

//Esta classe é responsável por abrir e fechar conexões com o banco de dados.

import java.sql.*;		

public class Conexao {	
	//Static permite retornar objeto conexao sem criar instancia do mesmo
	public static Connection abrirConexao(){
		Connection con = null;
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");	//tenta carregar o driver JDBC do banco de dados
			
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";	//passando nome do driver, host do BD, porta e nome do BD
			
			final String USER = "rm98373";
			final String PASS = "120503";
			
			con = DriverManager.getConnection(url, USER, PASS);		//Abre a conexão com o banco de dados, tendo como parâmetros url, user e pass
			System.out.println("Conexao aberta!");
			//Se o driver JDBC não for encontrado, o método lança exceção:
		}catch (ClassNotFoundException e) {	
			System.out.println(e.getMessage());
			//Se(conexão não puder ser aberta instrução/valor inválida etc) lança exceção:
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;		//Retorna conexão aberta ou nula(caso erro na conexao)
	}
	//fechando conexão
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexao fechada!");

		} catch (SQLException e) {			
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
