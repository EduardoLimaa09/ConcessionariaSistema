package concessionaria.model;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double preco, int cilindradas) {
        super(marca, modelo, ano, preco);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moto: " + modelo + " - " + marca + " (" + ano + ")");
        System.out.println("Preço: R$ " + preco);
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("ID do Veículo: " + id);
    }
}