package interfaces;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Banco ItsaJenny
 */
public class Projecto_Interface implements ActionListener {

    JFrame janela;
    JMenuBar barra_menu;
    JMenu ajuda;
    JMenu opcoes;
    JPanel painel;
    JMenuItem funcionarios;
    JMenuItem clientes;
    JMenuItem sistema;
    private JLabel icone;
    public static Projecto_Interface unicaInstancia;
    
    public static Projecto_Interface getUnicaInstancia1(){
        if (unicaInstancia == null) 
            unicaInstancia = new Projecto_Interface(); // Caso nao exista nenhuma instancia
        return unicaInstancia; //caso ja exista
    }
    public Projecto_Interface() {
        janela = new JFrame();
        barra_menu = new JMenuBar();
        ajuda = new JMenu("Ajuda");
        sistema = new JMenuItem("Sobre o sistema");
        ajuda.add(sistema);
        opcoes = new JMenu("Opcoes");
        funcionarios = new JMenuItem("Funcionarios");
        funcionarios.addActionListener(this);
        clientes = new JMenuItem("Clientes");
        opcoes.add(funcionarios);
        opcoes.add(clientes);
        icone = new JLabel();
        
        icone.setIcon(new ImageIcon("icone_p.png"));

        clientes.addActionListener(this);
        painel = new JPanel();

        barra_menu.add(opcoes);
        barra_menu.add(ajuda);

        JLabel bv = new JLabel("Bem Vindo ao Millenium!");

        JButton sair = new JButton("Sair");
        bv.setFont(new Font("Times new Roman", Font.BOLD, 20));

        JLabel vazia = new JLabel();

        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.REMAINDER;
        painel.add(icone, c);
        c.gridy = 1;
        painel.add(bv, c);
        c.gridx = 1;
        c.gridy = 2;
        painel.add(vazia, c);
        c.gridy = 3;
        painel.add(vazia, c);

        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createLineBorder(Color.PINK, 3, true));

        janela.add(painel);

        janela.setJMenuBar(barra_menu);
        janela.setIconImage(new ImageIcon("icone_janela.png").getImage());
        janela.setBackground(Color.GRAY);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationByPlatform(true);
        janela.setSize(790, 600);
        janela.setVisible(true);

    }

    public static void main(String[] args) {
        Projecto_Interface aux = getUnicaInstancia1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(clientes)) {
            new Tela_Login("cliente").janela.setVisible(true);
            janela.setVisible(false);
        }
        if (e.getSource().equals(funcionarios)) {
            new Tela_Login("funcionario").janela.setVisible(true);
            janela.setVisible(false);
        }

    }

}
