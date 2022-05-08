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

  public PortfolioDTO getPortafolios(long id) {
    Optional<Portfolio> portfolio = portfolioRepository.findById(id);
    PortfolioDTO dto = new PortfolioDTO();
    if (portfolio.isPresent()) {
      dto.setDescription(portfolio.get().getDescription());
      dto.setNames(portfolio.get().getNames());
      dto.setExperienceSummary(portfolio.get().getExperienceSummary());
      dto.setTittle(portfolio.get().getTittle());
      dto.setEmail(portfolio.get().getEmail());
      dto.setLastNames(portfolio.get().getLastNames());
      dto.setTwitterUsername(portfolio.get().getTwitterUsername());
      dto.setImage(portfolio.get().getImage());
      return dto;
    }
    return null;
  }

  public List<Portfolio> getAllPortafolios() {
    return portfolioRepository.findAll();
  }

  public void updatePortafolio(long id, PortfolioDTO dto) {
    Optional<Portfolio> port = portfolioRepository.findById(id);
    if (port.isPresent()) {
      if (dto.getDescription() != null) {
        port.get().setDescription(dto.getDescription());
      }
      if (dto.getNames() != null) {
        port.get().setNames(dto.getNames());
      }
      if (dto.getExperienceSummary() != null) {
        port.get().setExperienceSummary(dto.getExperienceSummary());
      }
      if (dto.getTittle() != null) {
        port.get().setTittle(dto.getTittle());
      }
      if (dto.getEmail() != null) {
        port.get().setEmail(dto.getEmail());
      }
      if (dto.getLastNames() != null) {
        port.get().setLastNames(dto.getLastNames());
      }
      if (dto.getTwitterUsername() != null) {
        port.get().setTwitterUsername(dto.getTwitterUsername());
      }
      if (dto.getImage() != null) {
        port.get().setImage(dto.getImage());
      }
      portfolioRepository.save(port.get());
    }
  }
}
