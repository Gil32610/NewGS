package Person;

public class Developer extends User {
    public Developer(String cpf, String fullName, String nationality, String email, String username,
                     Integer age,String password) {
        super(cpf, fullName,nationality,email,username,age,password);
    }

    public Developer(String email, String fullName){
        super(email, fullName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

}
