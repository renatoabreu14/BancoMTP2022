/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2022;

/**
 *
 * @author renato
 */
public class ContaCorrente extends Conta{
    
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (((this.getSaldo() + this.getLimite()) - valor) >= 0){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String retorno = super.toString(); 
        retorno += "Limite: " + this.limite + "\n";
        return retorno;
    }
    
    
}
