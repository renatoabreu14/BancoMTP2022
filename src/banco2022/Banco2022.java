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
        menu += "5 - Sair\n\n";
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
                    alterarPalavra();
                    break;
                }
            }
        }while(opcao < 5);
        
        
        /*ArrayList<String> palavras = new ArrayList<>();
        palavras.add("Renato");
        palavras.add("MTP");
        palavras.add("BEE");
        
        //palavras.remove(1);
        
        System.out.print("Informe a palavra a ser alterada: ");
        String alt = entrada.next();
        int posicao = palavras.indexOf(alt);
        if (posicao < 0){
            System.out.println("Palavra nao encontrada");
        }else{
            palavras.set(posicao, "Métodos e Técnicas de Programação");
        }*/
        
        
        
        /*for (int i = 0; i < palavras.size(); i++) {
            System.out.println(palavras.get(i));
            
        }*/
        
        /*for (String palavra: palavras) {
            System.out.println(palavra);
        }*/
        
        /*Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        
        System.out.print("Informe o numero da conta1:");
        conta1.setNumero(entrada.nextLine());
        System.out.print("Informe o titular da conta1:");
        conta1.setTitular(entrada.nextLine()) ;
        System.out.print("Informe o saldo da conta1:");
        conta1.setSaldo(entrada.nextDouble());
        
        entrada.nextLine();
        
        System.out.print("Informe o numero da conta2:");
        conta2.setNumero(entrada.nextLine());
        System.out.print("Informe o titular da conta2:");
        conta2.setTitular(entrada.nextLine()) ;
        System.out.print("Informe o saldo da conta2:");
        conta2.setSaldo(entrada.nextDouble());
        
        System.out.println(conta1.toString());
        System.out.println(conta2.toString());*/
        
    }
    
    public static void adicionarConta(){
        Conta conta = new Conta();
        System.out.print("Informe o número: ");
        conta.setNumero(entrada.next());
        entrada.nextLine();
        System.out.print("Informe o titular: ");
        conta.setTitular(entrada.nextLine());
        System.out.print("Informe o saldo: ");
        conta.setSaldo(entrada.nextDouble());
        
        banco.add(conta);
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
        banco.remove(banco.indexOf(conta));
    }
    
    private static void alterarPalavra() {
        /*System.out.print("Informe a palavra a ser alterada: ");
        String palavra = entrada.next();
        int posicao = palavras.indexOf(palavra);
        if (posicao < 0){
            System.out.println("Palavra não encontrada");
        }else{
            System.out.print("Infore a nova palavra: ");
            palavra = entrada.next();
            palavras.set(posicao, palavra);
        }*/
    }

    
}
