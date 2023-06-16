package com.example.backchallenge.controller;

import com.example.backchallenge.services.ProductService;
import com.example.backchallenge.vo.SimilarProducts;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
@Validated
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{productId}/similar")
  public ResponseEntity<SimilarProducts> getProducts(@PathVariable @Min(1) String productId) {
    return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts(productId));
  }
}
