package User;

public class User {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String phone;
    private String email;
    private String login;
    private String password;
    private Role role;

    public User(int id, String lastName, String firstName, String patronymic, String phone, String email, String login, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = Role.USER;
    }
    public User(int id, String lastName, String firstName, String patronymic, String phone, String email, String login, String password, Role role) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", lastName='" + lastName + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", patronymic='" + patronymic + '\'' +
//                ", phone='" + phone + '\'' +
//                ", email='" + email + '\'' +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", role=" + role +
//                '}';
//    }
}
