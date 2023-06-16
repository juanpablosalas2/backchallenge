package com.example.backchallenge.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {


  private final String code;

  private final String description;

  private final Integer statusCode;

  /**
   * Creates a new instance, with provided fields.
   *
   * @param code        API error code.
   * @param description API error description.
   * @param statusCode  API error HTTP Status code.
   */
  public ApiException(String code, String description, Integer statusCode) {
    super(description);
    this.code = code;
    this.description = description;
    this.statusCode = statusCode;
  }

  /**
   * Creates a new instance, with provided fields.
   *
   * @param code        API error code.
   * @param description API error description.
   * @param statusCode  API error HTTP Status code.
   * @param cause       API error cause.
   */
  public ApiException(String code, String description, Integer statusCode, Throwable cause) {
    super(description, cause);
    this.code = code;
    this.description = description;
    this.statusCode = statusCode;
  }
}
