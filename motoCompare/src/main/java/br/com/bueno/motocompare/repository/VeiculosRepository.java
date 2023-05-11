package br.com.bueno.motocompare.repository;


import br.com.bueno.motocompare.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculosRepository extends JpaRepository<VeiculoModel, Integer> {
    List<VeiculoModel> findByIdFabricante(Integer idFabricante);

}
