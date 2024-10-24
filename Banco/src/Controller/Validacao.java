/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entidades.Cliente;
import Model.Entidades.ContaCorrente;
import Model.Entidades.ContaPoupanca;
import Model.Entidades.Departamento;
import Model.Entidades.Movimentos;
import Model.Entidades.Trabalhador;
import javax.swing.JOptionPane;

/**
 *
 * @author Itsa Pepete
 */
public class Validacao {

   
    static boolean validarTrablhador(Trabalhador trab) {
        if (ValidacaoDados.validarString(trab.getNome()) && ValidacaoDados.validarString(trab.getApelido())
                && ValidacaoDados.validarString(trab.getCargo()) && ValidacaoDados.validarString(trab.getBairro())
                && ValidacaoDados.validarString(trab.getCidade())
                && ValidacaoDados.validarString(trab.getRua()) && ValidacaoDados.validarString(trab.getEstadoCivil())
                && ValidacaoDados.validarString(trab.getNacionalidade()) && ValidacaoDados.validarEmail(trab.getEmail())
                && ValidacaoDados.validarTelefone(trab.getTelefone1()) && ValidacaoDados.validarTelefone(trab.getTelefone2())
                && ValidacaoDados.validarString(trab.getNrBi()) && ValidacaoDados.validarString(trab.getGenero())) {
            return true;
        }
        return false;
    }

    static boolean validarActualizacaoCliente(int idCliente, String b, String c, String ec, String email, String rua, int tel1, int tel2) {
        if (ValidacaoDados.validarString(b) && ValidacaoDados.validarString(c) && ValidacaoDados.validarString(ec)
                && ValidacaoDados.validarEmail(email) && ValidacaoDados.validarString(rua) && ValidacaoDados.validarTelefone(tel1)
                && ValidacaoDados.validarTelefone(tel2)) {
            return true;
        }
        return false;
    }

    static Exception excepcao(String str) {
        if (str.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Dados invalidos!");
            throw new NullPointerException();
        }
        return new Exception();
    }

    static boolean validarPoupanca(ContaPoupanca contaPoupanca) {
        if (ValidacaoDados.validarString(contaPoupanca.getTempoLimite().toString())
                && ValidacaoDados.validarIdContaPoupanca(contaPoupanca.getIdConta())
                && ValidacaoDados.validarIdCliente(contaPoupanca.getIdTitular1())
                && ValidacaoDados.validarIdCliente(contaPoupanca.getIdTitular2())
                && ValidacaoDados.validarIdCliente(contaPoupanca.getIdTitular3())) {
            return true;
        } else {
            return false;
        }
    }
//int idConta, int idTitular1, int idTitular2, int idTitular3, float saldo

    static boolean validarCorrente(ContaCorrente contaCorrente) {
        if (ValidacaoDados.validarIdContaCorrente(contaCorrente.getIdConta())
                && ValidacaoDados.validarIdCliente(contaCorrente.getIdTitular1())
                && ValidacaoDados.validarIdCliente(contaCorrente.getIdTitular2())
                && ValidacaoDados.validarIdCliente(contaCorrente.getIdTitular3())) {
            return true;
        } else {
            return false;
        }
    }

    static boolean validarCliente(Cliente cliente) {
        if (ValidacaoDados.validarString(cliente.getNome()) && ValidacaoDados.validarString(cliente.getApelido())
                && ValidacaoDados.validarString(cliente.getBairro()) && ValidacaoDados.validarString(cliente.getCidade())
                && ValidacaoDados.validarEmail(cliente.getEmail()) && ValidacaoDados.validarString(cliente.getRua())
                && ValidacaoDados.validarString(cliente.getEstadoCivil()) && ValidacaoDados.validarString(cliente.getNacionalidade())
                && ValidacaoDados.validarTelefone(cliente.getTelefone1()) && ValidacaoDados.validarTelefone(cliente.getTelefone2())
                && ValidacaoDados.validarString(cliente.getNrBi()) && ValidacaoDados.validarString(cliente.getGenero())) {
            return true;

        }
        return false;
    }

    public static boolean validarDepartamento(Departamento dep) {
        if(ValidacaoDados.validarString(dep.getNomeDepartamento()) && ValidacaoDados.validarIdFuncionarioDep(dep.getIdChefeDepartamento())){
              return true;
        }
       return false;
    }

    static boolean validarMovimentos(Movimentos mov) {
        if (ValidacaoDados.validarString(mov.getTipo())) {
            return true;
        }
        return false;
    }

}
