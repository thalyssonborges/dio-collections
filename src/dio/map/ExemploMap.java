package dio.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/*
Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
modelo = gol - consumo = 14,4km/l
modelo = uno - consumo = 15,6 km/l
modelo = mobi - consumo = 16,1 km/l
modelo = hb20 - consumo = 14,5 km/l
modelo = kwid - consumo = 15,6 km/l

1)System.out.println("Crie um dicionário que relacione os 
modelos e seus respectivos consumos: ");
2)System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
3)System.out.println("Confira se o modelo tucson está no dicionário: ");
4)System.out.println("Exiba o consumo do uno: ");
5)System.out.println("Exiba os modelos: ");
6)System.out.println("Exiba os consumos dos carros: ");
7)System.out.println("Exiba o modelo mais econômico e seu consumo: ");
8)System.out.println("Exiba o modelo menos econômico e seu consumo: " );
9)System.out.println("Exiba a soma dos consumos: " + soma);
10)System.out.println("Exiba a média dos consumos deste dicionário de carros: ");
11)System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
12)System.out.println("Exiba todos os carros na ordem em que foram informados: ");
13)System.out.println("Exiba o dicionário ordenado pelo modelo: ");
14)System.out.println("Apague o dicionario de carros: ");
15)System.out.println("Confira se o dicionário está vazio: ");
*/

public class ExemploMap {

	public static void main(String[] args) {
		
		Map<String, Double> carros = new HashMap<String, Double>(){{
			put("Gol", 14.4);
			put("Uno", 15.6);
			put("Mobi", 16.1);
			put("Hb20", 14.5);
			put("Kwid", 15.6);
		}};
		System.out.println("1) Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
		System.out.println(carros);
		
		System.out.println("\n2) Substitua o consumo do gol por 15,2 km/l: ");
		carros.put("Gol", 15.2);
		System.out.println(carros);
		
		System.out.println("\n3) Confira se o modelo tucson está no dicionário: ");
		System.out.println(carros.containsKey("Tucson"));
		
		System.out.println("\n4) Exiba o consumo do uno: ");
		System.out.println(carros.get("Uno"));
		
		System.out.println("\n5) Exiba os modelos: ");
		System.out.println(carros.keySet());
		
		System.out.println("\n6) Exiba os consumos dos carros: ");
		System.out.println(carros.values());
		
		System.out.println("\n7) Exiba o modelo mais econômico e seu consumo: ");
		Double consumoMaisEficiente = Collections.max(carros.values());
		Set<Map.Entry<String, Double>> entries1 = carros.entrySet();
		String modeloMaisEficiente = "";
		for (Map.Entry<String, Double> entry : entries1) {
			if(entry.getValue().equals(consumoMaisEficiente)) {
				modeloMaisEficiente = entry.getKey();
				System.out.println(modeloMaisEficiente+": "+consumoMaisEficiente);
			}
		}
		
		System.out.println("\n8) Exiba o modelo menos econômico e seu consumo: ");
		Double consumoMenosEficiente = Collections.min(carros.values());
		Set<Map.Entry<String, Double>> entries2 = carros.entrySet();
		String modeloMenosEficiente = "";
		for (Map.Entry<String, Double> entry : entries2) {
			if (entry.getValue().equals(consumoMenosEficiente)) {
				modeloMenosEficiente = entry.getKey();
				System.out.println(modeloMenosEficiente+": "+consumoMenosEficiente);
			}
		}
		
		System.out.println("\n9) Exiba a soma dos consumos: ");
		Iterator<Double> iterator = carros.values().iterator();
		Double soma = 0d;
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println(soma);
		
		System.out.println("\n10) Exiba a média dos consumos deste dicionário de carros: ");
		System.out.println(soma/carros.size());
		
		System.out.println("\n11) Remova os modelos com o consumo igual a 15,6 km/l: ");
		System.out.println("antes: "+carros);
		Iterator<Double> iterator1 = carros.values().iterator();
		while (iterator1.hasNext()) {
			if(iterator1.next().equals(15.6)) {
				iterator1.remove();
			}	
		}
		System.out.println("depois: "+carros);
		
		System.out.println("\n12) Exiba todos os carros na ordem em que foram informados: ");
		Map<String, Double> carros1 = new LinkedHashMap<String, Double>(){{
			put("Gol", 14.4);
			put("Uno", 15.6);
			put("Mobi", 16.1);
			put("Hb20", 14.5);
			put("Kwid", 15.6);
		}};
		System.out.println(carros1);
		
		System.out.println("\n13) Exiba o dicionário ordenado pelo modelo: ");
		Map<String, Double> carros2 = new TreeMap<String, Double>(){{
			put("Gol", 14.4);
			put("Uno", 15.6);
			put("Mobi", 16.1);
			put("Hb20", 14.5);
			put("Kwid", 15.6);
		}};
		System.out.println(carros2);
		
		System.out.println("\n14) Apague o dicionario de carros: ");
		//carros.clear();
		carros1.clear();
		carros2.clear();
		System.out.println(carros+" "+carros1+" "+carros2);
		
		System.out.println("\n15) Confira se o dicionário está vazio: ");
		System.out.println("carros: "+carros.isEmpty());
		System.out.println("carros1: "+carros1.isEmpty());
		System.out.println("carros2: "+carros2.isEmpty());
		
	}

}


