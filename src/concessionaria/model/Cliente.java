package concessionaria.model;

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private Veiculo veiculoInteressado;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.veiculoInteressado = null;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setVeiculoInteressado(Veiculo veiculo) {
        this.veiculoInteressado = veiculo;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
        if (veiculoInteressado != null) {
            System.out.println("Interesse no veículo: " + veiculoInteressado.getModelo() + " - " + veiculoInteressado.getMarca());
        } else {
            System.out.println("Não possui interesse em nenhum veículo.");
        }
    }
}