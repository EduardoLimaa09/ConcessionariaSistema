package concessionaria;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double preco, int cilindradas) {
        super(marca, modelo, ano, preco);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moto: " + getMarca() + " " + getModelo() + " (" + getAno() + ")");
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Cilindradas: " + cilindradas + "cc");
    }
}