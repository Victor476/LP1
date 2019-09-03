/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplocompareto;

import java.util.Scanner;

/**
 *
 * @author a2021064
 */
class Entrada {
    public String lerString(String msg) {
        Scanner teclado = new Scanner(System.in);
        while (true) {

            try {

                System.out.print(msg + " =>");

                String x = teclado.nextLine();
                x=x.trim();
                if(x.isEmpty()){
                int n=3/0; }
                return x;

            } catch (Exception e) {

                System.out.println("Erro,String não pode ser vazia....");

                teclado = new Scanner(System.in);

            }

        }

    }
}
