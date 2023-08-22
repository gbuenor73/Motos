package br.com.bueno.motocompare.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DefaultController {


    <T> ResponseEntity<List<T>> buscaTodos();

    <T> ResponseEntity<T> buscaUm(Integer id);

//    <T> ResponseEntity<T> insereUm(T obj);

    ResponseEntity deletaUm(Integer id);


}
