/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

import java.time.LocalDate;

/**
 *
 * @author Itsa Pepete
 */
public class Movimentos {
    private int idMovimentos;
    private String tipo;
    private float taxa;
    private LocalDate dataMovimento;
    private int idContaCorrente;
    private int idContaPoupanca;

    public Movimentos(String tipo, float taxa, int idContaCorrente, int idContaPoupanca) {
       
        this.tipo = tipo;
        this.taxa = taxa;
        this.dataMovimento = LocalDate.now();
        this.idContaCorrente = idContaCorrente;
        this.idContaPoupanca = idContaPoupanca;
    }

    public Movimentos() {
        this("",0,0,0);
    }

    public int getIdMovimentos() {
        return idMovimentos;
    }

    public void setIdMovimentos(int idMovimentos) {
        this.idMovimentos = idMovimentos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDate dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public int getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaPoupanca(int idContaPoupanca) {
        this.idContaPoupanca = idContaPoupanca;
    }

    public void setIdContaCorrente(int idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public int getIdContaPoupanca() {
        return idContaPoupanca;
    }
    
    
    
    
    
    
    
}
