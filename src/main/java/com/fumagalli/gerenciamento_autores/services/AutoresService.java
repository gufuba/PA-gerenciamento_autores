package com.fumagalli.gerenciamento_autores.services;

import com.fumagalli.gerenciamento_autores.models.AutoresModel;
import com.fumagalli.gerenciamento_autores.repositories.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<AutoresModel> findAll(){
        return autoresRepository.findAll();
    }

    public AutoresModel criarAutor(AutoresModel autoresModel){
        return autoresRepository.save(autoresModel);
    }

    public Optional<AutoresModel> buscarPorId(Long id){
        return autoresRepository.findById(id);
    }

    public AutoresModel atualizar(long id, AutoresModel autoresModel){
        AutoresModel model = autoresRepository.findById(id).get();
        model.setNome(autoresModel.getNome());
        model.setNacionalidade(autoresModel.getNacionalidade());
        model.setDataNascimento(autoresModel.getDataNascimento());

        return autoresRepository.save(model);
    }

    public void deletar(Long id){
        autoresRepository.deleteById(id);
    }

}
