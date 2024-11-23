package concessionaria;

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
        System.out.println("Carro: " + getMarca() + " " + getModelo() + " (" + getAno() + ")");
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Tipo de Combustível: " + tipoCombustivel);
        System.out.println("Número de Portas: " + numPortas);
    }
}