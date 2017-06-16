package learn.basic.xml;
/**
 * 该类的设计目的在于描述EmpList.xml文件中保存的员工信息，每一个员工有５个信息，所有这里定义五个属性与之
 * 对应，EmpList.xml文件中有若干员工信息，我们就可以用若干Emp实例来表示了。
 * @author tarena
 *
 */
public class Emp {
	private int id;
	private String name;
	private int age;
	private String gender;
	private int salary;
	
	public Emp(){
		
	}
	
	public Emp(int id,String name,int age,String gender,int salary){
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return id+","+name+","+age+","+gender+","+salary;
	}
	
	
}
