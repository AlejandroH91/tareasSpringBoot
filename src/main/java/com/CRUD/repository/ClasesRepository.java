package com.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CRUD.entidad.*;

@Repository
public interface ClasesRepository extends JpaRepository<Clases, Integer> {

}