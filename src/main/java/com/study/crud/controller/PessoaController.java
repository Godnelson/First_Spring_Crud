package com.study.crud.controller;

import com.study.crud.model.PessoaModel;
import com.study.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public List<PessoaModel> getAll(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public Optional<PessoaModel> getByID(@PathVariable(name = "id") Long id){
        return pessoaRepository.findById(id);
    }

    @PostMapping("/pessoa")
    public PessoaModel saveRegister(@RequestBody PessoaModel pessoaModel){
        pessoaRepository.save(pessoaModel);
        return pessoaModel;
    }

    @PutMapping("/pessoa/{id}")
    public PessoaModel changeRegister(@RequestBody PessoaModel pessoaModel, @PathVariable(name = "id") Long id){
        PessoaModel pessoa = pessoaRepository.getById(id);
        pessoa.setNome(pessoaModel.getNome());
        pessoa.setNacionalidade(pessoaModel.getNacionalidade());
        pessoaRepository.save(pessoa);
        return pessoaModel;
    }

    @DeleteMapping("/pessoa/{id}")
    public String deleteRegister(@PathVariable(name = "id") Long id){
        pessoaRepository.deleteById(id);
        return "Deletado";
    }


}
