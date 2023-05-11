package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.controllers.Fabricante;
import br.com.bueno.motocompare.model.FabricanteModel;
import br.com.bueno.motocompare.repository.FabricantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FabricantesService {

    @Autowired
    private FabricantesRepository repository;

    public Fabricante buscaFabricante(Integer id) {
        FabricanteModel fabricanteModel = this.repository.findById(id).orElseThrow();
        return fabricanteModel.convertToDomain();
    }

    public List<Fabricante> buscaFabricantes() {
        List<FabricanteModel> todosFabricantes = this.repository.findAll();
        return todosFabricantes.stream().map(FabricanteModel::convertToDomain).toList();
    }

    public Fabricante insereNovoFabricante(FabricanteModel fabricanteModel) {
        FabricanteModel model = this.repository.save(fabricanteModel);
        return model.convertToDomain();
    }
}
