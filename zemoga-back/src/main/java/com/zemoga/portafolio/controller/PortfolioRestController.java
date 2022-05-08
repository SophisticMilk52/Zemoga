package com.zemoga.portafolio.controller;

import java.util.List;
import java.util.Map;

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
import com.zemoga.portafolio.common.utils.TwitterApi;
import com.zemoga.portafolio.service.PortafolioService;

import twitter4j.Status;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/")
public class PortfolioRestController {

  @Autowired private PortafolioService portfolioService;
  @Autowired private TwitterApi twitterApi;

  @GetMapping("/getPortafolio/{id}")
  public ResponseEntity<PortfolioDTO> getPortafolio(@PathVariable long id) throws TwitterException {
    PortfolioDTO port = portfolioService.getPortafolios(id);
    List<Status> list = twitterApi.consumeTwitterApi(port.getNames());
    port.setStatus(list);
    return new ResponseEntity<PortfolioDTO>(port, HttpStatus.OK);
  }

  @GetMapping("/getAllPortafolios")
  public ResponseEntity<List<Portfolio>> getAllPortafolios() {
    return new ResponseEntity<List<Portfolio>>(portfolioService.getAllPortafolios(), HttpStatus.OK);
  }

  @PatchMapping("/editPortfolio/{id}")
  public ResponseEntity<String> updatePortafolio(
      @PathVariable int id, @RequestBody Map<Object, Object> entityResource) {
    portfolioService.updatePortafolio(id, entityResource);
    return new ResponseEntity<>("Se actualizo correctamente el producto", HttpStatus.OK);
  }
}
