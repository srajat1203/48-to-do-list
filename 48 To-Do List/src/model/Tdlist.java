package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the TDLIST database table.
 * 
 */
@Table(name="TDlist", schema="TESTDB")
@Entity
@NamedQuery(name="Tdlist.findAll", query="SELECT t FROM Tdlist t")
public class Tdlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "Tdlist1", sequenceName = "TDLIST_SEQ1", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "Tdlist1")
	private long id;

	private String duedate;

	private String status;

	private String task;

	private String useremail;

	private long userid;

	public Tdlist() {
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

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid2) {
		this.userid = userid2;
	}

}