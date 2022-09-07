package com.estudo.querydsl.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.estudo.querydsl.datatable.DatatableRequest;
import com.estudo.querydsl.datatable.DatatableResponse;
import com.estudo.querydsl.model.Funcionario;
import com.estudo.querydsl.repository.FuncionarioRepository;

import lombok.Builder;

@Builder
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @ResponseBody
    @PostMapping("all")
    public ResponseEntity<DatatableResponse<Funcionario>> getAll(
        @RequestBody DatatableRequest datatableRequest){

        final List<Funcionario> listaFuncionario = (
            Objects.nonNull(datatableRequest.getSearch().getValue()) ?
            funcionarioRepository.findByNomeStartsWith(datatableRequest.getSearch().getValue()) :
            funcionarioRepository.findAll()
        );

        final DatatableResponse<Funcionario> datatableResponse = new DatatableResponse<>();

        datatableResponse.setDraw(datatableRequest.getDraw());
        datatableResponse.setRecordsTotal(listaFuncionario.size());
        datatableResponse.setRecordsFiltered(listaFuncionario.size());
        datatableResponse.setData(listaFuncionario);

        return new ResponseEntity<>(datatableResponse, HttpStatus.OK);
    }
}
