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

    public Location(String cityName, String regionName, String countryName, String countryCode) {
        this.cityName = cityName;
        this.regionName = regionName;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private RealTimeWeather realtimeWeather;

    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HourlyWeather> listHourlyWeather = new ArrayList<>();
    @OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyWeather> listDailyWeather = new ArrayList<>();


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
