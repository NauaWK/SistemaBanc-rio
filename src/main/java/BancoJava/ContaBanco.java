package BancoJava;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ContaBanco {
    
    //Atributos
    protected int numConta;
    protected String tipoConta;
    protected String nomeDono;
    protected BigDecimal saldo;
    protected boolean status = false;
    
    public ContaBanco(int numConta, String tipoConta, String nomeDono, BigDecimal saldo){
        this.numConta = numConta;
        this.tipoConta = tipoConta;
        this.nomeDono = nomeDono;
        this.saldo = saldo;
        status = true;
    }
  
    //Getters e Setters   
    public int getNumConta(){
        return numConta;
    }
    
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    
    public String getTipo() {
        return tipoConta;
    }
    
    public void setTipo(String tipo) {
        this.tipoConta = tipo;
    }
    
    public String getDono() {
        return nomeDono;
    }
    
    public void setDono(String dono) {
        this.nomeDono = dono;
    }
    
    public BigDecimal getSaldo() {
        return saldo.setScale(2, RoundingMode.HALF_EVEN);
    }
    
    public String isStatus(){
        return status ? "Aberta" : "Fechada";
    }
    
    //Métodos operacionais
    private boolean fecharContaAuto(){
        if(status && saldo.compareTo(BigDecimal.ZERO) == 0){
            status = false;
            return true;
        }
        else{
            return false;
        }
    }
    
    public void depositarSaldo(BigDecimal valor){
        if(status && valor.compareTo(BigDecimal.ZERO) > 0){
            saldo = saldo.add(valor);
        }
    }
  
    public String sacarSaldo(BigDecimal valor){
        if(status && saldo.compareTo(valor) >= 0 && valor.compareTo(BigDecimal.ZERO) > 0){
            saldo = saldo.subtract(valor);
            if(fecharContaAuto()){
                return "Valor sacado: " + valor + "\nConta fechada automaticamente (saldo zerado).";
            }
            else{
                return "Valor sacado: " + valor;
            }
        }
        else{
            return !status ? "Conta inativa." : "Saldo insuficiente ou valor de saque negativo/igual a zero. Valor de saque: " + valor;
        }
    }
    
    public abstract void pagarMensalidade();
  
    //Relatórios para testes  
    public void verStatus(){
        System.out.println("Conta: " + getNumConta());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Dono: " + getDono());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Status: " + isStatus());
    }
}
