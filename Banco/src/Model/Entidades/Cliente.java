/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

import Model.Entidades.Identidade;
import java.time.LocalDate;

/**
 *
 * @author Itsa Pepete
 */
public class Cliente extends Identidade {
     int idFuncionario;
    float rendaMensal;
    String ocupacao;
    
    public Cliente(String nome, String apelido, String nacionalidade, String bairro, String cidade, String estadoCivil,
            String email, String rua, LocalDate dataNascimento, int telefone1, int telefone2, int idFuncionario, String nrBi, 
            String genero, float rendaMensal, String ocupacao) {
        super(nome, apelido, nacionalidade, bairro, cidade, estadoCivil, email, rua, dataNascimento, telefone1, telefone2, nrBi, genero);
        this.idFuncionario = idFuncionario;
        this.rendaMensal = rendaMensal;
        this.ocupacao = ocupacao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public Cliente(){
        this(null, null, null, null, null, null, null, null, null, 0, 0, 0, null, "", 0, " ");
    }
    
    
    @Override
    public String toString() {
        return super.toString();
    }

    public void setIdFuncionario(int aInt) {
        idFuncionario= aInt;
    }
    
    
    
    
}
