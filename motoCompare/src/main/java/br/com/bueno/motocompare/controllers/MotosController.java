package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.model.FabricanteModel;
import br.com.bueno.motocompare.model.VeiculoModel;
import br.com.bueno.motocompare.services.FabricantesService;
import br.com.bueno.motocompare.services.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotosController {

    @Autowired
    private FabricantesService fabricantesService;

    @Autowired
    private VeiculosService veiculosService;

    @GetMapping(value = "/fabricante/{idFabricante}")
    public ResponseEntity<FabricanteModel> fabricantePorID(@PathVariable("idFabricante") Integer idFabricante) {
        return ResponseEntity.ok(this.fabricantesService.buscaFabricante(idFabricante));
    }

    @GetMapping(value = "/fabricantes")
    public ResponseEntity<List<FabricanteModel>> fabricantes() {
        return ResponseEntity.ok(this.fabricantesService.buscaFabricantes());
    }

    @GetMapping(value = "/veiculos")
    public ResponseEntity<List<VeiculoModel>> veiculos() {
        return ResponseEntity.ok(this.veiculosService.buscaVeiculos());
    }

    @GetMapping(value = "/veiculo/{idVeiculo}")
    public ResponseEntity<VeiculoModel> veiculoPorID(@PathVariable("idVeiculo") Integer idVeiculo) {
        return ResponseEntity.ok(this.veiculosService.buscaVeiculo(idVeiculo));
    }

    @PostMapping("/fabricante")
    public ResponseEntity<Fabricante> insereNovoFabricante(@RequestBody Fabricante fabricante) {
        FabricanteModel fabricanteModel = this.fabricantesService.insereNovoFabricante(fabricante.convertToModel());
        return ResponseEntity.ok(fabricante.revertFromModel(fabricanteModel));
    }

    public ResponseEntity<Veiculo> insereNovoVeiculo(@RequestBody Veiculo veiculo) {
        VeiculoModel veiculoModel = this.veiculosService.insereNovoVeiculo(veiculo.convertToModel());
        return ResponseEntity.ok(veiculo.revertFromModel(veiculoModel));
    }

}
