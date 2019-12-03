/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;

/**
 *
 * @author Victor Angelo
 */
public class PersonagemWOW {
    private String nome;
    private String sexo;
    private String facção;
    private String raça;
    private String classe;
    private Date datadecriação;
    private int nevel;

    public PersonagemWOW() {
    }

    public PersonagemWOW(String nome, String sexo, String facção, String raça, String classe, Date datadecriação, int nevel) {
        this.nome = nome;
        this.sexo = sexo;
        this.facção = facção;
        this.raça = raça;
        this.classe = classe;
        this.datadecriação = datadecriação;
        this.nevel = nevel;
    }

    public int getNevel() {
        return nevel;
    }

    public void setNevel(int nevel) {
        this.nevel = nevel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFacção() {
        return facção;
    }

    public void setFacção(String facção) {
        this.facção = facção;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Date getDatadecriação() {
        return datadecriação;
    }

    public void setDatadecriação(Date datadecriação) {
        this.datadecriação = datadecriação;
    }
    
}
