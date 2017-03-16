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


@Data
@Entity
@Table(name = "location")
@EqualsAndHashCode(exclude = "id")
public class Location  implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@JsonView(JsonViews.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="street", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String street;
	
	@Column(name="streetNO",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String streetNO;
	
	@Column(name="postalcode",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String postalCode;
	
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
		this.streetNO = streetNO;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Location(Long id, String street, String streetNO, String postalCode, String city, String country, String latitude,
			String longitude) {
		super();
		this.id = id;
		this.street = street;
		this.streetNO = streetNO;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNO() {
		return streetNO;
	}

	public void setStreetNO(String streetNO) {
		this.streetNO = streetNO;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	