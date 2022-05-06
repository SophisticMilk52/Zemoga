package com.zemoga.portafolio.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoga.portafolio.common.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
  //Optional<Portfolio> findByName(String name);
}
