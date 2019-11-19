/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;

/**
 *
 * @author a2021064
 */
public class Estrela {
   long Id;
   String nome;
   double massa;
   String cor;
   Date Datadescoberta;

    public Estrela() {
    }

    public Estrela(long Id, String nome, double massa, String cor, Date Datadescoberta) {
        this.Id = Id;
        this.nome = nome;
        this.massa = massa;
        this.cor = cor;
        this.Datadescoberta = Datadescoberta;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getDatadescoberta() {
        return Datadescoberta;
    }

    public void setDatadescoberta(Date Datadescoberta) {
        this.Datadescoberta = Datadescoberta;
    }
   
}
