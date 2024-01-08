package loginsys;
import user.UsersController;

class LoginModel {
    private String firstName;
    private String lastName;
    private UsersController control;
    boolean isUserExist;
    private String password;
	private String access;
    
    public LoginModel(){
        this.password= password;
        this.control = new UsersController(null);

        
    }
    

    public boolean validatePassword(String password){
        if(control.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    
    public boolean getIsUserExist(String username){
		control = new UsersController(username);
        this.isUserExist=control.getIsUserExist();
		if(isUserExist){
			control.initializeData();
		}
        return isUserExist;
    }
    
    public String getFirstName(){
        return control.getFirstName();
    }
    
    public String getLastName(){
            return control.getLastName();
    }
	
	public String getAccess(){
		return access;
	}

}
