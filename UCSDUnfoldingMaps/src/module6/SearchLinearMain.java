package module6;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class SearchLinearMain {
	
	static Airport[] airports = {new Airport("Barcelona", "BCN"), 
						  new Airport("Bergamo", "BGY"), 
						  new Airport("Charles de Gaulle", "CDG"), 
						  new Airport("Orly", "ORY"), 
						  new Airport("Nice", "NCE"),
						  new Airport("Marseille", "MRS"),
						  new Airport("JFK", "MRS")};
	
	public static void main(String[] args){
		
		String airportCode = "MRS";
		
		// find any match
		boolean anyMatch = Arrays.stream(airports).anyMatch(c -> c.getIataCode().equals(airportCode));
		System.out.println(anyMatch);
		
		// find first
		Optional<Airport> airportFound = Arrays.stream(airports).filter(a -> Objects.equals(a.getIataCode(), airportCode)).findFirst();
		System.out.println(airportFound.isPresent());
		
	}

}