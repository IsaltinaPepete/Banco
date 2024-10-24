/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import Model.Entidades.Trabalhador;
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
public class TrabalhadorDAO {
    
    private Connection conexao;

    public TrabalhadorDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TrabalhadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Trabalhador trabalhador) {
        String sql = "INSERT INTO Funcionario( pNome, apelido, nacionalidade, estadoCivil, cidade, bairro,"
                + " rua, dataNascimento, telefone1, telefone2, email, cargo, salario, Departamento_idDepartamento) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setString(1, trabalhador.getNome());
            ps.setString(2, trabalhador.getApelido());
            ps.setString(3, trabalhador.getNacionalidade());
            ps.setString(4, trabalhador.getEstadoCivil());
            ps.setString(5, trabalhador.getCidade());
            ps.setString(6, trabalhador.getBairro());
            ps.setString(7, trabalhador.getRua());
            ps.setDate(8, Date.valueOf(trabalhador.getDataNascimento()) );
            ps.setInt(9, trabalhador.getTelefone1());
            ps.setInt(10, trabalhador.getTelefone2());
            ps.setString(11, trabalhador.getEmail());
            ps.setString(12, trabalhador.getCargo());
            ps.setFloat(13, trabalhador.getSalario());
            ps.setInt(14, trabalhador.getIdDepartamento());
            ps.execute();
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Trabalhador trabalhador) {
        try {
            String sql = "UPDATE funcionario SET  apelido = ?, bairro = ?, cidade = ?, estadoCivil = ?, email = ? ,rua = ?,"
                    + "telefone1 = ?, telefone2 = ? , cargo = ? , Departamento_idDepartamento = ? WHERE idFuncionario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, trabalhador.getApelido());
            ps.setString(2, trabalhador.getBairro());
            ps.setString(3, trabalhador.getCidade());
            ps.setString(4, trabalhador.getEstadoCivil());
            ps.setString(5, trabalhador.getEmail());
            ps.setString(6, trabalhador.getRua());
            ps.setInt(7, trabalhador.getTelefone1());
            ps.setInt(8, trabalhador.getTelefone2());
            ps.setString(9, trabalhador.getCargo());
            ps.setInt(10, trabalhador.getIdDepartamento());
            ps.setInt(11, trabalhador.getId());
           
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(int idTrabalhador) {
        String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idTrabalhador);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Trabalhador> todos() {
        try {
            String sql = "SELECT * from Funcionario";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Trabalhador> lista = new ArrayList<>();
            while (rs.next()) {
                Trabalhador trabalhador = new Trabalhador();
                trabalhador.setId(rs.getInt("idFuncionario"));
                trabalhador.setNome(rs.getString("pNome"));
                trabalhador.setApelido(rs.getString("apelido"));
                trabalhador.setNacionalidade(rs.getString("nacionalidade"));
                trabalhador.setEstadoCivil(rs.getString("estadoCivil"));
                trabalhador.setBairro(rs.getString("bairro"));
                trabalhador.setCidade(rs.getString("cidade"));
                trabalhador.setRua(rs.getString("rua"));
                trabalhador.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                trabalhador.setTelefone1(rs.getInt("telefone1"));
                trabalhador.setTelefone2(rs.getInt("telefone2"));
                trabalhador.setEmail(rs.getString("email"));
                trabalhador.setCargo(rs.getString("cargo"));
                trabalhador.setSalario(rs.getFloat("salario"));
                trabalhador.setIdDepartamento(rs.getInt("Departamento_idDepartamento"));

                lista.add(trabalhador);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    
}
