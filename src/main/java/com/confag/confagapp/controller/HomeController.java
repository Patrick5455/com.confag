package com.confag.confagapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Value("${app.version}") //tells SB maps to look into the props section of the map and inject
    // property with this name ${app.version} into this field
    private String appVersion;

    @GetMapping
    public Map<String, Object> getStatus(){
        Map<String, Object> appV  = new HashMap<String, Object>();
        appV.put("app-version", appVersion);
        return appV;
    }
}
