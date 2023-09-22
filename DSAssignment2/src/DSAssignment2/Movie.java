package DSAssignment2;

public class Movie {
	String movieName;
	int movieYears;
	
	//Constructor
	public Movie(String movieName, int years) {
		this.movieName = movieName;
		this.movieYears = years;
	}

	public String getName() {
        return movieName;
    }
	
	public int getYear() {
		return movieYears;
	}
	
	public String toString() {
        return "Movie: " + movieName + ", Year: " + movieYears;
    }
}






