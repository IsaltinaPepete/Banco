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
public class Trabalhador extends Identidade{

    private String cargo;
    private float salario;
    private int idDepartamento;
    
    public Trabalhador(String cargo, float salario, int idDepartamento, String nome, String apelido, String nacionalidade, String bairro, String cidade, String estadoCivil, String email, String rua, LocalDate dataNascimento, int telefone1, int telefone2, String nrBi, 
            String genero) {
        super(nome, apelido, nacionalidade, bairro, cidade, estadoCivil, email, rua, dataNascimento, telefone1, telefone2, nrBi, genero);
        
        this.cargo = cargo;
        this.salario = salario;
        this.idDepartamento= idDepartamento;
    }
    
    public Trabalhador(){
        this( null, 0, 0, null, null, null, null, null, null, null, null, null, 0, 0, null, "");
    }
    public String getCargo() {
        return cargo;
    }

    public float getSalario() {
        return salario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    
    @Override
    public String toString() {
        return super.toString() + "cargo=" + cargo + ", salario=" + salario ;
    }

    
    
    
    
}
