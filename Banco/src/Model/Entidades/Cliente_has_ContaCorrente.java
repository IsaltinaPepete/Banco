
package Model.Entidades;

/**
 *
 * @author Thole
 */
public class Cliente_has_ContaCorrente {
    
    private int idCliente;
    private int idConta;

    public Cliente_has_ContaCorrente(int idCliente, int idConta) {
        this.idCliente = idCliente;
        this.idConta = idConta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
    
    
}
