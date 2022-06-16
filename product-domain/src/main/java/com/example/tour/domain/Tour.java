package com.example.tour.domain;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.STRING,
    name = "tour_type", // pet_type
    columnDefinition = "varchar(50)"
)
public abstract class Tour {     // Entity. Domain Class.


    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;    
        public Long getId() {
            return id;
        }

    private int orderQuantity; // Appearance

    public int getOrderQuantity() {
        return orderQuantity;
    }
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    String countryName;  //name
        public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    String type; // 국내, 해외 여부
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }


    abstract public void speak();

    @PostPersist
    public void onPostPersist(){
        TourReserved tourReserved = new TourReserved(); // PetReserved
        tourReserved.setOrderQuantity(this.getOrderQuantity()); // Appearance
        tourReserved.setPrice(this.getPrice()); // energy
        tourReserved.setId(this.getId());
        tourReserved.setCountryName(this.getCountryName());
        tourReserved.setType(this.getType());
        tourReserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){

        TourUpdated tourUpdated = new TourUpdated();
        tourUpdated.setOrderQuantity(this.getOrderQuantity());
        tourUpdated.setPrice(this.getPrice());
        tourUpdated.setId(this.getId());
        tourUpdated.setCountryName(this.getCountryName());
        tourUpdated.setType(this.getType());

        tourUpdated.publishAfterCommit();

    }
        
    // List<Listener> listeners = new ArrayList<Listener>();
    // public void addListener(Listener listener) {
    //     this.listeners.add(listener);
    // }

    private int price = 0; // energy
        public void setPrice(int price) {
        this.price = price;
    }
        public int getPrice() {
            return price;
        }
        // protected void setEnergy(int energy) {
        //     if(Math.abs(this.energy - energy) < 3 )
        //         this.energy = energy;
        //     else    
        //         throw new IllegalArgumentException("Energy change is too big");
        // }

    // public void eat(){
    //     energy += 1;

        // if(listeners!=null){
        //     for(int i = 0; i<listeners.size(); i++){
        //         listeners.get(i).energyChanged(energy);
        //     }
        // }
    // }

    // public void sleep(){
    //     energy += 2;
    // }

    @Override
    public String toString() {
        
        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'" + ">" + this.getClass().getSimpleName() + "</a>";
    }
    
}
