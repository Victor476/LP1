/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victor_amgelo_3bim_exercicio05;

/**
 *
 * @author a2021064
 */
public class Victor_Amgelo_3bim_Exercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        String frase=entrada.lerString("Digite a frase");
        int tiraespaço=processamento.tiraespaço(frase);
        int contvogais=processamento.contavogais(frase);
        System.out.println("O numero de espaços é: "+tiraespaço);
        System.out.println("O numero de vogais é: "+contvogais);
    }
    
}
