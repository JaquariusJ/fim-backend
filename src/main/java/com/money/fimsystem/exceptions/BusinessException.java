package com.money.fimsystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BusinessException extends RuntimeException{

    private String message;

}
