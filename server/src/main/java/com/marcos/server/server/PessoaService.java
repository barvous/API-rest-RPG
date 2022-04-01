package com.marcos.server.server;

import java.util.List;

import com.marcos.server.model.Pessoa;

public interface PessoaService {

    List<Pessoa> listarPessoa();

    Pessoa buscarPessoa(Long id);

    Pessoa criarPessoa(Pessoa pessoa);

    Pessoa atualizarPessoa(Pessoa pessoa, Long id);

    void removerPessoa(Long id);

    void validarPessoa(Pessoa pessoa);

}
