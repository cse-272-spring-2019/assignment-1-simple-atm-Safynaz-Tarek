package project;
public class LoginAuth {
    private int pass = 1234;

    public boolean validate(int password){
        boolean validateResult = false;
        
        if(pass == password){
           validateResult = true;
        }
        
        return validateResult;
    }
}
