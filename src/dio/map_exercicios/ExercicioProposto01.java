package dio.map_exercicios;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Dada a popula��o estimada de alguns estados do nordeste brasileiro, fa�a:
	 Estado = PE - popula��o = 9.616.621
	 Estado = AL - popula��o = 3.351.543
	 Estado = CE - popula��o = 9.187.103
	 Estado = RN - popula��o = 3.534.265
	 
01) Crie um dicion�rio que relacione os estados e suas respectivas popula��es
02) Substitua a popula��o do RN por 3.534.165
03) Confire se o estado do PB est� no dicion�rio, caso n�o adicione: PB - 4.039.277
04) Exiba a popula��o de PE
05) Exiba todos os estados e suas popula��es na ordem que foi informado
06) Exiba os estados e suas popula��es em ordem alfab�tica
07) Exiba o estado com a menor popula��o e sua quantidade
08) Exiba o estado com a maior popula��o e sua quantidade
09) Exiba a soma da popula��o desses estados
10) Exiba a m�dia da popula��o deste dicion�rio de estados
11) Remova os estados com a popula��o menor que 4.000.000
12) Apague o dicion�rio de estados
13) Confira se o dicion�rio est� vazio
*/

public class ExercicioProposto01 {

	public static void main(String[] args) {
		
		Map<String, Integer> populacaoEstado = new HashMap<>() {{
			put("PE", 9616621);
			put("AL", 3351543);
			put("CE", 9187103);
			put("RN", 3534265);
		}};
		System.out.println("01) Crie um dicion�rio que relacione os estados e suas respectivas popula��es");
		System.out.println(populacaoEstado);
		
		System.out.println("\n02) Substitua a popula��o do RN por 3.534.165");
		populacaoEstado.put("RN", 3534165);
		System.out.println(populacaoEstado);
		
		System.out.println("\n03) Confire se o estado do PB est� no dicion�rio, caso n�o adicione: PB - 4.039.277");
		if(!populacaoEstado.containsKey("PB")) populacaoEstado.put("PB", 4039277);
		System.out.println(populacaoEstado);
		
		System.out.println("\n04) Exiba a popula��o de PE");
		System.out.println("PE - "+populacaoEstado.get("PE"));
		
		System.out.println("\n05) Exiba todos os estados e suas popula��es na ordem que foi informado"); //Manter a ordem importa? LinkedHashSet
		Map<String, Integer> populacaoEstadoOrdemInformada = new LinkedHashMap<>();
			populacaoEstadoOrdemInformada.put("PE", 9616621);
			populacaoEstadoOrdemInformada.put("AL", 3351543);
			populacaoEstadoOrdemInformada.put("CE", 9187103);
			populacaoEstadoOrdemInformada.put("RN", 3534265);
			populacaoEstadoOrdemInformada.put("PB", 4039277);
		System.out.println(populacaoEstadoOrdemInformada);
		
		System.out.println("\n06) Exiba os estados e suas popula��es em ordem alfab�tica");
		Map<String, Integer> populacaoEstadoOrdemAlfabetica = new TreeMap<>(populacaoEstado);
		System.out.println(populacaoEstadoOrdemAlfabetica);
		
		System.out.println("\n07) Exiba o estado com a menor popula��o e sua quantidade");
		Collection<Integer> populacao = populacaoEstado.values();
		String estadoMaior = "";
		String estadoMenor = "";
		
		for (Map.Entry<String, Integer> entry : populacaoEstado.entrySet()) {
			if(entry.getValue().equals(Collections.min(populacao))) estadoMenor = entry.getKey();
			if(entry.getValue().equals(Collections.max(populacao))) estadoMaior = entry.getKey();
		}
		System.out.println(estadoMenor+" - "+Collections.min(populacao));
		
		System.out.println("\n08) Exiba o estado com a maior popula��o e sua quantidade");
		System.out.println(estadoMaior+" - "+Collections.max(populacao));
		
		System.out.println("\n09) Exiba a soma da popula��o desses estados");
		Integer soma = 0;
		for (Map.Entry<String, Integer> entry : populacaoEstado.entrySet()) {
			soma = soma + entry.getValue();
		}
		System.out.println(soma);
		
		System.out.println("\n10) Exiba a m�dia da popula��o deste dicion�rio de estados");
		Double somaTipoDouble = (double) soma;
		System.out.println(somaTipoDouble/populacaoEstado.size());
		
		System.out.println("\n11) Remova os estados com a popula��o menor que 4.000.000");
		Iterator<Integer> iterator = populacaoEstado.values().iterator();
		while(iterator.hasNext()) {
			if(iterator.next() < 4000000) {
				iterator.remove();
			}
		}
		System.out.println(populacaoEstado);
		
		System.out.println("\n12) Apague o dicion�rio de estados");
		populacaoEstado.clear();
		System.out.println(populacaoEstado);
		
		System.out.println("\n13) Confira se o dicion�rio est� vazio");
		System.out.println(populacaoEstado.isEmpty());
	}

}

