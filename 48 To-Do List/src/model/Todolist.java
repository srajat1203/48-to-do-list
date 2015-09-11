package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Table(name="TODOLIST", schema="TESTDB")
@Entity
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "TodolistSeq", sequenceName = "TODOLIST_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "TodolistSeq")
	private long id;

	private String duedate;

	private String status;

	private String task;

	//bi-directional many-to-one association to Us
	@ManyToOne
	@JoinColumn(name="USERID")
	private Us us;

	public Todolist() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDuedate() {
		return this.duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Us getUs() {
		return this.us;
	}

	public void setUs(Us us) {
		this.us = us;
	}

}