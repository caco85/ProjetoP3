
import java.util.ArrayList;

public class RepositoryProduto implements IRepositoryProduto {

    private ArrayList<Produto> arrayProduto;

    public RepositoryProduto() {
        if (this.arrayProduto == null) {
            this.arrayProduto = new ArrayList<>();
        }
    }

    @Override
    public void cadastrarProduto(Produto produto) {

        this.arrayProduto.add(produto);

        System.out.println("");
        System.out.println("Cadastro efetuado com sucesso");
        System.out.println("");
    }

    @Override
    public ArrayList<Produto> listarProduto() {
        return this.arrayProduto;
    }

    @Override
    public Produto buscarProduto(String idProduto) {
        Produto produto = null;
        for (int i = 0; i < this.arrayProduto.size(); i++) {
            if (this.arrayProduto.get(i).getIdProduto().equals(idProduto)) {
                produto = this.arrayProduto.get(i);
                break;
            }
        }
        return produto;
    }

    @Override
    public void atualizarProduto(Produto produto) {
        for (int i = 0; i < arrayProduto.size(); i++) {
            if (arrayProduto.get(i) == produto) {
                arrayProduto.set(i, produto);
                break;
            }
        }
        if (produto == null) {
            System.out.println("Produto n�o localizado");
        }
    }

    @Override
    public void removerProduto(Produto produto) {
        for (int i = 0; i < this.arrayProduto.size(); i++) {
            if (this.arrayProduto.get(i) == produto) {
                this.arrayProduto.remove(i);
                break;
            }
        }
    }
      public ArrayList<Produto> listarProdutosAll(ArrayList<Produto> listarProdutosAll) {
        if (listarProdutosAll != null) {

            for (int i = 0; i < listarProdutosAll.size(); i++) {
                listarProdutosAll.get(i);
                System.out.println("Id Produto : " + listarProdutosAll.get(i).getIdProduto()+ "Descrição: "
                        + listarProdutosAll.get(i).getDescricao()+ "Valor  :" + listarProdutosAll.get(i).getValor()
                        + " Quantidade em Estoque: " + listarProdutosAll.get(i).getQtdProduto());

            }
        }
        return listarProdutosAll;
    }
}
