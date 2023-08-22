package br.com.bueno.motocompare.interfaces;

import br.com.bueno.motocompare.controllers.requests.Veiculo;
import br.com.bueno.motocompare.model.VeiculoModel;

import java.util.List;

public interface VeiculoUseCase extends DefaultUseCase{

    List<Veiculo> buscaVeiculosPorFabricante(Integer idFabricante);

}
