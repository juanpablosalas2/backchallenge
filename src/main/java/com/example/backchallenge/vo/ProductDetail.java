package com.example.backchallenge.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {

  @NotNull
  @NotBlank
  private String id;

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  private Integer price;

  @NotNull
  @NotBlank
  private Boolean availability;
}
