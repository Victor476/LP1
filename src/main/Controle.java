package main;

import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author radames
 */
public class Controle {

    private List<Estrela> lista = new ArrayList<>();

    public Controle() { //esse construtor é usado para adicionar alguns dados na lista e 

    }

    public void limparLista() {
        lista.clear();//zera a lista
    }

    public void adicionar(Estrela estrela) {
        lista.add(estrela);
    }

    public List<Estrela> listar() {
        return lista;
    }

    public Estrela buscar(long id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return lista.get(i);
            }
        }
        return null;

    }

    public void alterar(Estrela estrela, Estrela estrelaAntigo) {
        lista.set(lista.indexOf(estrelaAntigo), estrela);

    }

    public void excluir(Estrela estrela) {
        lista.remove(estrela);
    }

    public void gravarLista(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> listaDeString = new ArrayList<>();
        for (Estrela estrela : lista) {
            listaDeString.add(estrela.toString());
        }
        manipulaArquivo.salvarArquivo(caminho, listaDeString);
    }

    void carregarDados(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if (!manipulaArquivo.existeOArquivo(caminho)) {
            manipulaArquivo.criarArquivoVazio(caminho);
        }

        List<String> listaDeString = manipulaArquivo.abrirArquivo(caminho);
        //converter de CSV para Estrela
        Estrela estrela;
        for (String string : listaDeString) {
            String aux[] = string.split(";");
            estrela = new Estrela();
            lista.add(estrela);
        }
    }

}
