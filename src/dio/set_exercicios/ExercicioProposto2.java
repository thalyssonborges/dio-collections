package dio.set_exercicios;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/

public class ExercicioProposto2 {

	public static void main(String[] args) {
		Set<LinguagemFavorita> linguagens = new HashSet<>() {{
			add(new LinguagemFavorita("Java", 1935, "Eclipse"));
			add(new LinguagemFavorita("Php", 1900, "Sublime Text"));
			add(new LinguagemFavorita("Javascript", 2005, "Visual Studio Code"));
		}};
		System.out.println("a) Ordem de inserção;");
		Set<LinguagemFavorita> linguagensOrdemInsercao = new LinkedHashSet<>() {{
			add(new LinguagemFavorita("Java", 1935, "Eclipse"));
			add(new LinguagemFavorita("Php", 1900, "Sublime Text"));
			add(new LinguagemFavorita("Javascript", 2005, "Visual Studio Code"));
		}};
		for (LinguagemFavorita linguagemFavorita : linguagensOrdemInsercao) {
			System.out.println("\t"+linguagemFavorita);
		}
		
		System.out.println("\nb) Ordem natural(nome);");
		Set<LinguagemFavorita> linguagensOrdemNome = new TreeSet(linguagens);
		for (LinguagemFavorita linguagemFavorita : linguagensOrdemNome) {
			System.out.println("\t"+linguagemFavorita);
		}
		System.out.println("\nc) IDE;");
		Set<LinguagemFavorita> linguagensOrdemIDE = new TreeSet<>(new ComparatorIDE());
		linguagensOrdemIDE.addAll(linguagens);
		for (LinguagemFavorita linguagemFavorita : linguagensOrdemIDE) {
			System.out.println("\t"+linguagemFavorita);
		}
		System.out.println("\nd) Ano de criação e nome;");
		Set<LinguagemFavorita> linguagensOrdemAnoDeCriacaoNome = new TreeSet<>(new ComparatorAnoDeCriacaoNome());
		linguagensOrdemAnoDeCriacaoNome.addAll(linguagens);
		for (LinguagemFavorita linguagemFavorita : linguagensOrdemAnoDeCriacaoNome) {
			System.out.println("\t"+linguagemFavorita);
		}
		System.out.println("\ne) Nome, ano de criação e IDE;");
		Set<LinguagemFavorita> linguagensOrdemNomeAnoIDE = new TreeSet<>(new ComparatorNomeAnoIDE());
		linguagensOrdemNomeAnoIDE.addAll(linguagens);
		for (LinguagemFavorita linguagemFavorita : linguagensOrdemNomeAnoIDE) {
			System.out.println("\t"+linguagemFavorita);
		}
	}

}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
	private String nome;
	private Integer anoDeCriacao;
	private String Ide;
	
	public LinguagemFavorita() {
	}

	public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
		this.nome = nome;
		this.anoDeCriacao = anoDeCriacao;
		Ide = ide;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnoDeCriacao() {
		return anoDeCriacao;
	}

	public void setAnoDeCriacao(Integer anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}

	public String getIde() {
		return Ide;
	}

	public void setIde(String ide) {
		Ide = ide;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Ide, anoDeCriacao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinguagemFavorita other = (LinguagemFavorita) obj;
		return Objects.equals(Ide, other.Ide) && Objects.equals(anoDeCriacao, other.anoDeCriacao)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return nome + " - " + anoDeCriacao + " - " + Ide;
	}

	@Override
	public int compareTo(LinguagemFavorita o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}


}
class ComparatorIDE implements Comparator<LinguagemFavorita>{

	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		return o1.getIde().compareToIgnoreCase(o2.getIde());
	}
	
}
class ComparatorAnoDeCriacaoNome implements Comparator<LinguagemFavorita>{

	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int ano = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
		if (ano != 0) return ano;
		return o1.getNome().compareToIgnoreCase(o2.getNome());
	}
	
}
class ComparatorNomeAnoIDE implements Comparator<LinguagemFavorita>{

	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
		if(nome != 0) return nome;
		
		int ano = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
		if(ano != 0) return ano;
		
		return o1.getIde().compareToIgnoreCase(o2.getIde());
	}
	
}


