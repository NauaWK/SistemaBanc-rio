package BancoJava;

import java.math.BigDecimal;

public class ContaCorrente extends ContaBanco {
    
   
    public ContaCorrente(int numConta, String tipoConta, String nomeDono, BigDecimal saldo){
        super(numConta, tipoConta, nomeDono, saldo);
        this.saldo = saldo.add(BigDecimal.valueOf(50));
    }
    
    @Override
    public void pagarMensalidade(){
        saldo = saldo.subtract(BigDecimal.valueOf(12));
    }
   
}
