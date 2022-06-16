package com.example.tour;


import com.example.tour.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String>{    // Repository Pattern Interface
  
}