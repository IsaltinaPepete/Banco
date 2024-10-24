package interfaces;

import Controller.Cadastro;
import Model.Entidades.Cliente;
import Model.Entidades.Trabalhador;
import static interfaces.CadastroFuncionario.getUnicaInstancia;
import static interfaces.Cadastro_Cliente.getUnicaInstancia;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Photoshop
 */
public class Cadastro_Cliente_part2 implements ActionListener, MouseListener {

    JFrame janela;
    private JPanel p_Endereco, p_Telefone, painel_botoes, p_principal, painel_icone;
    private JLabel lBairro, lCidade, lRua, lTel1, lTel2, lTel3, lEmail, lEstado_civil, lOcupacao, lRenda, icone;
    private JTextField tRua, tBairro, tCidade, tTel1, tTel2, tTel3, tEmail, tOcupacao, tRenda;

    private JComboBox cEstado_civil;

    private JButton back, clear, update, save;
     public static Cadastro_Cliente_part2 unicaInstancia;


    public Cadastro_Cliente_part2() {
        janela = new JFrame("Cadastro");
        p_Endereco = new JPanel();
        lRua = new JLabel("Rua:");
        tRua = new JTextField(10);
        lCidade = new JLabel("Cidade:");
        tCidade = new JTextField(10);
        lBairro = new JLabel("Bairro:");
        tBairro = new JTextField(10);
        icone = new JLabel();
        icone.setIcon(new ImageIcon("mili2.png"));

        painel_icone = new JPanel(new BorderLayout());
        painel_icone.add(icone, BorderLayout.WEST);
        painel_icone.setBackground(Color.PINK);

        p_Endereco.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4, 4, 4, 4);
        c.weightx = 1;
        c.gridy = 0;
        c.gridx = 0;
        p_Endereco.add(lRua, c);
        c.gridx = 1;
        p_Endereco.add(tRua, c);
        c.gridy = 1;
        c.gridx = 0;
        p_Endereco.add(lCidade, c);
        c.gridx = 1;
        p_Endereco.add(tCidade, c);
        c.gridy = 2;
        c.gridx = 0;
        p_Endereco.add(lBairro, c);
        c.gridx = 1;
        p_Endereco.add(tBairro, c);

        p_Telefone = new JPanel();
        lTel1 = new JLabel("Tel 1:");
        tTel1 = new JTextField("+258", 10);
        lTel2 = new JLabel("Tel 2:");
        tTel2 = new JTextField("+258", 10);
        lTel3 = new JLabel("Tel 3:");
        tTel3 = new JTextField("+258", 10);

        p_Telefone.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(4, 4, 4, 4);
        c2.weightx = 1;
        c2.gridy = 0;
        c2.gridx = 0;
        p_Telefone.add(lTel1, c2);
        c2.gridx = 1;
        p_Telefone.add(tTel1, c2);
        c2.gridy = 1;
        c2.gridx = 0;
        p_Telefone.add(lTel2, c2);
        c2.gridx = 1;
        p_Telefone.add(tTel2, c2);
        c2.gridy = 2;
        c2.gridx = 0;
        p_Telefone.add(lTel3, c2);
        c2.gridx = 1;
        p_Telefone.add(tTel3, c2);

        lEmail = new JLabel("Email:");
        tEmail = new JTextField(10);
        lEstado_civil = new JLabel("Estado_Civil:");
        String lista_Estado[] = {"", "Solteiro", "Casado"};
        cEstado_civil = new JComboBox(lista_Estado);
        lRenda = new JLabel("Renda Mensal:");
        tRenda = new JTextField("(MZN)", 10);
        lOcupacao = new JLabel("Ocupacao:");
        tOcupacao = new JTextField(10);

        back = new JButton("<< Back");
        clear = new JButton("Clear");
        save = new JButton("Save");
        update = new JButton("Update");
        
        update.setBackground(Color.white);
        back.setBackground(Color.white);
        clear.setBackground(Color.white);
        save.setBackground(Color.white);

        painel_botoes = new JPanel();
        painel_botoes.add(back);
        painel_botoes.add(clear);
        painel_botoes.add(save);
        painel_botoes.add(update);

        p_principal = new JPanel();
        p_principal.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.insets = new Insets(4, 4, 4, 4);
        c3.weightx = 1;
        c3.gridy = 0;
        c3.gridx = 0;
        c3.gridwidth = 2;
        c3.anchor = GridBagConstraints.EAST;
        p_principal.add(painel_icone, c3);
        c3.gridwidth = 1;
        c3.gridy = 1;
        p_principal.add(p_Endereco, c3);
        c3.gridx = 1;
        p_principal.add(p_Telefone, c3);
        c3.gridy = 2;
        c3.gridx = 0;
        p_principal.add(lEmail, c3);
        c3.gridx = 1;
        p_principal.add(tEmail, c3);
        c3.gridy = 3;
        c3.gridx = 0;
        p_principal.add(lEstado_civil, c3);
        c3.gridx = 1;
        p_principal.add(cEstado_civil, c3);
        c3.gridy = 4;
        c3.gridx = 0;
        p_principal.add(lRenda, c3);
        c3.gridx = 1;
        p_principal.add(tRenda, c3);
        c3.gridy = 5;
        c3.gridx = 0;
        p_principal.add(lOcupacao, c3);
        c3.gridx = 1;
        p_principal.add(tOcupacao, c3);
        c3.gridy = 6;
        c3.gridx = 0;
        c3.gridwidth = 2;
        p_principal.add(painel_botoes, c3);

        tBairro.setBorder(BorderFactory.createLoweredBevelBorder());
        tCidade.setBorder(BorderFactory.createLoweredBevelBorder());
        tRua.setBorder(BorderFactory.createLoweredBevelBorder());
        tTel1.setBorder(BorderFactory.createLoweredBevelBorder());
        tTel2.setBorder(BorderFactory.createLoweredBevelBorder());
        tTel3.setBorder(BorderFactory.createLoweredBevelBorder());
        tEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        tRenda.setBorder(BorderFactory.createLoweredBevelBorder());
        tOcupacao.setBorder(BorderFactory.createLoweredBevelBorder());

        p_Endereco.setBorder(BorderFactory.createTitledBorder(LineBorder.createGrayLineBorder(), "Endereco"));
        p_Telefone.setBorder(BorderFactory.createTitledBorder(LineBorder.createGrayLineBorder(), "Telefone"));
        p_Endereco.setBackground(Color.WHITE);
        p_Telefone.setBackground(Color.WHITE);
        p_principal.setBackground(Color.WHITE);
        painel_botoes.setBackground(Color.WHITE);
        
        preencherCampos();
        addEvents();

        janela.add(p_principal);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationByPlatform(true);
        janela.setSize(700, 480);
        janela.setVisible(true);

    }

   

    
    public static Cadastro_Cliente_part2 getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new Cadastro_Cliente_part2();
        }
        return unicaInstancia;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(clear)) {
            limparDados();
        }

        if (e.getSource().equals(back)) {
            Cadastro_Cliente aux =  Cadastro_Cliente.getUnicaInstancia();
            aux.janela.setVisible(true);
            janela.setVisible(false);
        }
        if (e.getSource().equals(save)) {
           
            cadastrar();
            new Projecto_Interface().janela.setVisible(true);
            janela.setVisible(false);
        }
        if (e.getSource().equals(update)) {
            janela.setVisible(false);
            actualizarCliente();
            new Historicos();
        }
    }

    private void limparDados() {
        tBairro.setText("");
        tCidade.setText("");
        tRua.setText("");
        tTel1.setText("+258");
        tTel2.setText("+258");
        tTel3.setText("+258");
        tEmail.setText("");
        tOcupacao.setText("");
        tRenda.setText("(MZN)");

    }

    private void addEvents() {
        update.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);
        save.addActionListener(this);
        
        update.addMouseListener(this);
        clear.addMouseListener(this);
        back.addMouseListener(this);
        save.addMouseListener(this);
    }

    void cadastrar() {

        Cadastro cadastro = new Cadastro();
        Cadastro_Cliente cl = Cadastro_Cliente.getUnicaInstancia();
             
        cadastro.cadastrarCliente(new Cliente(
                cl.tP_nome.getText(), cl.tU_nome.getText(), String.valueOf(cl.nacionalidade.getSelectedValue()), tBairro.getText(),
                tCidade.getText(),
                String.valueOf(cEstado_civil.getSelectedItem()),
                tEmail.getText(), tRua.getText(),
                LocalDate.parse(cl.data.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy")),
                Integer.parseInt(tTel1.getText().substring(4, 13)), Integer.parseInt(tTel2.getText().substring(4,13)),
                Integer.parseInt(Tela_Login.tEmail.getText()),
                cl.tBI.getText(), cl.gGenero.getSelection().toString(), Float.valueOf(tRenda.getText().substring(5)), tOcupacao.getText()
                        ));
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
        if (e.getSource().equals(save)) {
            save.setBackground(Color.pink);
        }
        if (e.getSource().equals(clear)) {
            clear.setBackground(Color.pink);
        }
        if (e.getSource().equals(update)) {
            update.setBackground(Color.pink);
        }
        if (e.getSource().equals(back)) {
            back.setBackground(Color.pink);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(save)) {
            save.setBackground(Color.white);
        }
        if (e.getSource().equals(clear)) {
            clear.setBackground(Color.white);
        }
        if (e.getSource().equals(update)) {
            update.setBackground(Color.white);
        }
        if (e.getSource().equals(back)) {
            back.setBackground(Color.white);
        }
    }


 private void preencherCampos() {
        JTable tab = Historico_Cliente.getTable();
        try {
            int linha = tab.getSelectedRow();
            tRua.setText(tab.getValueAt(linha, 6).toString());
            tBairro.setText(tab.getValueAt(linha, 5).toString());
            tCidade.setText(tab.getValueAt(linha, 4).toString());
            tTel1.setText(tab.getValueAt(linha, 8).toString());
            tTel2.setText(tab.getValueAt(linha, 11).toString());
            tEmail.setText(tab.getValueAt(linha, 9).toString());

        } catch (NullPointerException e) {

        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

   
    private void actualizarCliente() {
        Cadastro c = new Cadastro();
        JTable tab = Historico_Cliente.getTable();
        try {
            int linha = tab.getSelectedRow();
            c.actualizarCliente(Integer.parseInt(tab.getValueAt(linha, 0).toString()), tBairro.getText(), tCidade.getText(),
                    cEstado_civil.getSelectedItem().toString(), tEmail.getText(), tRua.getText(), Integer.parseInt(tTel1.getText()), Integer.parseInt(tTel2.getText()));
            JOptionPane.showMessageDialog(janela, "Dados do cliente actualizados :) !");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janela, "Ocorreu algum erro durante a operacao :( !", "", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException i) {
            JOptionPane.showMessageDialog(janela, "Error", "", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    }


   


