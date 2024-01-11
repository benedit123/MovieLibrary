package dto;

public class Movie {

	private int movie_id;
	private String movie_name;
	private double movie_price;
	private double movie_rating;
	private String movie_genre;
	private String movie_language;
	private byte[] movie_image;
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public double getMovie_price() {
		return movie_price;
	}
	public void setMovie_price(double movie_price) {
		this.movie_price = movie_price;
	}
	public double getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(double movie_rating) {
		this.movie_rating = movie_rating;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	public String getMovie_language() {
		return movie_language;
	}
	public void setMovie_language(String movie_language) {
		this.movie_language = movie_language;
	}
	public byte[] getMovie_image() {
		return movie_image;
	}
	public void setMovie_image(byte[] movie_image) {
		this.movie_image = movie_image;
	}
}
