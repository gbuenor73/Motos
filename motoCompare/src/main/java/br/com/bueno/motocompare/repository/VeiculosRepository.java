package br.com.bueno.motocompare.repository;


import br.com.bueno.motocompare.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<VeiculoModel, Integer> {
}
