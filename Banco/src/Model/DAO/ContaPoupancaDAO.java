
package Model.DAO;

import Model.DAO.Conexao;
import Model.Entidades.Cliente_has_ContaPoupanca;
import Model.Entidades.ContaPoupanca;
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
 * @author Thole
 */
public class ContaPoupancaDAO {
    private Connection conexao;
    
    public ContaPoupancaDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(ContaPoupanca conta) {
        String sql = "INSERT INTO ContaPoupanca(idConta, taxaJuros, tempoLimite,saldo) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, conta.getIdConta());
            ps.setFloat(2, conta.getTaxaJurus());
            ps.setDate(3, Date.valueOf(conta.getTempoLimite()));
            ps.setFloat(4, conta.getSaldo());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        inserirClientePoupanca(conta);
        
    }
    private void inserirClientePoupanca(ContaPoupanca conta){
        String sql = "INSERT INTO cliente_has_contapoupanca(ContaPoupanca_idConta, Cliente_idCliente) VALUES(?,?)";
        int aux = conta.getIdTitular1();
        while(aux>0){
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, conta.getIdConta());
            ps.setFloat(2, aux);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        aux= conta.getIdTitular2();
        }
    }

    public void actualizar(ContaPoupanca conta) {
        try {
            String sql = "UPDATE ContaPoupanca SET  taxaJuros = ?, tempoLimite = ? WHERE idConta = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, conta.getTaxaJurus());
            ps.setDate(2, Date.valueOf(conta.getTempoLimite()));
            ps.setInt(3, conta.getIdConta());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void levantar(int idConta){
           try {
            String sql = "UPDATE ContaPoupanca SET  saldo = ? WHERE idConta = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, 0);
            ps.setInt(2,idConta);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(int  idConta) {
        apagarClienteHasConta(idConta);
        String sql = "DELETE FROM ContaPoupanca WHERE idConta = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idConta);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void aumentarSaldo(int idConta, float valor){
        try{
            String sql = "UPDATE ContaPoupanca set saldo = saldo + ? where idConta = idConta";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1 , valor);
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e){
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
   
    void apagarClienteHasConta(int idConta){
        String sql = "DELETE FROM Cliente_has_ContaPoupanca WHERE ContaPoupanca_idConta = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idConta);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public ArrayList<ContaPoupanca> todos() {
        try {
            String sql = "SELECT * from ContaPoupanca";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<ContaPoupanca> lista = new ArrayList<>();
            while (rs.next()) {
                ContaPoupanca conta = new ContaPoupanca();
                conta.setIdConta(rs.getInt("idConta"));
                conta.setTaxaJurus(rs.getFloat("taxaJuros"));
                conta.setTempoLimite(rs.getDate("tempoLimite").toLocalDate());
                conta.setSaldo(rs.getFloat("saldo"));

                lista.add(conta);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    public List<Cliente_has_ContaPoupanca> clienteConta() {
        try {
            String sql = "SELECT * from Cliente_has_ContaPoupanca";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente_has_ContaPoupanca> lista = new ArrayList<>();
            while (rs.next()) {
                Cliente_has_ContaPoupanca c = new Cliente_has_ContaPoupanca(rs.getInt("ContaPoupanca_idConta"), rs.getInt("Cliente_idCliente"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ContaPoupancaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
}
