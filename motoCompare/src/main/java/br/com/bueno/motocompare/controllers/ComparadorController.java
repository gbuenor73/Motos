package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.services.ComparadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/comparar")
public class ComparadorController {

    @Autowired
    private ComparadorService comparadorService;

    @GetMapping
    public ResponseEntity<List<String>> compararModelos(@RequestParam("id_veiculo_um") Integer veiculo1, @RequestParam("id_veiculo_dois") Integer veiculo2) {
        List<String> comparar = this.comparadorService.comparar(veiculo1, veiculo2);
        return ok(comparar);
    }

}
