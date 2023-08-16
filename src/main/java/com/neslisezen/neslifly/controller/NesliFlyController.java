package com.neslisezen.neslifly.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/neslifly")
public class NesliFlyController
{
    List<String> nameList = new ArrayList<>() ;

   @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }
    @GetMapping(value = "/probe")
    public String getName(){
        return nameList.get(2);
    }

}
