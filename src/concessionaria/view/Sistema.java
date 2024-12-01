package concessionaria.view;

import concessionaria.dao.VeiculoDAO;
import concessionaria.model.Cliente;
import concessionaria.model.Carro;
import concessionaria.model.Moto;
import concessionaria.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Veiculo> veiculos; //aq tem uma associação pq "Sistema" contém uma lista de veículos, mas a lista não pertence exclusivamente ao sistema e os veículos podem existir independentemente
    private List<Cliente> clientes; //aq a mesma coisa
    private VeiculoDAO veiculoDAO; //aq o "Sistema" usa o DAO para interagir com o banco de dados dos veiculos
    private Scanner scanner;

    public Sistema() {
        veiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        veiculoDAO = new VeiculoDAO();
        scanner = new Scanner(System.in);
    }

    public void executar() {
        while (true) {
            System.out.println("---> Concessionária do Tião <---");
            System.out.println("\n1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("3 - Remover Veículo");
            System.out.println("4 - Cadastrar Cliente");
            System.out.println("5 - Listar Clientes");
            System.out.println("6 - Remover Cliente");
            System.out.println("7 - Sair");
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    removerVeiculo();
                    break;
                case 4:
                    cadastrarCliente();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    removerCliente();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarVeiculo() {
        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o ano de fabricação: ");
        int ano = scanner.nextInt();
        System.out.print("Digite o preço do veículo: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        if (tipoVeiculo == 1) {
            System.out.print("Digite o tipo de combustível do carro: ");
            String tipoCombustivel = scanner.nextLine();
            System.out.print("Digite o número de portas do carro: ");
            int numPortas = scanner.nextInt();

            Carro carro = new Carro(marca, modelo, ano, preco, tipoCombustivel, numPortas);
            veiculoDAO.adicionarVeiculo(carro);
            veiculos.add(carro);
            System.out.println("Carro cadastrado com sucesso!");

        } else if (tipoVeiculo == 2) {
            System.out.print("Digite a cilindrada da moto: ");
            int cilindradas = scanner.nextInt();

            Moto moto = new Moto(marca, modelo, ano, preco, cilindradas);
            veiculoDAO.adicionarVeiculo(moto);
            veiculos.add(moto);
            System.out.println("Moto cadastrada com sucesso!");

        } else {
            System.out.println("Opção inválida.");
        }
    }

    private void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
        } else {
            System.out.println("Veículos cadastrados:");
            for (Veiculo veiculo : veiculos) {
                veiculo.exibirDetalhes();
                System.out.println();
            }
        }
    }

    private void removerVeiculo() {
        System.out.print("Digite o ID do veículo a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        veiculoDAO.removerVeiculo(id);
        System.out.println("Veículo removido com sucesso!");
    }

    private void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail do cliente: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

        System.out.print("Deseja registrar o veículo de interesse? (s/n): ");
        char resposta = scanner.nextLine().charAt(0);

        if (resposta == 's' || resposta == 'S') {
            System.out.print("Digite o ID do veículo de interesse: ");
            int idVeiculo = scanner.nextInt();
            scanner.nextLine(); 

            boolean veiculoEncontrado = false;
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getId() == idVeiculo) {
                    cliente.setVeiculoInteressado(veiculo); //aq tem uma agregação pois a classe cliente pode conter um objeto de outra classe, mas os objetos podem existir independentemente.
                    veiculoEncontrado = true;
                    System.out.println("Veículo de interesse registrado com sucesso!");
                    break;
                }
            }
            if (!veiculoEncontrado) {
                System.out.println("Veículo não encontrado!");
            }
        }
    }

    private void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                cliente.exibirDetalhes();
                System.out.println();
            }
        }
    }

    private void removerCliente() {
        System.out.print("Digite o nome do cliente a ser removido: ");
        String nome = scanner.nextLine();

        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteRemover = cliente;
                break;
            }
        }

        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.executar();
    }
}