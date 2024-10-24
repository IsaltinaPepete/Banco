/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Controller.Cadastro;
import Model.Entidades.Movimentos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thole
 */
public class Historico_Movimentos extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    private JTextField search_bar, textD;
    private JList list;
    private JTable tabela;
    private JButton voltar, cancelar, limpar, save, next, bSearch, bOk;
    private JPanel painel;
    private JLabel icone, texto, tipoConta;
    private String colunas[] = {"Id_Movimento", "Tipo", "Taxa", "Data", "Id_Conta"};
    private Object dados[][] = new Object[5][16];
    private JScrollPane pane;
    private DefaultTableModel tab;
    private JComboBox comboTipo;
    private JDialog d;

    public Historico_Movimentos() {
        configurarJTextField();
        list = new JList();
        voltar = new JButton("<< Back");
        cancelar = new JButton("Cancel");
        limpar = new JButton("Clear");
        save = new JButton("Save");
        next = new JButton("Next >>");
        next.setEnabled(false);
        bSearch = new JButton("Search");
        tabela = new JTable();
        painel = new JPanel();
        painel.setBackground(Color.PINK);
        texto = new JLabel("Movimentos");
        texto.setFont(new Font("Times new Roman", Font.BOLD, 20));
        painel.add(texto);
        comboTipo = new JComboBox(new String[]{"deposito", "levantamento", "transferencia", "consulta"});
        tipoConta = new JLabel("Operacao:");

        pane = new JScrollPane(tabela);
        tab = new DefaultTableModel();
        tab.setColumnIdentifiers(colunas);
        tabela.setModel(tab);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setFillsViewportHeight(true);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        pane.setPreferredSize(new Dimension(500, 100));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 3, 3, 3);
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(painel, c);
        c.gridy = 1;
        this.add(tipoConta, c);
        c.gridwidth = 3;
        c.gridx = 1;
        this.add(comboTipo, c);
        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel("Conta Numero:"), c);
        c.gridx = 1;
        //c.gridwidth = 4;
        this.add(search_bar, c);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        this.add(pane, c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        this.add(voltar, c);
        c.gridx = 1;
        this.add(cancelar, c);
        c.gridx = 2;
        this.add(save, c);
        c.gridx = 3;
        this.add(limpar, c);
        c.gridx = 4;
        this.add(next, c);
        c.gridy = 2;
        this.add(bSearch, c);

        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(720, 700));

        d = pDelete();

        addEvents();

    }

    public void configurarJTextField() {
        search_bar = new JTextField(10) {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque()) {
                    int w = getWidth() - 1;
                    int h = getHeight() - 1;
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setPaint(UIManager.getColor("TextField.background"));
                    g2.fillRoundRect(0, 0, w, h, h, h);
                    g2.setPaint(Color.gray);
                    g2.drawRoundRect(0, 0, w, h, h, h);
                    g2.dispose();
                }
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            }
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(limpar)) {
            search_bar.setText("");
            comboTipo.setSelectedIndex(0);
            tab = new DefaultTableModel();
            tab.setColumnIdentifiers(colunas);
            tabela.setModel(tab);
        }

        if (e.getSource().equals(bSearch)) {
            pesquisarMovimentosId();
        }
        if (e.getSource().equals(comboTipo)) {
            pesquisarMovimentosTipo();

        }
        if (e.getSource().equals(save)) {
            d.setVisible(true);
        }

        if (e.getSource().equals(bOk)) {
            int result = JOptionPane.showConfirmDialog(this, "Certeza que pretende apagar essa transaccao?", "",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                apagarMovimentos();
                d.setVisible(false);
            } else {
                d.setVisible(false);
            }
        }
        if (e.getSource().equals(voltar)) {
            new MenuAdmin();
            Historicos.getJanela().setVisible(false);
        }
    }

    private JDialog pDelete() {
        JFrame f = new JFrame();
        d = new JDialog(f, "Remove by Id", true);
        textD = new JTextField(10);
        d.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 0;
        d.add(new JLabel("Digite o id da transaccao"), c);
        c.gridy = 1;
        d.add(textD, c);
        c.gridy = 2;
        bOk = new JButton("Apagar");
        d.add(bOk, c);

        f.setIconImage(new ImageIcon("icone_janela.png").getImage());
        d.setSize(250, 150);
        d.setLocationRelativeTo(this);
        return d;
    }

    public void pesquisarMovimentosData() {
        tab = new DefaultTableModel();
        tab.setColumnIdentifiers(colunas);
        tabela.setModel(tab);
        Cadastro cadastro = new Cadastro();
        ArrayList<Movimentos> list = cadastro.historico_movimentos_data(LocalDate.parse(search_bar.getText()));

        list.forEach((Movimentos m) -> {
            tab.addRow(new Object[]{m.getIdMovimentos(), m.getTipo(), m.getTaxa(),
                m.getDataMovimento(), m.getIdContaCorrente(), m.getIdContaPoupanca()});
        });
    }

    public void pesquisarMovimentosId() {

        Cadastro cadastro = new Cadastro();
        ArrayList<Movimentos> list = cadastro.historico_movimentos_IdMovimento(Integer.parseInt(search_bar.getText()));

        list.forEach((Movimentos m) -> {
            tab.addRow(new Object[]{m.getIdMovimentos(), m.getTipo(), m.getTaxa(),
                m.getDataMovimento(), m.getIdContaCorrente(), m.getIdContaPoupanca()});
        });

    }

    public void pesquisarMovimentosTipo() {
        tab = new DefaultTableModel();
        tab.setColumnIdentifiers(colunas);
        tabela.setModel(tab);
        Cadastro cadastro = new Cadastro();
        ArrayList<Movimentos> list = cadastro.historico_movimentos_tipo(comboTipo.getSelectedItem().toString());

        list.forEach((Movimentos m) -> {
            tab.addRow(new Object[]{m.getIdMovimentos(), m.getTipo(), m.getTaxa(),
                m.getDataMovimento(), m.getIdContaCorrente(), m.getIdContaPoupanca()});
        });

    }

    public void apagarMovimentos() {
//        Cadastro cadastro = new Cadastro();
//        try {
//            cadastro.apagarMovimentos(Integer.parseInt(textD.getText()));
//            JOptionPane.showMessageDialog(this, "Operacao terminada!");
//        } catch (NullPointerException e) {
//            JOptionPane.showMessageDialog(this, "Introduziu dados invalidos, clique em Ok para continuar!", "Alerta!", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Ocorreu um erro!", "Alerta", JOptionPane.ERROR_MESSAGE);
//
//        }
    }

    public void addEvents() {
        voltar.addActionListener(this);
        limpar.addActionListener(this);
        cancelar.addActionListener(this);
        save.addActionListener(this);
        bSearch.addActionListener(this);
        bSearch.addMouseListener(this);
        comboTipo.addMouseListener(this);
        comboTipo.addActionListener(this);
        bOk.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.getSource().equals(comboTipo)) {
//            pesquisarMovimentosTipo();
//            
//        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
