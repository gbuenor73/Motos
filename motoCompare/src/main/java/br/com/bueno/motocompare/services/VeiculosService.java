package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.controllers.Veiculo;
import br.com.bueno.motocompare.model.VeiculoModel;
import br.com.bueno.motocompare.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository repository;

    public Veiculo buscaVeiculo(Integer id) {
        VeiculoModel veiculoModel = this.repository.findById(id).orElseThrow();
        return veiculoModel.convertToDomain();
    }

    public List<Veiculo> buscaVeiculos() {
        List<VeiculoModel> todosModels = this.repository.findAll();
        return todosModels.stream().map(VeiculoModel::convertToDomain).toList();
    }

    public Veiculo insereNovoVeiculo (VeiculoModel veiculoModel){
        VeiculoModel save = this.repository.save(veiculoModel);
        return save.convertToDomain();
    }

    public List<Veiculo> buscaVeiculosPorFabricante(Integer idFabricante) {
         List<VeiculoModel> models = this.repository.findByIdFabricante(idFabricante);
        return models.stream().map(VeiculoModel::convertToDomain).toList();
    }
}
