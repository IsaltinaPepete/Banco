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
public class Departamento {
    private int idDepartamento, nrFuncionarios, idChefeDepartamento;
    private String nomeDepartamento;

    public Departamento( String nomeDepartamento,  int idChefeDepartamento ) {
      
        this.idChefeDepartamento = idChefeDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }

    public Departamento() {
        this(null, 0);
    }

    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public int getNrFuncionarios() {
        return nrFuncionarios;
    }

    public int getIdChefeDepartamento() {
        return idChefeDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setNrFuncionarios(int nrFuncionarios) {
        this.nrFuncionarios = nrFuncionarios;
    }

    public void setIdChefeDepartamento(int idChefeDepartamento) {
        this.idChefeDepartamento = idChefeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public String toString() {
        return  "idDepartamento=" + idDepartamento + ", nrFuncionarios=" + nrFuncionarios + ", idChefeDepartamento=" + idChefeDepartamento + ", nomeDepartamento=" + nomeDepartamento;
    }
    
    
    
}

