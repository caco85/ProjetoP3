
import java.util.ArrayList;
/**
 *
 * @author Renato Nunes
 */
public interface IRepositoryVenda {

    public void addProduto(Produto produto);

    public ArrayList<Produto> listarProdutosVenda();

    public Produto buscarProdutoVenda(String idProduto);

    public void removerProdutoVenda(Produto produto);

    public ArrayList<Produto> listarProdutosAllCarrinho(ArrayList<Produto> listarProdutosAllCarrinho);
    public void calcularVenda(ArrayList<Produto> listarProdutosAllCarrinho) ;

}
