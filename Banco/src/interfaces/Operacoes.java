package interfaces;

import Controller.Cadastro;
import Model.Entidades.Movimentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Banco ItsaJenny
 */
public class Operacoes implements ActionListener, WindowListener {

    private JButton bTransferir, bLevantar, bDepositar, bVer_saldo,
            bVoltar, bCancelar, Voltar, lCancelar, lConfirmar, dVoltar, dCancelar, dConfirmar,
            tVoltar, tCancelar, tConfirmar;

    private JPanel painel_esquerdo, painel_principal, painel_deposito, card,
            painel_botoes, p_levantamento, p_transferencia;

    private String str_levantar, str_depositar, str_voltar;
    private JLabel icone, lConta, moeda, lValor, label;
    private JTextField tConta, tValor;

    private JMenuBar barra_menu;
    private JMenu ajuda;
    private static JFrame janela;

    public Operacoes() {

        initialize();
        addEvents();
        addComponents();
        createAndShowGUI();

    }

    public JPanel deposito() {
        lValor = new JLabel("Digite o valor a depositar");
        tValor = new JTextField(10);
        label = new JLabel("Deposito");
        dVoltar = new JButton(str_voltar);
        dCancelar = new JButton("Cancel");
        dConfirmar = new JButton("Commit");

        dVoltar.addActionListener(this);

        label.setFont(new Font("Times new Roman", Font.BOLD, 20));

        JPanel painel_depositar = new JPanel();

        painel_depositar.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        painel_depositar.add(label, c);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        painel_depositar.add(new JLabel(""), c);
        c.gridy = 2;
        painel_depositar.add(lValor, c);
        c.gridy = 3;
        painel_depositar.add(tValor, c);
        c.gridy = 4;
        painel_depositar.add(new JLabel(" "), c);
        c.gridy = 5;
        painel_depositar.add(new JLabel(" "), c);
        c.gridwidth = 1;
        c.gridy = 6;
        painel_depositar.add(dVoltar, c);
        c.gridx = 1;
        painel_depositar.add(dCancelar, c);
        c.gridx = 2;
        painel_depositar.add(dConfirmar, c);
        
        painel_depositar.setBackground(Color.WHITE);

        tValor.setBorder(BorderFactory.createLoweredBevelBorder());

        return painel_depositar;

    }

    public void initialize() {
        janela = new JFrame("Operacoes");
        str_depositar = "Depositar";
        str_voltar = "<< Back";
        bTransferir = new JButton("Transferir");
        bLevantar = new JButton("Levantar");
        bDepositar = new JButton(str_depositar);
        bVer_saldo = new JButton("Saldo");
        bVoltar = new JButton("<< Back");
        bCancelar = new JButton("Cancel");
        barra_menu = new JMenuBar();
        ajuda = new JMenu("Ajuda");
        tVoltar = new Transferencia().getbVoltar();

        painel_esquerdo = new JPanel();
        painel_principal = new JPanel();

        moeda = new JLabel();
        moeda.setIcon(new ImageIcon("moeda_2.0.png"));

        painel_botoes = new JPanel();

        icone = new JLabel();
        icone.setIcon(new ImageIcon("mili.png"));
        painel_deposito = deposito();

        card = new JPanel(new CardLayout());

    }

    public void addComponents() {
        painel_botoes.add(bVoltar);
        painel_botoes.add(bCancelar);

        painel_esquerdo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        painel_esquerdo.add(moeda, c);
        c.gridy = 1;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 2;
        painel_esquerdo.add(bTransferir, c);
        c.gridy = 3;
        painel_esquerdo.add(bLevantar, c);
        c.gridy = 4;
        painel_esquerdo.add(bDepositar, c);
        c.gridy = 5;
        painel_esquerdo.add(bVer_saldo, c);
        c.gridy = 6;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 7;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 8;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 9;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 10;
        painel_esquerdo.add(new JLabel("        "), c);

        c.gridy = 11;
        painel_esquerdo.add(new JLabel("          "), c);

        c.gridy = 12;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 13;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 14;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 15;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridy = 16;
        painel_esquerdo.add(new JLabel("        "), c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 17;
        painel_esquerdo.add(bVoltar, c);
        c.gridx = 1;
        painel_esquerdo.add(bCancelar, c);

        painel_esquerdo.setBackground(Color.PINK);
        painel_principal.setLayout(new BorderLayout());

        painel_principal.add(painel_esquerdo, BorderLayout.WEST);
        painel_principal.add(icone, BorderLayout.EAST);

        painel_botoes.setBackground(Color.WHITE);
        painel_principal.setBackground(Color.WHITE);

        card.add(painel_principal, bVoltar.getText());
        card.add(painel_deposito, str_depositar);
        card.add(Transferencia.transferencia(), bTransferir.getText());
        card.add(new Levantamento().Levantamento(), bLevantar.getText());

    }

    public void addEvents() {
        bTransferir.addActionListener(this);
        bLevantar.addActionListener(this);
        bDepositar.addActionListener(this);
        dVoltar.addActionListener(this);
        bVoltar.addActionListener(this);
        bCancelar.addActionListener(this);
        dConfirmar.addActionListener(this);
        bVer_saldo.addActionListener(this);
        janela.addWindowListener(this);

    }

    public void depositar() {
        Cadastro cadastro = new Cadastro();
        try {
            if (Tela_Login.getCombo().getSelectedItem().toString().equalsIgnoreCase("Corrente")) {
                cadastro.depositarCorrente(new Movimentos( "deposito", 0.03f, Integer.parseInt(Tela_Login.tEmail.getText()), 0),
                        Integer.parseInt(Tela_Login.tEmail.getText()), Float.parseFloat(tValor.getText()));
            } else {
                cadastro.depositarPoupanca(new Movimentos( "deposito", 0.03f, 0, Integer.parseInt(Tela_Login.tEmail.getText())),
                        Integer.parseInt(Tela_Login.tEmail.getText()), Float.parseFloat(tValor.getText()));
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janela, "Introduziu dados invalidos, clique em Ok para continuar!", "Alerta!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception n) {
            JOptionPane.showMessageDialog(janela, "Ocorreu algum erro!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bDepositar)) {
            CardLayout c1 = (CardLayout) (card.getLayout());
            janela.setSize(new Dimension(600, 300));
            c1.show(card, e.getActionCommand());

        } else {
            if (e.getSource().equals(dVoltar)) {
                CardLayout c1 = (CardLayout) (card.getLayout());
                janela.setSize(new Dimension(790, 600));
                c1.show(card, e.getActionCommand());

            }
        }
        if (e.getSource().equals(bTransferir)) {
            CardLayout c1 = (CardLayout) (card.getLayout());
            janela.setSize(new Dimension(600, 300));
            c1.show(card, e.getActionCommand());
        }
        if (e.getSource().equals(bLevantar)) {
            CardLayout c1 = (CardLayout) (card.getLayout());
            janela.setSize(new Dimension(600, 400));
            c1.show(card, e.getActionCommand());
        }
        if (e.getSource().equals(bVoltar)) {
            new Projecto_Interface();
            janela.setVisible(false);
        }
        if (e.getSource().equals(bCancelar)) {
            System.exit(0);
        }
        if (e.getSource().equals(dConfirmar)) {
            depositar();
            JOptionPane.showMessageDialog(janela, "Operacao terminada com sucesso!");
        }
        if (e.getSource().equals(bVer_saldo)) {
            Cadastro c = new Cadastro();
            float saldo = 0;
            try {
                if (Tela_Login.getCombo().getSelectedItem().toString().equalsIgnoreCase("corrente")) {
                    saldo = c.verificarSaldoCorrente(new Movimentos( "Consulta", 0.01f, Integer.parseInt(Tela_Login.tEmail.getText()), 0), Integer.parseInt(Tela_Login.tEmail.getText()));
                } else {

                    saldo = c.verificarSaldoPoupanca(new Movimentos( "Consulta", 0.01f, 0, Integer.parseInt(Tela_Login.tEmail.getText())), Integer.parseInt(Tela_Login.tEmail.getText()));
                }
                JOptionPane.showMessageDialog(janela, "O seu saldo e " + saldo + " MZN");
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(janela, "Introduziu dados invalidos, clique em Ok para continuar!", "Alerta!", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public static JFrame getJanela() {
        return janela;
    }

    public JPanel getCard() {
        return card;
    }

    public void setCard(JPanel card) {
        this.card = card;
    }

//    public static void main(String[] args) {
//        getUnicaInstancia1();
//    }
    public void createAndShowGUI() {

        janela.add(card);
        janela.setJMenuBar(barra_menu);
        janela.setSize(new Dimension(790, 600));
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (Tela_Login.getCombo().getSelectedItem().toString().equalsIgnoreCase("poupanca")) {
            bTransferir.setEnabled(false);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
