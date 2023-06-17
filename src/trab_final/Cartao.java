package trab_final;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Cartao {
	    private int cartaoId;
	    private double saldo;
	    private double limiteGastos;
	    private List<Movimentacao> movimentacoes;

	    public Cartao(int cartaoId) {
	        this.cartaoId = cartaoId;
	        this.saldo = 0.0;
	        this.limiteGastos = 0.0;
	        this.movimentacoes = new ArrayList<>();
	    }

	    public int getCartaoId() {
	        return cartaoId;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void atualizarSaldo(double valor) {
	        this.saldo += valor;
	    }

	    public void adicionarMovimentacao(Movimentacao movimentacao) {
	        movimentacoes.add(movimentacao);
	    }

	    public String getExtrato() {
	        String extrato = "";
	        for (Movimentacao movimentacao : movimentacoes) {
	            extrato += movimentacao.toString() + "\n";
	        }
	        return extrato;
	    }

	    public void setLimiteGastos(double limiteGastos) {
	        this.limiteGastos = limiteGastos;
	    }

	    public double getLimiteGastos(){
	        return limiteGastos;
	    }
	    
	    public double somarMovimentacoesSaida() {
	        double totalSaida = 0.0;
	        for (Movimentacao movimentacao : movimentacoes) {
	            if (movimentacao.getValor() < 0) {
	                totalSaida += movimentacao.getValor();
	            }
	        }
	        return totalSaida;
	    }
	
}
