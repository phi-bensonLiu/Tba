package phi.vo;

public class GeoBean 
{
	private String countryCode;
	private String countryName;
	private String city;
	private double latitude;
	private double longitude;
	
	public GeoBean(String countryCode, String countryName, String city,
	double latitude, double longitude) 
	{
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getCity() {
		return city;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}