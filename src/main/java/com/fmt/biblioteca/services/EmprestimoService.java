package com.fmt.biblioteca.services;

import com.fmt.biblioteca.entities.Emprestimo;
import com.fmt.biblioteca.entities.Livro;
import com.fmt.biblioteca.entities.Membro;
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


    public Emprestimo create(EmprestimoModel model) throws RuntimeException {
        Livro livro = livroRepository.findById(model.getIdLivro()).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        Membro membro = membroRepository.findById(model.getIdMembro()).orElseThrow(() -> new RuntimeException("Membro não encontrado!"));

        if (emprestimoRepository.existsByMembro_IdAndLivro_IdAndDataDevolucao(model.getIdMembro(), model.getIdLivro(), null))
            throw new RuntimeException("Emprestimo já realizado!");

        return emprestimoRepository.save(new Emprestimo(membro,livro));
    }

    public Emprestimo update(EmprestimoModel model) throws Exception {
        Emprestimo existent = emprestimoRepository.findFirstByMembro_IdAndLivro_IdAndDataDevolucao(model.getIdMembro(), model.getIdLivro(), null).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado!"));
        existent.setDataDevolucao(LocalDateTime.now());
        emprestimoRepository.update(existent.getId(), existent.getDataDevolucao());
        return existent;
    }

    public void delete(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
