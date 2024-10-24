/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Itsa Pepete
 */
public class Identidade {
    
      protected String nome, apelido, nacionalidade, bairro, cidade, estadoCivil, email;
    protected int id;
    protected String rua, nrBi;
    protected LocalDate dataNascimento;
    protected int telefone1, telefone2;
    protected String genero;

    public Identidade(String nome, String apelido, String nacionalidade, String bairro, String cidade, String estadoCivil, String email, String rua, LocalDate dataNascimento, int telefone1, int telefone2, String nrBi, String genero) {
     
        this.nome = nome;
        this.apelido = apelido;
        this.nacionalidade = nacionalidade;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.rua = rua;
        this.dataNascimento = dataNascimento;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.nrBi = nrBi;
        this.genero= genero;
        
    }
    
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public String getRua() {
        return rua;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getTelefone1() {
        return telefone1;
    }

    public int getTelefone2() {
        return telefone2;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone1(int telefone1) {
        this.telefone1 = telefone1;
    }

    public void setTelefone2(int telefone2) {
        this.telefone2 = telefone2;
    }

    public String getNrBi() {
        return nrBi;
    }

    public String getGenero() {
        return genero;
    }

    public void setNrBi(String nrBi) {
        this.nrBi = nrBi;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

  
    

    @Override
    public String toString() {
        return "id=" + id +  ", nome=" + nome + ", apelido=" + apelido + ", nacionalidade=" + nacionalidade + ", bairro=" + bairro + ", cidade=" + cidade + ", estadoCivil=" + estadoCivil + ", email=" + email + ", rua=" + rua + ", dataNascimento=" + dataNascimento + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 ;
    }
    
    
}
