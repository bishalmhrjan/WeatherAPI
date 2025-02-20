package com.weatherapi.forecast.common;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyWeatherId implements Serializable {
    private int dayOfMonth;
    private int month;

    @ManyToOne
    @JoinColumn(name="location_code")
    private Location location;


}
