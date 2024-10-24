/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

import Model.Entidades.Conta;



/**
 *
 * @author Itsa Pepete
 */
public class ContaCorrente extends Conta{
    
    private float limiteLevantamento;

    public ContaCorrente( int idTitular1, int idTitular2, int idTitular3, float saldo) {
        super(idTitular1, idTitular2, idTitular3, saldo);
        this.limiteLevantamento = 5000;
    }

    @Override
    public String toString() {
        return super.toString()+ "limiteLevantamento=" + limiteLevantamento ;
    }

    public ContaCorrente() {
        this(0,0,0,0);
    }

    public float getLimiteLevantamento() {
        return limiteLevantamento;
    }

    public void setLimiteLevantamento(float limiteLevantamento) {
        this.limiteLevantamento = limiteLevantamento;
    }

    public void transferirValor(float valor, int idConta){
         if(valor < 0)
            throw new IllegalArgumentException("Valor invalido!");
         
       this.taxa = 0.01f*valor;
    }
    
    @Override
    public void verSaldo(){
        this.taxa = 0.005f*this.saldo;
    }
    
    
    
}

    
    
    

