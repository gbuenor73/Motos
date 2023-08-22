package br.com.bueno.motocompare.controllers.requests;

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
public class Veiculo extends AbstractObject {

    @JsonProperty("id_veiculo")
    private Integer idVeiculo;

    @JsonProperty("id_fabricante")
    private Integer idFabricante;

    @JsonProperty("nome_veiculo")
    private String nomeVeiculo;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("ano")
    private String ano;

    @JsonProperty("cilindrada")
    private Integer cilindrada;

    @JsonProperty("cavalos")
    private Integer cavalos;

    @JsonProperty("torque")
    private Integer torque;

    @JsonProperty("imagem")
    private String imagem;



}
