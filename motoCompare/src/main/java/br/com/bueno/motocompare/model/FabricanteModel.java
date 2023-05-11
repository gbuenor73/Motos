package br.com.bueno.motocompare.model;

import br.com.bueno.motocompare.controllers.Fabricante;
import br.com.bueno.motocompare.utils.AbstractObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "fabricantes")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteModel extends AbstractObject {

    @Id
    private Integer idFabricante;
    private String nomeFabricante;

    public Fabricante convertToDomain(){
        return Fabricante.builder()
                .id(this.idFabricante)
                .nomeFabricante(this.nomeFabricante)
                .build();
    }

    public static FabricanteModel convertToModel(Fabricante fabricante){
        return FabricanteModel.builder()
                .idFabricante(fabricante.getId())
                .nomeFabricante(fabricante.getNomeFabricante())
                .build();
    }

}
