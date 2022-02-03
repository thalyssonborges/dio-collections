package dio.set_ordenacao;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*Dadas as seguintes informa��es sobre minhas s�ries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de epis�dio);
S�rie 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
S�rie 2 = nome: dark, genero: drama, tempoEpisodio: 60
S�rie 3 = nome: that '70s show, genero: com�dia, tempoEpisodio: 25
*/

/*Exercicio Ordena��o : 
 * System.out.println("--\tOrdem aleat�ria\t--");
 * System.out.println("--\tOrdem inser��o\t--");
 * System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
 * System.out.println("--\tOrdem Nome/G�nero/TempoEpisodio\t--");
 * System.out.println("--\tOrdem g�nero\t--");
 * System.out.println("--\tOrdem Tempo Epis�dio\t--");
 * 
 */

public class ExemploOrdenacaoSet {

	public static void main(String[] args) {

		Set<Serie> series = new HashSet<>();
		series.add(new Serie("got", "fantasia", 60));
		series.add(new Serie("dark", "drama", 60));
		series.add(new Serie("that '70s show", "com�dia", 25));

		System.out.println("--\tOrdem aleat�ria\t--");
		for (Serie serie : series) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}
		// --------------------------------------------------------------------------------------
		System.out.println("\n--\tOrdem inser��o\t--");
		Set<Serie> series1 = new LinkedHashSet<>();
		series1.add(new Serie("got", "fantasia", 60));
		series1.add(new Serie("dark", "drama", 60));
		series1.add(new Serie("that '70s show", "com�dia", 25));
		for (Serie serie : series1) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}
		// --------------------------------------------------------------------------------------
		System.out.println("\n--\tOrdem natural (TempoEpisodio)\t--");
		Set<Serie> series2 = new TreeSet<>(series1);
		for (Serie serie : series2) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}

		System.out.println("\n--\tOrdem Nome/G�nero/TempoEpisodio\t--");
		Set<Serie> series3 = new TreeSet<>(new ComparatoNomeGeneroEpisodio());
		series3.addAll(series);
		for (Serie serie : series3) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}

		System.out.println("\n--\tOrdem g�nero\t--");
		Set<Serie> series4 = new TreeSet<>(new ComparatorGenero());
		series4.addAll(series);
		for (Serie serie : series4) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}

		System.out.println("\n--\tOrdem Tempo Epis�dio\t--");
		Set<Serie> series5 = new TreeSet<Serie>(new ComparatorTempoEpisodio());
		series5.addAll(series);
		for (Serie serie : series5) {
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		}
	}

}

class ComparatoNomeGeneroEpisodio implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		int nome = s1.getNome().compareTo(s2.getNome());
		if (nome != 0)
			return nome;

		int genero = s1.getGenero().compareTo(s2.getGenero());
		if (genero != 0)
			return genero;

		return s1.getTempoEpisodio();
	}

}

class ComparatorGenero implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		return s1.getGenero().compareTo(s2.getGenero());
	}

}

class ComparatorTempoEpisodio implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		return s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
	}

}
