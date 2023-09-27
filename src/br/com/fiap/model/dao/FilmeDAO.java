//Rodrigo Camargo 98373
package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.model.bean.Filme;

public class FilmeDAO {
	private Connection con;	
	
	//construtor - Parâmetro obriga passagem de uma conexão válida para usar os métodos
	public FilmeDAO(Connection con) {
		this.con = con;
	}

	//gets e sets - permitem alterar conexão
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Insere um filme no banco de dados.
	 * 
	 * @param  filme O objeto Filme a ser inserido.
	 * @return Uma mensagem indicando se a inserção foi bem-sucedida ou não.
	 * @author Rodrigo Camargo
	 */
	public String inserir(Filme filme) throws SQLException {				
		String sql = "insert into tb_ddd_filmes(codigo, titulo, genero, produtora) values(?,?,?,?)";	//cria o comando ddl
			//Preenche colunas
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			
			//Executa o PreparedStatement, e retorna Mensagem de sucesso ou falha
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao inserir";
			}			

	}
	
    /*Desc: Atualiza os dados de um filme no banco de dados
	 *
     * @param filme O objeto Filme com os dados atualizados.
     * @return Uma mensagem indicando se a atualização foi bem-sucedida ou não.
     *@author Rodrigo Camargo
     */
	public String alterar(Filme filme) throws SQLException {
		//comando SQL para alterar valores 
		String sql = "update tb_ddd_filmes set titulo = ?, genero = ?, produtora = ? where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			//Preenche colunas
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getGenero());
			ps.setString(3, filme.getProdutora());
			ps.setString(4, filme.getCodigo());
			
			//Executa o PreparedStatement, e retorna Mensagem de sucesso ou falha
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar";
			}			
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
    /* Exclui um filme do banco de dados.

     * @param filme O objeto Filme a ser excluído.
     * @return Uma mensagem indicando se a exclusão foi bem-sucedida ou não.
     *@author Rodrigo Camargo
     */
	public String excluir(Filme filme) {
		//comando SQL para alterar valores 
		String sql = "delete from tb_ddd_filmes where codigo = ?";	//cria o comando ddl
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);			
			ps.setString(1, filme.getCodigo());
			
			//Executa o PreparedStatement, e retorna Mensagem de sucesso ou falha
			if (ps.executeUpdate() > 0) {
				return "Excluído com sucesso!";
			} else {
				return "Erro ao excluir!";
			}			
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
    /*Lista todos os filmes cadastrados no banco de dados.
     * Obs: Em controller, converter para uma String
	 *@return: ArrayList de objetos Filme com os dados dos filmes cadastrados.
     *@author rodrigo camargo
     */
	public ArrayList<Filme> listarTodos() throws SQLException{
	    String sql = "select * from tb_ddd_filmes";
	    ArrayList<Filme> resultados = new ArrayList<Filme>();

	        PreparedStatement ps = getCon().prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs != null) {	        		        
		        while (rs.next()) {
		        	Filme filme = new Filme();
		            // Obtém valores do banco de dados e seta nos atributos de Filme     	
					filme.setCodigo(rs.getString(1));
					filme.setTitulo(rs.getString(2));
					filme.setGenero(rs.getString(3));
					filme.setProdutora(rs.getString(4));
	
		            // Armazena os atributos do filme no Array
		            resultados.add(filme);
		        }	        
		        return resultados;
			} else {
				return null;
			}	    
	}	
	
} //fim da classe


