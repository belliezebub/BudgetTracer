package register;
import user.UsersController;
public class RegisterModel{
	private UsersController control;

	public RegisterModel(String firstName, String lastName,String username, String password){
		this.control =  new UsersController(firstName,lastName,username,password);
	}

	public boolean isUserExist(){
		if(control.getIsUserExist()){
			return true;
		}
		return false;
	}
	
	public void confirmRegister(){
			control.confirmRegister();
	}
	
}
 