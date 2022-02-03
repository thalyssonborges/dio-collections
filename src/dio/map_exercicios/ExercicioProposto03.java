package dio.map_exercicios;

import java.util.*;
import java.util.Map.Entry;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

public class ExercicioProposto03 {

	public static void main(String[] args) {
		
		Map<Integer, Contato> agenda = new HashMap<>() {{
			put(1, new Contato("Simba", 2222));
			put(4, new Contato("Cami", 5555));
			put(3, new Contato("Jon", 1111));
		}};
		
		System.out.println("--\tOrdem aleatória\t--");
		for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
		
		System.out.println("\n--\tOrdem Inserção\t--");
		Map<Integer, Contato> agendaOrdemInsercao = new LinkedHashMap<>() {{
			put(1, new Contato("Simba", 2222));
			put(4, new Contato("Cami", 5555));
			put(3, new Contato("Jon", 1111));
		}};
		for (Map.Entry<Integer, Contato> entry : agendaOrdemInsercao.entrySet()) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
				
		System.out.println("\n--\tOrdem id\t--");
		Map<Integer, Contato> agendaOrdemID = new TreeMap<>(agenda);
		for (Map.Entry<Integer, Contato> entry : agendaOrdemID.entrySet()) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
		
		System.out.println("\n--\tOrdem número telefone\t--");
		Set<Map.Entry<Integer, Contato>> agendaOrdemTefefone = new TreeSet<>(new ComparatorTelefone());
		agendaOrdemTefefone.addAll(agenda.entrySet());
		for (Map.Entry<Integer, Contato> entry : agendaOrdemTefefone) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
		
		
		System.out.println("\n--\tOrdem nome contato\t--");
		Set<Map.Entry<Integer, Contato>> agendaOrdemNome = new TreeSet<>(new ComparatorNome());
		agendaOrdemNome.addAll(agenda.entrySet());
		for (Map.Entry<Integer, Contato> entry : agendaOrdemNome) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
		
	}

}
class ComparatorTelefone implements Comparator<Map.Entry<Integer, Contato>>{

	@Override
	public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
		return Integer.compare(c1.getValue().getTelefone(), c2.getValue().getTelefone());
	}
	
}
class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>>{

	@Override
	public int compare(Entry<Integer, Contato> c1, Entry<Integer, Contato> c2) {
		return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
	}
	
}
