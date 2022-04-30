/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2022;

import java.util.ArrayList;

/**
 *
 * @author renato
 */
public class Teste {
    
    public static void main(String[] args) {
        ArrayList<Conta> lista = new ArrayList<>();
        
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        
        cc.setNumero("1");
        cc.setTitular("Renato");
        cc.setSaldo(100);
        cc.setLimite(100);
        
        cp.setNumero("2");
        cp.setTitular("Mateus");
        cp.setSaldo(500);
        cp.setVariacao(51);
        
        lista.add(cc);
        lista.add(cp);
        
        for (Conta conta : lista) {
            System.out.println(conta.toString());
        }
    }
    
}
