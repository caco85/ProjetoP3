
import java.util.ArrayList;

public interface IRepositoryFuncionario {

    public void cadastrarFuncionario(Funcionario funcionario);

    public ArrayList<Funcionario> listarFuncionarios();

    public Funcionario buscarFuncionario(String idFuncionario);

    public void atualizarFuncionario(Funcionario funcionario);

    public void removerFuncionario(Funcionario funcionario);
    public ArrayList<Funcionario> listarFuncionariosAll(ArrayList<Funcionario> arrayFuncionariosAll);
}
