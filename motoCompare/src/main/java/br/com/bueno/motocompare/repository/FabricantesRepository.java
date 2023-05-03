package br.com.bueno.motocompare.repository;


import br.com.bueno.motocompare.model.FabricanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricantesRepository extends JpaRepository<FabricanteModel, Integer> {
}
