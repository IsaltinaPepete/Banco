/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entidades.Senha;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Thole
 */
public class FicheiroTexto {

    private ArrayList lista;
    private int cont;

    public FicheiroTexto() {
        lista = new ArrayList<>();
    }

    public ArrayList<Senha> lerFicheiroTxt(String nomeFich) throws IOException {
        StringTokenizer umaCadeia;
        String umaLinha = "", tipo;
        int id, senha;
        try {
            FileReader fr = new FileReader(nomeFich);
            BufferedReader fichIn = new BufferedReader(fr);
            umaLinha = fichIn.readLine();
            while (umaLinha != null) {

                umaCadeia = new StringTokenizer(umaLinha, ";");
                id = Integer.parseInt(umaCadeia.nextToken());
                senha = Integer.parseInt(umaCadeia.nextToken());
                if(nomeFich.equalsIgnoreCase("senhasClientes.txt")){
                    tipo = umaCadeia.nextToken();
                    lista.add(new Senha(id, senha,tipo));
                }else
                    lista.add(new Senha(id, senha,""));
                       
                umaLinha = fichIn.readLine();
            }
            fichIn.close();
        } catch (FileNotFoundException nn) {
            JOptionPane.showMessageDialog(null, "Ficheiro nao encontrado!");
        } catch (NumberFormatException nn) {
            System.out.println(nn.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

}
