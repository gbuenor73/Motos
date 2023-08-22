package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.controllers.requests.Veiculo;
import br.com.bueno.motocompare.interfaces.DefaultController;
import br.com.bueno.motocompare.interfaces.VeiculoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.bueno.motocompare.model.VeiculoModel.convertToModel;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController implements DefaultController {

    @Autowired
    private VeiculoUseCase useCase;

    @Override
    @GetMapping
    public ResponseEntity<List<Veiculo>> buscaTodos() {
        List<Veiculo> veiculos = this.useCase.buscaTodos();
        return ok(veiculos);
    }

    @Override
    @GetMapping(value = "/{idVeiculo}")
    public ResponseEntity<Veiculo> buscaUm(@PathVariable("idVeiculo") Integer idVeiculo) {
        Veiculo veiculo = this.useCase.buscaUm(idVeiculo);
        return ok(veiculo);
    }

//    @Override
    @PostMapping
    public ResponseEntity<Veiculo> insereUm(@RequestBody Veiculo veiculo) {
        Veiculo returned = this.useCase.insereUm(convertToModel(veiculo)).convertToDomain();
        return ok(returned);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deletaUm(@PathVariable("id") Integer idVeiculo) {
        this.useCase.deletaUm(idVeiculo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/por-fabricante")
    public ResponseEntity<List<Veiculo>> listaVeiculoPorFabricante(@RequestParam("id_fabricante") Integer idFabricante) {
        List<Veiculo> veiculos = this.useCase.buscaVeiculosPorFabricante(idFabricante);
        return ok(veiculos);
    }

}
