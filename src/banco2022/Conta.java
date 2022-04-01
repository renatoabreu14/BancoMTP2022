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
public class Conta {
    
    private String numero;
    private String titular;
    private double saldo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String toString(){
        String retorno = "Número: " + this.numero + "\n";
        retorno += "Titular: " + this.titular + "\n";
        retorno += "Saldo: " + this.saldo + "\n";
        return retorno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Conta){
            Conta conta = (Conta) obj;
            if (this.getNumero().equals(conta.getNumero())){
                return true;
            }
        }
        return false;
    }
    
    
    
}
