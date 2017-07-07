package AM;

import java.util.*;

class Movie {
    private int id;
    private float rating;
    private List<Movie> similarMovies;
    public Movie(int id, float rate, List<Movie> neighbors) {
        this.id = id;
        this.rating = rate;
        this.similarMovies = neighbors;
    }
    public float getRating(){
        return rating;
    }
    public int getId(){
        return id;
    }
    public List<Movie> getSimilarMovies(){
        return similarMovies;
    }
}
public class Movie_Network {
	public static void main(String[] args){			
		Movie m = getTestMovie();
		List<Movie> res = getMovieRecommendations(m, 2);
		for(Movie mm : res)
			System.out.print(mm.getId() + " ");
	}
	//get test data
	private static Movie getTestMovie() {		
		Movie m3 = new Movie(3, 4, new ArrayList<Movie>());
		Movie m5 = new Movie(5, 5, new ArrayList<Movie>());		
		Movie m2 = new Movie(2, 3, new ArrayList<Movie>(Arrays.asList(m5)));
		Movie m1 = new Movie(1, 2, new ArrayList<Movie>(Arrays.asList(m3)));
		Movie m0 = new Movie(0, 1, new ArrayList<Movie>(Arrays.asList(m1, m2)));
		return m0;
	}
	//get list of movies which are similar to the input movie
	public static List<Movie> getMovieRecommendations (Movie movie, int numSimilar){
		//PriorityQueue with rating value
		PriorityQueue<Movie> q = new PriorityQueue<>(new Comparator<Movie>() {
			public int compare(Movie m1, Movie m2) {
				return (int)(m1.getRating() - m2.getRating());
			}
		});		
		getMovies(movie, q, numSimilar);
		
		//convert q to list
		List<Movie> res = new ArrayList<Movie>();
		while (!q.isEmpty()){
			res.add(q.poll());
		}
		return res;
	}
	//get all k movies
	private static void getMovies(Movie movie, PriorityQueue<Movie> queue, int k) {
        for (Movie m : movie.getSimilarMovies()) {
            if (!queue.contains(m)) {
            	/*if (queue.size() < k)
            		queue.offer(m);
            	else if (queue.peek().getRating() < m.getRating()){//remove the peek movie if the size is k and peek's rating is less than m'rating
            		queue.poll();
            		queue.offer(m);
            	} */
            	queue.offer(m);
            	if (queue.size() == k + 1)//remove the first move which has the lowest ranking
            		queue.poll();
            	getMovies(m, queue, k);
            }
        }
	}
}
