package trab_final;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	    private List<Cartao> cartoes;

	    public Sistema() {
	        this.cartoes = new ArrayList<>();
	    }

	    public void atualizarSaldo(int cartaoId, double valor) {
	        Cartao cartao = buscarCartao(cartaoId);
	        if (cartao != null) {
	            cartao.atualizarSaldo(valor);
	            JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Cartão não encontrado.");
	        }
	    }

	    public void cadastrarCartao(Cartao cartao) {
	        cartoes.add(cartao);
	        JOptionPane.showMessageDialog(null, "Cartão cadastrado com sucesso.");
	    }

	    public void extrato(int cartaoId) {
	        Cartao cartao = buscarCartao(cartaoId);

	        if (cartao != null) {
		        String saldo = "Você tem " + cartao.getSaldo() + " de saldo\n";
	            String extrato = "Extrato do Cartão #" + cartao.getCartaoId() + ":\n";
	            extrato += cartao.getExtrato();
	            JOptionPane.showMessageDialog(null, saldo + "\n" + extrato);
	        } else {
	            JOptionPane.showMessageDialog(null, "Cartão não encontrado.");
	        }
	    }

	    public void movimentacaoSaida(int cartaoId, double valor, String descricao, String categoria) {
	        Cartao cartao = buscarCartao(cartaoId);
	        if (cartao != null) {
	            double totalSaida = cartao.somarMovimentacoesSaida() + valor;
	            if(cartao.getLimiteGastos() == 0) {
	                JOptionPane.showMessageDialog(null, "Lembre-se de registrar o limite de gastos.");
	            }
	            else if (totalSaida > cartao.getLimiteGastos()) {
	                JOptionPane.showMessageDialog(null, "Movimentação de saída excede o limite de gastos.");
	            } else {
	                Movimentacao movimentacao = new Movimentacao(-valor, descricao, categoria);
	                cartao.adicionarMovimentacao(movimentacao);
	                cartao.atualizarSaldo(-valor);
	                JOptionPane.showMessageDialog(null, "Movimentação de saída registrada com sucesso.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Cartão não encontrado.");
	        }
	    }


	    public void movimentacaoEntrada(int cartaoId, double valor, String descricao, String categoria) {
	        Cartao cartao = buscarCartao(cartaoId);
	        if (cartao != null) {
	            Movimentacao movimentacao = new Movimentacao(valor, descricao, categoria);
	            cartao.adicionarMovimentacao(movimentacao);
	            cartao.atualizarSaldo(valor);
	            JOptionPane.showMessageDialog(null, "Movimentação de entrada registrada com sucesso.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Cartão não encontrado.");
	        }
	    }

	    public void registrarLimiteGastos(int cartaoId, double limite) {
	        Cartao cartao = buscarCartao(cartaoId);
	        if (cartao != null) {
	            cartao.setLimiteGastos(limite);
	            JOptionPane.showMessageDialog(null, "Limite de gastos registrado com sucesso.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Cartão não encontrado.");
	        }
	    }

	    private Cartao buscarCartao(int cartaoId) {
	        for (Cartao cartao : cartoes) {
	            if (cartao.getCartaoId() == cartaoId) {
	                return cartao;
	            }
	        }
	        return null;
	    }
}
