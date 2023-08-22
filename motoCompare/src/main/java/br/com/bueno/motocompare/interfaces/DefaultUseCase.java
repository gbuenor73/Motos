package br.com.bueno.motocompare.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public interface DefaultUseCase {

    <T> List<T> buscaTodos();
    <T> T buscaUm(Integer id);

    <T> T insereUm(Object model);

    void deletaUm(Integer id);

}
