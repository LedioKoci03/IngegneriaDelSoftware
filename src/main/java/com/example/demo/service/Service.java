package com.example.demo.service;

import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Service
public class Service {

    Repository repository;

    public Service(Repository repository){
        this.repository = repository;
    }

}
