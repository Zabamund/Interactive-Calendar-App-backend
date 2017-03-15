package calendApp.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
*
* @author Adrian Gross
*/

@Data
@Entity
@Table(name = "location")
@EqualsAndHashCode(exclude = "locationId")
public class Location  implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@JsonView(JsonViews.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="street", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String street;
	
	@Column(name="streetno",nullable = false, length = 20)
	@JsonView(JsonViews.Public.class)
	private String streetno;
	
	@Column(name="postalcode",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String postalcode;
	
	@Column(name="city",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String city;
	
	@Column(name="country",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String country;
	
	@Column(name="latitude",nullable = true, length = 50)
	@JsonView(JsonViews.Public.class)
	private String latitude;
	
	@Column(name="longitude",nullable = true, length = 50)
	@JsonView(JsonViews.Public.class)
	private String longitude;

	public Location() {
	}
	
	public Location(String street, String streetNO, String postalCode, String city, String country, String latitude,
			String longitude) {
		super();
		this.street = street;
		this.streetno = streetNO;
		this.postalcode = postalCode;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Location(Long locationId, String street, String streetNO, String postalCode, String city, String country, String latitude,
			String longitude) {
		super();
		this.id = locationId;
		this.street = street;
		this.streetno = streetNO;
		this.postalcode = postalCode;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getLocationId() {
		return id;
	}

	public void setLocationId(Long locationId) {
		this.id = locationId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNO() {
		return streetno;
	}

	public void setStreetNO(String streetNO) {
		this.streetno = streetNO;
	}

	public String getPostalCode() {
		return postalcode;
	}

	public void setPostalCode(String postalCode) {
		this.postalcode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

}
	