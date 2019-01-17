package com.epam.estate.beans;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Estate {

    private Date buildingYear;
    private String address;
    private String city;
    private int area;
    private BigDecimal price;


}
