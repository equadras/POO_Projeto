
package trab_final;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
public class Main {

	
	public static void main(String[] args) {
		 Sistema sistema = new Sistema();

	        boolean sair = false;
	        while (!sair) {
	            String opcao = JOptionPane.showInputDialog(
	                    "========= Menu Principal =========\n" +
	                    "1. Atualizar Saldo\n" +
	                    "2. Cadastrar Cartão\n" +
	                    "3. Extrato\n" +
	                    "4. Registrar Movimentação de Saída\n" +
	                    "5. Registrar Movimentação de Entrada\n" +
	                    "6. Registrar Limite de Gastos\n" +
	                    "0. Sair\n\n" +
	                    "Selecione uma opção:"
	            );

	            switch (opcao) {
	                case "1":
	                    int cartaoIdSaldo = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cartão:"));
	                    double valorSaldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser atualizado:"));
	                    sistema.atualizarSaldo(cartaoIdSaldo, valorSaldo);
	                    break;

	                case "2":
	                    int cartaoIdCadastro = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cartão:"));
	                    Cartao cartao = new Cartao(cartaoIdCadastro);
	                    sistema.cadastrarCartao(cartao);
	                    break;

	                case "3":
	                    int cartaoIdExtrato = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cartão:"));
	                    sistema.extrato(cartaoIdExtrato);
	                    break;

	                case "4":
	                    int cartaoIdSaida = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cartão:"));
	                    double valorSaida = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da movimentação de saída:"));
	                    String descricaoSaida = JOptionPane.showInputDialog("Informe a descrição da movimentação de saída:");
	                    String categoriaSaida = JOptionPane.showInputDialog("Informe a categoria da movimentação de saída:");
	                    sistema.movimentacaoSaida(cartaoIdSaida, valorSaida, descricaoSaida, categoriaSaida);
	                    break;

	                case "5":
	                    int cartaoIdEntrada = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cartão:"));
	                    double valorEntrada = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da movimentação de entrada:"));
	                    String descricaoEntrada = JOptionPane.showInputDialog("Informe a descrição da movimentação de entrada:");
	                    String categoriaEntrada = JOptionPane.showInputDialog("Informe a categoria da movimentação de entrada:");
	                    sistema.movimentacaoEntrada(cartaoIdEntrada, valorEntrada, descricaoEntrada, categoriaEntrada);
	                    break;

	                case "6":
	                    int cartaoIdLimite = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cartão:"));
	                    double limiteGastos = Double.parseDouble(JOptionPane.showInputDialog("Informe o limite de gastos:"));
	                    sistema.registrarLimiteGastos(cartaoIdLimite, limiteGastos);
	                    break;

	                case "0":
	                    sair = true;
	                    break;

	                default:
	                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, selecione uma opção válida.");
	                    break;
	            }
	        }

	        JOptionPane.showMessageDialog(null, "Sistema encerrado.");
	}

}
