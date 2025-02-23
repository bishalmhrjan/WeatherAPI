package com.skyapi.weatherforecast.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Location {

	@Column(length = 12, nullable = false, unique = true)
	@Id
	private String code;

	@Column(length = 128, nullable = false)
	private String cityName;

	@Column(length = 128)
	private String regionName;

	@Column(length = 64, nullable = false)
	private String countryName;

	@Column(length = 2, nullable = false)
	private String countryCode;

	private boolean enabled;
	
	private boolean trashed;
	
	@OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private RealtimeWeather realtimeWeather;
	
	@OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HourlyWeather> listHourlyWeather = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.location", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DailyWeather> listDailyWeather = new ArrayList<>();

	public Location(String city, String region, String countryLong, String countryShort) {
		this.cityName=city;
		this.regionName=region;
		this.countryCode=countryShort;
		this.countryName=countryLong;
	}


	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(code, other.code);
	}




	public Location code(String code) {
		setCode(code);
		return this;
	}




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
