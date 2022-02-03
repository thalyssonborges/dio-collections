package dio.list_exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*Fa�a um programa que receba a temperatura m�dia os 6 primeiros meses do ano e armazene-as em uma lista.
Ap�s isto, calcule a m�dia semestral das temperaturas e mostre todas as temperaturas acima desta m�dia,
e em que m�s elas ocorreram (mostrar o m�s por extenso: 1 � Janeiro, 2 � Fevereiro e etc).
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
		temperaturas.forEach(t -> System.out.print(t +" �C; "));
		System.out.println("\n-----------------------------");
		
		double soma = 0;
		Iterator<Double> iterator = temperaturas.iterator();
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		double media = soma/temperaturas.size();
		System.out.println("M�dia das temperaturas: "+media+" �C");
		

        System.out.print("Temperaturas acima da m�dia: ");
        for (Double t : temperaturas) {
			if(t > media) {
				System.out.print(t+" �C; ");
			}
		}
        System.out.println("\n-----------------------------");
		
		for (int i=1; i<=6; i++) {
			switch (i) {
			case 1:
				System.out.println("1 - Janeiro: "+temperaturas.get(i-1)+" �C");
				break;
			case 2:
				System.out.println("2 - Fevereiro: "+temperaturas.get(i-1)+" �C");
				break;
			case 3:
				System.out.println("3 - Mar�o: "+temperaturas.get(i-1)+" �C");
				break;
			case 4:
				System.out.println("4 - Abril: "+temperaturas.get(i-1)+" �C");
				break;
			case 5:
				System.out.println("5 - Maio: "+temperaturas.get(i-1)+" �C");
				break;
			case 6:
				System.out.println("6 - Junho: "+temperaturas.get(i-1)+" �C");
				break;
			default:
				break;
			}
		}
		
	}

}

