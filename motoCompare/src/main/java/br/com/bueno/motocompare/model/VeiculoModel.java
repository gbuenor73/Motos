package br.com.bueno.motocompare.model;

import br.com.bueno.motocompare.utils.AbstractObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "veiculos")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoModel extends AbstractObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idVeiculo;

    private Integer idFabricante;
    private String nomeVeiculo;
    private String modelo;
    private String ano;
    private Integer cilindrada;
    private Integer cavalos;
    private Integer torque;
    private String imagem;

}
