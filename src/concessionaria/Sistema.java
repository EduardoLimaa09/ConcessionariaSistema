package concessionaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void executar() {
        int opcao;

        do {
            System.out.println("\n---》 Concessionária do Tião 《---");
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Cadastrar Moto");
            System.out.println("3 - Listar Veículos");
            System.out.println("4 - Excluir Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    cadastrarMoto();
                    break;
                case 3:
                    listarVeiculos();
                    break;
                case 4:
                    excluirVeiculo();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Puts meu nobre, não consegui encontrar essa opção. Tente denovo!");
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarCarro() {
        System.out.println("---> Cadastro de Carro <---");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Tipo de Combustível: ");
        String tipoCombustivel = scanner.nextLine();
        System.out.print("Número de Portas: ");
        int numPortas = scanner.nextInt();

        veiculos.add(new Carro(marca, modelo, ano, preco, tipoCombustivel, numPortas));
        System.out.println("Carro cadastrado com sucesso, valeu!");
    }

    private void cadastrarMoto() {
        System.out.println("---> Cadastro de Moto <---");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Cilindradas: ");
        int cilindradas = scanner.nextInt();

        veiculos.add(new Moto(marca, modelo, ano, preco, cilindradas));
        System.out.println("Moto cadastrada com sucesso, valeu!");
    }

    private void listarVeiculos() {
    if (veiculos.isEmpty()) {
        System.out.println("Puts, não há nenhum veículo cadastrado.");
    } else {
        System.out.println("---> Lista de Veículos <---");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println("ID: " + (i + 1));
            veiculos.get(i).exibirDetalhes();
            System.out.println();
        }
    }
}

    private void excluirVeiculo() {
        listarVeiculos();
        System.out.print("Digite o ID do veículo que deseja excluir: ");
        int id = scanner.nextInt();

        if (id > 0 && id <= veiculos.size()) {
            veiculos.remove(id - 1);
            System.out.println("Veículo excluído com sucesso, valeu!");
        } else {
            System.out.println("Poxa, ID inválido. Veículo não encontrado.");
        }
    }
}