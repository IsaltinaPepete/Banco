

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Model.Entidades.Conta;
import java.time.LocalDate;

/**
 *
 * @author
 */
public class ContaPoupanca extends Conta{
    
    private float valorPoupanca, taxaJurus;
    private LocalDate tempoLimite;

    public ContaPoupanca( LocalDate tempoLimite, int idTitular1, int idTitular2, int idTitular3, float saldo) {
        super( idTitular1, idTitular2, idTitular3, saldo);
        taxaJurus = getTaxaJurus();
        this.tempoLimite = tempoLimite;
    }

    public ContaPoupanca() {
        this(null,0,0,0,0);
    }

    public float getValorPoupanca() {
        return valorPoupanca;
    }

    public void setValorPoupanca(float valorPoupanca) {
        this.valorPoupanca = valorPoupanca;
    }

    public float getTaxaJurus() {
        return 5;
    }

    public void setTaxaJurus(float taxaJurus) {
        this.taxaJurus = taxaJurus;
    }

    public LocalDate getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(LocalDate tempoLimite) {
        this.tempoLimite = tempoLimite;
    }
    

    

    
    
}

