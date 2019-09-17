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
class Processamento {
    int contesp=0;
    int contvogal=0;
    Integer tiraespaço(String frase) {
        String lstring="";
        for (int i = 0;i<frase.length(); i++) {
            lstring=String.valueOf(frase.charAt(i));
            if (lstring.equals(" ")) {
                contesp++;
            }
            }
        return contesp;
        }

    int contavogais(String frase) {
        frase=frase.toLowerCase();
        String lstring="";
        for (int i = 0;i<frase.length(); i++) {
            lstring=String.valueOf(frase.charAt(i));
            if (lstring.equals("a")||lstring.equals("e")||
                    lstring.equals("i")||lstring.equals("o")||
                    lstring.equals("u")) {
                contvogal++;
            }
            }
        return contvogal;
    }
}
    

