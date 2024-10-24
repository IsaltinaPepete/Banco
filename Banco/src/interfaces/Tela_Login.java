package interfaces;

import Controller.Cadastro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;

public class Tela_Login implements ActionListener, MouseListener {

    JFrame janela;
    JPanel painel;
    JLabel login;
    JLabel texto;
    JLabel lId;
    JLabel lPassword, lTypeAccount;
    JCheckBox check;
    static JTextField tEmail;
    JPasswordField tPassword;
    JButton bLogin;
    String tipo;
    private static JComboBox combo;

    public Tela_Login(String tipo) {
        this.tipo = tipo;
        janela = new JFrame();
        painel = new JPanel();
        login = new JLabel("Login");
        texto = new JLabel("Entre com os seus dados correctamente para acessar"
                + " o sistema");
        lId = new JLabel(" ");
        lPassword = new JLabel("Password: ");
        check = new JCheckBox("Remember Me");
        tEmail = new JTextField(10);
        tPassword = new JPasswordField(10);
        bLogin = new JButton("Login");
        bLogin.setBounds(new Rectangle());
        login.setFont(new Font("Times new Roman", Font.BOLD, 20));
        lTypeAccount = new JLabel("Tipo de conta:");
        combo = new JComboBox(new String[]{"Poupanca", "Corrente"});

        tEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        tPassword.setBorder(BorderFactory.createLoweredBevelBorder());

        bLogin.addActionListener(this);
        bLogin.addMouseListener(this);
        bLogin.setBackground(Color.WHITE);

        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridwidth = 2;
        painel.add(login, c);
        c.gridy = 1;
        c.gridwidth = 3;
        painel.add(texto, c);
        c.gridwidth = 1;
        c.gridy = 2;
        if (tipo.equals("cliente")) {
            lId = new JLabel("Conta: ");
            painel.add(lId, c);
            c.gridy = 4;
            painel.add(lTypeAccount, c);
            c.gridx = 1;
            painel.add(combo, c);
        }
        if (tipo.equals("funcionario")) {
            lId = new JLabel("Funcionario: ");
            painel.add(lId, c);
        }
        c.gridwidth = 2;
        c.gridy = 2;
        c.gridx = 1;
        painel.add(tEmail, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        painel.add(lPassword, c);
        c.gridx = 1;
        c.gridwidth = 2;
        painel.add(tPassword, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        painel.add(new JLabel(" "), c);
        c.gridx = 1;
        c.gridy = 6;
        painel.add(bLogin, c);

        painel.setBackground(Color.WHITE);

        janela.add(painel);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationByPlatform(true);
        janela.setSize(500, 300);
        janela.setVisible(true);

    }

    public static JComboBox getCombo() {
        return combo;
    }

    public static Tela_Login unicaInstancia;

    public static Tela_Login getUnicaInstancia(String tipo) {
        if (unicaInstancia == null) {
            unicaInstancia = new Tela_Login(tipo);
        }
        return unicaInstancia;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        bLogin.setBackground(Color.pink);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        bLogin.setBackground(Color.white);
    }

    public boolean validarSenhaCliente() throws IOException {
        Cadastro c = new Cadastro();
        String senha = tPassword.getText();
        try {
            if (c.validarSenhaCliente(Integer.parseInt(tEmail.getText()), Integer.parseInt(senha), combo.getSelectedItem().toString())) {
                return true;
            }

            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janela, "Ocorreu algum erro! :( " + e);
        }
        return false;
    }

    public boolean validarSenhaFuncionario() throws IOException {
        Cadastro c = new Cadastro();
        String senha = tPassword.getText();
        try {
            if (c.validarSenhaFuncionario(Integer.parseInt(tEmail.getText()), Integer.parseInt(senha))) {
                return true;
            }

            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janela, "Ocorreu algum erro! :( " + e);
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bLogin) && tipo.equals("cliente")) {
            try {
                if (validarSenhaCliente()) {
                    new Operacoes();
                    janela.setVisible(false);
                } else {
                    limpaTela();
                    JOptionPane.showMessageDialog(janela, "Introduziu dados nao validos!", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(Tela_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource().equals(bLogin) && tipo.equals("funcionario")) {
            try {
                if (validarSenhaFuncionario()) {
                    new MenuAdmin();
                    janela.setVisible(false);
                } else {
                    limpaTela();
                    JOptionPane.showMessageDialog(janela, "Introduziu dados nao validos!", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(Tela_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void limpaTela() {
        tEmail.setText("");
        tPassword.setText("");
        combo.setSelectedIndex(0);
    }

}
