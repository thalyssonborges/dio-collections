package dio.map_ordenacao;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome Autor - Nome Livro);
Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
*/

public class ExemploOrdenacaoMap {

	public static void main(String[] args) {
		Map<String, Livro> livros = new HashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
			put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
			put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
		}};
		
		System.out.println("--\tOrdem aleatória\t--");
		for (Map.Entry<String, Livro> livro : livros.entrySet()) {
			System.out.println(livro.getKey() + " - " +livro.getValue().getNomeLivro());
		}
		
		System.out.println("\n--\tOrdem Inserção\t--");
		Map<String, Livro> livrosOrdemInsercao = new LinkedHashMap<String, Livro>(){{
			put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
			put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
			put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
		}};
		
		for (Map.Entry<String, Livro> livro : livrosOrdemInsercao.entrySet()) {
			System.out.println(livro.getKey() + " - " +livro.getValue().getNomeLivro());
		}
		
		System.out.println("\n--\tOrdem alfabética autores\t--");
		Map<String, Livro> livrosOrdemAlfabetica = new TreeMap<String, Livro>(livros);
		for (Map.Entry<String, Livro> livro : livrosOrdemAlfabetica.entrySet()) {
			System.out.println(livro.getKey() +" - "+livro.getValue().getNomeLivro());
		}
		
		System.out.println("\n--\tOrdem alfabética nomes dos livros\t--");
		Set<Map.Entry<String, Livro>> livrosOrdemNomeLivro = new TreeSet<>(new ComparatorNome());
		livrosOrdemNomeLivro.addAll(livros.entrySet());
		for (Map.Entry<String, Livro> livro : livrosOrdemNomeLivro) {
			System.out.println(livro.getKey() +" - "+livro.getValue().getNomeLivro());
		}
		
		System.out.println("\n--\tOrdem número de página\t--");
		Set<Map.Entry<String, Livro>> livrosOrdemNumeroPaginas = new TreeSet<>(new ComparatorNumeroPaginas());
		livrosOrdemNumeroPaginas.addAll(livros.entrySet());
		for (Map.Entry<String, Livro> livro : livrosOrdemNumeroPaginas) {
			System.out.println(livro.getKey() +" - "+livro.getValue().getNomeLivro()+" - "+livro.getValue().getPaginasLivro());
		}
		
	}

}
class Livro{
	private String nomeLivro;
	private Integer paginasLivro;
	
	public Livro() {
	}
	public Livro(String nomeLivro, Integer paginasLivro) {
		this.nomeLivro = nomeLivro;
		this.paginasLivro = paginasLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public Integer getPaginasLivro() {
		return paginasLivro;
	}
	public void setPaginasLivro(Integer paginasLivro) {
		this.paginasLivro = paginasLivro;
	}
	@Override
	public String toString() {
		return "[Livro = " + nomeLivro + ", Páginas = " + paginasLivro + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nomeLivro, paginasLivro);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Livro))
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nomeLivro, other.nomeLivro) && Objects.equals(paginasLivro, other.paginasLivro);
	}	
}
class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

	@Override
	public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
		
		return o1.getValue().getNomeLivro().compareToIgnoreCase(o2.getValue().getNomeLivro());
	}	
}
class ComparatorNumeroPaginas implements Comparator<Map.Entry<String, Livro>>{

	@Override
	public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
		return o1.getValue().getPaginasLivro().compareTo(o2.getValue().getPaginasLivro());
	}
	
	
}
