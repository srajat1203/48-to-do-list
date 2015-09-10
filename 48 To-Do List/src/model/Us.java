package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the US database table.
 * 
 */
@Table(name="US", schema="TESTDB")
@Entity
@NamedQuery(name="Us.findAll", query="SELECT u FROM Us u")
public class Us implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "UsSeq", sequenceName = "US_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "UsSeq")
	private long id;

	private String email;

	private String name;

	public Us() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}