package user;

public class UsersController{
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String access;
	private boolean isUserExist;
	private UsersModel model;
	
	public UsersController(String username){
		this.username=username;
		this.model=new UsersModel();	
	}
	
	public UsersController(String firstName, String lastName,String username, String password){
		this.model= new UsersModel();
		this.username= username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password= password;
		if(model.retrieveUser(username)){
			this.isUserExist= true;	
			initializeData();
			
		}
	}
	
	public void confirmRegister(){
		model.addUser(firstName,lastName,username,password);
	}
	
	public void initializeData(){
		this.username=username;
		this.firstName = model.getFirstName();
		this.lastName = model.getLastName();	
		this.password=model.getPassword();
		this.access=model.getAccess();
	}

	public void setUsername(String username){
		this.username =username;
	}
	public boolean getIsUserExist(){
		if(model.retrieveUser(username)){
			this.isUserExist= true;
				
		}
		return isUserExist;
	}
	

	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	

	public String getPassword(){
		return password;
	}
	
	public String getAccess(){
		return access;
	}
}