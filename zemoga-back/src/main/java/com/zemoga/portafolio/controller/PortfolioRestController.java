package com.zemoga.portafolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoga.portafolio.common.PortfolioDTO;
import com.zemoga.portafolio.common.entity.Portfolio;
import com.zemoga.portafolio.service.PortafolioService;

@RestController
@RequestMapping("/")
public class PortfolioRestController {

  @Autowired private PortafolioService portfolioService;

  @GetMapping("/getPortafolio/{id}")
  public ResponseEntity<Portfolio> getPortafolio(@PathVariable long id) {
    return new ResponseEntity<Portfolio>(portfolioService.getPortafolios(id), HttpStatus.OK);
  }

  @GetMapping("/getAllPortafolios")
  public ResponseEntity<List<Portfolio>> getAllPortafolios() {
    return new ResponseEntity<List<Portfolio>>(portfolioService.getAllPortafolios(), HttpStatus.OK);
  }

  @PatchMapping("/editPortfolio/{id}")
  public ResponseEntity<String> updatePortafolio(
      @PathVariable long id, @RequestBody PortfolioDTO entityResource) {
    portfolioService.updatePortafolio(id, entityResource);
    return new ResponseEntity<>("Se actualizo correctamente el producto", HttpStatus.OK);
  }
}
