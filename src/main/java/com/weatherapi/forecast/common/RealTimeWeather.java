package com.weatherapi.forecast.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealTimeWeather {

    @Id
    @Column(name = "location_code")
    private String locationCode;

    private int temperature;
    private int humidity;
    private int precipitation;
    private int windSpeed;

    @Column(length = 50)
    private String status;

    @JsonProperty("last_updated")
    private Date lastUpdated;

    @OneToOne
    @JoinColumn(name = "location_code")
    @MapsId
    private Location location;

}
