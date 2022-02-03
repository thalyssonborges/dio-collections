package dio.set_exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

public class ExercicioProposto1 {

	public static void main(String[] args) {
		Set<Cor> arcoIris = new HashSet<>() {{
			add(new Cor("Vermelha"));
			add(new Cor("Laranja"));
			add(new Cor("Amarelo"));
			add(new Cor("Verde"));
			add(new Cor("Azul"));
			add(new Cor("Anil"));
			add(new Cor("Violeta"));
		}};
		
		System.out.println("a) Exiba todas as cores o arco-íris uma abaixo da outra;");
		for (Cor cor : arcoIris) {
			System.out.println(cor);
		}
		System.out.println("\nb) A quantidade de cores que o arco-íris tem: "+arcoIris.size());
		
		System.out.println("\nc) Exiba as cores em ordem alfabética;");
		Set<Cor> arcoIris1 = new TreeSet<>(new ComparatorNome());
		arcoIris1.addAll(arcoIris);
		for (Cor cor : arcoIris1) {
			System.out.println(cor);
		}
		
		System.out.println("\nd) Exiba as cores na ordem inversa da que foi informada;");
		Set<String> arcoIris3 = new LinkedHashSet<>(Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
	    System.out.println(arcoIris3);
	    List<String> arcoIrisList = new ArrayList<>(arcoIris3);
	    Collections.reverse(arcoIrisList);
	    System.out.println(arcoIrisList);
		
		System.out.println("\ne) Exiba todas as cores que começam com a letra ”v”;");
		for (String arco : arcoIris3) {
			if(arco.startsWith("v")) {
				System.out.println(arco);
			}
		}
		System.out.println("\nf) Remova todas as cores que não começam com a letra “v”;");
		Iterator<String> iterator = arcoIris3.iterator();
		while(iterator.hasNext()) {
			if(!iterator.next().startsWith("v")) {
				iterator.remove();
			}
		}
		System.out.println(arcoIris3);
		
		System.out.println("\ng) Limpe o conjunto;");
		arcoIris3.clear();
		System.out.println(arcoIris3);
		
		System.out.println("\nh) Confira se o conjunto está vazio;");
		System.out.println(arcoIris3.isEmpty());
		
		
	}

}
class Cor {
	private String nome;

	public Cor() {
		
	}
	
	public Cor(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "nome:" + nome;
	}
}

class ComparatorNome implements Comparator<Cor>{
	
	@Override
	public int compare(Cor c1, Cor c2) {
		return c1.getNome().compareToIgnoreCase(c2.getNome());
	}
	
}
class ComparatorReverseNome implements Comparator<Cor>{

	@Override
	public int compare(Cor o1, Cor o2) {

		return 0;
	}
	
}
