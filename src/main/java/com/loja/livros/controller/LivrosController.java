package com.loja.livros.controller;

import com.loja.livros.models.LivrosModel;
import com.loja.livros.reporitory.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/livros")
@Validated
public class LivrosController {
    @Autowired
    private LivrosRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivrosModel>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value="id") UUID id ){
        Optional<LivrosModel> productO = livroRepository.findById(id);
        if(productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product nao encontrado");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(productO.get());
        }
    }

    @PostMapping
    public ResponseEntity<LivrosModel> addLivro(@RequestBody LivrosModel livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
    }

    @GetMapping("/genero/{genero}")
    public List<LivrosModel> getLivrosByGenero(@PathVariable String genero) {
        return livroRepository.findByGenero(genero);
    }
}
