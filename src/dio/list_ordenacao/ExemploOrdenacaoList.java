package dio.list_ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);
Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/

public class ExemploOrdenacaoList {

	public static void main(String[] args) {
		
		List<Gato> gatos = new ArrayList<>() {{
			add(new Gato("Jon", 18, "preto"));
			add(new Gato("Simba", 6, "tigrado"));
			add(new Gato("Jon", 12, "amarelo"));
		}};
		System.out.println(gatos);

        System.out.println("\n--\tOrdem de Inserção\t---");
        System.out.println(gatos);

        System.out.println("\n--\tOrdem aleatória\t---");
        Collections.shuffle(gatos);
        System.out.println(gatos);

        System.out.println("\n--\tOrdem Natural (Nome)\t---");
        //Collections.sort(gatos); -> Comparable
        gatos.sort(new ComparatorNome());
        System.out.println(gatos);

        System.out.println("\n--\tOrdem Idade\t---");
        gatos.sort(new ComparatorIdade());
        System.out.println(gatos);

        System.out.println("\n--\tOrdem cor\t---");
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

        System.out.println("\n--\tOrdem Nome/Cor/Idade\t---");
        gatos.sort(new ComparatorNomeIdade());
        System.out.println(gatos);

	}
}
class ComparatorNome implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getNome().compareToIgnoreCase(g2.getNome());
	}
}
class ComparatorIdade implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getIdade() - g2.getIdade();
	}	
}
class ComparatorCor implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}
}
class ComparatorNomeIdade implements Comparator<Gato>{
	@Override
	public int compare(Gato g1, Gato g2) {
		int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
		if (nome != 0) return nome;
		
		int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
		if (cor != 0) return cor;
		
		return Integer.compare(g1.getIdade(), g2.getIdade());
	}
	
}


