package interfaces;

//import static interfaces.Operacoes.getUnicaInstancia1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Cadastro;
import Model.Entidades.Movimentos;

/**
 *
 * @author Banco ItsaJenny
 */
public class Transferencia extends JPanel implements ActionListener {

    private JButton confirmar;
    private JButton cancelar;
    private JLabel lConta;
    private JTextField tConta;
    private JLabel lValor;
    private JTextField tValor;
    private JLabel label;
    private JButton bVoltar, bCancelar, bConfirmar;
    

    public Transferencia() {
        lConta = new JLabel("Digite o numero da conta");
        tConta = new JTextField(10);
        lValor = new JLabel("Digite o valor a transferir");
        tValor = new JTextField(10);
        label = new JLabel("Transferencia");
        bVoltar = new JButton("<< Back");
        bCancelar = new JButton("Cancel");
        bConfirmar = new JButton("Commit");
        
        bConfirmar.addActionListener(this);
        bVoltar.addActionListener(this);

        label.setFont(new Font("Times new Roman", Font.BOLD, 20));

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        add(label, c);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel(""), c);
        c.gridy = 2;
        add(lConta, c);
        c.gridy = 3;
        add(tConta, c);
        c.gridy = 4;
        add(lValor, c);
        c.gridy = 5;
        add(tValor, c);
        c.gridy = 6;
        add(new JLabel(" "), c);
        c.gridy = 7;
        add(new JLabel(" "), c);
        c.gridwidth = 1;
        c.gridy = 8;
        add(bVoltar, c);
        c.gridx = 1;
        add(bCancelar, c);
        c.gridx = 2;
        add(bConfirmar, c);
        
        setBackground(Color.WHITE);

        tConta.setBorder(BorderFactory.createLoweredBevelBorder());
        tValor.setBorder(BorderFactory.createLoweredBevelBorder());

    }

    public JButton getbVoltar() {
        return bVoltar;
    }

    public JButton getbCancelar() {
        return bCancelar;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bVoltar)) {
            this.setVisible(false);
            //Operacoes op = getUnicaInstancia1();
            Operacoes.getJanela().setSize(new Dimension(790, 600));
            Operacoes.getJanela().setVisible(true);
            this.setVisible(false);
            //op.setSize(790, 600);
        }
        
        if(e.getSource().equals(bConfirmar)){
            sendMoney();
            JOptionPane.showMessageDialog(null, "Operacao efectuada com sucesso :)!");
        }

    }

    public void sendMoney() {
        Cadastro cadastro = new Cadastro();
        cadastro.transferirValor(new Movimentos("transferencia", 0.01f, Integer.parseInt(Tela_Login.tEmail.getText()), 0),
                Integer.parseInt(Tela_Login.tEmail.getText()), Integer.parseInt(tConta.getText()), Float.parseFloat(tValor.getText()));

    }

    public String getValor() {
        return tValor.getText();
    }
    
    public static Transferencia transferencia(){
        return new Transferencia();
    }

}
