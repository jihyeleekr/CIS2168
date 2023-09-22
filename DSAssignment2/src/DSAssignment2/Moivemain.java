package DSAssignment2;
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;// Import the Scanner class to read text files
import java.util.Iterator;
import java.util.LinkedList;

public class Moivemain {
	public static void main(String[] args) throws FileNotFoundException {
		//LinkedList for movies
		LinkedList<String> movies = new LinkedList<String>();
		LinkedList<Integer> years = new LinkedList<Integer>();
		
		//Add movieListA & B years into the LinkedList (the order is A then B)
		getYears("/Users/jihyelee/Desktop/movieListA.txt", years);
		getYears("/Users/jihyelee/Desktop/movieListB.txt", years);
		
		//Add movieListB years into the LinkedList (the order is A then B)
		getNames("/Users/jihyelee/Desktop/movieListA.txt", movies);
		getNames("/Users/jihyelee/Desktop/movieListB.txt", movies);
		
		// Create the mergedList 
		LinkedList<Movie> mergedList = merge(movies, years);
		
		// Print the results
		System.out.println(mergedList); // print mergedList
		System.out.println(oldest(mergedList)); // print the oldest movie in the list with name and year
		System.out.println(latest(mergedList));// print the latest movie in the list with name and year
		mergedList = removeThe(mergedList); // Remove movie names which contains "the" or "The"
		System.out.println(mergedList); // Print mergedList after removing movies names with "the"
		System.out.println(oldest(mergedList)); // Print the oldest movie after removing movie names with "the"
	}
	//Read files and store the names of movies into a string.
	public static LinkedList<String> getNames(String fileName, LinkedList<String> movies) throws FileNotFoundException {
		
		File file = new File(fileName);// check the file
		try (Scanner in = new Scanner(file)) { // read the file if the does exits
			while(in.hasNext()) {// runs until the code hits the last line of the file.
				String s = in.nextLine();
				if (!s.matches(".*\\d.*")){// add movie names ONLY!!
					movies.add(s);
				}
			}
		}
		return movies;
	}
	
	public static LinkedList<Integer> getYears(String fileName, LinkedList<Integer> years) throws FileNotFoundException {
		File file = new File(fileName);// check the file
		try (Scanner in = new Scanner(file)) { // read the file if the does exits
			while(in.hasNext()) {// runs until the code hits the last line of the file.
				String num = in.next();
				if(num.matches(".*[a-zA-Z].*") != true) {// add years ONLY!!
					years.add(Integer.parseInt(num));
				}		
			}
		}
		return years;
	}
	// Merge two Linked List into One
	public static LinkedList<Movie> merge(LinkedList<String> names, LinkedList<Integer> years) {
		// Creates new LinkedList 
	    LinkedList<Movie> mergedList = new LinkedList<Movie>();

	    // Make sure both lists have the same size before merging
	    if (names.size() != years.size()) {
	        throw new IllegalArgumentException("Lists must have the same size to merge.");
	    }

	    // Iterate through both lists and create MovieYearPair objects
	    Iterator<String> namesIterator = names.iterator();
	    Iterator<Integer> yearsIterator = years.iterator();

	    // Format: Movie name , year
	    while (namesIterator.hasNext() && yearsIterator.hasNext()) {
	        String name = namesIterator.next();
	        int year = yearsIterator.next();
	        
	        boolean isDuplicate = false;
	        
	        // Check if the movie name already exists in the mergedList
	        for (Movie movie : mergedList) {
	            if (movie.getName().equalsIgnoreCase(name)) {
	                isDuplicate = true;
	                break;
	            }
	        }

	        // If it's not a duplicate, add it to the result list
	        if (!isDuplicate) {
	            mergedList.add(new Movie(name, year));
	        }
	    }


	    return mergedList;
	}
	
	// Return the oldest movie and year
	public static LinkedList<Movie> oldest(LinkedList<Movie> movies) {
	    LinkedList<Movie> oldestMovie = new LinkedList<Movie>();

	    // Find the earliest year in the list
	    int earliestYear = Integer.MAX_VALUE;

	    for (Movie movie : movies) {
	        if (movie.getYear() < earliestYear) {
	            earliestYear = movie.getYear();
	        }
	    }

	    // Add movies with the earliest year to the oldestMovie list
	    for (Movie movie : movies) {
	        if (movie.getYear() == earliestYear) {
	            oldestMovie.add(movie);
	        }
	    }

	    return oldestMovie;
	}
	// Return the latest movie and year
	public static LinkedList<Movie> latest(LinkedList<Movie> movies) {
	    LinkedList<Movie> latestMovie = new LinkedList<Movie>();

	    // Find the latest year in the list
	    int latestYear = Integer.MIN_VALUE;

	    for (Movie movie : movies) {
	        if (movie.getYear() > latestYear) {
	        	latestYear = movie.getYear();
	        }
	    }

	    // Add movies with the earliest year to the oldestMovie list
	    for (Movie movie : movies) {
	        if (movie.getYear() == latestYear) {
	        	latestMovie.add(movie);
	        }
	    }

	    return latestMovie;
	}
	
	// Remove the movie name that contains "the" in their movie name
	public static LinkedList<Movie> removeThe(LinkedList<Movie> movies){
		LinkedList<Movie> theRemoved = new LinkedList<Movie>();
		for (Movie movie : movies) {
	        String movieNameLower = movie.getName().toLowerCase();
	        if (!movieNameLower.contains("the")) {
	        	theRemoved.add(movie);
	        }
	    }
		
		return theRemoved;
	}
	
}
