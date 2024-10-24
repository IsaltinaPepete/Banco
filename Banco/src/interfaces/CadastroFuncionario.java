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
import interfaces.CadastroFuncionario2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class CadastroFuncionario implements ActionListener, MouseListener {

    JFrame janela;
    JPanel painel, painelBotoes, painelPrincipal;
    JLabel icon;
    ButtonGroup botao;
    String listaNacionalidade[] = {"Africa do Sul", "Angola", "Argelia", "Mocambique",
        "Quenia", "Sualizandia", "Zimbabwe", "Tanzania", "Nigeria", "Uganda"};
    JScrollPane scrol;
    JRadioButton femenino, masculino;
    JFormattedTextField data, tBi;
    JTextField tNome, tApelido;
    JList nacionalidade;
    private JButton bVoltar, bLimpar, bCancel, bNext;

    public static CadastroFuncionario unicaInstancia;

    public static CadastroFuncionario getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new CadastroFuncionario(); // Caso nao exista nenhuma instancia
        }
        return unicaInstancia; //caso ja exista
    }

    public CadastroFuncionario() {
        inicializar();
        configurar();
        adicionar();
        configurarJTextField();
    }

    void inicializar() {
        janela = new JFrame();
        painel = new JPanel();
        painelBotoes = new JPanel();
        painelPrincipal = new JPanel();
        nacionalidade = new JList();
        botao = new ButtonGroup();
        icon = new JLabel("");
        icon.setIcon(new ImageIcon("mili2.png"));
        femenino = criarButton("feminino");
        masculino = criarButton("masculino");
        try {
            data = criarTextF("##/##/####");
            tBi = criarTextF("#############U");
        } catch (ParseException ex) {
            Logger.getLogger(CadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        tNome = criarText("");
        tApelido = criarText("");

        bVoltar = criarBotao("Back<<");
        bLimpar = criarBotao("Clear");
        bCancel = criarBotao("Cancel");
        bNext = criarBotao("Next>>");
    }

    void configPainelBotoes() {
       painelBotoes.add(bVoltar);
        painelBotoes.add(bLimpar);
        painelBotoes.add(bCancel);
        painelBotoes.add(bNext);
        painelBotoes.setBackground(Color.WHITE);
    }

    void criarList(String lista[]) {
        nacionalidade = new JList(lista);
        scrol = new JScrollPane(nacionalidade);
        scrol.setPreferredSize(new Dimension(50, 70));
    }

    JTextField criarText(String msg) {
        JTextField aux = new JTextField(msg);
        return aux;
    }

    JFormattedTextField criarTextF(String msg) throws ParseException {
        JFormattedTextField aux = new JFormattedTextField(new MaskFormatter(msg));
        return aux;
    }

    void configurar() {
        painel.setLayout(new GridBagLayout());
        painel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Dados Pessoais"));
        painel.setBackground(Color.WHITE);
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBackground(Color.PINK);
        femenino.setBackground(Color.WHITE);
        masculino.setBackground(Color.WHITE);

    }

    void adicionar() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.1;
        gbc.gridx = 2;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        painel.add(new JLabel("Nome: "), gbc);
        gbc.gridy = 2;
        painel.add(new JLabel("Data Nascimento: "), gbc);
        gbc.gridy = 3;
        painel.add(new JLabel("Genero:"), gbc);
        gbc.gridy = 4;
        painel.add(new JLabel("Nascionalidade:"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        painel.add(new JLabel("Apelido: "), gbc);
        gbc.gridy = 2;
        painel.add(new JLabel("BI: "), gbc);
        gbc.gridy = 3;
        painel.add(femenino, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(tNome, gbc);
        gbc.gridy = 2;
        painel.add(data, gbc);
        gbc.gridy = 3;
        painel.add(masculino, gbc);
        gbc.gridwidth = 3;
        gbc.gridy = 4;
        criarList(listaNacionalidade);
        painel.add(scrol, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        painel.add(tApelido, gbc);
        gbc.gridy = 2;
        painel.add(tBi, gbc);

        configPainelBotoes();

        painelPrincipal.add(icon, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
        painelPrincipal.add(painel, BorderLayout.CENTER);

        janela.getContentPane().add(painelPrincipal);
        janela.setSize(700, 450);
        janela.setLocationByPlatform(true);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }

    JButton criarBotao(String msg) {
        JButton aux = new JButton(msg);
        aux.addActionListener(this);
        aux.addMouseListener(this);
        aux.setBackground(Color.white);
        return aux;
    }

    private void configurarJTextField() {
        tNome.setBorder(BorderFactory.createLoweredBevelBorder());
        tApelido.setBorder(BorderFactory.createLoweredBevelBorder());
        data.setBorder(BorderFactory.createLoweredBevelBorder());
        nacionalidade.setBorder(BorderFactory.createLoweredBevelBorder());
        tBi.setBorder(BorderFactory.createLoweredBevelBorder());

    }

    JRadioButton criarButton(String msg) {
        JRadioButton aux = new JRadioButton(msg);
        botao.add(aux);
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Next>>")) {
            janela.setVisible(false);
            CadastroFuncionario2 aux = CadastroFuncionario2.getUnicaInstancia();
            aux.janela.setVisible(true);
        }
        if (evento.getActionCommand().equals("Clear")) {
            tNome.setText("");
            tApelido.setText("");
            botao.clearSelection();

            nacionalidade.setSelectedIndex(-1);
            data.setText("");

        }
        if (evento.getActionCommand().equals("Cancel")) {
            janela.setVisible(false);
            new Projecto_Interface().janela.setVisible(true);

        }
        if (evento.getActionCommand().equals("Back<<")) {
            janela.setVisible(false);
            new MenuAdmin();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {   
        bVoltar.setBackground(Color.pink);
         bLimpar.setBackground(Color.pink);
         bCancel.setBackground(Color.pink);
         bNext.setBackground(Color.pink);
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
     bVoltar.setBackground(Color.white);
         bLimpar.setBackground(Color.white);
         bCancel.setBackground(Color.white);
         bNext.setBackground(Color.white);
    }




    private void preencherCampos() {
         JTable tab = Historico_Trabalhador.getTable();
        try {
            int linha = tab.getSelectedRow();
            tNome.setText(tab.getValueAt(linha, 1).toString());
            tApelido.setText(tab.getValueAt(linha, 2).toString());
            data.setText(tab.getValueAt(linha, 7).toString());
            nacionalidade.setSelectedValue(tab.getValueAt(linha, 3).toString(), true);

        } catch (NullPointerException e) {

        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
    
   

}
