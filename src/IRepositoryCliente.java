
import java.util.ArrayList;

/**
 *
 * @author Renato Nunes
 */
public interface IRepositoryCliente {
    public  void cadastrarCliente(Cliente cliente);
    public  ArrayList<Cliente> listarClientes();
    public  Cliente buscarCliente(String codigoCli);
    public  void atualizarCliente(Cliente cliente);
    public  void removerCliente(Cliente cliente);
    public ArrayList<Cliente> listarClientesAll(ArrayList<Cliente> arrayClientesAll);
   
    
}
