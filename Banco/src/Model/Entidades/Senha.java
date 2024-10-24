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

public class Senha {
    private int id, senha;
    private String tipoConta;
    
    public Senha(int id, int senha, String tipoConta) {
        this.id = id;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }

    public int getId() {
        return id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public int getSenha() {
        return senha;
    }

   
    
    

}
