/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Controller.Cadastro;
import Model.Entidades.Trabalhador;
import static interfaces.CadastroFuncionario.getUnicaInstancia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Banco ItsaJenny
 */
public class CadastroFuncionario2 implements ActionListener, MouseListener {

    JFrame janela;
    JPanel painelEndereco, painelContacto, painelDescricao, painelPrincipal, painelBotoes, painel;
    JLabel icon;
    JTextField tCidade, tBairro, tRua, tEmail, cargo;
    JFormattedTextField tCel1, tCel2, salario, tId;
    String lista[] = {"", "Solteiro/a", "Casado/a", "Divorciado/a", "Viuvo/a"};
    JComboBox estadoCivil;
    private JButton bVoltar, bLimpar, bCancel, bSave;
    private static CadastroFuncionario2 unicaInstancia;

    public static CadastroFuncionario2 getUnicaInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new CadastroFuncionario2(); // Caso nao exista nenhuma instancia
        }
        return unicaInstancia; //caso ja exista
    }

    public CadastroFuncionario2() {
        inicializar();
        configurar();
        adicionar();
        configurarJTextField();
    }

    void configPainelBotoes() {
         bVoltar =criarBotao("Back<<");
         bLimpar = criarBotao("Clear");
         bCancel = criarBotao("Cancel");
         bSave = criarBotao("Save");
        painelBotoes.add(bVoltar);
        painelBotoes.add(bLimpar);
        painelBotoes.add(bCancel);
        painelBotoes.add(bSave);
    }

    void inicializar() {
        janela = new JFrame();
        painelEndereco = new JPanel();
        painelContacto = new JPanel();
        painelPrincipal = new JPanel();
        painelDescricao = new JPanel();
        painelBotoes = new JPanel();
        painel = new JPanel();
        icon = new JLabel("");

        icon.setIcon(new ImageIcon("mili2.png"));
        tCidade = criarText("");
        tBairro = criarText("");
        tRua = criarText("");
        tId = new JFormattedTextField(new Integer (0));
        tCel1 = criarTextF("#########");
        tCel2 = criarTextF("#########");
        tEmail = criarText("");
        salario = new JFormattedTextField(new Float(2));
        cargo = criarText("");
        estadoCivil = new JComboBox(lista);
    }

     public JFormattedTextField getFormatacao(int nrCasas, Comparable maximo){
        DecimalFormat aux = new DecimalFormat();
        aux.setMaximumFractionDigits(nrCasas);
        aux.setMinimumFractionDigits(nrCasas);
        aux.setRoundingMode(RoundingMode.HALF_UP);
        DecimalFormatSymbols other = new DecimalFormatSymbols();
        other.setDecimalSeparator('.');
        aux.setDecimalFormatSymbols(other);
        NumberFormatter format = new NumberFormatter(aux);
       
        format.setMinimum(0.00);
        format.setMaximum(maximo);
        return new JFormattedTextField(format);
    }
    JTextField criarText(String msg) {
        JTextField aux = new JTextField(msg);
        return aux;
    }

    JFormattedTextField criarTextF(String msg) {
        JFormattedTextField aux = new JFormattedTextField();
        try {
            aux = new JFormattedTextField(new MaskFormatter(msg));

        } catch (ParseException cp) {
            System.out.println("Erro de Formatacao");
        }
        return aux;
    }

    void configurar() {
        painelEndereco.setLayout(new GridBagLayout());
        painelDescricao.setLayout(new GridBagLayout());
        painelContacto.setLayout(new GridBagLayout());
        painelPrincipal.setLayout(new GridBagLayout());

        painelEndereco.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Endereco"));
        painelContacto.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Contacto"));
        painelDescricao.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(), "Descricao"));
        painel.setLayout(new BorderLayout());

        painelEndereco.setBackground(Color.WHITE);
        painelContacto.setBackground(Color.WHITE);
        painelDescricao.setBackground(Color.WHITE);
        painelPrincipal.setBackground(Color.WHITE);
        painel.setBackground(Color.PINK);
        painelBotoes.setBackground(Color.WHITE);
    }

    void configPainelEndereco() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 2, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weighty=1;
        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelEndereco.add(new JLabel("Cidade: "), gbc);
        gbc.gridy = 1;
        painelEndereco.add(new JLabel("Bairro: "), gbc);
        gbc.gridy = 2;
        painelEndereco.add(new JLabel("Rua:"), gbc);

        gbc.weightx = 0.9;
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelEndereco.add(tCidade, gbc);
        gbc.gridy = 1;
        painelEndereco.add(tBairro, gbc);
        gbc.gridy = 2;
        painelEndereco.add(tRua, gbc);
    }

    void configPainelContacto() {
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.insets = new Insets(2, 10, 2, 10);
        gbl.fill = GridBagConstraints.HORIZONTAL;
        gbl.weighty = 1;
        gbl.weightx = 0.1;

        gbl.gridx = 0;
        gbl.gridy = 0;
        painelContacto.add(new JLabel("Telefone1: "), gbl);
        gbl.gridy = 1;
        painelContacto.add(new JLabel("Telefone2: "), gbl);
        gbl.gridy = 2;
        painelContacto.add(new JLabel("Email: "), gbl);

        gbl.weightx = 0.9;
        gbl.gridwidth = 2;
        gbl.gridx = 1;
        gbl.gridy = 0;
        painelContacto.add(tCel1, gbl);
        gbl.gridy = 1;
        painelContacto.add(tCel2, gbl);
        gbl.gridy = 2;
        painelContacto.add(tEmail, gbl);
    }

    void configPainelDescricao() {
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new Insets(2, 10, 2, 10);
        gb.fill = GridBagConstraints.HORIZONTAL;

        gb.weightx = 0.1;

        gb.gridx = 0;
        gb.gridy = 0;
        painelDescricao.add(new JLabel("Estado Civil: "), gb);
        gb.gridy = 1;
        painelDescricao.add(new JLabel("cargo: "), gb);
        gb.gridy = 2;
        painelDescricao.add(new JLabel("SalarioMin: "), gb);
        gb.gridy = 3;
        painelDescricao.add(new JLabel("ID Departamento: "), gb);

        gb.weightx = 0.9;
        gb.gridx = 1;
        gb.gridwidth = 2;
        gb.gridy = 0;
        painelDescricao.add(estadoCivil, gb);
        gb.gridy = 1;
        painelDescricao.add(cargo, gb);
        gb.gridy = 2;
        painelDescricao.add(salario, gb);
        gb.gridy = 3;
        painelDescricao.add(tId, gb);
    }

    void configPainelPrincipal() {
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(2, 10, 2, 10);
        g.fill = GridBagConstraints.BOTH;
        g.weightx = 1;
        g.weighty = 1;

        g.gridx = 0;
        g.gridy = 0;
        painelPrincipal.add(painelEndereco, g);
        g.gridx = 1;
        painelPrincipal.add(painelContacto, g);
        g.gridy = 1;
        g.gridx = 0;
        g.gridwidth = 2;
        painelPrincipal.add(painelDescricao, g);
    }

    void adicionar() {
        configPainelEndereco();
        configPainelContacto();
        configPainelDescricao();
        configPainelPrincipal();
        configPainelBotoes();

        painel.add(icon, BorderLayout.NORTH);
        painel.add(painelPrincipal, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        janela.getContentPane().add(painel);
        janela.setSize(700, 450);
        janela.setLocationByPlatform(true);
        //janela.setResizable(false);
        janela.setIconImage(new ImageIcon("icone_p.png").getImage());
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }

    private void configurarJTextField() {
        tId.setBorder(BorderFactory.createLoweredBevelBorder());
        tCel1.setBorder(BorderFactory.createLoweredBevelBorder());
        tCel2.setBorder(BorderFactory.createLoweredBevelBorder());
        salario.setBorder(BorderFactory.createLoweredBevelBorder());
        tCidade.setBorder(BorderFactory.createLoweredBevelBorder());
        tBairro.setBorder(BorderFactory.createLoweredBevelBorder());
        tRua.setBorder(BorderFactory.createLoweredBevelBorder());
        tEmail.setBorder(BorderFactory.createLoweredBevelBorder());
        cargo.setBorder(BorderFactory.createLoweredBevelBorder());

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Back<<")) {
            CadastroFuncionario aux = CadastroFuncionario.getUnicaInstancia();
            janela.setVisible(false);
            aux.janela.setVisible(true);

        }
        if (evento.getActionCommand().equals("Clear")) {
            tCidade.setText("");
            tBairro.setText("");
            tRua.setText("");
            tCel1.setText("");
            tCel2.setText("");
            tEmail.setText("");
            salario.setText("");
            cargo.setText("");
            tId.setText("");
            estadoCivil.setSelectedIndex(-1);

        }
        if (evento.getActionCommand().equals("Cancel")) {
            janela.setVisible(false);
            new Projecto_Interface().janela.setVisible(true);
        }
        if (evento.getActionCommand().equals("Save")) {
            CadastroFuncionario aux = CadastroFuncionario.getUnicaInstancia();
            System.out.println(aux.data.getText());
            if (((salario.getText().equals("")) || (tId.getText().equals(""))
                    && (tCel1.getText().equals("")) || (tCel2.getText().equals("")) || aux.data.getText().equals(""))) {
                JOptionPane.showMessageDialog(janela, "Dados Invalidos");
            } else {

                cadastrar();
                return;
            }
        }
    }

    JButton criarBotao(String msg) {
        JButton aux = new JButton(msg);

        aux.addActionListener(this);
        aux.addMouseListener(this);
        aux.setBackground(Color.white);
        return aux;
    }

    void cadastrar() {

        Cadastro teste = new Cadastro();
        CadastroFuncionario aux = CadastroFuncionario.getUnicaInstancia();

        if (teste.cadastrarTrabalhador(new Trabalhador(
                cargo.getText(), Float.valueOf(salario.getText().replace(".", "").replace(",", ".")), Integer.parseInt(tId.getText()), aux.tNome.getText(),
                aux.tApelido.getText(), String.valueOf(aux.nacionalidade.getSelectedValue()), tBairro.getText(), tCidade.getText(),
                String.valueOf(estadoCivil.getSelectedItem()),
                tEmail.getText(), tRua.getText(),
                LocalDate.parse(aux.data.getText(), DateTimeFormatter.ofPattern("d/MM/yyyy")),
                Integer.parseInt(tCel1.getText()), Integer.parseInt(tCel2.getText()),
                aux.tBi.getText(), aux.botao.getSelection().toString()))) {

            JOptionPane.showMessageDialog(janela, "Cadastro Efectuado Com Sucesso");

        } else {
            JOptionPane.showMessageDialog(janela, "Cadastro Efectuado Sem Sucesso");
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
         bVoltar.setBackground(Color.pink);
         bLimpar.setBackground(Color.pink);
         bCancel.setBackground(Color.pink);
         bSave.setBackground(Color.pink);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        bVoltar.setBackground(Color.white);
         bLimpar.setBackground(Color.white);
         bCancel.setBackground(Color.white);
         bSave.setBackground(Color.white);
    }


    
    
    private void preencherCampos() {
         JTable tab = Historico_Trabalhador.getTable();
        try {
            int linha = tab.getSelectedRow();
            tCidade.setText(tab.getValueAt(linha, 4).toString());
            tRua.setText(tab.getValueAt(linha, 6).toString());
            tBairro.setText(tab.getValueAt(linha, 5).toString());
            tEmail.setText(tab.getValueAt(linha, 9).toString());
            cargo.setText(tab.getValueAt(linha, 11).toString());
            salario.setText(tab.getValueAt(linha, 12).toString());
            tCel1.setText(tab.getValueAt(linha, 8).toString());
            tCel2.setText(tab.getValueAt(linha, 13).toString());
            estadoCivil.setSelectedItem(tab.getValueAt(linha, 10).toString());
            tId.setText(tab.getValueAt(linha, 14).toString());

        } catch (NullPointerException e) {

        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
    
    private void actualizarTrabalhador() {
        Cadastro c = new Cadastro();
        JTable tab = Historico_Trabalhador.getTable();
        CadastroFuncionario f = CadastroFuncionario.getUnicaInstancia();
        try {
            int linha = tab.getSelectedRow();
            Trabalhador trab = new Trabalhador(  null, 0, 0, null, null, null, null, null, null, null, null, null, 0, 0, null, "");
            trab.setId(Integer.parseInt(tab.getValueAt(linha,0).toString()));
            trab.setCargo(cargo.getText());
            trab.setSalario( Float.parseFloat(salario.getText()));
            trab.setIdDepartamento( Integer.parseInt(tId.getText()));
            trab.setNome( f.tNome.getText());
            trab.setApelido(f.tApelido.getText());
            trab.setNacionalidade(f.nacionalidade.getSelectedValue().toString());
            trab.setBairro( tBairro.getText());
            trab.setCidade(tCidade.getText());
            trab.setEstadoCivil(estadoCivil.getSelectedItem().toString());
            trab.setEmail(tEmail.getText());
            trab.setRua(tRua.getText());
            trab.setTelefone1(Integer.parseInt(tCel1.getText()));
            trab.setTelefone2( Integer.parseInt(tCel2.getText()));
            c.actualizarFuncionario(trab);
                   
           
          
                    
            JOptionPane.showMessageDialog(janela, "Dados do cliente actualizados :) !");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(janela, "Ocorreu algum erro durante a operacao :( !", "", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException i) {
            JOptionPane.showMessageDialog(janela, "Error", "", JOptionPane.ERROR_MESSAGE);
        }
    }

}
