/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entidades.Departamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itsa Pepete
 */
public class DepartamentoDAO {
    
     private Connection conexao;

    public DepartamentoDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Departamento departamento) {
        String sql = "INSERT INTO Departamento(nome_departamento,"
                + " id_Chefe_Departamento) VALUES(?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setInt(2, departamento.getIdChefeDepartamento());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Departamento departamento) {
        try {
            String sql = "UPDATE Departamento SET  nome_departamento = ?, id_Chefe_Departamento = ? WHERE idDepartamento = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setInt(2, departamento.getIdChefeDepartamento());
            ps.setInt(3, departamento.getIdDepartamento());
            
           
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(int idDepartamento) {
        String sql = "DELETE FROM Departamento WHERE idDepartamento = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idDepartamento);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Departamento> todos() {
        try {
            String sql = "SELECT * from Departamento";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Departamento> lista = new ArrayList<>();
            while (rs.next()) {
                Departamento dept = new Departamento();
                dept.setIdDepartamento(rs.getInt("idDepartamento"));
                dept.setNomeDepartamento(rs.getString("nome_departamento"));
                dept.setNrFuncionarios(rs.getInt("nrFuncionarios"));
                dept.setIdChefeDepartamento(rs.getInt("id_Chefe_Departamento"));
                

                lista.add(dept);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    
}
