
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Renato Nunes
 */
public class LojaApp {

    public static Scanner scanner = new Scanner(System.in);
    public static IRepositoryCliente repCliente = new RepositoryCliente();
    public static IRepositoryFuncionario repFuncionario = new RepositoryFuncionario();
    public static IRepositoryProduto repProduto = new RepositoryProduto();
    public static IRepositoryVenda repVenda = new RepositoryVenda();

    public static void main(String[] args) {
        int opcMenu;
        do {
            System.out.println("Digite a opção desejada! ");
            System.out.println("");
            System.out.println("1- para cadastro de Clientes: ");
            System.out.println("2- para cadastro de Produtos: ");
            System.out.println("3- para cadastro de Empresa; ");
            System.out.println("4- para Local de Vendas: ");
            System.out.println("0-sair do menu princial: ");
            opcMenu = scanner.nextInt();
            switch (opcMenu) {
                case 1:
                    CadastroClientes();
                    break;
                case 2:
                    CadastroProdutos();
                    break;
                case 3:
                    CadastroEmpresa();
                    break;
                case 4:
                    Venda();
                    break;
                case 0:
                    System.out.println("Você escolheu sair, obrigado!");
                    break;
                default:
                    System.out.println("Você Digitou algo errado! ");
            }
        } while (opcMenu != 0);
    }

    private static void CadastroClientes() {
        int opcSub, telefone, cont = 0, tam = 0, rgOuInscEstadual, escOpc, opcAtt;
        String codigo, nome, email, cpfouCnpj;

        do {
            System.out.println("Bem vindo a area do cliente aqui voce pode escolher as opões abaixo,"
                    + "Digite a opção dejejada");
            System.out.println("-----------------");
            MenuCliente();
            opcSub = scanner.nextInt();
            scanner.nextLine();
            Cliente clientePF;
            Cliente clientePJ;
            Endereco end;
            switch (opcSub) {
                case 1:
                    clientePF = new ClientePF();
                    clientePJ = new ClientePJ();
                    end = new Endereco();

                    codigo = Integer.toString(cont + 1); //auto incremente do codigo.
                    System.out.println("Digite o Nome do Cliente");
                    nome = scanner.nextLine();
                    System.out.println("Digite o Email do Cliente");
                    email = scanner.nextLine();
                    System.out.println("Digite o  CPF ou CNPJ do Cliente");
                    cpfouCnpj = scanner.nextLine();
                    tam = cpfouCnpj.length();
                    while (clientePF.validarNum(cpfouCnpj) != true || tam != 11 && tam != 14) {
                        System.out.println("o CPF ou CNPJ precisa ser apenas numeros e o tamanho de:"
                                + " CPF = 11 ou CNPJ = 14! ");
                        System.out.println("Digite o  CPF ou CNPJ do Cliente");
                        cpfouCnpj = scanner.nextLine();
                        tam = cpfouCnpj.length();
                    }
                    System.out.println("Digite o Telefone do Cliente");
                    telefone = scanner.nextInt();

                    if (tam == 11) {
                        System.out.println("Digite o  RG do Cliente");
                        rgOuInscEstadual = scanner.nextInt();
                        clientePF.setCodigoCliente(codigo);
                        clientePF.setNome(nome);
                        ((ClientePF) clientePF).setCpf(cpfouCnpj);
                        ((ClientePF) clientePF).setRg(rgOuInscEstadual);
                        clientePF.setEmail(email);
                        clientePF.setTelefone(telefone);
                        cadastrarEndereco(end);
                        clientePF.setEndereco(end);

                        if (repCliente.buscarCliente(clientePF.getCodigoCliente()) != null) {
                            System.out.println("Não cadastrado pois o codigo á existe ");
                        } else {
                            repCliente.cadastrarCliente(clientePF);
                        }

                    } else {
                        System.out.println("Digite a inscrição estadual ou zero se não houver: ");
                        rgOuInscEstadual = scanner.nextInt();
                        clientePJ.setCodigoCliente(codigo);
                        clientePJ.setNome(nome);
                        ((ClientePJ) clientePJ).setCNPJ(cpfouCnpj);
                        ((ClientePJ) clientePJ).setInscricaoEstadual(rgOuInscEstadual);
                        clientePJ.setEmail(email);
                        clientePJ.setTelefone(telefone);
                        cadastrarEndereco(end);
                        clientePJ.setEndereco(end);
                        if (repCliente.buscarCliente(clientePJ.getCodigoCliente()) != null) {
                            System.out.println("Não cadastrado pois o codigo á existe ");
                        } else {
                            repCliente.cadastrarCliente(clientePJ);
                        }
                    }
                    cont = cont + 1;
                    break;
                case 2:
                    System.out.println("Lista de Clientes Cadastrado: ");
                    repCliente.listarClientesAll(repCliente.listarClientes());
                    System.out.println("");

                    break;
                case 3:
                    System.out.println("Digite o codigo do cliente para a pesquisa");
                    codigo = scanner.nextLine();

                    Cliente clientePesquisa = repCliente.buscarCliente(codigo);
                    if (clientePesquisa != null) {
                        System.out.println("Cliente Localizado foi: Codigo: " + clientePesquisa.getCodigoCliente()
                                + " Nome: " + clientePesquisa.getNome()
                                + " Email: " + clientePesquisa.getEmail());
                        if (clientePesquisa instanceof ClientePF) {
                            System.out.println(" CPF: " + ((ClientePF) clientePesquisa).getCpf()
                                    + " RG: " + ((ClientePF) clientePesquisa).getRg());
                        } else if (clientePesquisa instanceof ClientePJ) {
                            System.out.println(" CNPJ: " + ((ClientePJ) clientePesquisa).getCNPJ()
                                    + " Escrição Estadual: " + ((ClientePJ) clientePesquisa).getInscricaoEstadual());
                        }
                    } else {
                        System.out.println("Cliente digitado não localizado! ");
                    }
                    break;
                case 4:
                    System.out.println("Escolha a opção de pesquisa parar atualizar 1- Clientes PF ou 2 Para Clientes PJ: ");
                    escOpc = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o codigo do cliente para a Atualizar");
                    codigo = scanner.nextLine();
                    if (escOpc == 1) {
                        Cliente clientePesquisaPF = repCliente.buscarCliente(codigo);
                        if (clientePesquisaPF != null) {
                            System.out.println("Agora digite o que quer atualizar!");
                            System.out.println("1- Nome 2 - Email 3 - Telefone 4 Nome,Email e Telefone.");
                            opcAtt = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcAtt) {
                                case 1:
                                    System.out.println("Digite o novo nome: ");
                                    nome = scanner.nextLine();
                                    clientePesquisaPF.setNome(nome);
                                    break;
                                case 2:
                                    System.out.println("Digite o n"
                                            + "ovo Email: ");
                                    email = scanner.nextLine();
                                    clientePesquisaPF.setEmail(email);
                                    break;
                                case 3:
                                    System.out.println("Digite o novo Telefone: ");
                                    telefone = scanner.nextInt();
                                    clientePesquisaPF.setTelefone(telefone);
                                    break;
                                case 4:
                                    System.out.println("Digite o novo nome: ");
                                    nome = scanner.nextLine();
                                    clientePesquisaPF.setNome(nome);
                                    System.out.println("Digite o novo Email: ");
                                    email = scanner.nextLine();
                                    clientePesquisaPF.setEmail(email);
                                    System.out.println("Digite o novo Telefone: ");
                                    telefone = scanner.nextInt();
                                    clientePesquisaPF.setTelefone(telefone);
                                    break;
                                default:
                                    System.out.println("Voce escolheu uma opção invalida");
                            }
                            repCliente.atualizarCliente(clientePesquisaPF);
                        } else {
                            System.out.println("Não foi possivel Atualizar,Cliente digitado não localizado");
                        }
                    } else if (escOpc == 2) {
                        Cliente clientePesquisaPJ = repCliente.buscarCliente(codigo);
                        if (clientePesquisaPJ != null) {
                            System.out.println("Agora digite o que quer atualizar!");
                            System.out.println("1- Nome 2 - Email 3 - Telefone 4 Nome,Email e Telefone.");
                            opcAtt = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcAtt) {
                                case 1:
                                    System.out.println("Digite o novo nome: ");
                                    nome = scanner.nextLine();
                                    clientePesquisaPJ.setNome(nome);
                                    break;
                                case 2:
                                    System.out.println("Digite o novo Email: ");
                                    email = scanner.nextLine();
                                    clientePesquisaPJ.setEmail(email);
                                    break;
                                case 3:
                                    System.out.println("Digite o novo Telefone: ");
                                    telefone = scanner.nextInt();
                                    clientePesquisaPJ.setTelefone(telefone);
                                    break;
                                case 4:
                                    System.out.println("Digite o novo nome: ");
                                    nome = scanner.nextLine();
                                    clientePesquisaPJ.setNome(nome);
                                    System.out.println("Digite o novo Email: ");
                                    email = scanner.nextLine();
                                    clientePesquisaPJ.setEmail(email);
                                    System.out.println("Digite o novo Telefone: ");
                                    telefone = scanner.nextInt();
                                    clientePesquisaPJ.setTelefone(telefone);
                                    break;
                                default:
                                    System.out.println("Voce escolheu uma opção invalida");
                            }
                            repCliente.atualizarCliente(clientePesquisaPJ);
                        } else {
                            System.out.println("Não foi possivel Atualizar,Cliente digitado não localizado");
                        }
                    } else {
                        System.out.println("Você Digitou algo errado e foi direcionado para o menu Principal! ");
                    }
                    break;
                case 5:
                    System.out.println("Digite o codigo do cliente para a Remover");
                    codigo = scanner.nextLine();
                    Cliente clientePesquisaRemover = repCliente.buscarCliente(codigo);
                    if (clientePesquisaRemover != null) {
                        repCliente.removerCliente(clientePesquisaRemover);
                    } else {
                        System.out.println("Não foi possivel Remover,Cliente digitado não localizado");
                    }
                    break;
                case 0:
                    System.out.println("Você escolheu sair, obrigado!");
                    break;
                default:
                    System.out.println("Você Digitou algo errado! ");
            }
        } while (opcSub != 0);
    }

    private static void CadastroProdutos() {
        int opc, cont = 0, qtd;
        String descricao, idProduto;
        double valor;
        do {
            System.out.println("Bem vindo a area do produto, aqui voce pode escolher as opções abaixo,"
                    + "Digite a opção desejada");
            System.out.println("-----------------");
            MenuProduto();
            opc = scanner.nextInt();
            scanner.nextLine();
            Produto produto;
            switch (opc) {
                case 1:
                    produto = new Produto();
                    idProduto = Integer.toString(cont + 1);
                    System.out.println("Digite o Descriçao do Produto");
                    descricao = scanner.nextLine();
                    System.out.println("Digite o Pre�o do Produto");
                    valor = scanner.nextDouble();
                    System.out.println("Digite a quantidade do produto");
                    qtd = scanner.nextInt();
                    produto.setidProduto(idProduto);
                    produto.setDescricao(descricao);
                    produto.setValor(valor);
                    produto.setQtdProduto(qtd);
                    if (repProduto.buscarProduto(produto.getIdProduto()) != null) {
                        System.out.println("N�o cadastrado pois o codigo � existe ");
                    } else {
                        repProduto.cadastrarProduto(produto);
                    }

                    cont = cont + 1;
                    break;

                case 2:
                    System.out.println("Lista de Produtos: ");
                    repProduto.listarProdutosAll(repProduto.listarProduto());
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Digite o id do produto para a pesquisa");
                    idProduto = scanner.nextLine();

                    produto = new Produto();
                    produto = repProduto.buscarProduto(idProduto);
                    if (produto != null) {
                        System.out.println("Produto Localizado foi: ID: " + produto.getIdProduto()
                                + " Nome: " + produto.getDescricao()
                                + " Preço: " + produto.getValor()
                                + " Quantidade: " + produto.getQtdProduto());
                    } else {
                        System.out.println("Produto digitado não localizado! ");
                    }
                    break;

                case 4:
                    System.out.println("Digite o codigo do Produto para a Atualizar");
                    idProduto = scanner.nextLine();
                    produto = new Produto();
                    produto = repProduto.buscarProduto(idProduto);
                    if (produto != null) {
                        System.out.println("Agora digite o que quer atualizar!");
                        System.out.println("1- Nome 2- Preço 3- quantidade 4- Nome e Preço e quantidade.");
                        int opcAttP = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcAttP) {
                            case 1:
                                System.out.println("Digite o novo nome: ");
                                descricao = scanner.nextLine();
                                produto.setDescricao(descricao);
                                break;
                            case 2:
                                System.out.println("Digite o novo Preço: ");
                                valor = scanner.nextInt();
                                produto.setValor(valor);
                                break;
                            case 3:
                                System.out.println("Digite a nova Quantidade: ");
                                qtd = scanner.nextInt();
                                produto.setQtdProduto(qtd);
                                break;
                            case 4:
                                System.out.println("Digite o novo nome: ");
                                descricao = scanner.nextLine();
                                produto.setDescricao(descricao);
                                System.out.println("Digite o novo Pre�o: ");
                                valor = scanner.nextInt();
                                System.out.println("Digite a nova Quantidade: ");
                                qtd = scanner.nextInt();
                                produto.setQtdProduto(qtd);
                                produto.setValor(valor);
                                break;
                            default:
                                System.out.println("Voce escolheu uma opção invalida");
                        }

                        repProduto.atualizarProduto(produto);
                    } else {
                        System.out.println("Nao foi possivel Atualizar, Produto digitado n�o localizado");
                    }
                    break;
                case 5:
                    System.out.println("Digite o codigo do Produto para a Remover");
                    idProduto = scanner.nextLine();
                    produto = new Produto();
                    produto = repProduto.buscarProduto(idProduto);
                    if (produto != null) {
                        repProduto.removerProduto(produto);
                    } else {
                        System.out.println("Nao foi possivel Remover, Produto digitado nao localizado");
                    }
                    break;
                case 0:
                    System.out.println("Voce escolheu sair, obrigado!");
                    break;
                default:
                    System.out.println("Voce Digitou algo errado! ");
            }

        } while (opc != 0);

    }

    private static void CadastroEmpresa() {
        int opc, codF = 0;
        String nome, cpf, idFuncionario;
        double salario;
        do {
            System.out.println("Bem vindo a area do funcionário, aqui voce pode escolher as opçôes abaixo,"
                    + "Digite a opçõeo desejada");
            System.out.println("-----------------");
            menuFuncionario();
            opc = scanner.nextInt();
            Funcionario funcionario;
            switch (opc) {
                case 1:
                    funcionario = new Funcionario();
                    idFuncionario = Integer.toString(codF + 1);
                    System.out.println("Digite o Nome do Funcionário");
                    nome = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Digite o CPF do Funcionário");
                    cpf = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Digite o salário do Funcionário");
                    salario = scanner.nextDouble();

                    funcionario.setIdFuncionario(idFuncionario);
                    funcionario.setNome(nome);
                    funcionario.setSalario(salario);
                    funcionario.setCpf(cpf);
                    if (repFuncionario.buscarFuncionario(funcionario.getIdFuncionario()) != null) {
                        System.out.println("Nao cadastrado pois o codigo ja existe ");
                    } else {
                        repFuncionario.cadastrarFuncionario(funcionario);
                    }

                    codF = codF + 1;
                    break;

                case 2:
                    System.out.println("Lista de Funcionários: ");
                    repFuncionario.listarFuncionariosAll(repFuncionario.listarFuncionarios());
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Digite o id do funcionário para a pesquisa");
                    idFuncionario = scanner.nextLine();
                    funcionario = new Funcionario();
                    funcionario = repFuncionario.buscarFuncionario(idFuncionario);
                    if (funcionario != null) {
                        System.out.println("Funcionario Localizado foi: ID: " + funcionario.getIdFuncionario()
                                + " Nome: " + funcionario.getNome()
                                + "CPF: " + funcionario.getCpf()
                                + " Salario: " + funcionario.getSalario());
                    } else {
                        System.out.println("Funcionario digitado nâo localizado! ");
                    }
                    break;

                case 4:
                    System.out.println("Digite o codigo do funcionario para a Atualizar");
                    idFuncionario = scanner.nextLine();
                    funcionario = new Funcionario();
                    funcionario = repFuncionario.buscarFuncionario(idFuncionario);
                    if (funcionario != null) {
                        System.out.println("Agora digite o que quer atualizar!");
                        System.out.println("1- Nome 2- Salário 3- Nome e Salário.");
                        int opcAttP = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcAttP) {
                            case 1:
                                System.out.println("Digite o novo nome: ");
                                nome = scanner.nextLine();
                                funcionario.setNome(nome);
                                break;
                            case 2:
                                System.out.println("Digite o novo Salário: ");
                                salario = scanner.nextInt();
                                funcionario.setSalario(salario);
                                break;
                            case 3:
                                System.out.println("Digite o novo nome: ");
                                nome = scanner.nextLine();
                                funcionario.setNome(nome);
                                System.out.println("Digite o novo Salário: ");
                                salario = scanner.nextInt();
                                funcionario.setSalario(salario);
                                break;
                            default:
                                System.out.println("Voce escolheu uma opção invalida");
                        }

                        repFuncionario.atualizarFuncionario(funcionario);
                    } else {
                        System.out.println("Não foi possivel Atualizar, Funcionario digitado não localizado");
                    }
                    break;
                case 5:
                    System.out.println("Digite o codigo do Funcionario para a Remover");
                    idFuncionario = scanner.nextLine();
                    funcionario = new Funcionario();
                    funcionario = repFuncionario.buscarFuncionario(idFuncionario);
                    if (funcionario != null) {
                        repFuncionario.removerFuncionario(funcionario);
                    } else {
                        System.out.println("Não foi possivel Remover, Funcionario digitado não localizado");
                    }
                    break;
                case 0:
                    System.out.println("Você escolheu sair, obrigado!");
                    break;
                default:
                    System.out.println("Você Digitou algo errado! ");
            }

        } while (opc != 0);

    }

    private static void Venda() {
        int opc, cont = 0, qtdP;
        String idProdutoVenda, idVenda;

        do {
            System.out.println("Bem vindo a area de compra, aqui voce pode escolher as opçoes abaixo,"
                    + "Digite a opção desejada");
            System.out.println("-----------------");
            menuVenda();
            opc = scanner.nextInt();
            scanner.nextLine();
            Venda venda;
            Produto produto;
            venda = new Venda();
            idVenda = Integer.toString(cont + 1);
            venda.setIdVenda(idVenda);
            cont = cont + 1;

            switch (opc) {
                case 1:
                    System.out.println("Digite a id do Produto da Compra");
                    idProdutoVenda = scanner.nextLine();
                    produto = new Produto();
                    produto = repProduto.buscarProduto(idProdutoVenda);

                    if (produto != null && produto.getQtdProduto() > 0) {
                        repVenda.addProduto(produto);
                        qtdP = produto.getQtdProduto() - 1;
                        produto.setQtdProduto(qtdP);
                    } else {
                        System.out.println("O produto não foi encontrado ou está em falta: ");
                    }

                    break;

                case 2:
                    venda = new Venda();
                    System.out.println("Lista de Produtos no Carrinho: ");
                    repVenda.listarProdutosAllCarrinho(repVenda.listarProdutosVenda());
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Digite o id do produto para a pesquisa");
                    idProdutoVenda = scanner.nextLine();

                    produto = new Produto();
                    produto = repVenda.buscarProdutoVenda(idProdutoVenda);
                    if (produto != null) {
                        System.out.println("Produto Localizado foi: ID: " + produto.getIdProduto()
                                + " Nome: " + produto.getDescricao()
                                + " Preço: " + produto.getValor()
                                + " Quantidade: " + produto.getQtdProduto());
                    } else {
                        System.out.println("Produto digitado não localizado! ");
                    }
                    break;

                case 4:
                    System.out.println("Digite o codigo do Produto para a Remover");
                    idProdutoVenda = scanner.nextLine();
                    produto = new Produto();
                    produto = repVenda.buscarProdutoVenda(idProdutoVenda);
                    if (produto != null) {
                        repVenda.removerProdutoVenda(produto);
                    } else {
                        System.out.println("Nao foi possivel Remover, Produto digitado nao localizado");
                    }
                    break;
                    
                case 5:
                    repVenda.calcularVenda(repVenda.listarProdutosAllCarrinho(repVenda.listarProdutosVenda()));
                    break;
                case 0:
                    System.out.println("Voce escolheu sair, obrigado!");
                    break;
                default:
                    System.out.println("Voce Digitou algo errado! ");

            }
        } while (opc != 0);
    }

    private static void cadastrarEndereco(Endereco e) {
        System.out.println("Digite o Nome da Rua");
        e.setNomeRua(scanner.nextLine()); //duplicado devido o erro do buff do teclado
        e.setNomeRua(scanner.nextLine());
        System.out.println("Digite o numero da Casa");
        e.setNumCasa(scanner.nextInt());
        System.out.println("Digite o Complento");
        e.setComplemento(scanner.nextLine()); //msm coisa de rua
        e.setComplemento(scanner.nextLine());
        System.out.println("Digite o cep");
        e.setCep(scanner.nextLine());
        System.out.println("Digite o Bairro");
        e.setBairro(scanner.nextLine());
        System.out.println("Digite a Cidade");
        e.setCidade(scanner.nextLine());
        System.out.println("Digite o Estado");
        e.setEstado(scanner.nextLine());

    }

    public static void MenuCliente() {
        System.out.println("Digite 1 - Cadastrar Cliente: ");
        System.out.println("Digite 2 - Listar todos os  Clientes: ");
        System.out.println("Digite 3 - Listar apenas um Cliente: ");
        System.out.println("Digite 4 - Atualiar um Cliente: ");
        System.out.println("Digite 5 - remover um Cliente: ");
        System.out.println("Digite 0 - Para voltar para o menu princiapl: ");
    }

    public static void MenuProduto() {
        System.out.println("Digite 1 - Cadastrar Produto: ");
        System.out.println("Digite 2 - Listar todos os Produtos: ");
        System.out.println("Digite 3 - Listar apenas um Produto: ");
        System.out.println("Digite 4 - Atualizar um Produto: ");
        System.out.println("Digite 5 - remover um Produto: ");
        System.out.println("Digite 0 - Para voltar para o menu principal: ");
    }

    public static void menuFuncionario() {
        System.out.println("Digite 1 - Cadastrar Funcionario: ");
        System.out.println("Digite 2 - Listar todos os Funcion�rios: ");
        System.out.println("Digite 3 - Listar apenas um Funcion�rio: ");
        System.out.println("Digite 4 - Atualizar um Funcion�rio: ");
        System.out.println("Digite 5 - remover um Funcion�rio: ");
        System.out.println("Digite 0 - Para voltar para o menu principal: ");
    }

    public static void menuVenda() {
        System.out.println("Digite 1 - Adicionar produto ao carrinho: ");
        System.out.println("Digite 2 - Listar os Produtos do carrinho: ");
        System.out.println("Digite 3 - Listar um Produto do carrinho: ");
        System.out.println("Digite 4 - Remover um produto do carrinho: ");
        System.out.println("Digite 5 - Calcular vendas: ");
        System.out.println("Digite 0 - Para encerrar a compra e voltar ao menu principal: ");
    }
}
