/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.TrabalhadorDAO;
import Model.Entidades.Cliente;
import Model.Entidades.Trabalhador;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Itsa Pepete
 */
public class Relatorios {

    public static boolean relatorioClientes() {

        try {
            PdfPTable table = new PdfPTable(12);

            Document doc = new Document();
            OutputStream os = new FileOutputStream(
                    "C:\\Users\\Itsa Pepete\\Documents\\NetBeansProjects\\ultima versao\\Banco-Projecto(versao 4)\\Banco-Projecto\\clientes.pdf");
            PdfWriter.getInstance(doc, os);
            doc.addTitle("Clientes");
            
            ClienteDAO aux = new ClienteDAO();
            ArrayList<Cliente> list = aux.todos();

            //Titulo
            table.addCell("ID");
                table.addCell("Nome");
                table.addCell("Apelido");
                table.addCell("Nacionalidade");
                table.addCell("Bairro");
                table.addCell("Cidade");
                table.addCell("Estado Civil");
                table.addCell("Email");
                table.addCell("Rua");
                table.addCell("Data Nascimento");
                table.addCell("Telefone 1");
                table.addCell("Telefone 2");
            
            for (int i = 0; i < list.size(); i++) {
                table.addCell(String.valueOf(list.get(i).getId()));
                table.addCell(list.get(i).getNome());
                table.addCell(list.get(i).getApelido());
                table.addCell(list.get(i).getNacionalidade());
                table.addCell(list.get(i).getBairro());
                table.addCell(list.get(i).getCidade());
                table.addCell(list.get(i).getEstadoCivil());
                table.addCell(list.get(i).getEmail());
                table.addCell(list.get(i).getRua());
                table.addCell(String.valueOf(list.get(i).getDataNascimento()));
                table.addCell(String.valueOf(list.get(i).getTelefone1()));
                table.addCell(String.valueOf(list.get(i).getTelefone2()));
            }
            doc.open();

            doc.add(table);

            doc.close();
            return true;
        } catch (IOException ex) {
            System.out.println("erro");
        } catch (DocumentException es) {
            System.out.println("erro");
        }
        return false;
    }

    
      public static boolean relatorioFuncionarios() {

        try {
            PdfPTable table = new PdfPTable(12);

            Document doc = new Document();
            OutputStream os = new FileOutputStream(
                    "C:\\Users\\Itsa Pepete\\Documents\\NetBeansProjects\\ultima versao\\Banco-Projecto(versao 4)\\Banco-Projecto\\funcionarios.pdf");
            PdfWriter.getInstance(doc, os);

            TrabalhadorDAO aux = new TrabalhadorDAO();
            ArrayList<Trabalhador> list = aux.todos();

            //Titulo
            table.addCell("ID");
                table.addCell("Nome");
                table.addCell("Apelido");
                table.addCell("Nacionalidade");
                table.addCell("Bairro");
                table.addCell("Cidade");
                table.addCell("Estado Civil");
                table.addCell("Email");
                table.addCell("Rua");
                table.addCell("Data Nascimento");
                table.addCell("Telefone 1");
                table.addCell("Telefone 2");
            
            for (int i = 0; i < list.size(); i++) {
                table.addCell(String.valueOf(list.get(i).getId()));
                table.addCell(list.get(i).getNome());
                table.addCell(list.get(i).getApelido());
                table.addCell(list.get(i).getNacionalidade());
                table.addCell(list.get(i).getBairro());
                table.addCell(list.get(i).getCidade());
                table.addCell(list.get(i).getEstadoCivil());
                table.addCell(list.get(i).getEmail());
                table.addCell(list.get(i).getRua());
                table.addCell(String.valueOf(list.get(i).getDataNascimento()));
                table.addCell(String.valueOf(list.get(i).getTelefone1()));
                table.addCell(String.valueOf(list.get(i).getTelefone2()));
            }
            doc.open();

            doc.add(table);

            doc.close();
            return true;
        } catch (IOException ex) {
            System.out.println("erro");
        } catch (DocumentException es) {
            System.out.println("erro");
        }
        return false;
    }

}
