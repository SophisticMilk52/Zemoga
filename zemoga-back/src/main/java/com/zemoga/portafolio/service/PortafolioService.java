package com.zemoga.portafolio.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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

  public Portfolio addPortfolio(PortfolioDTO dto) {
    Portfolio portfolio = new Portfolio();
    portfolio.setDescription(dto.getDescription());
    portfolio.setEmail(dto.getEmail());
    portfolio.setImage(dto.getImage());
    portfolio.setExperienceSummary(dto.getExperienceSummary());
    portfolio.setLastNames(dto.getLastNames());
    portfolio.setNames(dto.getNames());
    portfolio.setTittle(dto.getTittle());
    portfolio.setTwitterUsername(dto.getTwitterUsername());
    return portfolioRepository.save(portfolio);
  }

  public void updatePortafolio(long id, Map<Object, Object> entityResource) {
    Optional<Portfolio> port = portfolioRepository.findById(id);
    if (port.isPresent()) {
      entityResource.forEach(
          (key, value) -> {
            Field field = ReflectionUtils.findField(Portfolio.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, port.get(), value);
          });
      portfolioRepository.save(port.get());
    }
  }
}
