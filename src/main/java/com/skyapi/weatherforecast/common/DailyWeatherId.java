package com.skyapi.weatherforecast.common;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class DailyWeatherId implements Serializable {

	private int dayOfMonth;
	private int month;
	
	@ManyToOne
	@JoinColumn(name = "location_code")
	private Location location;


	
}
