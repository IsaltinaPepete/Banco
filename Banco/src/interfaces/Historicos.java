package interfaces;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Thole
 */
public class Historicos {

    private JTabbedPane painel_principal;
    private JPanel p_cliente, p_movimentos, p_funcionario;
    private static JFrame janela;

    public Historicos() {
        painel_principal = new JTabbedPane();
        p_cliente = new Historico_Cliente();
        p_movimentos = new Historico_Movimentos();
        p_funcionario = new Historico_Trabalhador();
        painel_principal.addTab("Cliente", p_cliente);
        painel_principal.addTab("Movimentos", p_movimentos);
        painel_principal.addTab("Funcionarios", p_funcionario);

        painel_principal.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        janela = new JFrame("Historico");

        janela.add(painel_principal);
        janela.setIconImage(new ImageIcon("icone_janela.png").getImage());
        janela.setBackground(Color.GRAY);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationByPlatform(true);
        janela.setSize(new Dimension(750, 500));
        janela.setVisible(true);
    }

    public static JFrame getJanela() {
        return janela;
    }
    
    

}
