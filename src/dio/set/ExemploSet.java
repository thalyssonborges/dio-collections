package dio.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
 * COLLECTION SET:
 *  - NÃO PERMITE ELEMENTOS DUPLICADOS
 *  - NÃO POSSUI ÍNDICE

   Crie um conjunto e adicione as notas: 7, 8.5, 9.3, 5, 7, 0, 3.6 "  
// System.out.println("Exiba a posição da nota 5.0: ");
// System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
// System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
   System.out.println("Confira se a nota 5.0 está no conjunto: ");
// System.out.println("Exiba a terceira nota adicionada: ");
   System.out.println("Exiba a menor nota: ");
   System.out.println("Exiba a maior nota: ");
   System.out.println("Exiba a soma dos valores: " + soma);
   System.out.println("Exiba a média das notas: " + (soma/ notas.size()));
   System.out.println("Remova a nota 0: ");
// System.out.println("Remova a nota da posição 0");
   System.out.println("Remova as notas menores que 7 e exiba a lista: ");
   System.out.println("Exiba todas as notas na ordem em que foram informados: ");
   System.out.println("Exiba todas as notas na ordem crescente: ");
   System.out.println("Apague todo o conjunto");
   System.out.println("Confira se o conjunto está vazio: ");
   System.out.println("Confira se o conjunto 2 está vazio: ");
   System.out.println("Confira se o conjunto 3 está vazio: ");
 */

public class ExemploSet {

	public static void main(String[] args) {
		Set<Double> notas = new HashSet<>();
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(3.6);
		
		System.out.println(notas);
		
		System.out.println("Confira se a nota 5.0 está no conjunto: "+notas.contains(5.0));
		System.out.println("Exiba a menor nota: "+Collections.min(notas));
		System.out.println("Exiba a maior nota: "+Collections.max(notas));
		//---------------------------------------------------------------------------------
		double soma = 0;
		Iterator<Double> iterator = notas.iterator();
		while(iterator.hasNext()) {
			double next = iterator.next();
			soma += next;
		}
		System.out.println("Exiba a soma dos valores: "+soma);
		//---------------------------------------------------------------------------------
		System.out.println("Exiba a média das notas: "+soma/notas.size());
		System.out.println("Remova a nota 0: "+notas.remove(0.0));
		//---------------------------------------------------------------------------------
		Iterator<Double> iterator1 = notas.iterator();
		while(iterator1.hasNext()) {
			if(iterator1.next() < 7) {
				iterator1.remove();
			}
		}
		System.out.println("Remova as notas menores que 7 e exiba a lista: "+notas);
		//---------------------------------------------------------------------------------
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7.0);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5.0);
		notas2.add(7.0);
		notas2.add(3.6);
		
		System.out.println("Exiba todas as notas na ordem em que foram informados: "+notas2);
		//----------------------------------------------------------------------------------
		Set<Double> notas3 = new TreeSet<>(notas2);
		System.out.println("Exiba todas as notas na ordem crescente: "+notas3);
		//----------------------------------------------------------------------------------
		notas.clear();
		notas2.clear();
		notas3.clear();
		System.out.println("Apague todo o conjunto: "+notas+" "+notas2+" "+notas3);
		
		System.out.println("Confira se o conjunto está vazio: "+notas.isEmpty());
		System.out.println("Confira se o conjunto 2 está vazio: "+notas2.isEmpty());
		System.out.println("Confira se o conjunto 3 está vazio: "+notas3.isEmpty());	
		
		
	}

}
