package br.com.bilotta.bluetasks.domain.task;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.bilotta.bluetasks.domain.user.AppUser;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	private LocalDate whenToDo;
	
	private boolean done = false;
	
	@ManyToOne
	@JoinColumn(name = "app_user_id")
	private AppUser appUser;
	
	
	public Task() {
		
	}


	public Task(String description, LocalDate whenToDo, boolean done) {
		super();
		this.description = description;
		this.whenToDo = whenToDo;
		this.done = done;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getWhenToDo() {
		return whenToDo;
	}


	public void setWhenToDo(LocalDate whenToDo) {
		this.whenToDo = whenToDo;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}


	public AppUser getAppUser() {
		return appUser;
	}


	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	public Integer getId() {
		return id;
	}
	
	
}
