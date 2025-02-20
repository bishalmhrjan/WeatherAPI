package com.weatherapi.forecast.common;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locations")

public class Location {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String code;

    @Column(length = 2, nullable = false)
    private String cityName;
    @Column(length = 2, nullable = false)
    private String regionName;
    @Column(length = 2, nullable = false)
    private String countryName;
    @Column(length = 2, nullable = false)
    private String countryCode;
    @Column(length = 2, nullable = false)
    private boolean enabled;

    private boolean trashed;

    public Location code(String code) {
        setCode(code);
        return this;
    }



    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HourlyWeather> listHourlyWeather = new ArrayList<>();



    public void copyFieldsFrom(Location another) {
        setCityName(another.getCityName());
        setRegionName(another.getRegionName());
        setCountryCode(another.getCountryCode());
        setCountryName(another.getCountryName());
        setEnabled(another.isEnabled());
    }

    public void copyAllFieldsFrom(Location another) {
        copyFieldsFrom(another);
        setCode(another.getCode());
        setTrashed(another.isTrashed());
    }
}
