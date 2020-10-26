
import java.util.ArrayList;

public class RepositoryFuncionario implements IRepositoryFuncionario {

    private ArrayList<Funcionario> arrayFuncionario;

    public RepositoryFuncionario() {
        if (this.arrayFuncionario == null || this.arrayFuncionario == null) {

            this.arrayFuncionario = new ArrayList<>();
        }
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {

        this.arrayFuncionario.add(funcionario);

        System.out.println("");
        System.out.println("Cadastro efetuado com sucesso");
        System.out.println("");
    }

    @Override
    public ArrayList<Funcionario> listarFuncionarios() {
        return this.arrayFuncionario;
    }

    @Override
    public Funcionario buscarFuncionario(String idFuncionario) {
        Funcionario funcionario = null;

        for (int i = 0; i < this.arrayFuncionario.size(); i++) {
            if (this.arrayFuncionario.get(i).getIdFuncionario().equals(idFuncionario)) {
                funcionario = this.arrayFuncionario.get(i);
                break;
            }
        }
        return funcionario;
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        for (int i = 0; i < arrayFuncionario.size(); i++) {
            if (arrayFuncionario.get(i) == funcionario) {
                arrayFuncionario.set(i, funcionario);
                break;
            }
        }
        if (funcionario == null) {
            System.out.println("Funcion�rio n�o localizado");

        }
    }

    @Override
    public void removerFuncionario(Funcionario funcionario) {
        for (int i = 0; i < this.arrayFuncionario.size(); i++) {
            if (this.arrayFuncionario.get(i) == funcionario) {
                this.arrayFuncionario.remove(i);
                break;
            }
        }
    }

    public ArrayList<Funcionario> listarFuncionariosAll(ArrayList<Funcionario> arrayFuncionariosAll) {
        if (arrayFuncionariosAll != null) {

            for (int i = 0; i < arrayFuncionariosAll.size(); i++) {
                arrayFuncionariosAll.get(i);
                System.out.println("Id Funcionario : " + arrayFuncionariosAll.get(i).getIdFuncionario() + "Nome: "
                        + arrayFuncionariosAll.get(i).getNome() + "CPF :" + arrayFuncionariosAll.get(i).getCpf() + " Salario: "
                        + arrayFuncionariosAll.get(i).getSalario());

            }
        }
        return arrayFuncionariosAll;
    }
}
