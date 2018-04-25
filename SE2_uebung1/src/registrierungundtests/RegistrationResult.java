package registrierungundtests;

import java.util.ArrayList;

public class RegistrationResult {
	private ArrayList<String> messages=new ArrayList<String>();
	private boolean status;
	public RegistrationResult(boolean status){
		this.status=status;
	}
	public void addMessage(String message){
		messages.add(message);
	}
	
	//Getter
	public boolean getStatus(){
		return this.status;
	}
	public ArrayList<String> getMessages(){
		return this.messages;
	}
	//Setter
	public void setStatus(boolean status){
		this.status=status;
	}
	
	public boolean equals(Object object){
		if (object == null) return false;
		if (! ( object instanceof RegistrationResult)){
			return false;
		}
		RegistrationResult regresult = (RegistrationResult) object;
		if(this.messages.equals(regresult.getMessages())&&this.status==regresult.getStatus()){
			return true;
		}else{
			return false;
		}
	}
}
