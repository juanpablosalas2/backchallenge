package com.example.backchallenge.exceptions;

import com.example.backchallenge.shared.Constants;
import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ApiException{

  public ProductNotFoundException(){
    super(Constants.ERROR_MSG, "Product not found", HttpStatus.NOT_FOUND.value());
  }
}
