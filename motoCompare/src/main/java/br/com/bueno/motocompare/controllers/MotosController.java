package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.services.ComparadorService;
import br.com.bueno.motocompare.services.FabricantesService;
import br.com.bueno.motocompare.services.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.bueno.motocompare.model.VeiculoModel.convertToModel;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MotosController {

    @Autowired
    private FabricantesService fabricantesService;

    @Autowired
    private VeiculosService veiculosService;

    @Autowired
    private ComparadorService comparadorService;

    @GetMapping(value = "/fabricantes")
    public ResponseEntity<List<Fabricante>> fabricantes() {
        List<Fabricante> fabricantes = this.fabricantesService.buscaFabricantes();
        return ok(fabricantes);
    }

    @GetMapping(value = "/veiculos")
    public ResponseEntity<List<Veiculo>> veiculos() {
        List<Veiculo> veiculos = this.veiculosService.buscaVeiculos();
        return ok(veiculos);
    }

    @GetMapping(value = "/fabricante/{idFabricante}")
    public ResponseEntity<Fabricante> fabricantePorID(@PathVariable("idFabricante") Integer idFabricante) {
        Fabricante fabricante = this.fabricantesService.buscaFabricante(idFabricante);
        return ok(fabricante);
    }

    @GetMapping(value = "/veiculo/{idVeiculo}")
    public ResponseEntity<Veiculo> veiculoPorID(@PathVariable("idVeiculo") Integer idVeiculo) {
        Veiculo veiculo = this.veiculosService.buscaVeiculo(idVeiculo);
        return ok(veiculo);
    }

    @PostMapping("/fabricante")
    public ResponseEntity<Fabricante> insereNovoFabricante(@RequestBody Fabricante fabricante) {
        Fabricante returned = this.fabricantesService.insereNovoFabricante(fabricante.convertToModel());
        return ok(returned);
    }

    @PostMapping("/veiculo")
    public ResponseEntity<Veiculo> insereNovoVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo returned = this.veiculosService.insereNovoVeiculo(convertToModel(veiculo));
        return ok(returned);
    }

    @GetMapping("/veiculosf")
    public ResponseEntity<List<Veiculo>> ListaVeiculoPorFabricante(@RequestParam("id_fabricante") Integer idFabricante) {
        List<Veiculo> veiculos = this.veiculosService.buscaVeiculosPorFabricante(idFabricante);
        return ok(veiculos);
    }

    @GetMapping("/compare")
    public ResponseEntity<List<String>> compararModelos(@RequestParam("id_veiculo_um") Integer veiculo1, @RequestParam("id_veiculo_dois") Integer veiculo2) {
        List<String> comparar = this.comparadorService.comparar(veiculo1, veiculo2);
        return ok(comparar);
    }

}
