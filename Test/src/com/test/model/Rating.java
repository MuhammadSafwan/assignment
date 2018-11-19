/**
 * 
 */
package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Safwan
 *
 */

@Entity
@Table(name="ratings")
public class Rating {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "movie_id")
	private int movie_id;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "created_at")
	private String created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user_id;
	}

	public void setUser(int user_id) {
		this.user_id = user_id;
	}

	public int getMovie() {
		return movie_id;
	}

	public void setMovie(int movie_id) {
		this.movie_id = movie_id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	

}
