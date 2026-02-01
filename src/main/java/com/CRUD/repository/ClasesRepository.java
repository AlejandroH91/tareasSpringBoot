package com.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entidad.Clases;

@Repository
public interface ClasesRepository extends JpaRepository<Clases, Integer> {

}