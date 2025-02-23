package com.skyapi.weatherforecast.common;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class HourlyWeatherId implements Serializable {
	private int hourOfDay;

	@ManyToOne
	@JoinColumn(name = "location_code")
	private Location location;
	
	public HourlyWeatherId() { }
	
	public HourlyWeatherId(int hourOfDay, Location location) {
		super();
		this.hourOfDay = hourOfDay;
		this.location = location;
	}


	@Override
	public int hashCode() {
		return Objects.hash(hourOfDay, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HourlyWeatherId other = (HourlyWeatherId) obj;
		return hourOfDay == other.hourOfDay && Objects.equals(location, other.location);
	}

	
}
