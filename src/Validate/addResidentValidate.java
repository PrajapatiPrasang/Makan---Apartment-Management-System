package Validate;


import VO.addResidentVO;



public class addResidentValidate {
	public String mandatory(addResidentVO addResidentVO){
		
		if(addResidentVO.getFirst_name().isEmpty() && addResidentVO.getLast_name().isEmpty() && addResidentVO.getEmail_id().isEmpty() && addResidentVO.getAddress().isEmpty() && addResidentVO.getUser_id().isEmpty() && addResidentVO.getPassword().isEmpty()){
			return "All fields are Mandatory";
		}
		
		else if(addResidentVO.getFirst_name().isEmpty() || addResidentVO.getFirst_name().trim().length() <= 0){
			return "First Name is mandatory!";
		}
		
		else if(addResidentVO.getLast_name().isEmpty() || addResidentVO.getLast_name().trim().length() <= 0){
			return "Last Name is mandatory!";
		}
		
		else if(addResidentVO.getEmail_id().isEmpty() || addResidentVO.getEmail_id().trim().length() <= 0){
			return "Email Id is mandatory!";
		}
		
		else if(addResidentVO.getUser_id().isEmpty() || addResidentVO.getUser_id().trim().length() <= 0){
			return "User Id is mandatory!";
		}
		else if(addResidentVO.getPassword().isEmpty() || addResidentVO.getPassword().trim().length() <= 0){
			return "Password is mandatory!";
		}
		
		return "success";
		
		
	}
	public String parameters_resident(addResidentVO addResidentVO){
		 
		if(addResidentVO.getFirst_name().matches("[a-zA-Z]+")){
			if(addResidentVO.getLast_name().matches("[a-zA-Z]+")){
				if(addResidentVO.getEmail_id().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")){
					if(addResidentVO.getUser_id().matches("[a-zA-Z][0-9]")){
						if(addResidentVO.getPassword().matches("[a-zA-Z][0-9]")){
							return "success";
						}
						else{
							return "Password should be alph-numeric";
						}
					}
					else{
						return "User Id should be alpha-numeric";
					}
					
			}
				else{
					return "Invalid Email Id";
				}
				}
			else{
				return "Last Name should be alphabets only!";
			}
				
			}
		else{
			return "First Name should be alphabets only!";
		}
		
	}
}
