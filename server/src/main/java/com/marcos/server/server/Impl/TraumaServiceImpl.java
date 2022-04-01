package com.marcos.server.server.Impl;

import java.util.List;

import com.marcos.server.model.Trauma;
import com.marcos.server.model.exception.BadRequestException;
import com.marcos.server.model.exception.NotFoundException;
import com.marcos.server.repository.TraumaRepository;
import com.marcos.server.server.TraumaService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TraumaServiceImpl implements TraumaService{
    
    @Autowired
    TraumaRepository traumaRepository;

    @Override
    public List<Trauma> listarTrauma() {
        return traumaRepository.findAll();
    }

    @Override
    public Trauma buscarTrauma(Long id) {
        return traumaRepository.findById(id)
        .orElseThrow(()-> new NotFoundException("Não foi encontrado nenhuma trauma com o id "+id));
    }

    @Override
    public Trauma criarTrauma(Trauma trauma) {
        
        //VERIFICA SE OS CAMPOS PRINCIPAIS ESTÃO NULOS
        validarTrauma(trauma);

        //SETANDO O ID COMO NULL PARA SER GERADO UM ID AUTOMÁTICO NO BANCO DE DADOS
        //E TAMBÉM PARA NÃO CORRER RISCO DE ALTERAR OUTRO REGISTRO NO BANCO.
        trauma.setId(null);

        //SALVANDO O HABILIDADE NO BANCO DE DADOS
        return traumaRepository.save(trauma);
        
    }

    @Override
    public Trauma atualizarTrauma(Trauma traumaAlteracoes, Long id) {

        //SETANDO O ID DO OBJETO COMO O ID DA URL
        traumaAlteracoes.setId(id);
        
        //PROCURA A HABILIDADE QUE SE DESEJA ATUALIZAR E LANÇA UMA EXCEÇÃO CASO NÃO ENCONTRE
        Trauma traumaAlvo = buscarTrauma(id);
            
        //VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
        traumaAlteracoes = verificarAtualizacaoTrauma(traumaAlteracoes, traumaAlvo);
        
        //AS ALTERAÇÕES SÃO COPIADAS PARA A HABILIDADE ALVO
        BeanUtils.copyProperties(traumaAlteracoes, traumaAlvo);
        
        //O HABILIDADE ALVO, AGORA COM AS ALTERAÇÕES, É SALVO NO BANCO DE DADOS
        traumaRepository.save(traumaAlvo);

        return traumaAlvo;
    }

    @Override
    public void removerTrauma(Long id) {
        try {
            traumaRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new BadRequestException("Não foi encontrado nenhum trauma com o id "+id);
        }
    }

    //VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
    public Trauma verificarAtualizacaoTrauma(Trauma traumaAlteracoes, Trauma traumaAlvo){
        //CASO O NOME SEJA NULO, ELE NÃO SOFRE ALTERAÇÕES
        if(traumaAlteracoes.getDescricao() == null)
        traumaAlteracoes.setDescricao(traumaAlvo.getDescricao());

        if(traumaAlteracoes.getGravidade() == null)
        traumaAlteracoes.setGravidade(traumaAlvo.getGravidade());

        if(traumaAlteracoes.getNome() == null)
        traumaAlteracoes.setNome(traumaAlvo.getNome());

        return traumaAlteracoes;
    }

    //VERIFICA SE OS CAMPOS PRINCIPAIS ESTÃO NULOS
    public void validarTrauma(Trauma trauma){
        if(trauma.getNome() == null || trauma.getGravidade() == null)
            throw new BadRequestException("Requisição inválida. Os campos: nome e gravidade não podem ser nulos.");
    }
}
