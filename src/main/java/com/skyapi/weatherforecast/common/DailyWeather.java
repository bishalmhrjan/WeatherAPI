package com.skyapi.weatherforecast.common;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "weather_daily")
public class DailyWeather {

	@EmbeddedId
	private DailyWeatherId id = new DailyWeatherId();
	
	private int minTemp;
	private int maxTemp;
	private int precipitation;
	
	@Column(length = 50)
	private String status;

	public DailyWeather getShallowCopy() {
		DailyWeather copy = new DailyWeather();
		copy.setId(this.getId());
		
		return copy;
	}
	

	public DailyWeather precipitation(int precipitation) {
		setPrecipitation(precipitation);
		return this;
	}
	
	public DailyWeather status(String status) {
		setStatus(status);
		return this;
	}
	
	public DailyWeather location(Location location) {
		this.id.setLocation(location);
		return this;
	}	
	
	public DailyWeather dayOfMonth(int day) {
		this.id.setDayOfMonth(day);
		return this;
	}
	
	public DailyWeather month(int month) {
		this.id.setMonth(month);
		return this;
	}
	
	public DailyWeather minTemp(int temp) {
		setMinTemp(temp);
		return this;
	}
	
	public DailyWeather maxTemp(int temp) {
		setMaxTemp(temp);
		return this;
	}

	@Override
	public String toString() {
		return "DailyWeather [id=" + id + ", minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", precipitation="
				+ precipitation + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DailyWeather other = (DailyWeather) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}
