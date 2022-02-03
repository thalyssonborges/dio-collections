package dio.list_exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, fa�a um programa que fa�a 5 perguntas para uma pessoa sobre um crime. As perguntas s�o:
1. "Telefonou para a v�tima?"
2. "Esteve no local do crime?"
3. "Mora perto da v�tima?"
4. "Devia para a v�tima?"
5. "J� trabalhou com a v�tima?"
Se a pessoa responder positivamente a 2 quest�es ela deve ser classificada como "Suspeita", entre 3 e 4 como
"C�mplice" e 5 como "Assassina". Caso contr�rio, ele ser� classificado como "Inocente".
*/

public class Exercicio02 {

	public static void main(String[] args) {
		List<String> perguntas = new ArrayList<>();
		List<String> respostas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		String pergunta;
		pergunta = "Telefonou para a v�tima?";
		perguntas.add(pergunta);
		
		pergunta = "Esteve no local do crime?";
		perguntas.add(pergunta);
		
		pergunta = "Mora perto da vitima?";
		perguntas.add(pergunta);
		
		pergunta = "Devia para a vitima?";
		perguntas.add(pergunta);
		
		pergunta = "J� trabalhou com a vitima?";
		perguntas.add(pergunta);
		
		for(int i=0; i<perguntas.size(); i++) {
			System.out.println(perguntas.get(i));
			String p = sc.nextLine();
			respostas.add(p);
		}
		System.out.println("\nRespostas: ");
		for (String r : respostas) {
			System.out.print(r+"; ");
		}
		
		int contadorSim = 0;
		int contadorNao = 0;
		for (int i = 0; i < respostas.size(); i++) {
			if(respostas.get(i).contains("s")){
				contadorSim++;
			}else {
				contadorNao++;
			}
		}
		
		System.out.println("\n\nSitua��o: ");
		if(contadorSim == 5) {
			System.out.println("Assassina");
		}else if(contadorSim == 3 || contadorSim == 4) {
			System.out.println("C�mplice");
		}else if(contadorSim == 2) {
			System.out.println("Suspeita");
		}else {
			System.out.println("Inocente");
		}
		
		
		
	}

}
