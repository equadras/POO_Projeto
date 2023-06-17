package trab_final;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Movimentacao {
	    private double valor;
	    private String descricao;
	    private String categoria;

	    public double getValor() {
			return valor;
		}

		public Movimentacao(double valor, String descricao, String categoria) {
	        this.valor = valor;
	        this.descricao = descricao;
	        this.categoria = categoria;
	    }
	    
	    @Override
	    public String toString() {
	        return "Valor: " + valor + " | Descrição: " + descricao + " | Categoria: " + categoria;
	    }

}
