package com.loja.livros.reporitory;

import com.loja.livros.models.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivrosRepository extends JpaRepository<LivrosModel, UUID> {
    List<LivrosModel> findByGenero(String genero);
}
