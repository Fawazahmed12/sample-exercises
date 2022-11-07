package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Person {
    String name;
    List<Person> friends = new ArrayList<>();

    Person(String name) {
        this.name = name;
    }

    public void addFriend(Person person) {
        if (!friends.contains(person)) {
            friends.add(person);
            person.addFriend(this);
        }
    }


    public static void main(String[] args) {
        Person p1 = new Person("John");
        Person p2 = new Person("Peter");
        Person p3 = new Person("Sundar");
        Person p4 = new Person("Prem");
        Person p5 = new Person("Saleem");

        p2.addFriend(p1);
        p2.addFriend(p3);
        p2.addFriend(p4);

        p4.addFriend(p1);
        p3.addFriend(p1);

        p5.addFriend(p1);
        p5.addFriend(p3);

        List<Person> allPersons = Arrays.asList(p1, p2, p3, p4, p5);

        Optional<Person> personWithMaxFriends = allPersons.stream().max((o1, o2) -> {
            if (o1.friends.size() > o2.friends.size()) {
                return 1;
            }
            return -1;
        });

        System.out.println(personWithMaxFriends);

    }
}
