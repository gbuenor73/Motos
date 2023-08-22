package br.com.bueno.motocompare.services;

import br.com.bueno.motocompare.controllers.requests.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComparadorService {

    @Autowired
    private VeiculosService veiculosService;

    public List<String> comparar(Integer veiculo1, Integer veiculo2) {
        List<String> retorno = new ArrayList<>();

        Integer maiorCC = null;
        Integer maiorCV = null;
        Integer maiorTorque = null;

        Veiculo veiculoUm = this.veiculosService.buscaUm(veiculo1);
        Veiculo veiculoDois = this.veiculosService.buscaUm(veiculo2);

        if (veiculoUm.getCilindrada() > veiculoDois.getCilindrada())
            maiorCC = 1;
        else
            maiorCC = 2;
        retorno.add("A cilindrada do veiculo " + maiorCC + " eh maior");

        if (veiculoUm.getCavalos() > veiculoDois.getCavalos())
            maiorCV = 1;
        else
            maiorCV = 2;
        retorno.add("A cavalos do veiculo " + maiorCV + " eh maior");

        if (veiculoUm.getTorque() > veiculoDois.getTorque())
            maiorTorque = 1;
        else
            maiorTorque = 2;
        retorno.add("A torque do veiculo " + maiorTorque + " eh maior");

        return retorno;
    }
}
