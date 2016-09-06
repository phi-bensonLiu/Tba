package phi.dao.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity  
@Table(name = "test")
public class Test implements Serializable{
	 
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Id
    //@GeneratedValue(generator="idGenerator")
    //@GenericGenerator(name="idGenerator", strategy="uuid")
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sn", unique = true)
	private Integer tag_sn;
	
	@Column(name = "tag_name", nullable = false)  
	private String tag_name;
	
	//@OneToOne
	
	@ManyToOne
	@JoinColumn(name="sn", referencedColumnName="sn", insertable = false, updatable = false) 
	@JsonBackReference("rrrr")
	private Note note;
	
	@ManyToOne
	@JoinColumn(name="tag_name", referencedColumnName="content", insertable = false, updatable = false) 
	@JsonBackReference("BBB")
	private Note note2;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTag_sn() {
		return tag_sn;
	}
	public void setTag_sn(Integer tag_sn) {
		this.tag_sn = tag_sn;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public Note getNote2() {
		return note2;
	}
	public void setNote2(Note note2) {
		this.note2 = note2;
	}
}
