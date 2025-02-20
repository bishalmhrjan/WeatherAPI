package com.weatherapi.forecast.common;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HourlyWeatherId {
    private int hourOfDay;

    private Location location;

}
