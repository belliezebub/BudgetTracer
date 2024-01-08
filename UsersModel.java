package user;


import java.io.*;
import java.io.IOException;

public class UsersModel{
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String access;
	
	public void addUser(String firstName,String lastName, String username, String password){
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("Database/Users/users.dat",true))){
			buffer.write(firstName+"\t "+ lastName +"\t"+ username +"\t"+password+"\t"+"viewer"+"\n");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public boolean retrieveUser(String username){
		try(BufferedReader buffer = new BufferedReader(new FileReader("Database/Users/users.dat"))){
			String line;
			while((line = buffer.readLine()) != null){
				String[] data = line.split("\t");
				if(data[2].equals(username)){
					this.firstName = data[0];
					this.lastName = data[1];
					this.password= data[3];
					this.access= data[4];
					return true;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return false;
	}



	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getAccess(){
		return access;
	}


}