
import java.util.ArrayList;

/**
 *
 * @author Renato Nunes
 */
abstract class Cliente implements Comparable<Cliente>{
    private String codigoCliente;
    private String nome;
    private String email;
    private int telefone;
    private Endereco endereco;

    public Cliente(String codigoCliente, String nome, String email, int telefone, Endereco endereco) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigoCliente=" + codigoCliente + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
    
    
    @Override
    public int compareTo(Cliente c) {
        return this.codigoCliente.compareTo(c.getCodigoCliente());
       
    }
   public abstract boolean validarNum(String num);
   public abstract boolean  validarCli(Object c);
    
}
