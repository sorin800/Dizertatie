package com.tsv.diz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class Result {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="result_id")
	private int id;
	@Column(name="cluster")
	private int cluster;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Result() {
		
	}
	
	
	public Result(int cluster, User user) {
		this.cluster = cluster;
		this.user = user;
	}

	public Result(int cluster) {
		this.cluster = cluster;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCluster() {
		return cluster;
	}
	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", cluster=" + cluster + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
