package com.zemoga.portafolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoga.portafolio.common.PortafolioDTO;
import com.zemoga.portafolio.common.entity.Portafolio;
import com.zemoga.portafolio.common.repository.PortafolioRepository;

@Service
public class PortafolioService {
  @Autowired private PortafolioRepository portafolioRepository;

  public Portafolio getPortafolios(Long id) {
    return portafolioRepository.getById(id);
  }

  public void updatePortafolio(PortafolioDTO dto) {
    portafolioRepository.save(null);
  }
}
