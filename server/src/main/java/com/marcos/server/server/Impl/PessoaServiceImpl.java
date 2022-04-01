package com.marcos.server.server.Impl;

import java.util.List;

import com.marcos.server.model.Pessoa;
import com.marcos.server.model.exception.BadRequestException;
import com.marcos.server.model.exception.NotFoundException;
import com.marcos.server.repository.PessoaRepository;
import com.marcos.server.server.PessoaService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {
    
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa buscarPessoa(Long id) {
        return pessoaRepository.findById(id)
        .orElseThrow(()-> new NotFoundException("Não foi encontrado nenhuma pessoa com o id "+id));
    }

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        
        //VERIFICA SE OS CAMPOS PRINCIPAIS ESTÃO NULOS
        validarPessoa(pessoa);

        //SETANDO O ID COMO NULL PARA SER GERADO UM ID AUTOMÁTICO NO BANCO DE DADOS
        //E TAMBÉM PARA NÃO CORRER RISCO DE ALTERAR OUTRO REGISTRO NO BANCO.
        pessoa.setId(null);

        //SALVANDO O PESSOA NO BANCO DE DADOS
        return pessoaRepository.save(pessoa);
        
    }

    @Override
    public Pessoa atualizarPessoa(Pessoa pessoaAlteracoes, Long id) {

        //SETANDO O ID DO OBJETO COMO O ID DA URL
        pessoaAlteracoes.setId(id);
        
        //PROCURA A PESSOA QUE SE DESEJA ATUALIZAR E LANÇA UMA EXCEÇÃO CASO NÃO ENCONTRE
        Pessoa pessoaAlvo = buscarPessoa(id);
            
        //VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
        pessoaAlteracoes = verificarAtualizacaoPessoa(pessoaAlteracoes, pessoaAlvo);
        
        //AS ALTERAÇÕES SÃO COPIADAS PARA A PESSOA ALVO
        BeanUtils.copyProperties(pessoaAlteracoes, pessoaAlvo);
        
        //O PESSOA ALVO, AGORA COM AS ALTERAÇÕES, É SALVO NO BANCO DE DADOS
        pessoaRepository.save(pessoaAlvo);

        return pessoaAlvo;
    }

    @Override
    public void removerPessoa(Long id) {
        try {
            pessoaRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new BadRequestException("Não foi encontrado nenhum pessoa com o id "+id);
        }
    }

    //VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
    public Pessoa verificarAtualizacaoPessoa(Pessoa pessoaAlteracoes, Pessoa pessoaAlvo){
        //CASO O NOME SEJA NULO, ELE NÃO SOFRE ALTERAÇÕES
        if(pessoaAlteracoes.getAltura() ==0)
        pessoaAlteracoes.setAltura(pessoaAlvo.getAltura());

        if(pessoaAlteracoes.getAparencia() == null)
        pessoaAlteracoes.setAparencia(pessoaAlvo.getAparencia());

        if(pessoaAlteracoes.getDataNascimento() == null)
        pessoaAlteracoes.setDataNascimento(pessoaAlvo.getDataNascimento());

        if(pessoaAlteracoes.getGenero() == null)
        pessoaAlteracoes.setGenero(pessoaAlvo.getGenero());
        
        if(pessoaAlteracoes.getFamilia() == null)
        pessoaAlteracoes.setFamilia(pessoaAlvo.getFamilia());
        
        if(pessoaAlteracoes.getLore() == null)
        pessoaAlteracoes.setLore(pessoaAlvo.getLore());

        if(pessoaAlteracoes.getNome() == null)
        pessoaAlteracoes.setNome(pessoaAlvo.getNome());

        if(pessoaAlteracoes.getTerraNatal() == null)
        pessoaAlteracoes.setTerraNatal(pessoaAlvo.getTerraNatal());


        return pessoaAlteracoes;
    }

    //VERIFICA SE OS CAMPOS DE PESSOA SÃO NULOS OU VAZIOS
    public void validarPessoa(Pessoa pessoa){
        if(pessoa.getAltura() == 0)
        throw new BadRequestException("Altura não pode ser nula");

        if(pessoa.getAparencia() == null)
        throw new BadRequestException("Aparencia não pode ser nula");

        if(pessoa.getDataNascimento() == null)
        throw new BadRequestException("Data de nascimento não pode ser nula");

        if(pessoa.getGenero() == null)
        throw new BadRequestException("Genero não pode ser nulo");

        if(pessoa.getFamilia() == null)
        throw new BadRequestException("Familia não pode ser nula");

        if(pessoa.getLore() == null)
        throw new BadRequestException("Lore não pode ser nula");

        if(pessoa.getNome() == null)
        throw new BadRequestException("Nome não pode ser nulo");

        if(pessoa.getTerraNatal() == null)
        throw new BadRequestException("Terra natal não pode ser nula");
    }

    
}
