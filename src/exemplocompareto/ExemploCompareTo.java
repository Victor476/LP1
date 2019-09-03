/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplocompareto;

/**
 *
 * @author a2021064
 */
public class ExemploCompareTo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Entrada entrada = new Entrada();
        Processamento processamento = new Processamento();
        Saida saida = new Saida();
        String Sa=entrada.lerString("Digite um nome");
        String Sb=entrada.lerString("Digite um nome");
        String Sc=entrada.lerString("Digite um nome");
        String S1=Sa;
        if (Sa.compareTo(Sb)>0) {
            S1=Sa;
            Sa=Sb;
            Sb=S1;
        }
        if (Sb.compareTo(Sc)>0) {
            S1=Sb;
            Sb=Sc;
            Sc=S1;
        }
        if (Sa.compareTo(Sb)>0) {
            S1=Sa;
            Sa=Sb;
            Sb=S1;
        }
        System.out.println(Sa+" "+Sb+" "+Sc);
    }
    
}
