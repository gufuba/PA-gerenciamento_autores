package com.fumagalli.gerenciamento_autores.controllers;

import com.fumagalli.gerenciamento_autores.models.AutoresModel;
import com.fumagalli.gerenciamento_autores.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autores")
public class AutoresController {
    @Autowired
    private AutoresService autoresService;

    @GetMapping
    public ResponseEntity<List<AutoresModel>> findAll(){
        List<AutoresModel> requeste = autoresService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<AutoresModel> criarAutor(@RequestBody AutoresModel autoresModel){
        AutoresModel novo = autoresService.criarAutor(autoresModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autoresService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoresModel> buscarPorIdAutor(@PathVariable Long id){
        Optional<AutoresModel> autor = autoresService.buscarPorId(id);

        if(autor.isPresent()){
            return ResponseEntity.ok(autor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoresModel> atualizarAutor(@PathVariable Long id, @RequestBody AutoresModel autoresModel){
        AutoresModel atualizado = autoresService.atualizar(id, autoresModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
