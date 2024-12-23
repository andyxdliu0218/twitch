package com.laioffer.twitch.hello;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Locale;


@RestController
public class HelloController {


    @GetMapping("/hello")
    public Address sayHello(@RequestParam(required = false) String locale) {
        if (locale == null) {
            locale = "en_US";
        }


        Faker faker = new Faker(new Locale(locale));


        String name = faker.name().fullName();
        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();


        Address address = new Address(street, city, state);
        Book book = new Book(bookTitle, bookAuthor);
        Person p= new Person(name, company,address, book) ;
        return p.homeAddress();
        //return new Person(name, company,address, book);
    }
}

