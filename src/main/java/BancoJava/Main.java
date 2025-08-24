package BancoJava;

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numConta;
        String tipoConta;
        String nomeDono; 
        BigDecimal saldo;
    
        System.out.println("Seja bem vindo(a)! Digite seu nome, por gentileza: ");
        nomeDono = scanner.nextLine();        
        while(nomeDono.equals("")){
            System.out.println("Insira seu nome por favor: ");
            nomeDono = scanner.nextLine();
        }
          
        System.out.println("Insira o tipo da conta desejada: (corrente ou poupanca): ");
        tipoConta = scanner.nextLine();
        
        while(!tipoConta.equals("corrente") && !tipoConta.equals("poupanca")){
            System.out.println("Erro: tipo de conta invalido: " + tipoConta + ". Tente novamente: ");
            tipoConta = scanner.nextLine();
        }
        
        
        System.out.println("Insira o numero da sua conta (entre 4 a 6 digitos):");
        numConta = scanner.nextInt();
        int tamanhoNumConta = String.valueOf(numConta).length();
        while(tamanhoNumConta < 4 || tamanhoNumConta > 6){
            System.out.println("Erro: numero da conta invalido: " + tamanhoNumConta + "\n\"Insira o numero da sua conta (entre 4 a 6 digitos):\"");
            numConta = scanner.nextInt();
            tamanhoNumConta = String.valueOf(numConta).length();
        }
        
        System.out.println("Entre com o saldo inicial da sua conta: ");
        saldo = scanner.nextBigDecimal();
        while(saldo.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("Saldo inicial nao pode ser negativo: " + saldo + "\nInsira novamente o saldo inicial desejado:");
            saldo = scanner.nextBigDecimal();
        }
        
        if(tipoConta.equals("corrente")){
            ContaBanco contaCorrente = new ContaCorrente(numConta, tipoConta, nomeDono, saldo);
            System.out.println("Conta criada com sucesso!\nStatus da sua conta: ");
            contaCorrente.verStatus();            
        }
        else if(tipoConta.equals("poupanca")){
            ContaBanco contaPoupanca = new ContaPoupanca(numConta, tipoConta, nomeDono, saldo);
            System.out.println("Conta criada com sucesso!\nStatus da sua conta: ");
            contaPoupanca.verStatus();
        }        
    }
}


