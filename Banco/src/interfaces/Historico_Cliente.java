package interfaces;

import Controller.Cadastro;
import Controller.Relatorios;
import Model.Entidades.Cliente;
import Model.Entidades.Movimentos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thole
 */
public class Historico_Cliente extends JPanel implements ActionListener {

    private JTextField search_bar, textD;
    private JList list;
    private static JTable tabela;
    private JButton bVoltar, bUpdate, bLimpar, bDelete, bSave, bSearch, bOk, relatorio;
    private JPanel painel;
    private JLabel icone, texto, lGenero, lNome;
    private JScrollPane pane;
    private DefaultTableModel tab;
    private JComboBox comboGenero;
    private String colunas[] = {"id cliente", "nome", "sobrenome", "nacionalidade", "cidade", "bairro", "rua", "data_nascimento", "telefone1", "email", "estado civil", "telefone2", "id funcionario"};
    private JDialog d;

    public Historico_Cliente() {
        configurarJTextField();

        tabela = new JTable();
        pane = new JScrollPane(tabela);
        tab = new DefaultTableModel();
        tab.setColumnIdentifiers(colunas);
        tabela.setModel(tab);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setFillsViewportHeight(true);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        pane.setPreferredSize(new Dimension(500, 100));
        
        relatorio= new JButton("relatorio");
        relatorio.addActionListener(this);
        bVoltar = new JButton("<< Back");
        bLimpar = new JButton("Clear");
        bDelete = new JButton("Delete");
        bUpdate = new JButton("Update");
        bSave = new JButton("Save");
        bSave.setEnabled(false);
        bSearch = new JButton("Search");
        lGenero = new JLabel("Genero >>");
        lNome = new JLabel("Nome >>");

        comboGenero = new JComboBox(new String[]{"", "feminino", "masculino"});

        painel = new JPanel();
        painel.setBackground(Color.PINK);
        texto = new JLabel("Cliente");
        texto.setFont(new Font("Times new Roman", Font.BOLD, 20));
        painel.add(texto);

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
        this.add(lGenero, c);
        c.gridwidth = 3;
        c.gridx = 1;
        this.add(comboGenero, c);
        c.gridx = 0;
        c.gridy = 2;
        this.add(lNome, c);
        c.gridx = 1;
        //c.gridwidth = 4;
        this.add(search_bar, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 5;
        this.add(pane, c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        this.add(bVoltar, c);
        c.gridx = 1;
        this.add(bLimpar, c);
        c.gridx = 2;
        this.add(bUpdate, c);
        c.gridx = 3;
        this.add(bDelete, c);
        c.gridx = 4;
        this.add(bSave, c);
        c.gridx = 5;
        this.add(relatorio, c);
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

    public void pesquisarClienteNome() {
        tab = new DefaultTableModel();
        tab.setColumnIdentifiers(colunas);
        tabela.setModel(tab);
        Cadastro cadastro = new Cadastro();
        ArrayList<Cliente> list = cadastro.historico_cliente_nome(search_bar.getText());

        list.forEach((Cliente cliente) -> {
            tab.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getApelido(),
                cliente.getNacionalidade(), cliente.getCidade(), cliente.getBairro(), cliente.getRua(),
                cliente.getDataNascimento(), cliente.getTelefone1(), cliente.getEmail(), cliente.getEstadoCivil(),
                cliente.getTelefone2(), cliente.getIdFuncionario()});
        });
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
        d.add(new JLabel("Digite o id do cliente"), c);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bLimpar)) {
            search_bar.setText("");
            tab = new DefaultTableModel();
            tab.setColumnIdentifiers(colunas);
            tabela.setModel(tab);
        }
        if (e.getSource().equals(bSearch)) {
            pesquisarClienteNome();
        }

        if (e.getSource().equals(bDelete)) {
            d.setVisible(true);
        }
        if (e.getSource().equals(bOk)) {
            int result = JOptionPane.showConfirmDialog(this, "Certeza que pretende apagar esse cliente", "",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                apagarCliente();
                d.setVisible(false);
            } else {
                d.setVisible(false);
            }
        }
        if (e.getSource().equals(relatorio)) {
           if( Relatorios.relatorioClientes()){
               JOptionPane.showMessageDialog(this, "Relatorio Gerado Com Sucesso");
           } else{
                JOptionPane.showMessageDialog(this, "Relatorio Gerado Sem Sucesso");
           }
        }
        if (e.getSource().equals(bVoltar)) {
            new MenuAdmin();
            Historicos.getJanela().setVisible(false);
        }

        if (e.getSource().equals(bUpdate)) {
            new Cadastro_Cliente_part2();
        }
    }

    public void apagarCliente() {
        Cadastro cadastro = new Cadastro();
        try {
            cadastro.apagarCliente(Integer.parseInt(textD.getText()));
            JOptionPane.showMessageDialog(this, "Operacao terminada!");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Introduziu dados invalidos, clique em Ok para continuar!", "Alerta!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro!", "Alerta", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static JTable getTable() {
        return tabela;
    }

    public void addEvents() {
        bVoltar.addActionListener(this);
        bLimpar.addActionListener(this);
        bUpdate.addActionListener(this);
        bDelete.addActionListener(this);
        bSearch.addActionListener(this);
        bOk.addActionListener(this);

    }

}
