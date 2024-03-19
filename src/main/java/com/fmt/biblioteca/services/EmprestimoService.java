package com.fmt.biblioteca.services;

import com.fmt.biblioteca.entities.Emprestimo;
import com.fmt.biblioteca.entities.Livro;
import com.fmt.biblioteca.entities.Membro;
import com.fmt.biblioteca.handlers.RestConflictException;
import com.fmt.biblioteca.handlers.RestNotFoundException;
import com.fmt.biblioteca.models.EmprestimoModel;
import com.fmt.biblioteca.repositories.EmprestimoRepository;
import com.fmt.biblioteca.repositories.LivroRepository;
import com.fmt.biblioteca.repositories.MembroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final MembroRepository membroRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository, MembroRepository membroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.membroRepository = membroRepository;
    }

    public List<Emprestimo> list() {
        return emprestimoRepository.findAllByOrderByIdAsc();
    }


    public Emprestimo create(EmprestimoModel model) {
        Livro livro = livroRepository.findById(model.getIdLivro()).orElseThrow(() -> new RestNotFoundException("Livro não encontrado!"));

        Membro membro = membroRepository.findById(model.getIdMembro()).orElseThrow(() -> new RestNotFoundException("Membro não encontrado!"));

        if (emprestimoRepository.existsByMembro_IdAndLivro_IdAndDataDevolucao(model.getIdMembro(), model.getIdLivro(), null))
            throw new RestConflictException("Emprestimo já realizado!");

        return emprestimoRepository.save(new Emprestimo(membro,livro));
    }

    public Emprestimo update(EmprestimoModel model) {
        Emprestimo existent = emprestimoRepository.findFirstByMembro_IdAndLivro_IdAndDataDevolucao(model.getIdMembro(), model.getIdLivro(), null).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado!"));
        existent.setDataDevolucao(LocalDateTime.now());
        emprestimoRepository.update(existent.getId(), existent.getDataDevolucao());
        return existent;
    }

    public void delete(Long id) {
        int deleted = emprestimoRepository.deleteEmprestimoById(id);
        if(deleted==0)
            throw new RestNotFoundException("Emprestimo não encontrado!");
    }
}
