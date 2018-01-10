package IO;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID=12L;
	private String ID;
	private String name;
	private String sex;
	public Student(String id,String na,String se){
		this.ID=id;
		this.name=na;
		this.sex=se;
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//÷ÿ–¥toString
	public String toString(){
		return "id:"+this.ID+"  –’√˚£∫"+this.name+"  –‘Ñe£∫"+this.sex;
	}
}
