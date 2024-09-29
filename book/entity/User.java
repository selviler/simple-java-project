package entity;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User()
    {}

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name= '" + name + '\'' +
                ", email= '" + email + '\'' +
                ", password= '" + password + '\'' +
                '}';
    }

}
