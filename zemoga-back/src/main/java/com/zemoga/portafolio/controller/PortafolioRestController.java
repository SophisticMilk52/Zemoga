package com.zemoga.portafolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zemoga.portafolio.common.PortafolioDTO;
import com.zemoga.portafolio.common.entity.Portafolio;
import com.zemoga.portafolio.service.PortafolioService;

@RestController
@RequestMapping("/")
public class PortafolioRestController {
  @Autowired private PortafolioService portafolioService;

  @GetMapping("/getProducts")
  public ResponseEntity<Portafolio> getPortafolio(@RequestParam Long id) {
    return new ResponseEntity<Portafolio>(portafolioService.getPortafolios(id), HttpStatus.OK);
  }

  @PatchMapping("/editProduct")
  public ResponseEntity<String> updateProduct(@RequestBody PortafolioDTO entityResource) {

    return new ResponseEntity<>("Se actualizo correctamente el producto", HttpStatus.OK);
  }
}
