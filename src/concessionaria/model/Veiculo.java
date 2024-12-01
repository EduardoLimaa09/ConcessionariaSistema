package concessionaria.model;

public abstract class Veiculo {
    protected static int idCounter = 1;
    protected int id;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double preco;

    public Veiculo(String marca, String modelo, int ano, double preco) {
        this.id = idCounter++;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public abstract void exibirDetalhes();
}