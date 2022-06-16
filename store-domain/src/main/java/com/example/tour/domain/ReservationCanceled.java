package com.example.tour.domain;

import com.example.tour.AbstractEvent;

public class ReservationCanceled extends AbstractEvent {
    public ReservationCanceled(){
        super();
    }
    
    Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}
}
