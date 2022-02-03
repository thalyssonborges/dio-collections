package dio.streamAPI;

import java.util.Map.Entry;
import java.util.function.Function;
import java.util.*;

public class Exemplo1 {

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
		/*
		//Utilizando conceito de CLASSE ANÔNIMA!
		 
		    Set<Map.Entry<Integer, Contato>> agendaOrdemTefefone = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {

			@Override
			public int compare(Entry<Integer, Contato> o1, Entry<Integer, Contato> o2) {
				return Integer.compare(o1.getValue().getTelefone(), o2.getValue().getTelefone());
			}
		});
		agendaOrdemTefefone.addAll(agenda.entrySet());
		
	  	//Utilizando conceito de FUNCTIONAL INTERFACE ANÔNIMA!	 
	    
	    Set<Map.Entry<Integer, Contato>> agendaOrdemTefefone = new TreeSet<>(Comparator.comparing(
	    		new Function<Map.Entry<Integer, Contato>, Integer>() {
			@Override
			public Integer apply(Map.Entry<Integer, Contato> contatoEntry) {
				return contatoEntry.getValue().getTelefone();
			}
		}));
		
		*/
		
	  	//Utilizando conceito de FUNCTIONAL INTERFACE ANÔNIMA!	 
	    
		Set<Map.Entry<Integer, Contato>> agendaOrdemTefefone = new TreeSet<>(
				Comparator.comparing(contatoEntry -> contatoEntry.getValue().getTelefone()));
		agendaOrdemTefefone.addAll(agenda.entrySet());

		
		for (Map.Entry<Integer, Contato> entry : agendaOrdemTefefone) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
		
		
		System.out.println("\n--\tOrdem nome contato\t--");
		/* Resumindo o ComparatorNome para uma classe anônima

		Set<Map.Entry<Integer, Contato>> agendaOrdemNome = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {

			@Override
			public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
			}
		});
		*/
		
		//Reduzindo de classe anônima para funnção Lambda (resultado final)
		Set<Map.Entry<Integer, Contato>> agendaOrdemNome = new TreeSet<>(Comparator.comparing(
				t -> t.getValue().getNome()));
	
		agendaOrdemNome.addAll(agenda.entrySet());
		
		
		for (Map.Entry<Integer, Contato> entry : agendaOrdemNome) {
			System.out.println("   "+ entry.getKey() + "\t" + entry.getValue().getNome() +"\t"+ entry.getValue().getTelefone());
		}
		
		
	}

}
/*
class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>>{

	@Override
	public int compare(Entry<Integer, Contato> c1, Entry<Integer, Contato> c2) {
		return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
	}
	
}
*/