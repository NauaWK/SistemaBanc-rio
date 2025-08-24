package BancoJava;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBanco {
    
    public ContaPoupanca(int numConta, String tipoConta, String nomeDono, BigDecimal saldo){
        super(numConta, tipoConta, nomeDono, saldo);
        this.saldo = saldo.add(BigDecimal.valueOf(150));
    }
    
    @Override
    public void pagarMensalidade(){
        saldo = saldo.subtract(BigDecimal.valueOf(20));
    }
}
