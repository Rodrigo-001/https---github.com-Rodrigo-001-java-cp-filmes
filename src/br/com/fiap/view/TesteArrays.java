package br.com.fiap.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TesteArrays {

	public static void main(String[] args) {
		
		//cria array list
        ArrayList<String> listaDeNomes = new ArrayList<>();
        //preenche 
        listaDeNomes.add("Alice");
        listaDeNomes.add("Bob");
        listaDeNomes.add("Carol");
        listaDeNomes.add("David");
        String lista = "Nomes:\n\n";
        
        for (String i : listaDeNomes) {
        	lista += i + "\n";
			
		}
        JOptionPane.showMessageDialog(null, lista);
	}

}
