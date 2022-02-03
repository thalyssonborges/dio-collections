package dio.list_exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/

public class Exercicio02 {

	public static void main(String[] args) {
		List<String> perguntas = new ArrayList<>();
		List<String> respostas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		String pergunta;
		pergunta = "Telefonou para a vítima?";
		perguntas.add(pergunta);
		
		pergunta = "Esteve no local do crime?";
		perguntas.add(pergunta);
		
		pergunta = "Mora perto da vitima?";
		perguntas.add(pergunta);
		
		pergunta = "Devia para a vitima?";
		perguntas.add(pergunta);
		
		pergunta = "Já trabalhou com a vitima?";
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
		
		System.out.println("\n\nSituação: ");
		if(contadorSim == 5) {
			System.out.println("Assassina");
		}else if(contadorSim == 3 || contadorSim == 4) {
			System.out.println("Cúmplice");
		}else if(contadorSim == 2) {
			System.out.println("Suspeita");
		}else {
			System.out.println("Inocente");
		}
		
		
		
	}

}
