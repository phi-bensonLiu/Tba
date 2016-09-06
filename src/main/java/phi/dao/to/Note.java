package phi.dao.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "note")
public class Note implements Serializable{
	
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sn", unique = true)
	private Integer sn;
	
	@Column(name = "content", nullable = false)  
	private String content;
	
	@Column(name = "create_datetime", nullable = false) 
	private Date create_datetime;
	
	@Column(name = "modify_datetime", nullable = false) 
	private Date modify_datetime;
	
	@Column(name = "countdown", nullable = false)  
	private String countdown;
	
	//如果有@JsonManagedReference，则会自动注入自动注入@JsonBackReference标注的属性。 
	
	@OneToMany(mappedBy="note" , fetch=FetchType.LAZY )
	@JsonManagedReference("AAAAA")
	private List<Test> testList = new ArrayList<Test>();
	
	//@OneToOne(mappedBy="note")
	//private Test testList = new Test();
	
	@OneToMany(mappedBy="note2" , fetch=FetchType.LAZY )
	@JsonManagedReference("BBB")
	private List<Test> test2List = new ArrayList<Test>();
	
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_datetime() {
		return create_datetime;
	}
	public void setCreate_datetime(Date create_datetime) {
		this.create_datetime = create_datetime;
	}
	public Date getModify_datetime() {
		return modify_datetime;
	}
	public void setModify_datetime(Date modify_datetime) {
		this.modify_datetime = modify_datetime;
	}
	public String getCountdown() {
		return countdown;
	}
	public void setCountdown(String countdown) {
		this.countdown = countdown;
	}
	/*
	public Test getTestList() {
		return testList;
	}
	public void setTestList(Test testList) {
		this.testList = testList;
	}
	*/
	
	public List<Test> getTestList() {
		return testList;
	}
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}
	public List<Test> getTest2List() {
		if(test2List.size() > 0){
			return test2List;
		}else{
			return null;
		}
	}
	public void setTest2List(List<Test> test2List) {
		this.test2List = test2List;
	}
}
