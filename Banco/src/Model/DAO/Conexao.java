/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Itsa Pepete
 */
public class Conexao {
     private  String Host;
    private  String BD;
    private  String user;
    private  String password;
    private  String porta;

    public Conexao() {
        this.Host = "localhost"; // 127.0.0.1 = localhost
        
        this.BD = "Banco";
        this.user = "itsa";
        this.password = "0000";
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
//        BDconexao bDconexao = new BDconexao();
//       // return DriverManager.getConnection("jdbc:mysql://" + bDconexao.Host + ":" + bDconexao.porta + "/" + bDconexao.BD + "?user="+bDconexao.user+"&password="+bDconexao.password+"&noAccessToProcedureBodies=true");
       
       return DriverManager.getConnection("jdbc:mysql://localhost/banco", "root", "");
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

//    public String getPorta() {
//        return porta;
//    }
//
//    public void setPorta(String porta) {
//        this.porta = porta;
//    }
    
}
