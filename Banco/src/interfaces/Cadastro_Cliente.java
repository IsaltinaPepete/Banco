package interfaces;

import interfaces.Cadastro_Cliente_part2;
import interfaces.Historico_Cliente;
import interfaces.MenuAdmin;
import interfaces.Projecto_Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class Cadastro_Cliente implements ActionListener, MouseListener {

    JFrame janela;
    JLabel icon;
    JLabel lP_nome;
    JLabel lU_nome;
    JTextField tP_nome;
    JTextField tU_nome;
    JLabel lBI;
    JTextField tBI;

    JFormattedTextField data;
    JLabel lGenero;
    JRadioButton feminino;
    JRadioButton masculino;
    JPanel pGenero;
    ButtonGroup gGenero;
    JLabel lNacionalidade;
    JList nacionalidade;
    JScrollPane scrollPane;
    JLabel proximo;
    JPanel painel;
    JButton next;
    JButton back;
    JButton cancel;
    JButton clear;
    JPanel principal;
    JPanel painel_botoes;

    public Cadastro_Cliente() {
        janela = new JFrame("Cadastro");
        lP_nome = new JLabel("Nome:");
        lU_nome = new JLabel("Sobrenome: ");
        tP_nome = new JTextField(10);
        tU_nome = new JTextField(10);
        lBI = new JLabel("BI: ");
        tBI = new JTextField();

        lGenero = new JLabel("Genero:");
        feminino = new JRadioButton("F");
        masculino = new JRadioButton("M");
        pGenero = new JPanel();
        pGenero.add(feminino);
        pGenero.add(masculino);
        gGenero = new ButtonGroup();
        gGenero.add(feminino);
        gGenero.add(masculino);
        lNacionalidade = new JLabel("Nacionalidade:");
        String listaNacionalidade[] = {"Africa do Sul", "Angola", "Argelia", "Mocambique",
            "Quenia", "Sualizandia", "Zimbabwe", "Tanzania", "Nigeria", "Uganda"};
        nacionalidade = new JList(listaNacionalidade);
        scrollPane = new JScrollPane(nacionalidade);
        scrollPane.setPreferredSize(new Dimension(50, 70));

        try {

            data = criarTextF("##/##/####");
        } catch (ParseException ex) {
            System.out.println("Erro d Formatacao");
        }

        icon = new JLabel("");
        icon.setIcon(new ImageIcon("mili2.png"));

        next = new JButton("Next >>");
        next.setBackground(Color.white);
        back = new JButton("<< Back");
        back.setBackground(Color.white);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        clear = new JButton("Clear");
        clear.setBackground(Color.white);

        addEvents();
        // back.setEnabled(false);
        //proximo.setFont(new Font("Times new Roman", Font.ITALIC, 16));
        tBI.setBorder(BorderFactory.createLoweredBevelBorder());
        tP_nome.setBorder(BorderFactory.createLoweredBevelBorder());
        tU_nome.setBorder(BorderFactory.createLoweredBevelBorder());
        data.setBorder(BorderFactory.createLoweredBevelBorder());
        nacionalidade.setBorder(BorderFactory.createLoweredBevelBorder());

        painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        painel.add(lP_nome, c);
        c.gridx = 1;
        painel.add(tP_nome, c);
        c.gridx = 2;
        painel.add(lU_nome, c);
        c.gridx = 3;
        painel.add(tU_nome, c);
        c.gridx = 0;
        c.gridy = 1;
        painel.add(lBI, c);
        c.gridx = 1;
        painel.add(tBI, c);
        c.gridx = 2;
        painel.add(new JLabel("Data Nascimento: "), c);
        c.gridx = 3;
        painel.add(data, c);
        c.gridx = 0;
        c.gridy = 2;
        painel.add(lNacionalidade, c);
        c.gridx = 1;
        c.gridwidth = 3;
        painel.add(scrollPane, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        painel.add(lGenero, c);
        c.gridx = 1;
        painel.add(pGenero, c);

        painel_botoes = new JPanel();
        painel_botoes.add(back);
        painel_botoes.add(clear);
        painel_botoes.add(cancel);
        painel_botoes.add(next);

        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.add(icon, BorderLayout.NORTH);
        principal.add(painel, BorderLayout.CENTER);
        principal.add(painel_botoes, BorderLayout.SOUTH);

        principal.setBackground(Color.PINK);
        painel.setBackground(Color.WHITE);
        painel_botoes.setBackground(Color.WHITE);
        pGenero.setBackground(Color.WHITE);
        feminino.setBackground(Color.WHITE);
        masculino.setBackground(Color.WHITE);

        painel.setBorder(BorderFactory.createTitledBorder(LineBorder.createGrayLineBorder(), "Dados Pessoais"));
        preencherCampos();
        janela.add(principal);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationByPlatform(true);
        janela.setSize(700, 450);
        janela.setVisible(true);

    }

    void addEvents() {
        back.addActionListener(this);
        next.addActionListener(this);
        next.addMouseListener(this);
        back.addMouseListener(this);

        cancel.addActionListener(this);
        cancel.addMouseListener(this);

        clear.addMouseListener(this);
        clear.addActionListener(this);

    }


    JFormattedTextField criarTextF(String msg) throws ParseException {
        JFormattedTextField aux = new JFormattedTextField(new MaskFormatter(msg));

        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(next)) {
            Cadastro_Cliente_part2 aux = Cadastro_Cliente_part2.getUnicaInstancia();
            aux.janela.setVisible(true);
            janela.setVisible(false);
        }
        if (e.getSource().equals(clear)) {
            tP_nome.setText("");
            tU_nome.setText("");
            tBI.setText("");
            gGenero.clearSelection();

        }
        if (e.getSource().equals(back)) {
            new MenuAdmin();
            janela.setVisible(false);
        }
        if (e.getSource().equals(cancel)) {
            new Projecto_Interface().janela.setVisible(true);
            janela.setVisible(false);
        }

    }

    public static Cadastro_Cliente unicaInstancia;

    public static Cadastro_Cliente getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new Cadastro_Cliente();
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
        if (e.getSource().equals(next)) {
            next.setBackground(Color.pink);
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
        if (e.getSource().equals(next)) {
            next.setBackground(Color.white);
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



    
     public void preencherCampos() {
        JTable tab = Historico_Cliente.getTable();
        try {
            int linha = tab.getSelectedRow();
            Object v1 = tab.getValueAt(linha,1);
            tP_nome.setText(v1.toString());
            tU_nome.setText(tab.getValueAt(linha, 2).toString());
            tBI.setText(tab.getValueAt(linha, 0).toString());
            data.setText(tab.getValueAt(linha, 7).toString());
            
            
        } catch(NullPointerException e){
            
        }
    }

}
