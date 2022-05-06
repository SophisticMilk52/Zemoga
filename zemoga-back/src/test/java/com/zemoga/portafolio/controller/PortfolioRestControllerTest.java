package com.zemoga.portafolio.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.zemoga.portafolio.common.PortfolioDTO;
import com.zemoga.portafolio.common.entity.Portfolio;
import com.zemoga.portafolio.service.PortafolioService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PortfolioRestControllerTest {

  @Mock private PortafolioService portafolioService;
  @InjectMocks private PortfolioRestController portfolioRestController;

  @Test
  public void getPortafolioTest() {
    when(portafolioService.getPortafolios(any(Long.class))).thenReturn(new Portfolio());
    assertEquals(HttpStatus.OK, portfolioRestController.getPortafolio(2L).getStatusCode());
  }

  @Test
  public void getAllPortafoliosTest() {
    assertEquals(HttpStatus.OK, portfolioRestController.getAllPortafolios().getStatusCode());
  }

  @Test
  public void updatePortafolioTest() {

    // verify(portafolioService).updatePortafolio(any(Long.class), any(PortfolioDTO.class));
    assertEquals(
        HttpStatus.OK,
        portfolioRestController.updatePortafolio(2L, new PortfolioDTO()).getStatusCode());
  }
}
