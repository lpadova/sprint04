package br.com.fiap.challenge03.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationFieldError {

    private String error;
    private String msg;
}
