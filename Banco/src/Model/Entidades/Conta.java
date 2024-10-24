/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

/**
 *
 * @author
 */



public class Conta {
    
    protected int idConta, idTitular1, idTitular2, idTitular3;
    protected float saldo;
    protected  float taxa;

    public Conta(int idTitular1, int idTitular2, int idTitular3, float saldo) {
        
        this.idTitular1 = idTitular1;
        this.idTitular2 = idTitular2;
        this.idTitular3 = idTitular3;
        this.saldo = saldo;
        
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdTitular1() {
        return idTitular1;
    }

    public void setIdTitular1(int idTitular1) {
        this.idTitular1 = idTitular1;
    }

    public int getIdTitular2() {
        return idTitular2;
    }

    public void setIdTitular2(int idTitular2) {
        this.idTitular2 = idTitular2;
    }

    public int getIdTitular3() {
        return idTitular3;
    }

    public void setIdTitular3(int idTitular3) {
        this.idTitular3 = idTitular3;
    }
    

   
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "idConta=" + idConta + ", idTitular1=" + idTitular1 + ", idTitular2=" + idTitular2 + ", idTitular3=" + idTitular3 + ", saldo=" + saldo + '}';
    }

  

    
    public void depositar(float valor){
        
        if(valor < 0)
            throw new IllegalArgumentException("Valor invalido!");
        
        saldo += valor;
    }
    
    public void verSaldo(){
        
    }
    
    public void levantar(float valor){
        if(valor < 0)
            throw new IllegalArgumentException("Valor invalido!");
        this.taxa = 0.03f*valor;
        if (saldo < (valor + taxa)){
            throw new IllegalArgumentException("Saldo insuficiente");
        } else{
            saldo -= valor;
        }
        
    }
       
    
    
   
    
    
    
}

    
    

   
    

