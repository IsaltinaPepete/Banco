/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Validacao;
import Model.DAO.ClienteDAO;
import Model.DAO.ContaCorrenteDAO;
import Model.DAO.ContaPoupancaDAO;
import Model.DAO.DepartamentoDAO;
import Model.DAO.MovimentosDAO;
import Model.DAO.TrabalhadorDAO;
import Model.Entidades.Cliente;
import Model.Entidades.ContaCorrente;
import Model.Entidades.ContaPoupanca;
import Model.Entidades.Departamento;
import Model.Entidades.Movimentos;
import Model.Entidades.Senha;
import Model.Entidades.Trabalhador;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Itsa Pepete
 */
public class Cadastro<T> {

    public boolean cadastrarTrabalhador(Trabalhador trab) {
        if (Validacao.validarTrablhador(trab)) {
            TrabalhadorDAO aux = new TrabalhadorDAO();
            aux.inserir(trab);
         return true;
         } else{
            return false;
        }
    }

    public boolean cadastrarContaPoupanca(ContaPoupanca contaPoupanca) {
        if (Validacao.validarPoupanca(contaPoupanca)) {
            ContaPoupancaDAO aux = new ContaPoupancaDAO();
            aux.inserir(contaPoupanca);
         return true;
         } else{
            return false;
        }
    }

    public boolean cadastrarContaCorrente(ContaCorrente contaCorrente) {
        if (Validacao.validarCorrente(contaCorrente)) {
            ContaCorrenteDAO aux = new ContaCorrenteDAO();
            aux.inserir(contaCorrente);
            return true;
         } else{
            return false;
        }
    }

    public boolean cadastrarCliente(Cliente cliente) {
        if (Validacao.validarCliente(cliente)) {
            ClienteDAO cl = new ClienteDAO();
            cl.inserir(cliente);
            return true;
        } else{
            return false;
        }
    }

    public boolean criarDepartamento(Departamento dep) {

        if (Validacao.validarDepartamento(dep)) {
            DepartamentoDAO dao = new DepartamentoDAO();
            dao.inserir(dep);
            return true;
        } else{
            return false;
        }
    }

    public boolean levantar(Movimentos movimento, int idConta, float valor) {

        if (ValidacaoDados.validarIdContaCorrente(idConta)) {
            MovimentosDAO mov = new MovimentosDAO();
            ContaCorrenteDAO conta_c = new ContaCorrenteDAO();
            ContaPoupancaDAO conta_p = new ContaPoupancaDAO();
            mov.inserir(movimento);
            conta_c.reduzirSaldo(idConta, valor * (1 - movimento.getTaxa()));
            conta_p.levantar(idConta);
            return true;
        } else {
            return false;
        }
    }

    public boolean transferirValor(Movimentos movimento, int id_Emissor, int id_Receptor, float valor) {
        if (ValidacaoDados.validarIdContaCorrente(id_Emissor) && (ValidacaoDados.validarIdContaCorrente(id_Receptor)
                || ValidacaoDados.validarIdContaPoupanca(id_Receptor))) {
            MovimentosDAO mov = new MovimentosDAO();
            ContaCorrenteDAO conta1 = new ContaCorrenteDAO();
            ContaCorrenteDAO conta_c = new ContaCorrenteDAO();
            mov.inserir(movimento);
            conta1.reduzirSaldo(id_Emissor, valor);
            conta_c.aumentarSaldo(id_Receptor, valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean depositarCorrente(Movimentos movimento, int idConta, float valor) {
        if ((ValidacaoDados.validarIdContaCorrente(idConta) )) {
            MovimentosDAO mov = new MovimentosDAO();
            ContaCorrenteDAO conta_c = new ContaCorrenteDAO();
            mov.inserir(movimento);
            conta_c.aumentarSaldo(idConta, valor);
            return true;
        } else{
            return false;
        }
    }
    

    public boolean depositarPoupanca(Movimentos movimento, int idConta, float valor) {
       if (ValidacaoDados.validarIdContaPoupanca(idConta)) {
        MovimentosDAO mov = new MovimentosDAO();
        ContaPoupancaDAO conta_p = new ContaPoupancaDAO();
        mov.inserir(movimento);
        conta_p.aumentarSaldo(idConta, valor);
        return true;
       } else{
           return false;
       }

    }

    public float verificarSaldoCorrente(Movimentos movimento, int idConta) {
        ContaCorrenteDAO conta = new ContaCorrenteDAO();
        MovimentosDAO mov = new MovimentosDAO();
        ArrayList<ContaCorrente> lista = conta.todos();
        try {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getIdConta() == idConta) {
                    mov.inserir(movimento);
                    return lista.get(i).getSaldo();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Introduziu dados nao validos!");
        }
        return -1;
    }

    public float verificarSaldoPoupanca(Movimentos movimento, int idConta) {
        ContaPoupancaDAO conta = new ContaPoupancaDAO();
        MovimentosDAO mov = new MovimentosDAO();
        ArrayList<ContaPoupanca> lista = conta.todos();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdConta() == idConta) {
                mov.inserir(movimento);
                return lista.get(i).getSaldo();
            }
        }
        return 0;
    }

    public ArrayList<Movimentos> historico_movimentos_tipo(String tipo) {
        MovimentosDAO mov = new MovimentosDAO();
        ArrayList<Movimentos> list = new ArrayList();
        ArrayList<Movimentos> auxiliar = new ArrayList();
        try {
            list = mov.todos();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getTipo().equalsIgnoreCase(tipo)) {
                    auxiliar.add(list.get(j));
                }
            }
            return auxiliar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos");
        }
        return auxiliar;
    }

    public ArrayList<Movimentos> historico_movimentos_data(LocalDate date) {
        MovimentosDAO mov = new MovimentosDAO();
        ArrayList<Movimentos> list = new ArrayList();
        ArrayList<Movimentos> auxiliar = new ArrayList();
        try {
            list = mov.todos();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getDataMovimento().equals(date)) {
                    auxiliar.add(list.get(j));
                }
            }
            return auxiliar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos:" + e);
        }
        return auxiliar;
    }

    public ArrayList<Movimentos> historico_movimentos_IdMovimento(int id) {
        MovimentosDAO mov = new MovimentosDAO();
        ArrayList<Movimentos> list = new ArrayList();
        ArrayList<Movimentos> auxiliar = new ArrayList();
        try {
            list = mov.todos();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getIdMovimentos() == id) {
                    auxiliar.add(list.get(j));
                }
            }
            return auxiliar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos:" + e);
        }
        return auxiliar;
    }

    public ArrayList<Cliente> historico_cliente_nome(String nome) {
        ClienteDAO cliente = new ClienteDAO();
        ArrayList<Cliente> list = new ArrayList();
        ArrayList<Cliente> auxiliar = new ArrayList();
        try {
            list = cliente.todos();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getNome().equalsIgnoreCase(nome)) {
                    auxiliar.add(list.get(j));
                }
            }
            return auxiliar;
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos");
        }
        return auxiliar;
    }

//    public void apagarMovimentos(int id) {
//        MovimentosDAO mov = new MovimentosDAO();
//        mov.apagar(id);
//    }
    public boolean apagarCliente(int id) {
        if(ValidacaoDados.validarIdCliente(id)){
        ClienteDAO cl = new ClienteDAO();
        cl.apagar(id);
        return true;
        }else{
            return false;
        }
    }

    // receber cliente
    public void actualizarCliente(int idCliente, String b, String c, String ec, String email, String rua, int tel1, int tel2) {
        ClienteDAO cliente = new ClienteDAO();
        cliente.actualizarCliente(idCliente, b, c, ec, email, rua, tel1, tel2);
    }
    
    public void apagarFuncionario(int id) {
        TrabalhadorDAO cl = new TrabalhadorDAO();
        cl.apagar(id);
    }

  

    public boolean validarSenhaCliente(int id, int senha, String tipo) throws IOException {
        FicheiroTexto fich = new FicheiroTexto();
        ArrayList<Senha> list = fich.lerFicheiroTxt("senhasClientes.txt");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id && list.get(i).getSenha() == senha && list.get(i).getTipoConta().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarSenhaFuncionario(int id, int senha) throws IOException {
        FicheiroTexto fich = new FicheiroTexto();
        ArrayList<Senha> list = fich.lerFicheiroTxt("senhaFuncionarios.txt");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id && list.get(i).getSenha() == senha) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Trabalhador> historico_funcionario_nome(String nome) {
        TrabalhadorDAO trab = new TrabalhadorDAO();
        ArrayList<Trabalhador> list = new ArrayList();
        ArrayList<Trabalhador> auxiliar = new ArrayList();
        try {
            list = trab.todos();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getNome().equalsIgnoreCase(nome)) {
                    auxiliar.add(list.get(j));
                }
            }
            return auxiliar;
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduziu dados invalidos");
        }
        return auxiliar;
    }
    public void actualizarFuncionario(Trabalhador trab) {
        TrabalhadorDAO t = new TrabalhadorDAO();
        t.actualizar(trab);
    }
    

}
