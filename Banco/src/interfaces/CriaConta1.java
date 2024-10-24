/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author  Banco ItsaJenny
 */
import interfaces.CriarConta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriaConta1 implements ActionListener {
    
    JFrame janela;
    JPanel painel, pIcon;
    ButtonGroup botao;
    JLabel icon;
    JRadioButton corrente, poupanca;
    
    public static CriaConta1 unicaInstancia;
    public static CriaConta1 getUnicaInstancia() {
        if (unicaInstancia == null) 
            unicaInstancia = new CriaConta1(); // Caso nao exista nenhuma instancia
        return unicaInstancia; //caso ja exista
    }
    public CriaConta1(){
        inicializar();
        configuracoes();
        configurar();
    }
    
    void inicializar(){
        janela = new JFrame();
        painel = new JPanel();
        pIcon = new JPanel();
        botao = new ButtonGroup();
        icon = new JLabel("");
        icon.setIcon(new ImageIcon("mili2.png"));
        corrente = criarRadio("Conta Corrente");
        poupanca = criarRadio("Conta Poupanca");

    }
    
    void configuracoes(){
        painel.setLayout(new BorderLayout());
        pIcon.setLayout(new BorderLayout());
        pIcon.setBackground(Color.pink);
        painel.setBackground(Color.WHITE);
    }
    
    void configurar(){
        pIcon.add(icon, BorderLayout.NORTH);
        pIcon.add(new JLabel("                                               Tipo de Conta"), BorderLayout.CENTER);
        painel.add(pIcon, BorderLayout.NORTH);
        painel.add(corrente, BorderLayout.WEST);
        painel.add(poupanca, BorderLayout.EAST);
        
        janela.getContentPane().add(painel);
        janela.setSize(500, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    JRadioButton criarRadio(String msg){
        JRadioButton aux = new JRadioButton(msg);
        botao.add(aux);
        aux.setBackground(Color.WHITE);
        aux.addActionListener(this);
        return aux;
    }
    
  

    @Override
    public void actionPerformed(ActionEvent evento) {
        CriarConta aux = CriarConta.getUnicaInstancia();
        janela.setVisible(false);
    }
    
   
}
