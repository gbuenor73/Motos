package br.com.bueno.motocompare.controllers;

import br.com.bueno.motocompare.model.VeiculoModel;
import br.com.bueno.motocompare.utils.AbstractObject;
import lombok.Builder;

@Builder
public class Veiculo extends AbstractObject {

    private Integer idVeiculo;

    private Integer idFabricante;
    private String nomeVeiculo;
    private String modelo;
    private String ano;
    private Integer cilindrada;
    private Integer cavalos;
    private Integer torque;
    private String imagem;

    public VeiculoModel convertToModel() {
        return VeiculoModel.builder()
                .idVeiculo(this.idVeiculo)
                .idFabricante(this.idFabricante)
                .nomeVeiculo((this.nomeVeiculo))
                .modelo(this.modelo)
                .ano(this.ano)
                .cilindrada(this.cilindrada)
                .cavalos(this.cavalos)
                .torque(this.torque)
                .imagem(this.imagem)
                .build();
    }

    public Veiculo revertFromModel(VeiculoModel veiculoModel) {
        return Veiculo.builder()
                .idVeiculo(veiculoModel.getIdVeiculo())
                .idFabricante(veiculoModel.getIdFabricante())
                .nomeVeiculo(veiculoModel.getNomeVeiculo())
                .modelo(veiculoModel.getModelo())
                .ano(veiculoModel.getAno())
                .cilindrada(veiculoModel.getCilindrada())
                .cavalos(veiculoModel.getCavalos())
                .torque(veiculoModel.getTorque())
                .imagem(veiculoModel.getImagem())
                .build();
    }
}
