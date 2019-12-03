/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.DecimalFormat;
import java.util.Date;
import tools.CaixaDeFerramentas;

/**
 *
 * @author a2021064
 */
public class Saida {
    CaixaDeFerramentas cf = new CaixaDeFerramentas();
    public void imprimirNumeroDouble(String msg, double num) {
        //formata e imprime um número double
        DecimalFormat df = new DecimalFormat("###,##0.00");
        System.out.println(msg + ": " + df.format(num));
    }

    public void rotuloString(String rotulo, String s) {
        System.out.println(rotulo + ": " + s);
    }

    public void imprimirNumeroInteiro(String rotulo, int i) {
        System.out.println(rotulo + ": " + i);
    }
    
    public void imprimirData(String msg, Date outraData)
    {
        System.out.println(msg + "=>" +cf.converteDeDateParaString(outraData));
    }
}
