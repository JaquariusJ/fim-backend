package com.money.fimsystem;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class ServiceTest {

    public static void main(String[] args) {
        String isFromDisk = "true";
        boolean aTrue = StringUtils.equals(isFromDisk, "true");
        System.out.println(aTrue);
    }
}
