package Model.DAO;

import Model.DAO.Conexao;
import Model.Entidades.Cliente_has_ContaCorrente;
import Model.Entidades.ContaCorrente;
import Model.Entidades.Movimentos;
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
public class MovimentosDAO {

    private Connection conexao;

    public MovimentosDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MovimentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Movimentos m) {
        String sql = "INSERT INTO movimentos(data, taxa,ContaPoupanca_idConta, ContaCorrente_idConta, tipo) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(m.getDataMovimento()));
            ps.setFloat(2, m.getTaxa());
            ps.setInt(3, m.getIdContaPoupanca());
            ps.setInt(4, m.getIdContaCorrente());
            ps.setString(5, m.getTipo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(int idMovimentos) {
        String sql = "DELETE FROM Movimentos WHERE idMovimento = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idMovimentos);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Movimentos> todos() {
        try {
            String sql = "SELECT * from Movimentos";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Movimentos> lista = new ArrayList<>();
            while (rs.next()) {
                Movimentos mov = new Movimentos();
                mov.setIdMovimentos(rs.getInt("idMovimento"));
                mov.setTipo(rs.getString("tipo"));
                mov.setTaxa(rs.getFloat("taxa"));
                mov.setDataMovimento(rs.getDate("data").toLocalDate());
                mov.setIdContaPoupanca(rs.getInt("ContaPoupanca_idConta"));
                mov.setIdContaCorrente(rs.getInt("ContaCorrente_idConta"));

                lista.add(mov);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MovimentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

}
