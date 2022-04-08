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
                    adicionarConta();
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
    
    public static void adicionarConta(){
        Conta conta = new Conta();
        System.out.print("Informe o número: ");
        conta.setNumero(entrada.next());
        if (banco.indexOf(conta) < 0){
            entrada.nextLine();
            System.out.print("Informe o titular: ");
            conta.setTitular(entrada.nextLine());
            System.out.print("Informe o saldo: ");
            conta.setSaldo(entrada.nextDouble());
            banco.add(conta);
        }else{
            System.out.println("Número de Conta já cadastrado");
        }
    }

    private static void exibirContas() {
        for (Conta conta : banco) {
            System.out.println(conta);
        }
    }

    private static void removerConta() {
        Conta conta = new Conta();
        System.out.print("Informe o número da conta a ser removida: ");
        conta.setNumero(entrada.next());
        int posicao = banco.indexOf(conta);
        if (posicao < 0){
            System.out.println("Conta não encontrada");
        }else{
            banco.remove(posicao);
            System.out.println("Conta removida com sucesso");
        }
    }
    
    private static void alterarConta() {
        Conta conta = new Conta();
        System.out.print("Informe o número da conta a ser alterada: ");
        conta.setNumero(entrada.next());
        int posicao = banco.indexOf(conta);
        if (posicao < 0){
            System.out.println("Conta não encontrada");
        }else{
            entrada.nextLine();
            System.out.print("Informe o titular: ");
            conta.setTitular(entrada.nextLine());
            System.out.print("Informe o saldo: ");
            conta.setSaldo(entrada.nextDouble());
            banco.set(posicao, conta);
            System.out.println("Conta alterada com sucesso");
        }
    }

    private static int getNumeroUltimaConta(){
        return Integer.parseInt(banco.get(banco.size()-1).getNumero());
    }

    private static void depositarEmConta() {
        Conta conta = new Conta();
        System.out.print("Informe o número da conta que deseja efetuar o depósito: ");
        conta.setNumero(entrada.next());
        int posicao = banco.indexOf(conta);
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
        Conta conta = new Conta();
        System.out.print("Informe o número da conta que deseja efetuar o saque: ");
        conta.setNumero(entrada.next());
        int posicao = banco.indexOf(conta);
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
        Conta origem = new Conta();
        System.out.print("Informe o número da conta de origem: ");
        origem.setNumero(entrada.next());
        int pos_origem = banco.indexOf(origem);
        if (pos_origem < 0){
            System.out.println("Conta de origem não encontrada");
        }else{
            Conta destino = new Conta();
            System.out.print("Informe o número da conta de destino: ");
            destino.setNumero(entrada.next());
            int pos_destino = banco.indexOf(destino);
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
