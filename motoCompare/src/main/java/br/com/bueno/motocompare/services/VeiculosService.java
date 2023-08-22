package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.controllers.requests.Veiculo;
import br.com.bueno.motocompare.interfaces.VeiculoUseCase;
import br.com.bueno.motocompare.model.VeiculoModel;
import br.com.bueno.motocompare.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService implements VeiculoUseCase {

    @Autowired
    private VeiculosRepository repository;

    @Override
    public Veiculo buscaUm(Integer id) {
        VeiculoModel veiculoModel = this.repository.findById(id).orElseThrow();
        return veiculoModel.convertToDomain();
    }

    @Override
    public List<Veiculo> buscaTodos() {
        List<VeiculoModel> todosModels = this.repository.findAll();
        return todosModels.stream().map(VeiculoModel::convertToDomain).toList();
    }

    public VeiculoModel insereUm(VeiculoModel veiculoModel){
        return this.repository.save(veiculoModel);
    }

    public void deletaUm(Integer idVeiculo) {
        this.repository.deleteById(idVeiculo);
    }

    public List<Veiculo> buscaVeiculosPorFabricante(Integer idFabricante) {
         List<VeiculoModel> models = this.repository.findByIdFabricante(idFabricante);
        return models.stream().map(VeiculoModel::convertToDomain).toList();
    }

}
