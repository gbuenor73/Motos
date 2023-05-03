package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.model.FabricanteModel;
import br.com.bueno.motocompare.repository.FabricantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FabricantesService {

    @Autowired
    private FabricantesRepository repository;

    public FabricanteModel buscaFabricante(Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    public List<FabricanteModel> buscaFabricantes() {
        return this.repository.findAll();
    }

    public FabricanteModel insereNovoFabricante(FabricanteModel fabricanteModel) {
        return this.repository.save(fabricanteModel);
    }
}
