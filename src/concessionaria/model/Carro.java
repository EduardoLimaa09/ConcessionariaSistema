package concessionaria.model;

public class Carro extends Veiculo {
    private String tipoCombustivel;
    private int numPortas;

    public Carro(String marca, String modelo, int ano, double preco, String tipoCombustivel, int numPortas) {
        super(marca, modelo, ano, preco);
        this.tipoCombustivel = tipoCombustivel;
        this.numPortas = numPortas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Carro: " + modelo + " - " + marca + " (" + ano + ")");
        System.out.println("Preço: R$ " + preco);
        System.out.println("Tipo de Combustível: " + tipoCombustivel);
        System.out.println("Número de Portas: " + numPortas);
        System.out.println("ID do Veículo: " + id);
    }
}