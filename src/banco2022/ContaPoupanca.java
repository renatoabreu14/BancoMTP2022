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
public class ContaPoupanca extends Conta{
    
    private int variacao;

    public int getVariacao() {
        return variacao;
    }

    public void setVariacao(int variacao) {
        this.variacao = variacao;
    }

    @Override
    public boolean sacar(double valor) {
        if ((this.getSaldo() - valor) >= 0){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String retorno = super.toString(); 
        retorno += "Variação: " + this.variacao + "\n";
        return retorno;
    }
}
