/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Banco ItsaJenny
 */
import Controller.Cadastro;
import Model.Entidades.ContaCorrente;
import Model.Entidades.ContaPoupanca;
import static interfaces.CriaConta1.getUnicaInstancia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class CriarConta implements ActionListener, MouseListener, WindowListener {

    private JFrame janela;
    private JPanel painel1, painel2, painelMeio, painel, painelBotoes;
    private ButtonGroup botao;
    private JLabel icon;
    private JRadioButton singular, conjunta;
    private JFormattedTextField tId, tID1, tID2, tID3, saldo, tempo, limite;
    public static CriarConta unicaInstancia;
    JButton save;
    JButton back;
    JButton cancel;
    JButton clear;

    public static CriarConta getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new CriarConta(); // Caso nao exista nenhuma instancia
        }
        return unicaInstancia; //caso ja exista
    }

    public CriarConta() {
        inicializar();
        configuracao();
        addPainel();
        configurarJTextField();
    }

    void inicializar() {
        janela = new JFrame();
        painel1 = new JPanel();
        painel = new JPanel();
        painel2 = new JPanel();
        painelBotoes = new JPanel();
        painelMeio = new JPanel();
        botao = new ButtonGroup();
        icon = new JLabel("");
        icon.setIcon(new ImageIcon("mili2.png"));
        singular = criarRadio("Singular");
        conjunta = criarRadio("Conjunta");
        singular.setBackground(Color.WHITE);
        conjunta.setBackground(Color.WHITE);

        tID1 = criarTextF("####");
        tID2 = criarTextF("####");
        tID3 = criarTextF("####");
        saldo = new JFormattedTextField(new Float(5000));
        tempo = criarTextF("##/##/####");
        limite = new JFormattedTextField(new Float(5000));

        save = criarBotao("Save");
        cancel = criarBotao("Cancel");
        clear = criarBotao("Clear");
        back = criarBotao("Back<<");

        singular.addActionListener(this);
        conjunta.addActionListener(this);

    }

    JFormattedTextField criarTextF(String msg) {
        JFormattedTextField aux = new JFormattedTextField(10);
        try {
            aux = new JFormattedTextField(new MaskFormatter(msg));

        } catch (ParseException cp) {
            System.out.println("Erro de Formatacao");
        }
        return aux;
    }

    void configuracao() {
        painel1.setLayout(new GridBagLayout());
        painel2.setLayout(new GridBagLayout());
        painel.setLayout(new BorderLayout());
        painelMeio.setLayout(new BorderLayout());
        painel1.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Dados Conta"));
        painel2.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Dados Secundarios"));

        cancel.setBackground(Color.white);
        back.setBackground(Color.white);
        clear.setBackground(Color.white);
        save.setBackground(Color.white);

    }

    void configPainel1() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridy = 0;
        painel1.add(new JLabel("Tipo: "), gbc);
        gbc.gridy = 1;
        painel1.add(new JLabel("Id_Titular(es)"), gbc);
        gbc.gridy = 2;
        painel1.add(new JLabel("Saldo Inicial: "), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 2;
        painel1.add(new JLabel("MZN"), gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        painel1.add(singular, gbc);
        gbc.gridx = 2;
        painel1.add(conjunta, gbc);

        gbc.weightx = 0.9;
        gbc.gridx = 1;

        gbc.gridy = 2;
        painel1.add(saldo, gbc);
        gbc.gridy = 1;
        painel1.add(tID1, gbc);
        gbc.gridx = 2;
        painel1.add(tID2, gbc);
        gbc.gridx = 3;
        painel1.add(tID3, gbc);

        painel1.setBackground(Color.WHITE);

    }

    JRadioButton criarRadio(String msg) {
        JRadioButton aux = new JRadioButton(msg);
        botao.add(aux);
        return aux;
    }

    void configPainel2() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel2.add(new JLabel("Limite Levantamento: "), gbc);
        gbc.gridy = 1;
        painel2.add(new JLabel("Tempo Limite: "), gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 3;
        gbc.gridy = 0;
        painel2.add(new JLabel("MZN"), gbc);
        gbc.gridy = 1;
        painel2.add(new JLabel(""), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; //gbc.gridwidth=2;
        gbc.weightx = 0.9;
        gbc.gridy = 0;
        painel2.add(limite, gbc);
        gbc.gridy = 1;
        painel2.add(tempo, gbc);

        painel2.setBackground(Color.WHITE);
    }

    JTextField criarText() {
        JTextField aux = new JTextField();
        return aux;
    }

    void configPainel() {
        painelMeio.add(painel1, BorderLayout.NORTH);
        painelMeio.add(painel2, BorderLayout.SOUTH);
        painelMeio.setBackground(Color.WHITE);

        painel.add(icon, BorderLayout.NORTH);
        painel.add(painelMeio, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        painel.setBackground(Color.PINK);
    }

    void configPainelBotoes() {
        painelBotoes = new JPanel();
        painelBotoes.add(back);
        painelBotoes.add(clear);
        painelBotoes.add(save);
        painelBotoes.add(cancel);

        painelBotoes.setBackground(Color.WHITE);
    }

    private void configurarJTextField() {

        tID1.setBorder(BorderFactory.createLoweredBevelBorder());
        tID2.setBorder(BorderFactory.createLoweredBevelBorder());
        tID3.setBorder(BorderFactory.createLoweredBevelBorder());
        saldo.setBorder(BorderFactory.createLoweredBevelBorder());
        tempo.setBorder(BorderFactory.createLoweredBevelBorder());
        limite.setBorder(BorderFactory.createLoweredBevelBorder());

    }

    void addPainel() {
        configPainel1();
        configPainel2();
        configPainelBotoes();
        configPainel();

        janela.getContentPane().add(painel);
        janela.setSize(650, 400);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setLocationByPlatform(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    JButton criarBotao(String msg) {
        JButton aux = new JButton(msg);

        aux.addActionListener(this);
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Back<<")) {
            CriaConta1 aux = CriaConta1.getUnicaInstancia();
            janela.setVisible(false);
            aux.janela.setVisible(true);
        }
        if (evento.getActionCommand().equals("Clear")) {
            tID1.setText("");
            tID2.setText("");
            tID3.setText("");
            saldo.setText("5000");
            tempo.setText("");
            limite.setText("5000");
        }
        if (evento.getActionCommand().equals("Cancel")) {
            janela.setVisible(false);
            new Projecto_Interface();

        }
        if (evento.getActionCommand().equals("Save")) {
            if (tID1.getText().equals("") || saldo.getText().equals("")) {
                    JOptionPane.showMessageDialog(janela, "Dados Innvalidos");  
            } else {
           
                cadastrar();
                janela.setVisible(false);
                new MenuAdmin();
                
                
            }
        }

        if (evento.getSource().equals(conjunta)) {
            tID2.setEditable(true);
            tID3.setEditable(true);
        }
        if (evento.getSource().equals(singular)) {
            tID2.setEditable(false);
            tID3.setEditable(false);
        }
    }

    void cadastrar() {

        Cadastro teste = new Cadastro();
        CriaConta1 aux = CriaConta1.getUnicaInstancia();

        if (aux.poupanca.isSelected()) {
            if (tID2.getText() == null) {
                tID2.setText("0");
            }
            if (tID3.getText() == null) {
                tID3.setText("0");
            }
            teste.cadastrarContaPoupanca(new ContaPoupanca(
                    LocalDate.parse(limite.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy")),
                    Integer.parseInt(tID1.getText()),
                    Integer.parseInt(tID2.getText()),
                    Integer.parseInt(tID3.getText()),
                    Float.parseFloat(saldo.getText())));
        }
        if (aux.corrente.isSelected()) {
            if (tID2.getText() == null) {
                tID2.setText("0");
            }
            if (tID3.getText() == null) {
                tID3.setText("0");
            }
            teste.cadastrarContaCorrente(new ContaCorrente(
                    Integer.parseInt(tID1.getText()),
                    Integer.parseInt(tID2.getText()),
                    Integer.parseInt(tID3.getText()),
                    Float.parseFloat(saldo.getText())));
        }
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
        if (e.getSource().equals(cancel)) {
            cancel.setBackground(Color.pink);
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
        if (e.getSource().equals(cancel)) {
            cancel.setBackground(Color.white);
        }
        if (e.getSource().equals(back)) {
            back.setBackground(Color.white);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
//         CriaConta1 aux = CriaConta1.getUnicaInstancia();
//         if( aux.botao.getSelection().equals(corrente)){
//           
//             tempo.setEditable(false);
//         }
//         if(aux.poupanca.isSelected()){
//             tempo.setEditable(true);
//         }
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
