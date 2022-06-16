package com.example.tour;


import com.example.tour.domain.Tour;

import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Long>{    // Repository Pattern Interface
  
}
