package app.designpatterns;


// Builder Interface
interface UserProfileBuilder {
    UserProfileBuilder setFirstName(String firstName);

    UserProfileBuilder setLastName(String lastName);

    UserProfileBuilder setAge(int age);

    UserProfileBuilder setEmail(String email);

    UserProfileBuilder setPhone(String phone);

    UserProfileBuilder setAddress(String address);

    UserProfile build();
}

class UserProfile {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;

    public UserProfile(String firstName, String lastName, int age, String email, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
public class BuilderPattern {
    public static void main(String args[]){
        UserProfileBuilder userProfileBuilder = new UserProfileBuilderImpl();
        UserProfile userProfile = userProfileBuilder
                .setFirstName("Akash")
                .setLastName("Roy")
                .setAge(30)
                .setEmail("akash.roy@epam.com")
                .setPhone("4505645766")
                .setAddress("Beliny PadzMoszkiego")
                .build();

        System.out.println("User Profile: " + userProfile);

    }
}


class UserProfileBuilderImpl implements UserProfileBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;

    @Override
    public UserProfileBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserProfileBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserProfileBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public UserProfileBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserProfileBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public UserProfileBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public UserProfile build() {
        return new UserProfile(firstName, lastName, age, email, phone, address);
    }
}
