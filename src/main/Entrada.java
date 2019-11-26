/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author a2021064
 */
public class Entrada {
    Scanner teclado = new Scanner(System.in);
    
    public void pausaEnter(){
        System.out.println("Pressione [Enter] para continuar");
        teclado.nextLine();
    }

    public Double lerNumeroDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg + " =>");
                double x = teclado.nextDouble();
                return x;
            } catch (Exception e) {
                System.out.println("Erro,digite um double....");
                teclado = new Scanner(System.in);
            }
        }
    }

    public Integer lerNumeroInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg + " =>");
                int x = teclado.nextInt();
                return x;
            } catch (Exception e) {
                System.out.println("Erro,digite um inteiro....");
                teclado = new Scanner(System.in);
            }
        }
    }

    public String lerString(String msg) {
        teclado = new Scanner(System.in);
        //evita que o usuário deixe a string vazia
        while (true) {
            try {
                System.out.print(msg + " =>");
                String x = teclado.nextLine();
                if (x.trim().isEmpty()) {
                    int k = 3 / 0; //propositalmente provoca um erro para ir para o catch
                }
                return x;
            } catch (Exception e) {
                System.out.println("Erro, a string não pode ser vazia");
                teclado = new Scanner(System.in);
            }
        }
    }

    public boolean lerConfirmacao(String msg) {
        teclado = new Scanner(System.in);
        //ler uma resposta sim ou não do usuário
        while (true) {
            try {
                System.out.print(msg + " (S ou N) ");
                char x = teclado.next().charAt(0);
                if (x == 's' || x == 'S') {
                    return true;
                } else if (x == 'n' || x == 'N') {
                    return false;
                } else {
                    int a = 3 / 0;//provocar um erro propositalmente
                }
            } catch (Exception e) {
                System.out.println("Erro, são válidas as letras S ou N");
                teclado = new Scanner(System.in);
            }
        }
    }
}
