package com.example.backchallenge.services;

import com.example.backchallenge.vo.SimilarProducts;

public interface ProductService {

  SimilarProducts getProducts(String id);
}
