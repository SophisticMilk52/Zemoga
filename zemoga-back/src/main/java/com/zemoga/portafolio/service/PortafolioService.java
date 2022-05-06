package com.zemoga.portafolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoga.portafolio.common.PortfolioDTO;
import com.zemoga.portafolio.common.entity.Portfolio;
import com.zemoga.portafolio.common.repository.PortfolioRepository;

@Service
public class PortafolioService {
  @Autowired private PortfolioRepository portfolioRepository;

  public Portfolio getPortafolios(long id) {
    Optional<Portfolio> portfolio = portfolioRepository.findById(id);
    if (portfolio.isPresent()) {
      return portfolio.get();
    }
    return null;
  }

  public List<Portfolio> getAllPortafolios() {
    return portfolioRepository.findAll();
  }

  public void updatePortafolio(long id, PortfolioDTO dto) {
    Optional<Portfolio> port = portfolioRepository.findById(id);
    if (port.isPresent()) {
      port.get().setDescription(dto.getDescription());
      port.get().setNames(dto.getNames());
      port.get().setExperienceSummary(dto.getExperienceSummary());
      port.get().setTittle(dto.getTittle());
      port.get().setEmail(dto.getEmail());
      port.get().setLastNames(dto.getLastNames());
      port.get().setTwitterUsername(dto.getTwitterUsername());
      port.get().setImage(dto.getImage());
      portfolioRepository.save(port.get());
    }
  }
}
