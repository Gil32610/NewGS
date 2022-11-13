package Person;

public abstract class Person {
    private String cpf;
    private String fullName;
    private String nationality;
    private Integer age;


    public Person(String fullname){
        this.fullName = fullname;
    }
    public Person(String cpf, String fullname, String nationality,Integer age) {
        this.cpf = cpf;
        this.fullName = fullname;
        this.nationality = nationality;
        this.age = age;
    }

    public Person(String fullname, String nationality){
        this.fullName = fullname;
        this.nationality = nationality;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(Integer age){this.age = age;}

    public Integer getAge(){return this.age;}
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.getCpf().equals(p.getCpf());
        }
        return false;
    }
}
