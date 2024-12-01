package concessionaria.dao;

import concessionaria.model.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private List<Veiculo> veiculos;

    public VeiculoDAO() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(int id) {
        Veiculo veiculoRemover = null;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                veiculoRemover = veiculo;
                break;
            }
        }

        if (veiculoRemover != null) {
            veiculos.remove(veiculoRemover);
        }
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }
}