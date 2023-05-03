package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.model.VeiculoModel;
import br.com.bueno.motocompare.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository repository;

    public VeiculoModel buscaVeiculo(Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    public List<VeiculoModel> buscaVeiculos() {
        return this.repository.findAll();
    }

    public VeiculoModel insereNovoVeiculo (VeiculoModel veiculoModel){
        return this.repository.save(veiculoModel);
    }
}
