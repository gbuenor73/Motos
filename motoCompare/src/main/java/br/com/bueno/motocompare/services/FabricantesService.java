package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.controllers.requests.Fabricante;
import br.com.bueno.motocompare.interfaces.DefaultUseCase;
import br.com.bueno.motocompare.interfaces.FabricanteUseCase;
import br.com.bueno.motocompare.model.FabricanteModel;
import br.com.bueno.motocompare.repository.FabricantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FabricantesService implements FabricanteUseCase {

    @Autowired
    private FabricantesRepository repository;

    @Override
    public Fabricante buscaUm(Integer id) {
        FabricanteModel fabricanteModel = this.repository.findById(id).orElseThrow();
        return fabricanteModel.convertToDomain();
    }

    @Override
    public List<Fabricante> buscaTodos() {
        List<FabricanteModel> todosFabricantes = this.repository.findAll();
        return todosFabricantes.stream().map(FabricanteModel::convertToDomain).toList();
    }

    @Override
    public FabricanteModel insereUm(FabricanteModel fabricanteModel) {
        return this.repository.save(fabricanteModel);
    }

    @Override
    public void deletaUm(Integer id) {
        this.repository.deleteById(id);
    }
}
