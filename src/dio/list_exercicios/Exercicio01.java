package dio.list_exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

public class Exercicio01 {

	public static void main(String[] args) {
		List<Double> temperaturas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		int contador = 0;
		while(true) {
			if(contador == 6) break;
			
			System.out.print("Digite a temperatura: ");
			double temp = sc.nextDouble();
			temperaturas.add(temp);
			contador++;
		}
		System.out.println("-----------------------------");
		temperaturas.forEach(t -> System.out.print(t +" °C; "));
		System.out.println("\n-----------------------------");
		
		double soma = 0;
		Iterator<Double> iterator = temperaturas.iterator();
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		double media = soma/temperaturas.size();
		System.out.println("Média das temperaturas: "+media+" °C");
		

        System.out.print("Temperaturas acima da média: ");
        for (Double t : temperaturas) {
			if(t > media) {
				System.out.print(t+" °C; ");
			}
		}
        System.out.println("\n-----------------------------");
		
		for (int i=1; i<=6; i++) {
			switch (i) {
			case 1:
				System.out.println("1 - Janeiro: "+temperaturas.get(i-1)+" °C");
				break;
			case 2:
				System.out.println("2 - Fevereiro: "+temperaturas.get(i-1)+" °C");
				break;
			case 3:
				System.out.println("3 - Março: "+temperaturas.get(i-1)+" °C");
				break;
			case 4:
				System.out.println("4 - Abril: "+temperaturas.get(i-1)+" °C");
				break;
			case 5:
				System.out.println("5 - Maio: "+temperaturas.get(i-1)+" °C");
				break;
			case 6:
				System.out.println("6 - Junho: "+temperaturas.get(i-1)+" °C");
				break;
			default:
				break;
			}
		}
		
	}

}

