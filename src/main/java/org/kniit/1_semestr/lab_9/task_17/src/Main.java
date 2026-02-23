public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        User user = new User(
                null,               
                "LongUsernameHere", 
                21                  
        );

        Validator.validate(user);
    }
}
