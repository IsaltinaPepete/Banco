/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.DAO.Conexao;
import Model.Entidades.Cliente_has_ContaCorrente;
import Model.Entidades.ContaCorrente;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Thole
 */
public class ContaCorrenteDAO {

    private Connection conexao;

    public ContaCorrenteDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(ContaCorrente conta) {
        String sql = "INSERT INTO ContaCorrente(idConta, limiteLevantamento, saldo) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, conta.getIdConta());
            ps.setFloat(2, conta.getLimiteLevantamento());
            ps.setFloat(3, conta.getSaldo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        inserirClienteCorrente(conta);

    }

    private void inserirClienteCorrente(ContaCorrente conta) {

        String sql = "INSERT INTO cliente_has_contacorrente(Cliente_idCliente, ContaCorrente_idConta, dataCriacao) VALUES(?,?,?)";
        int aux = conta.getIdTitular1();
        while (aux > 0) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, aux);
                ps.setInt(2, conta.getIdConta());
                ps.setDate(3, Date.valueOf(LocalDate.now()));
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = conta.getIdTitular2();
        }
        aux = conta.getIdTitular3();
        if (aux > 0) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, aux);
                ps.setInt(2, conta.getIdConta());
                ps.setDate(3, Date.valueOf(LocalDate.now()));
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public void actualizar(ContaCorrente conta) {
//        try {
//            String sql = "UPDATE ContaCorrente SET  limiteLevantamento = ? WHERE idConta = ?";
//            PreparedStatement ps = conexao.prepareStatement(sql);
//            ps.setFloat(1, conta.getLimiteLevantamento());
//            ps.setInt(2, conta.getIdConta());
//
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void actualizar(int id, float saldoo) {
        try {
            String sql = "UPDATE ContaCorrente SET  saldo = saldo-saldoo WHERE idConta = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(int idConta) {
        apagarClienteHasConta(idConta);
        String sql = "DELETE FROM ContaCorrente WHERE idConta = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idConta);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void apagarClienteHasConta(int idConta) {
        String sql = "DELETE FROM Cliente_has_ContaCorrente WHERE ContaCorrente_idConta = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idConta);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ContaCorrente> todos() {
        ArrayList<ContaCorrente> lista = new ArrayList<>();
        try {
            String sql = "SELECT * from ContaCorrente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ContaCorrente conta = new ContaCorrente();
                conta.setIdConta(rs.getInt("idConta"));
                conta.setLimiteLevantamento(rs.getFloat("LimiteLevantamento"));
                conta.setSaldo(rs.getFloat("saldo"));

                lista.add(conta);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public void aumentarSaldo(int idConta, float valor) {
        try {
            String sql = "UPDATE ContaCorrente set saldo = saldo + ? where idConta = idConta";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, valor);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void reduzirSaldo(int idConta, float valor) {
        try {
            String sql = "UPDATE ContaCorrente set saldo = saldo - ? where idConta = idConta";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, valor);
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

   
    public List<Cliente_has_ContaCorrente> clienteConta() {
        try {
            String sql = "SELECT * from Cliente_has_ContaCorrente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente_has_ContaCorrente> lista = new ArrayList<>();
            while (rs.next()) {
                Cliente_has_ContaCorrente c = new Cliente_has_ContaCorrente(rs.getInt("ContaCorrente_idConta"), rs.getInt("Cliente_idCliente"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ContaCorrenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

}
