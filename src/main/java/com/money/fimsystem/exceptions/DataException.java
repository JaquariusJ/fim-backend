package com.money.fimsystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DataException extends RuntimeException{

    private String message;

}
