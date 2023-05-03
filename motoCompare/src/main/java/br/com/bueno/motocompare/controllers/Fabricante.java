package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.model.FabricanteModel;
import br.com.bueno.motocompare.utils.AbstractObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fabricante extends AbstractObject {

    private Integer id;

    @JsonProperty("nome_do_fabricante")
    private String nomeFabricante;

    public FabricanteModel convertToModel() {
        return FabricanteModel.builder().nomeFabricante(this.nomeFabricante).build();
    }

    public Fabricante revertFromModel(FabricanteModel fabricanteModel) {
        return Fabricante.builder().nomeFabricante(fabricanteModel.getNomeFabricante()).id(fabricanteModel.getIdFabricante()).build();
    }

}
