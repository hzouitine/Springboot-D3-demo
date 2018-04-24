package com.example.demo.repositories;

import com.example.demo.domain.Age;
import org.springframework.data.repository.CrudRepository;

public interface AgeRepository extends CrudRepository<Age,Integer> {
}
