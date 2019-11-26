/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author a2021064
 */
public class Controle {
    private List<ElementoQuimico> lista = new ArrayList<>();
    
    

    public Controle() { //esse construtor é usado para adicionar alguns dados na lista e 

    }

    public void limparLista() {
        lista.clear();//zera a lista
    }

    public void adicionar(ElementoQuimico elementoquimico) {
        lista.add(elementoquimico);
    }

    public List<ElementoQuimico> listar() {
        return lista;
    }

    public ElementoQuimico buscar(int numerodeprotons) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumerodeProtons()==numerodeprotons) {
                return lista.get(i);
            }
        }
        return null;

    }

    public void alterar(ElementoQuimico elementoquimico, ElementoQuimico elementoquimicoAntigo) {
        lista.set(lista.indexOf(elementoquimicoAntigo), elementoquimico);

    }

    public void excluir(ElementoQuimico elementoquimico) {
        lista.remove(elementoquimico);
    }

    public void gravarLista(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> listaDeString = new ArrayList<>();
        for (ElementoQuimico elementoquimico : lista) {
            listaDeString.add(elementoquimico.toString());
        }
        manipulaArquivo.salvarArquivo(caminho, listaDeString);
    }

    void carregarDados(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if (!manipulaArquivo.existeOArquivo(caminho)) {
            manipulaArquivo.criarArquivoVazio(caminho);
        }

        List<String> listaDeString = manipulaArquivo.abrirArquivo(caminho);
        //converter de CSV para ElementoQuimico
        ElementoQuimico elementoquimico;
        for (String string : listaDeString) {
            String aux[] = string.split(";");
            elementoquimico = 
                    new ElementoQuimico(Double.valueOf(aux[0]),
                            Integer.valueOf(aux[1]),aux[2],aux[3],aux[4],
                            Double.valueOf(aux[5]),Double.valueOf(aux[6]));
            lista.add(elementoquimico);
        }
    }
}
