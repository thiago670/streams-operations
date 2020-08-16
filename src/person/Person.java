package person;

import java.util.StringJoiner;

public class Person {

    private final String name;
    private final Integer age;
    private final String country;
    private final String company;
    private final Gender gender;


    public Person(String name, Integer age, String country, String company, Gender gender) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.company = company;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return new StringJoiner(" , ", "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("country='" + country + "'")
                .add("company='" + company + "'")
                .add("gender=" + gender)
                .toString();
    }
}
