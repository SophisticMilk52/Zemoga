package com.zemoga.portafolio.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoga.portafolio.common.entity.Portafolio;

public interface PortafolioRepository extends JpaRepository<Portafolio, Long> {
  Optional<Portafolio> findByName(String name);
}
