package interfaces;

import Controller.Cadastro;
//import static interfaces.Login_cliente.getUnicaInstancia;
//import static interfaces.Operacoes.getUnicaInstancia1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Thole
 */
public class Levantamento implements ActionListener {

    JButton confirmar;
    JButton cancelar;
    JLabel lConta, icon;
    JTextField tConta;
    JLabel lValor;
    JTextField tValor;
    JLabel label;
    JButton bVoltar, bCancelar, bConfirmar;
    JPanel painel_levantar;

    public JPanel Levantamento() {
        lValor = new JLabel("Digite o valor a levantar");
        tValor = new JTextField(10);
        tValor.setEditable(false);
        label = new JLabel("  Levantamento");
        bVoltar = new JButton("<< Back");
        bVoltar.addActionListener(this);
        bCancelar = new JButton("Cancel");
        bCancelar.addActionListener(this);
        bConfirmar = new JButton("Commit");
        bConfirmar.addActionListener(this);
        icon = new JLabel();
        icon.setIcon(new ImageIcon("icone_p.png"));
        icon.setBorder(BorderFactory.createLineBorder(Color.PINK, 2, true));
        label.setFont(new Font("Times new Roman", Font.BOLD, 20));

        JPanel painel_botoes = new JPanel();
        painel_botoes.add(bVoltar);
        painel_botoes.add(bCancelar);
        painel_botoes.add(bConfirmar);

        painel_levantar = new JPanel();

        painel_levantar.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);

        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        painel_levantar.add(icon, c);
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;
        painel_levantar.add(label, c);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        painel_levantar.add(new JLabel(" "), c);
        c.gridy = 3;
        painel_levantar.add(lValor, c);
        c.gridy = 4;
        painel_levantar.add(tValor, c);
        c.gridwidth = 1;
        c.gridy = 5;
        painel_levantar.add(criarBotao("100"), c);
        c.gridx = 1;
        painel_levantar.add(criarBotao("200"), c);
        c.gridx = 2;
        painel_levantar.add(criarBotao("500"), c);
        c.gridx = 0;
        c.gridy = 6;
        painel_levantar.add(criarBotao("1000"), c);
        c.gridx = 1;
        painel_levantar.add(criarBotao("2000"), c);
        c.gridx = 2;
        painel_levantar.add(criarBotao("5000"), c);
        c.gridy = 7;
        painel_levantar.add(criarBotao("Outros"), c);
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 8;
        painel_levantar.add(new JLabel(""), c);
        c.gridy = 9;
        painel_levantar.add(new JLabel(""), c);
        c.gridy = 10;
        painel_levantar.add(bVoltar, c);
        c.gridx = 1;
        painel_levantar.add(bCancelar, c);
        c.gridx = 2;
        painel_levantar.add(bConfirmar, c);
        
        painel_levantar.setBackground(Color.WHITE);

        tValor.setBorder(BorderFactory.createLoweredBevelBorder());
        return painel_levantar;

    }

    JButton criarBotao(String msg) {
        JButton aux = new JButton(msg);
        aux.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        aux.addActionListener(this);
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("100")) {
            tValor.setText("100");
        }
        if (e.getActionCommand().equals("200")) {
            tValor.setText("200");
        }
        if (e.getActionCommand().equals("500")) {
            tValor.setText("500");
        }
        if (e.getActionCommand().equals("1000")) {
            tValor.setText("1000");
        }
        if (e.getActionCommand().equals("2000")) {
            tValor.setText("2000");
        }
        if (e.getActionCommand().equals("5000")) {
            tValor.setText("5000");
        }
        if (e.getActionCommand().equals("Outros")) {
            tValor.setText("");
            tValor.setEditable(true);
        } else{
            tValor.setEditable(false);
        }
        if (e.getSource().equals(bVoltar)) {
//            Operacoes aux = getUnicaInstancia1();
//           
//            painel_levantar.setVisible(false);
//            aux.setSize(790, 600);
            Operacoes.getJanela().setSize(new Dimension(790, 600));
            Operacoes.getJanela().setVisible(true);
            painel_levantar.setVisible(false);

        }
        if (e.getSource().equals(bCancelar)) {
            Operacoes.getJanela().setSize(new Dimension(790, 600));
            Operacoes.getJanela().setVisible(true);
            painel_levantar.setVisible(false);
           
        }
        if (e.getSource().equals(bConfirmar)) {
            Cadastro cadastro = new Cadastro();
            
        }
    }
   
}
