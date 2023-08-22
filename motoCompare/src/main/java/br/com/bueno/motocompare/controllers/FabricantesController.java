package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.controllers.requests.Fabricante;
import br.com.bueno.motocompare.interfaces.DefaultController;
import br.com.bueno.motocompare.interfaces.DefaultUseCase;
import br.com.bueno.motocompare.interfaces.FabricanteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/fabricantes")
@RequiredArgsConstructor
public class FabricantesController implements DefaultController {


    private final FabricanteUseCase useCase;
    private final DefaultUseCase defaultUseCase;

    @Override
    @GetMapping
    public ResponseEntity<List<Fabricante>> buscaTodos() {
        List<Fabricante> fabricantes = this.useCase.buscaTodos();
        return ok(fabricantes);
    }

    @Override
    @GetMapping(value = "/{idFabricante}")
    public ResponseEntity<Fabricante> buscaUm(@PathVariable("idFabricante") Integer idFabricante) {
        Fabricante fabricante = this.defaultUseCase.buscaUm(idFabricante);
        return ok(fabricante);
    }

//    @Override
    @PostMapping
    public ResponseEntity<Fabricante> insereUm(@RequestBody Fabricante fabricante) {
        Fabricante returned = this.useCase.insereUm(fabricante.convertToModel()).convertToDomain();
        return ok(returned);
    }

    @Override
    public ResponseEntity deletaUm(Integer id) {
        this.useCase.deletaUm(id);
        return ResponseEntity.ok().build();
    }
}
