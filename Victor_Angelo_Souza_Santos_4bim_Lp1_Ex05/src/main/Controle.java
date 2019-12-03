/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;
import tools.CaixaDeFerramentas;
/**
 *
 * @author a2021064
 */
public class Controle {
    CaixaDeFerramentas cf = new CaixaDeFerramentas();
    private List<PersonagemWOW> lista = new ArrayList<>();
    
    

    public Controle() { //esse construtor é usado para adicionar alguns dados na lista e 

    }

    public void limparLista() {
        lista.clear();//zera a lista
    }

    public void adicionar(PersonagemWOW personagemwow) {
        lista.add(personagemwow);
    }

    public List<PersonagemWOW> listar() {
        return lista;
    }

    public PersonagemWOW buscar(String nome) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equals(nome)) {
                return lista.get(i);
            }
        }
        return null;

    }

    public void alterar(PersonagemWOW personagemwow, PersonagemWOW personagemwowantiga) {
        lista.set(lista.indexOf(personagemwowantiga), personagemwow);

    }

    public void excluir(PersonagemWOW personagemwow) {
        lista.remove(personagemwow);
    }

    public void gravarLista(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> listaDeString = new ArrayList<>();
        for (PersonagemWOW personagemwow : lista) {
            listaDeString.add(personagemwow.toString());
        }
        manipulaArquivo.salvarArquivo(caminho, listaDeString);
    }

    void carregarDados(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if (!manipulaArquivo.existeOArquivo(caminho)) {
            manipulaArquivo.criarArquivoVazio(caminho);
        }

        List<String> listaDeString = manipulaArquivo.abrirArquivo(caminho);
        //converter de CSV para PersonagemWOW
        PersonagemWOW personagemwow;
        for (String string : listaDeString) {
            String aux[] = string.split(";");  
            personagemwow = 
                    new PersonagemWOW(aux[0],aux[1],aux[2],aux[3],
                            aux[4],cf.converteDeStringParaDate(aux[5]),
                            Integer.valueOf(aux[7]));
            lista.add(personagemwow);
        }
    }
}
