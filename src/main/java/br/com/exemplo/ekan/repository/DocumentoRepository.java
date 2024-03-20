package br.com.exemplo.ekan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.ekan.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

  
}

