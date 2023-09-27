package br.com.fiap.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.controller.FilmeController;

public class FilmeView {

	public static void main(String[] args) {
		String aux, escolha = "sim", codigo, titulo, genero, produtora;
		int opcao;
		FilmeController filme = new FilmeController();
		
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha:\n (1)inserir filme\n(2)Alterar filme"
						+ "\n(3)Excluir filme");
				opcao = Integer.parseInt(aux);
				codigo = JOptionPane.showInputDialog("Codigo do filme:  ");
				switch (opcao) {
				case 1:
					titulo = JOptionPane.showInputDialog("Título do filme:");
					genero = JOptionPane.showInputDialog("Gênero do filme:: ");
					produtora = JOptionPane.showInputDialog("Produtora do filme:: ");
					System.out.println(filme.insereFilme(codigo, titulo, genero, produtora));
					JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());
					break;
				case 2:
					titulo = JOptionPane.showInputDialog("Título do novo filme:");
					genero = JOptionPane.showInputDialog("Gênero do novo filme: ");
					produtora = JOptionPane.showInputDialog("Produtora do novo filme: ");
					System.out.println(filme.alteraFilme(codigo, titulo, genero, produtora));
					JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());					
					break;
				case 3:
					System.out.println(filme.excluiFilme(codigo));
					JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());		
					break;

				default:
					System.out.println("Escolha incorreta!");		
					break;
				}
				
				
				//JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				System.out.println();
			}
			
			escolha = JOptionPane.showInputDialog("Deseja continuar? ");
		}
		JOptionPane.showMessageDialog(null, "Fim da execução, volte sempre!");
		

	}

}
