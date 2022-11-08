package Person;

public abstract class Person {
    private String cpf;
    private String fullname;
    private String nationality;

    public Person(String cpf, String fullname, String nationality) {
        this.cpf = cpf;
        this.fullname = fullname;
        this.nationality = nationality;
    }

    public Person(String fullname, String nationality){
        this.fullname = fullname;
        this.nationality = nationality;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.getCpf().equals(p.getCpf());
        }
        return false;
    }
}
