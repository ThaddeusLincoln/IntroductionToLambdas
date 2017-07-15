package module6;

public class Airport implements Comparable<Airport> {

	private String name;
	private String iataCode;
	
	
	
	public Airport(String name, String iataCode) {
		super();
		this.name = name;
		this.iataCode = iataCode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	@Override
	public int compareTo(Airport otherAirport) {
		return this.getName().compareTo(otherAirport.getName());
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + ", iataCode=" + iataCode + "]";
	}
	
	
	
	
}
