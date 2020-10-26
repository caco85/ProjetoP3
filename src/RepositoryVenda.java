
import java.util.ArrayList;

/**
 *
 * @author Renato Nunes
 */
public class RepositoryVenda implements IRepositoryVenda {

    private ArrayList<Produto> arrayCarrinho;

    public RepositoryVenda() {
        if (this.arrayCarrinho == null) {
            this.arrayCarrinho = new ArrayList<>();
        }
    }

    @Override
    public void addProduto(Produto produto) {

        this.arrayCarrinho.add(produto);

        System.out.println("");
        System.out.println("Produto adicionado ao carrinho com sucesso");
        System.out.println("");
    }

    @Override
    public ArrayList<Produto> listarProdutosVenda() {
        return this.arrayCarrinho;
    }

    @Override
    public Produto buscarProdutoVenda(String idProduto) {
        Produto produto = null;
        for (int i = 0; i < this.arrayCarrinho.size(); i++) {
            if (this.arrayCarrinho.get(i).getIdProduto().equals(idProduto)) {
                produto = this.arrayCarrinho.get(i);
                break;
            }
        }
        return produto;
    }

    @Override
    public void removerProdutoVenda(Produto produto) {
        for (int i = 0; i < this.arrayCarrinho.size(); i++) {
            if (this.arrayCarrinho.get(i) == produto) {
                this.arrayCarrinho.remove(i);
                break;
            }
        }
    }

    public ArrayList<Produto> listarProdutosAllCarrinho(ArrayList<Produto> listarProdutosAllCarrinho) {
        if (listarProdutosAllCarrinho != null) {

            for (int i = 0; i < listarProdutosAllCarrinho.size(); i++) {
                listarProdutosAllCarrinho.get(i);
                System.out.println("Id Produto : " + listarProdutosAllCarrinho.get(i).getIdProduto() + "Descri��o: "
                        + listarProdutosAllCarrinho.get(i).getDescricao() + "Valor  :" + listarProdutosAllCarrinho.get(i).getValor());

            }
        }
        return listarProdutosAllCarrinho;
    }

    @Override
    public void calcularVenda(ArrayList<Produto> listarProdutosAllCarrinho) {
        double valorTotal = 0;
        if (listarProdutosAllCarrinho != null) {
            for (int i = 0; i < listarProdutosAllCarrinho.size(); i++) {
                listarProdutosAllCarrinho.get(i);
                valorTotal = (listarProdutosAllCarrinho.get(i).getValor() * listarProdutosAllCarrinho.get(i).getQtdProduto()) + valorTotal;

            }
        }
        System.out.println("O valor total da compra é de: R$" + valorTotal);
    }

}
