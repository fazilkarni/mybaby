import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * http://alvinalexander.com/java/java-deep-clone-example-source-code
 * @author fazil
 *
 */
public class DeepCloningBySerialization implements Cloneable,Serializable {

 private String name;
 private String designation;
 List<DeepCloningBySerialization> reportees = new ArrayList<DeepCloningBySerialization>();

 public DeepCloningBySerialization() {
 this.setDesignation("Programmer");
 }
 public String getDesignation() {
 return designation;
 }

 public void setDesignation(String designation) {
 this.designation = designation;
 }

 public String getName() {
 return name;
 }

 public void setName(String name) {
 this.name = name;
 }

 public Object clone() throws CloneNotSupportedException {
	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 ObjectOutputStream oos;
	try {
		oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		
		return ois.readObject();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	 
 return super.clone();
 }
 
 public static void main(String[] args){
	 DeepCloningBySerialization e = new DeepCloningBySerialization();
	 e.setName("Fazil");
	 
	 try {
		DeepCloningBySerialization emp = (DeepCloningBySerialization) e.clone();
		emp.setDesignation("New one");
		System.out.println(emp.getName()+"and designation is :"+emp.getDesignation());
		DeepCloningBySerialization empClone = (DeepCloningBySerialization) emp.clone();
		System.out.println(empClone.getName()+"and designation is :"+empClone.getDesignation());
		
	 } catch (CloneNotSupportedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 
 }
}
