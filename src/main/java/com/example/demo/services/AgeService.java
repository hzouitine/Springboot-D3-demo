package com.example.demo.services;

import com.example.demo.domain.Age;
import com.example.demo.repositories.AgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgeService {

    private AgeRepository ageRepository;

    @Autowired
    public AgeService(AgeRepository ageRepository) {
        this.ageRepository = ageRepository;
    }

    public void save(Age age){
        ageRepository.save(age);
    }

    public List<Age> findAll(){
        List ages = new ArrayList<>();
        for(Age a : ageRepository.findAll()){
            ages.add(a);
        }
        return ages;
    }

    public int[] getChartData(){
       int[] data = new int[4];
       for(Age a : findAll()){
           int age = a.getAge();
           if(age < 10)
               data[0]++;
           else if (age < 20)
               data[1]++;
           else if (age<30)
               data[2]++;
           else if(age < 40)
               data[3]++;
       }
       return data;
    }
}
