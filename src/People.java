import person.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static person.Gender.*;

public class People {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        //Count the person's amount.
        System.out.println("People amount: " + countPeople(people));

        //List people information
        System.out.println("Persons information: " + people);

        //Get Jhon information
        System.out.println("Get one person(Jhon) information: " + getPerson("Jhon", people));

        //Get all the FEMALE's person
        System.out.println("Get all the females: "+ findAllFemales(people));

        //Sum the amount of age
        System.out.println("Get the amount of age: " + getAmountOfAge(people));

        //List the top three newer age
        System.out.println("Get the top three newer age person: " + topThreeNewerAge(people));

        //List the top three older age
        System.out.println("Get the top three older age person: " + topThreeOlderAge(people));

        //Get the age's average
        System.out.println("Get age's average: " + getTheAverageAge(people));

        //Get the companies that has "S.A" in the name
        System.out.println("Get the companies with 'S.A' in the name: " + findAllCompaniesThatHasSAInTheName(people));

    }

    private static double getTheAverageAge(List<Person> people) {
        return people       // person's list
                .stream()   // transform the list in a stream
                .mapToInt(person -> person.getAge()) // Get the age of each person
                .average() // Calc the average
                .orElse(0); // Case don't find anything return 0
    }

    private static Integer countPeople(List<Person> people) {
        return people       // person's list
                .size();     // Get the people's size list
    }

    private static Person getPerson(String name, List<Person> people) {
        return people.      // person's list
                stream()   // transform the list in a stream
                .filter(person -> person.getName().equals(name)) // filter the person with specifically name
                .findFirst() // Take the result of the filter
                .orElse(null); // Case don't find anything return null.
    }

    private static List<Person> findAllFemales(List<Person> people) {
        return people      // person's list
                .stream()   // transform the list in a stream
                .filter(person -> person.getGender().equals(FEMALE)) // Filter the FEMALE's gender
                .collect(Collectors.toList()); // put the result in a new list
    }


    private static Integer getAmountOfAge(List<Person> people) {
        return people.      // person's list
                stream()   // transform the list in a stream
                .mapToInt(person -> person.getAge()) // Get the age of each person
                .sum(); // sum the ages;
    }

    private static List<String> topThreeNewerAge(List<Person> people) {
        return people.      // person's list
                stream()   // transform the list in a stream
                .sorted(Comparator.comparingInt(Person::getAge)) // sort the list by age
                .limit(3) // limit the list's selection in three person
                .map(person -> person.getName()) // get the name from this list
                .collect(Collectors.toList()); // adicione these name in a new list
    }

    private static List<String> topThreeOlderAge(List<Person> people) {
        return people.      // person's list
                stream()   // transform the list in a stream
                .sorted(Comparator.comparingInt(Person::getAge).reversed()) // sort the list by age and reversed it
                .limit(3) // limit the list's selection in three person
                .map(person -> person.getName()) // get the name from this list
                .collect(Collectors.toList()); // adicione these name in a new list
    }

    private static List<String> findAllCompaniesThatHasSAInTheName(List<Person> people) {
        return people      // person's list
                .stream()   // transform the list in a stream
                .filter(person -> person.getCompany().contains("S.A")) // Filter the companies with S.A in the name
                .map(person -> person.getCompany())
                .collect(Collectors.toList()); // put the result in a new list
    }


    static List<Person> getPeople() {

        Person p1 = new Person("Jhon", 20, "Brazil", "Petrobras S.A", MALE);
        Person p2 = new Person("Eliza", 45, "USA", "Exxon", FEMALE);
        Person p3 = new Person("Cristina", 65, "Germany", "Volkwagen", FEMALE);
        Person p4 = new Person("Eric", 15, "Belgium", "Hearts S.A", NOT_INFORMED);
        Person p5 = new Person("Sayto", 40, "Japan", "Shimabuko Soft", MALE);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        return people;

    }

}
