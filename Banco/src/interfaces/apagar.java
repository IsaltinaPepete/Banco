/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Itsa Pepete
 */
public class apagar implements ActionListener{

    private JFrame janela;
    private JPanel painel, painelB, painelDef ;
    private JFormattedTextField tId;
    private JLabel icon;
    
    public apagar(String msg) {
        inicializar();
        configuracoes();
        preencherPainel(msg);
    }

    private void inicializar() {
        janela = new JFrame();
        painel = new JPanel();
        tId = criarTextF("####");
        icon = new JLabel("");
        icon.setIcon(new ImageIcon("mili2.png"));
        painelB= new JPanel();
        painelDef= new JPanel();
    }
    
    private void configuracoes(){
        tId.setBorder(BorderFactory.createLoweredBevelBorder());
       
        painel.setLayout(new GridBagLayout());
        painelDef.setLayout(new BorderLayout());
    }
    private void preencherPainel(String msg){
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0; gbc.gridwidth=3;
        gbc.gridy=0;
        painel.add(icon, gbc);
        gbc.gridy=1; painel.add(new JLabel(msg), gbc);
        
        gbc.gridwidth=1;
        gbc.gridy=2;painel.add(new JLabel(" "), gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx=0.1;
        
        gbc.gridy=3;
        painel.add(new JLabel("ID:  "), gbc);
        gbc.weightx=0.9; gbc.gridy=3;
        gbc.gridx=1; gbc.gridwidth=2;  painel.add(tId, gbc); 
       
        painelB.add(criarBotao("Back<<"));
        painelB.add(criarBotao("OK"));
       
        painelDef.add(painel, BorderLayout.CENTER);
        painelDef.add(painelB, BorderLayout.SOUTH);
        janela.getContentPane().add(painelDef);
        janela.setSize(400, 300);
        janela.setResizable(true);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
   
 
    private JButton criarBotao(String msg){
        JButton aux = new JButton(msg);
        aux.addActionListener( this);
//        if(msg.equals("Back<<")){
//            aux.setEnabled(false);
//        }
        return aux;
    }
   
    private JFormattedTextField criarTextF(String msg) {
        JFormattedTextField aux = new JFormattedTextField();
        try {
            aux = new JFormattedTextField(new MaskFormatter(msg));

        } catch (ParseException cp) {
            System.out.println("Erro de Formatacao");
        }
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equals("Back<<")){
            new MenuAdmin();
        }
        if(evento.getActionCommand().equals("OK")){
            
        }
    }

}
