/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author a2021064
 */

public class ElementoQuimico {
    private double numeroMassa;
    private int numerodeProtons;
    private String simbolo;
    private String nomeElem;
    private String camadadevalencia;
    private double raioatomico;
    private double eletronegatividade;

    public ElementoQuimico() {
    }

    public ElementoQuimico(double numeroMassa, int numerodeProtons, String simbolo, 
        String nomeElem, String camadadevalencia, double raioatomico, double eletronegatividade) {
        this.numeroMassa = numeroMassa;
        this.numerodeProtons = numerodeProtons;
        this.simbolo = simbolo;
        this.nomeElem = nomeElem;
        this.camadadevalencia = camadadevalencia;
        this.raioatomico = raioatomico;
        this.eletronegatividade = eletronegatividade;
    }

    
    public double getNumeroMassa() {
        return numeroMassa;
    }

    public void setNumeroMassa(double numeroMassa) {
        this.numeroMassa = numeroMassa;
    }

    public int getNumerodeProtons() {
        return numerodeProtons;
    }

    public void setNumerodeProtons(int numerodeProtons) {
        this.numerodeProtons = numerodeProtons;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNomeElem() {
        return nomeElem;
    }

    public void setNomeElem(String nomeElem) {
        this.nomeElem = nomeElem;
    }

    public String getCamadadevalencia() {
        return camadadevalencia;
    }

    public void setCamadadevalencia(String camadadevalencia) {
        this.camadadevalencia = camadadevalencia;
    }

    public double getRaioatomico() {
        return raioatomico;
    }

    public void setRaioatomico(double raioatomico) {
        this.raioatomico = raioatomico;
    }

    public double getEletronegatividade() {
        return eletronegatividade;
    }

    public void setEletronegatividade(double eletronegatividade) {
        this.eletronegatividade = eletronegatividade;
    }

}
