package app.model;



public class Person {
    String name;
    String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', city='" + city + "'}";
    }
}