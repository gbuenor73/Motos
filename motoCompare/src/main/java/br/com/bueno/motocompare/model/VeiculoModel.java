package br.com.bueno.motocompare.model;

import br.com.bueno.motocompare.controllers.requests.Veiculo;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeiculo;
    private Integer idFabricante;
    private String nomeVeiculo;
    private String modelo;
    private String ano;
    private Integer cilindrada;
    private Integer cavalos;
    private Integer torque;
    private String imagem;

    public Veiculo convertToDomain() {
        return Veiculo.builder()
                .idVeiculo(this.idVeiculo)
                .idFabricante(this.idFabricante)
                .nomeVeiculo(this.nomeVeiculo)
                .modelo(this.modelo)
                .ano(this.ano)
                .cilindrada(this.cilindrada)
                .cavalos(this.cavalos)
                .torque(this.torque)
                .imagem(this.imagem)
                .build();
    }

    public static VeiculoModel convertToModel(Veiculo veiculo) {
        return VeiculoModel.builder()
                .idVeiculo(veiculo.getIdVeiculo())
                .idFabricante(veiculo.getIdFabricante())
                .nomeVeiculo(veiculo.getNomeVeiculo())
                .modelo(veiculo.getModelo())
                .ano(veiculo.getAno())
                .cilindrada(veiculo.getCilindrada())
                .cavalos(veiculo.getCavalos())
                .torque(veiculo.getTorque())
                .imagem(veiculo.getImagem())
                .build();
    }

}
