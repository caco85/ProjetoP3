
import java.util.ArrayList;

public class Produto {

    private String idProduto;
    private String descricao;
    private double valor;
    private int qtdProduto;
  

    public Produto(String idProduto, String descricao, double valor, int qtd) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdProduto = qtd;
    }

    public Produto() {
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setidProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", descricao=" + descricao + ", valor=" + valor
                + ", qtdProduto=" + qtdProduto + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return this.idProduto == produto.idProduto;
    }
}
