
import java.util.ArrayList;

public interface IRepositoryProduto {

    public void cadastrarProduto(Produto produto);

    public ArrayList<Produto> listarProduto();

    public Produto buscarProduto(String idProduto);

    public void atualizarProduto(Produto produto);

    public void removerProduto(Produto produto);
    public ArrayList<Produto> listarProdutosAll(ArrayList<Produto> listarProdutosAll);
}
