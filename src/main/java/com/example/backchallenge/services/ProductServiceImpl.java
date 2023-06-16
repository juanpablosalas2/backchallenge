package com.example.backchallenge.services;

import com.example.backchallenge.exceptions.ProductNotFoundException;
import com.example.backchallenge.shared.Constants;
import com.example.backchallenge.vo.ProductDetail;
import com.example.backchallenge.vo.SimilarProducts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

  private final RestTemplate restTemplate;

  @Value("${products.url}")
  private String statusUrl;

  @Override
  public SimilarProducts getProducts(String id) {
    String urlSimilars = getUrl(id).concat(Constants.SIMILAR_IDS_PATH);
    List<ProductDetail> productDetails = new ArrayList<>();
    try {
      productDetails.add(restTemplate.getForEntity(getUrl(id), ProductDetail.class).getBody());
      Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(urlSimilars, Integer[].class).getBody()))
          .forEach(integer -> productDetails.add(restTemplate.getForEntity(getUrl(integer.toString()), ProductDetail.class).getBody()));
    }catch (Exception e){
      throw new ProductNotFoundException();
    }
    return SimilarProducts.builder()
        .productDetails(productDetails)
        .build();
  }

  private String getUrl(String id) {
    return UriComponentsBuilder.fromHttpUrl(statusUrl)
        .buildAndExpand(Collections.singletonMap(Constants.ID, id)).toUriString();
  }
}
