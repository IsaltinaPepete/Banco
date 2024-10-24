/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Controller.Cadastro;
import Model.Entidades.Departamento;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Itsa Pepete
 */
public class CadastroDepartamento implements ActionListener{

    JFrame janela;
    JPanel painel, painelDef, painelBotoes;
    JLabel icon;
    JFormattedTextField tIdChefe, tNome;

    public CadastroDepartamento() {
        inicializar();
        configuracoes();
        preencher();
    }

    void inicializar() {
        painel = new JPanel();
        painelBotoes = new JPanel();
        painelDef = new JPanel();
        janela = new JFrame();
        icon = new JLabel("");
        icon.setIcon(new ImageIcon("mili2.png"));
       
        tIdChefe = criarTextF("####");
        tNome = new JFormattedTextField(new String(""));
    }

    JFormattedTextField criarTextF(String msg) {
        JFormattedTextField aux = new JFormattedTextField();
        try {
            aux = new JFormattedTextField(new MaskFormatter(msg));
        } catch (ParseException cp) {
            System.out.println("Erro de Formatacao");
        }
        return aux;
    }

    private void configuracoes() {
       
         painel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Departamento"));
        painel.setLayout(new GridBagLayout());
        painelDef.setLayout(new BorderLayout());
        tNome.setBorder(BorderFactory.createLoweredBevelBorder());
        tIdChefe.setBorder(BorderFactory.createLoweredBevelBorder());
        painelBotoes.setBackground(Color.white);
        painelDef.setBackground(Color.pink);
        painel.setBackground(Color.white);
    }

   

    private void preencher() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridx = 0;
        gbc.weightx = 0.1;
        gbc.gridy = 0;
        painel.add(new JLabel("Nome Departamento:"), gbc);
        gbc.gridy = 1;
        painel.add(new JLabel("ID Chefe Departamento:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.9;
        gbc.gridy = 0;
        painel.add(tNome, gbc);
        gbc.gridy = 1;
        painel.add(tIdChefe, gbc);

        painelBotoes.add(criarBotao("Back<<"));
        painelBotoes.add(criarBotao("Clear"));
        painelBotoes.add(criarBotao("Cancel"));
        painelBotoes.add(criarBotao("Save"));

        painelDef.add(icon, BorderLayout.NORTH);
        painelDef.add(painel, BorderLayout.CENTER);
        painelDef.add(painelBotoes, BorderLayout.SOUTH);
        janela.getContentPane().add(painelDef);
        janela.setSize(600, 300);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }

    JButton criarBotao(String msg) {
        JButton aux = new JButton(msg);
        aux.addActionListener(this);

        return aux;
    }
    void cadastrar() {

        Cadastro cadastro = new Cadastro();
       if( cadastro.criarDepartamento(new Departamento(tNome.getText(), Integer.parseInt(tIdChefe.getText())))){
           JOptionPane.showMessageDialog(janela, "SucessFully");
       } else{
           JOptionPane.showMessageDialog(janela, "Unsucessfully");
       }
    

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Back<<")) {
            
            janela.setVisible(false);
            new MenuAdmin();
            
        }
        if (evento.getActionCommand().equals("Clear")) {
            tNome.setText("");
            tIdChefe.setText("");
        }
        if (evento.getActionCommand().equals("Cancel")) {
            janela.setVisible(false);
            new Projecto_Interface().janela.setVisible(true);
        }
        if (evento.getActionCommand().equals("Save")) {
            cadastrar();
            janela.setVisible(false);
            new MenuAdmin();
        }
    }

}
