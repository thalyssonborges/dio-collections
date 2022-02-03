package dio.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {

	public static void main(String[] args) {
		List<String> numerosAleatorios = Arrays.asList("1","0","4","1","2","3","9","9","6","5");
		
		System.out.println("Imprima todos os elementos dessa lista de String: ");
		numerosAleatorios.stream().forEach(System.out::print); //Reference Method
		
		System.out.println("\n\nPegue os 5 primeiros números e coloque dentro de um Set: ");
		numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::print);
		
		System.out.println("\n\nTransforme esta lista de String em uma lista de números inteiros: ");
		//numerosAleatorios.stream().map(s -> Integer.parseInt(s));//Função Lambda
		List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList()); //Reference Method
		numerosAleatoriosInteger.forEach(System.out::println);
		
		System.out.println("\nPegue os números pares e maiores que 2 e coloque em uma lista");
		List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
				.map(Integer::parseInt)
				.filter(t -> (t % 2 == 0 && t > 2))
				.collect(Collectors.toList());
		System.out.println(listParesMaioresQue2);
		
		System.out.println("\nMostre a média dos números: ");
		numerosAleatorios.stream()
				.mapToInt(Integer::parseInt)
				.average()
				.ifPresent(System.out::println);
		
		System.out.println("\nRemova os valores ímpares: ");
		numerosAleatoriosInteger.removeIf(t -> t % 2 !=0);
		System.out.println(numerosAleatoriosInteger);
		
		//para resolver
		List<Integer> numerosAleatoriosInteger2 = numerosAleatorios.stream().distinct().map(Integer::parseInt).collect(Collectors.toList());
		
		System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante:");
		numerosAleatoriosInteger2.stream().skip(3).forEach(System.out::print);
		
		System.out.println("\nRetirando os números repetidos da lista, quantos números ficam? ");
		long countNumerosRepetidos = numerosAleatoriosInteger2.stream().distinct().count();
		System.out.println(countNumerosRepetidos);
		
		System.out.println("\nMostre o menor valor da lista: ");
		numerosAleatoriosInteger2.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);
				
		System.out.println("\nMostre o maior valor da lista: ");
		numerosAleatoriosInteger2.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
		
		System.out.println("\nNumeros Inteiros:  "+numerosAleatoriosInteger2);
		System.out.println("\nPegue apenas os números ímpares e some: ");
		int somaNumerosImpares = numerosAleatoriosInteger2.stream().filter(i -> (!((i % 2) == 0))).mapToInt(Integer::intValue).sum();
		System.out.println(somaNumerosImpares);
		
		System.out.println("\nMostre a lista na ordem númerica: ");
		List<Integer> numerosOrdemNatural = numerosAleatoriosInteger2.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(numerosOrdemNatural);
		
		System.out.println("\nAgrupe os valores ímpares múltiplos de 3 ou de 5:");
		Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger2.stream().collect(Collectors.groupingBy(i -> (i % 3== 0 || i % 5 == 0)));
		System.out.println(collectNumerosMultiplosDe3E5);
		
		
		
	}

}
