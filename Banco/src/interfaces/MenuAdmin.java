/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Banco ItsaJenny
 */
public class MenuAdmin implements ActionListener {
    
    private JFrame janela;
    private JPanel painel, painellogo, painelTotal;
    private JButton bVoltar, bCancelar;

    
    
    public MenuAdmin(){
        inicializarComponentes();
        configuracoes();
        configurarPaineis();
        
    }
    
    public void inicializarComponentes(){
        janela = new JFrame();
        painel = new JPanel();
        painellogo = new JPanel();
        painelTotal = new JPanel();
        bVoltar = new JButton("<< Back");
        bCancelar = new JButton("    Cancel    ");
        bVoltar.addActionListener(this);
        bCancelar.addActionListener(this);
       
    }
    
    JButton criarBotao(String msg){
        JButton aux = new JButton(msg);
        aux.addActionListener(this);
        return aux;
    }
    public void configuracoes(){
        painel.setLayout(new GridBagLayout());
        painelTotal.setLayout(new BorderLayout());
        painel.setBackground(Color.pink);
    }
    
    public void configurarPaineis(){
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx=0;
        gbc.weightx=1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy=0; painel.add(new JLabel("MENU ADMINISTRADOR"), gbc);
      
        gbc.gridy=1; painel.add(new JLabel("   "), gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridy=2; gbc.gridx=0;
        gbc.gridwidth=2;
        painel.add(criarBotao("Cadastrar Cliente"), gbc);
        gbc.gridy=3; painel.add(criarBotao("Cadastrar Funcionaro"), gbc);
        gbc.gridy=4; painel.add(criarBotao("Criar Conta"), gbc);
        gbc.gridy=5; painel.add(criarBotao("Historicos"), gbc);
        //gbc.gridy=6; painel.add(criarBotao("Demitir Funcionario"), gbc);
        gbc.gridy=7; painel.add(criarBotao("Inserir Departamento"), gbc);
        gbc.gridy = 8; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 9; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 10; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 11; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 12; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 13; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 14; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 15; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 16; painel.add(new JLabel("    "), gbc);
        gbc.gridy = 17; painel.add(new JLabel("    "), gbc);
        gbc.gridwidth=1;gbc.gridy = 18; painel.add(bVoltar, gbc);
        gbc.gridx = 1; painel.add(bCancelar, gbc);
        
        JLabel icon = new JLabel("");

        icon.setIcon(new ImageIcon("mili.png"));
        
        painellogo.add(icon);
        painellogo.setBackground(Color.white);
        painelTotal.add(painel, BorderLayout.WEST);
        painelTotal.setBackground(Color.white);
        painelTotal.add(painellogo, BorderLayout.EAST);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setBackground(Color.pink);
        janela.getContentPane().add(painelTotal);
        janela.setLocationByPlatform(true);
        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
        janela.setSize(new Dimension(890,550));
        janela.setVisible(true);
    }
    
   
   public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equals("Cadastrar Cliente")){
            janela.setVisible(false);
            Cadastro_Cliente aux = Cadastro_Cliente.getUnicaInstancia();
            aux.janela.setVisible(true);
        }
        if(evento.getActionCommand().equals("Cadastrar Funcionaro")){
            CadastroFuncionario aux = CadastroFuncionario.getUnicaInstancia();
            janela.setVisible(false);
            aux.janela.setVisible(true);
        }
        if(evento.getActionCommand().equals("Criar Conta")){
            CriaConta1 aux = CriaConta1.getUnicaInstancia();
            janela.setVisible(false);
            aux.janela.setVisible(true);
        }
        if(evento.getActionCommand().equals("Historicos")){
            janela.setVisible(false);
            new Historicos();
        }
        if (evento.getSource().equals(bVoltar)) {
            new Projecto_Interface();
            janela.setVisible(false);
        }
        if (evento.getSource().equals(bCancelar)) {
             new Projecto_Interface();
            janela.setVisible(false);
        }
        
        if(evento.getActionCommand().equals("Inserir Departamento")){
            janela.setVisible(false);
            new CadastroDepartamento().janela.setVisible(true);
        }
       
    }
}
