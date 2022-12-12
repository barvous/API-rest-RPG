package com.marcos.server.server.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcos.server.model.Personagem;
import com.marcos.server.model.exception.NotFoundException;
import com.marcos.server.repository.PersonagemRepository;
import com.marcos.server.server.PersonagemService;

@Service
public class PersonagemServiceImpl implements PersonagemService {

    private final PersonagemRepository personagemRepository;

    //A injeção de dependência é feita através do construtor pois o objetos são 'final'.
    //Isso é feito para garantir que haverá somente UMA instância de cada classe que possa utilizar da Injeção de Dependência
    PersonagemServiceImpl(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    @Override
    @Transactional  // A anotação Transactional do springframework permite que as funções façam rollbacks no bancos de dados 
                    // caso haja alguma falha dentro da função.
    public Personagem salvarPersonagem(Personagem personagem) {

        if (personagem.getId() != null) {
            Long idPersonagem = personagem.getId();
            Personagem personagemBanco = buscarPersonagem(idPersonagem);

            // VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
            personagem = verificarAtualizacaoPersonagem(personagem, personagemBanco);

            // AS ALTERAÇÕES SÃO COPIADAS PARA A HABILIDADE ALVO
            BeanUtils.copyProperties(personagem, personagemBanco);
        }

        return personagemRepository.save(personagem);

    }

    @Override
    public List<Personagem> listarPersonagens() {
        return personagemRepository.findAll();
    }

    @Override
    public Personagem buscarPersonagem(Long idPersonagem) {
        return personagemRepository.findById(idPersonagem)
        .orElseThrow(() -> new NotFoundException("Não foi encontrado nenhum personagem com esse ID"));
    }

    @Override
    public void excluirPersonagem(Long idPersonagem) {

        try {
            personagemRepository.deleteById(idPersonagem);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Não foi encontrado nenhum personagem com esse ID");
        }

    }

    // VERIFICA SE ALGUM CAMPO É NULO, E CASO FOR NULO, ELE NÃO SOFRE ALTERAÇÕES
    private Personagem verificarAtualizacaoPersonagem(Personagem personagem, Personagem personagemBanco){
        //CASO O NOME SEJA NULO, ELE NÃO SOFRE ALTERAÇÕES
        if(personagem.getNomeJogador() == null){
            personagem.setNomeJogador(personagemBanco.getNomeJogador());
        }

        if(personagem.getNomePersonagem() == null){
            personagem.setNomePersonagem(personagemBanco.getNomePersonagem());
        }

        if(personagem.getOrigem() == null){
            personagem.setOrigem(personagemBanco.getOrigem());
        }
        
        if(personagem.getClasse() == null){
            personagem.setClasse(personagemBanco.getClasse());
        }

        if(personagem.getNex() == null){
            personagem.setNex(personagemBanco.getNex());
        }

        if(personagem.getAtributoForca() == null){
            personagem.setAtributoForca(personagemBanco.getAtributoForca());
        }

        if(personagem.getAtributoAgilidade() == null){
            personagem.setAtributoAgilidade(personagemBanco.getAtributoAgilidade());
        }

        if(personagem.getAtributoIntelecto() == null){
            personagem.setAtributoIntelecto(personagemBanco.getAtributoIntelecto());
        }

        if(personagem.getAtributoVigor() == null){
            personagem.setAtributoVigor(personagemBanco.getAtributoVigor());
        }

        if(personagem.getAtributoPresenca() == null){
            personagem.setAtributoPresenca(personagemBanco.getAtributoPresenca());
        }

        return personagem;
    }

}
