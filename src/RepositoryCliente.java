import java.util.ArrayList;

/**
 *
 * @author Renato Nunes
 */
public class RepositoryCliente implements IRepositoryCliente {

    private ArrayList<Cliente> arrayClientes;

    public RepositoryCliente() {
        if (this.arrayClientes == null) {
            this.arrayClientes = new ArrayList<>();
        }
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        this.arrayClientes.add(cliente);
        System.out.println("");
        System.out.println("Cadastro efetuado com sucesso");
        System.out.println("");
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        return this.arrayClientes;
    }

    @Override
    public Cliente buscarCliente(String codigoCli) {
        Cliente cliente = null;

        for (int i = 0; i < this.arrayClientes.size(); i++) {
            if (this.arrayClientes.get(i).getCodigoCliente().equals(codigoCli)) {
                cliente = this.arrayClientes.get(i);
                break;
            }
        }
        return cliente;
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        for (int i = 0; i < arrayClientes.size(); i++) {
            if (arrayClientes.get(i) == cliente) {
                arrayClientes.set(i, cliente);
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente n�o localizado");
        }
    }

    @Override
    public void removerCliente(Cliente cliente) {
        for (int i = 0; i < this.arrayClientes.size(); i++) {
            if (this.arrayClientes.get(i) == cliente) {
                this.arrayClientes.remove(i);
                break;
            }
        }
    }

    public ArrayList<Cliente> listarClientesAll(ArrayList<Cliente> arrayClientesAll) {
        if (arrayClientesAll != null) {

            for (int i = 0; i < arrayClientesAll.size(); i++) {
                arrayClientesAll.get(i);
                System.out.println("Codigo do Cliente : " + arrayClientesAll.get(i).getCodigoCliente() + "Nome do Cliente : "
                        + arrayClientesAll.get(i).getNome() + "Email :" + arrayClientesAll.get(i).getEmail() + " Telefone"
                        + arrayClientesAll.get(i).getTelefone() + " " + arrayClientesAll.get(i).getEndereco());

            }
        }
        return arrayClientesAll;
    }

}
