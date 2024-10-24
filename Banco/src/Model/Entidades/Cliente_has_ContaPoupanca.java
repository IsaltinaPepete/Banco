/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

/**
 *
 * @author Thole
 */
public class Cliente_has_ContaPoupanca {
    private int idCliente;
    private int idConta;

    public Cliente_has_ContaPoupanca(int idCliente, int idConta) {
        this.idCliente = idCliente;
        this.idConta = idConta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
    
    
    
}
