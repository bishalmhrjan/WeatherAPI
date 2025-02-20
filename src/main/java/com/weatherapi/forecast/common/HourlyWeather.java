package com.weatherapi.forecast.common;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="weather_hourly")

public class HourlyWeather implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private HourlyWeatherId id = new HourlyWeatherId();

    private int tempreature;
    private int precipitation;

    @Column(length = 50)
    private String status;


}
