package com.marcos.server.server.Impl;

import java.util.List;

import com.marcos.server.model.Habilidade;
import com.marcos.server.model.exception.BadRequestException;
import com.marcos.server.model.exception.NotFoundException;
import com.marcos.server.repository.HabilidadeRepository;
import com.marcos.server.server.HabilidadeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class HabilidadeServiceImpl  implements HabilidadeService{
    
    @Autowired
    HabilidadeRepository habilidadeRepository;

    @Override
    public List<Habilidade> listarHabilidade() {
        return habilidadeRepository.findAll();
    }

    @Override
    public Habilidade buscarHabilidade(Long id) {
        return habilidadeRepository.findById(id)
        .orElseThrow(()-> new NotFoundException("Não foi encontrado nenhuma habilidade com o id "+id));
    }

    @Override
    public Habilidade criarHabilidade(Habilidade habilidade) {
        
        //VERIFICA SE OS CAMPOS PRINCIPAIS ESTÃO NULOS
        validarHabilidade(habilidade);

        //SETANDO O ID COMO NULL PARA SER GERADO UM ID AUTOMÁTICO NO BANCO DE DADOS
        //E TAMBÉM PARA NÃO CORRER RISCO DE ALTERAR OUTRO REGISTRO NO BANCO.
        habilidade.setId(null);

        //SALVANDO O HABILIDADE NO BANCO DE DADOS
        return habilidadeRepository.save(habilidade);
        
    }

    @Override
    public Habilidade atualizarHabilidade(Habilidade habilidadeAlteracoes, Long id) {

        //SETANDO O ID DO OBJETO COMO O ID DA URL
        habilidadeAlteracoes.setId(id);
        
        //PROCURA A HABILIDADE QUE SE DESEJA ATUALIZAR E LANÇA UMA EXCEÇÃO CASO NÃO ENCONTRE
        Habilidade habilidadeAlvo = buscarHabilidade(id);
            
        //VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
        habilidadeAlteracoes = verificarAtualizacaoHabilidade(habilidadeAlteracoes, habilidadeAlvo);
        
        //AS ALTERAÇÕES SÃO COPIADAS PARA A HABILIDADE ALVO
        BeanUtils.copyProperties(habilidadeAlteracoes, habilidadeAlvo);
        
        //O HABILIDADE ALVO, AGORA COM AS ALTERAÇÕES, É SALVO NO BANCO DE DADOS
        habilidadeRepository.save(habilidadeAlvo);

        return habilidadeAlvo;
    }

    @Override
    public void removerHabilidade(Long id) {
        try {
            habilidadeRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new BadRequestException("Não foi encontrado nenhuma habilidade com o id "+id);
        }
    }

    //VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
    public Habilidade verificarAtualizacaoHabilidade(Habilidade habilidadeAlteracoes, Habilidade habilidadeAlvo){
        //CASO O NOME SEJA NULO, ELE NÃO SOFRE ALTERAÇÕES
        if(habilidadeAlteracoes.getNome() == null)
        habilidadeAlteracoes.setNome(habilidadeAlvo.getNome());

        if(habilidadeAlteracoes.getDescricao() == null)
        habilidadeAlteracoes.setDescricao(habilidadeAlvo.getDescricao());

        if(habilidadeAlteracoes.getTipo() == null)
        habilidadeAlteracoes.setTipo(habilidadeAlvo.getTipo());

        if(habilidadeAlteracoes.getCusto() == null)
        habilidadeAlteracoes.setCusto(habilidadeAlvo.getCusto());

        if(habilidadeAlteracoes.getValor() == null)
        habilidadeAlteracoes.setValor(habilidadeAlvo.getValor());
    
        return habilidadeAlteracoes;
    }

    //VERIFICA SE OS CAMPOS PRINCIPAIS ESTÃO NULOS
    public void validarHabilidade(Habilidade habilidade){
        if(habilidade.getNome() == null || habilidade.getTipo() == null || habilidade.getDescricao() == null)
            throw new BadRequestException("Requisição inválida. Os campos: nome, tipo e habilidade não podem ser nulos.");
    }
}
