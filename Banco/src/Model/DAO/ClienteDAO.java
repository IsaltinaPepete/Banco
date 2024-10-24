/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entidades.Cliente;
import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itsa Pepete
 */
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(pNome, apelido, nacionalidade, estadoCivil, cidade, bairro,"
                + " rua, dataNascimento, telefone1, telefone2, email, Funcionario_idFuncionario) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getApelido());
            ps.setString(3, cliente.getNacionalidade());
            ps.setString(4, cliente.getEstadoCivil());
            ps.setString(5, cliente.getCidade());
            ps.setString(6, cliente.getBairro());
            ps.setString(7, cliente.getRua());
            ps.setDate(8, Date.valueOf(cliente.getDataNascimento()));
            ps.setInt(9, cliente.getTelefone1());
            ps.setInt(10, cliente.getTelefone2());
            ps.setString(11, cliente.getEmail());
            ps.setInt(12, cliente.getIdFuncionario());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Cliente cliente) {
        try {
            String sql = "UPDATE cliente SET  apelido = ?, bairro = ?, cidade = ?, estadoCivil = ?, email = ? ,rua = ?,"
                    + "telefone1 = ?, telefone2 = ?, Funcionario_idFuncionario= ? WHERE idCliente = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cliente.getApelido());
            ps.setString(2, cliente.getBairro());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getEstadoCivil());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getRua());
            ps.setInt(7, cliente.getTelefone1());
            ps.setInt(8, cliente.getTelefone2());
            ps.setInt(9, cliente.getIdFuncionario());
            ps.setInt(10, cliente.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public void apagar(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Cliente> todos() {
        try {
            String sql = "SELECT * from Cliente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("idCliente"));
                cli.setNome(rs.getString("pNome"));
                cli.setApelido(rs.getString("apelido"));
                cli.setNacionalidade(rs.getString("nacionalidade"));
                cli.setEstadoCivil(rs.getString("estadoCivil"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setRua(rs.getString("rua"));
                cli.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                cli.setTelefone1(rs.getInt("telefone1"));
                cli.setTelefone2(rs.getInt("telefone2"));
                cli.setEmail(rs.getString("email"));
                cli.setIdFuncionario(rs.getInt("Funcionario_idFuncionario"));

                lista.add(cli);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public void actualizarCliente(int idCliente, String b, String c, String ec,String email,String rua, int tel1, int tel2) {
        try {
            String sql = "UPDATE cliente SET  bairro = ?, cidade = ?, estadoCivil = ?, email = ? ,rua = ?,"
                    + "telefone1 = ?, telefone2 = ? WHERE idCliente = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, b);
            ps.setString(2, c);
            ps.setString(3, ec);
            ps.setString(4, email);
            ps.setString(5, rua);
            ps.setInt(6, tel1);
            ps.setInt(7, tel2);
            ps.setInt(8, idCliente);
           
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
