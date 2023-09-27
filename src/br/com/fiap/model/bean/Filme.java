package br.com.fiap.model.bean;

/**
 * A classe armazena os atributos do filme (codigo, titulo, genêro e produtora)
 * @author Rodrigo Camargo
 */
public class Filme {
	private String codigo;
	private String titulo;
	private String genero;
	private String produtora;
	
	/* construtor vazio - os valores poderão ser definidos posteriormente
	 */
	public Filme() {		
	}
		
	//gets e sets - atributos poderão ser acessados / acessados
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	
	
}
