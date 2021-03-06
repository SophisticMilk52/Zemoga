package com.zemoga.portafolio.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.zemoga.portafolio.common.PortfolioDTO;
import com.zemoga.portafolio.common.entity.Portfolio;
import com.zemoga.portafolio.common.repository.PortfolioRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PortafolioServiceTest {
  @Mock private PortfolioRepository portfolioRepository;
  @InjectMocks private PortafolioService portafolioService;

  private Portfolio portfolio = new Portfolio();

  private List<Portfolio> list = new ArrayList<>();

  @Before
  public void setup() {
    portfolio.setDescription("descripcion");
    portfolio.setEmail("email@correo.com");
    portfolio.setIdPortfolio(2);
    portfolio.setNames("Alejandro");
    list.add(portfolio);
  }

  @Test
  public void getPortafoliosTest() {
    when(portfolioRepository.findById(any(Long.class))).thenReturn(Optional.of(portfolio));
    assertEquals("Alejandro", portafolioService.getPortafolios(2L).getNames());
  }

  @Test
  public void getAllPortafoliosTest() {
    portafolioService.getAllPortafolios();
    when(portfolioRepository.findAll()).thenReturn(list);
    assertEquals(1, portafolioService.getAllPortafolios().size());
  }

  @Test
  public void addPortfolioTest() {
    when(portfolioRepository.save(any(Portfolio.class))).thenReturn(new Portfolio());
    assertNotNull(portafolioService.addPortfolio(new PortfolioDTO()));
  }

  @Test
  public void updatePortafolioTest() {
    Map<Object, Object> map = new HashMap<Object, Object>();
    map.put("names", "Raul");
    when(portfolioRepository.findById(any(Long.class))).thenReturn(Optional.of(portfolio));
    portafolioService.updatePortafolio(2L, map);
    assertEquals("Raul", portfolioRepository.findById(2L).get().getNames());
  }
}
