package com.marcos.server.repository;

import com.marcos.server.model.Trauma;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TraumaRepository extends JpaRepository<Trauma, Long>{
    
}
