/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2022;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author renato
 */
public class Banco2022 {
    
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Conta> banco = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        String menu = "1 - Adicionar conta\n";
        menu += "2 - Exibir contas\n";
        menu += "3 - Remover conta\n";
        menu += "4 - Alterar conta\n";
        menu += "5 - Depositar em conta\n";
        menu += "6 - Sacar da conta\n";
        menu += "7 - Transferir para conta\n";
        menu += "8 - Sair\n\n";
        menu += "Escolha uma opção: ";
        int opcao = 0;
        
        do{
            System.out.print(menu);
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:{
                    escolherTipoConta();
                    break;
                }
                case 2:{
                    exibirContas();
                    break;
                }
                case 3:{
                    removerConta();
                    break;
                }
                case 4:{
                    alterarConta();
                    break;
                }
                case 5:{
                    depositarEmConta();
                    break;
                }
                case 6:{
                    sacarDaConta();
                    break;
                }
                case 7:{
                    transferirParaConta();
                    break;
                }
            }
        }while(opcao < 8);
        
    }
    
    public static void escolherTipoConta(){
        String menu = "1 - Conta Corrente\n";
        menu += "2 - Conta Poupança\n";
        menu += "3 - Voltar\n\n";
        
        menu += "Escolha uma opção: ";
        int opcao = 0;
        
        do{
            System.out.print(menu);
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:{
                    adicionarContaCorrente();
                    break;
                }
                case 2:{
                    adicionarContaPoupanca();
                    break;
                }
            }
            
        }while(opcao < 3);
    }
    
    public static void adicionarContaCorrente(){
        ContaCorrente cc = new ContaCorrente();
        preencherConta(cc);
        if (cc.getTitular() != null){
            System.out.print("Informe o limite: ");
            cc.setLimite(entrada.nextDouble());
            banco.add(cc);
        }
    }
    
    public static void adicionarContaPoupanca(){
        ContaPoupanca cp = new ContaPoupanca();
        preencherConta(cp);
        if (cp.getTitular() != null){
            System.out.print("Informe a variação: ");
            cp.setVariacao(entrada.nextInt());
            banco.add(cp);
        }
    }
    
    private static void preencherConta(Conta conta){
        System.out.print("Informe o número: ");
        conta.setNumero(entrada.next());
        if (banco.indexOf(conta) < 0){
            entrada.nextLine();
            System.out.print("Informe o titular: ");
            conta.setTitular(entrada.nextLine());
            System.out.print("Informe o saldo: ");
            conta.setSaldo(entrada.nextDouble());
        }else{
            System.out.println("Número de Conta já cadastrado");
        }
    }

    private static void exibirContas() {
        for (Conta conta : banco) {
            System.out.println(conta);
        }
    }
    
    private static int buscaPosicaoConta(String complemento){
        ContaCorrente cc = new ContaCorrente();
        System.out.print("Informe o número da conta"+complemento+": ");
        cc.setNumero(entrada.next());
        return banco.indexOf(cc);
    }

    private static void removerConta() {
        int posicao = buscaPosicaoConta(" a ser removida");
        if (posicao < 0){
            System.out.println("Conta não encontrada");
        }else{
            banco.remove(posicao);
            System.out.println("Conta removida com sucesso");
        }
    }
    
    private static void alterarConta() {
        int posicao = buscaPosicaoConta(" a ser alterada");
        if (posicao < 0){
            System.out.println("Conta não encontrada");
        }else{
            Conta conta  = banco.get(posicao);
            if (conta instanceof ContaCorrente){
                ContaCorrente cc = (ContaCorrente)conta;
                System.out.print("Informe o titular: ");
                cc.setTitular(entrada.nextLine());
                System.out.print("Informe o saldo: ");
                cc.setSaldo(entrada.nextDouble());
                System.out.print("Informe o limite: ");
                cc.setLimite(entrada.nextDouble());
                banco.set(posicao, cc);
                System.out.println("Conta alterada com sucesso");
            }else{
                ContaPoupanca cp = (ContaPoupanca)conta;
                System.out.print("Informe o titular: ");
                cp.setTitular(entrada.nextLine());
                System.out.print("Informe o saldo: ");
                cp.setSaldo(entrada.nextDouble());
                System.out.print("Informe a variação: ");
                cp.setVariacao(entrada.nextInt());
                banco.set(posicao, cp);
                System.out.println("Conta alterada com sucesso");
            }
        }
    }

    private static int getNumeroUltimaConta(){
        return Integer.parseInt(banco.get(banco.size()-1).getNumero());
    }

    private static void depositarEmConta() {
        int posicao = buscaPosicaoConta(" para depósito");
        if (posicao < 0){
            System.out.println("Conta não encontrada");
        }else{
            System.out.print("Informe o valor a ser depositado:");
            double valor = entrada.nextDouble();
            banco.get(posicao).depositar(valor);
            System.out.println("Depósito realizado com sucesso");
        }
    }

    private static void sacarDaConta() {
        int posicao = buscaPosicaoConta(" que deseja sacar");
        if (posicao < 0){
            System.out.println("Conta não encontrada");
        }else{
            System.out.print("Informe o valor a ser sacado:");
            double valor = entrada.nextDouble();
            if (banco.get(posicao).sacar(valor)){
                System.out.println("Saque realizado com sucesso");
            }else{
                System.out.println("Saldo insuficiente");
            }
        }
    }

    private static void transferirParaConta() {
        int pos_origem = buscaPosicaoConta(" de origem");
        if (pos_origem < 0){
            System.out.println("Conta de origem não encontrada");
        }else{
            int pos_destino = buscaPosicaoConta(" de destino");
            if (pos_destino < 0){
                System.out.println("Conta de destino não encontrada");
            }else{
                System.out.print("Informe o valor a ser transferido:");
                double valor = entrada.nextDouble();
                if (banco.get(pos_origem).transferir(banco.get(pos_destino), valor)){
                    System.out.println("Transferencia realizada com sucesso");
                }else{
                    System.out.println("Saldo insuficiente na conta de origem");
                }
            }
        }
    }
}
