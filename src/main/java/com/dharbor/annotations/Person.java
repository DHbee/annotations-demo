package com.dharbor.annotations;

/**
 * @Author: psaradhi
 * Created: 08-08-2023
 */

@JsonSerializable
public class Person {

    @JsonElement
    String firstName;

    @JsonElement
    String lastName;

    @JsonElement(name = "age")
    String personAge;

    public Person(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = age;
    }

    @Init
    public void convert(){
        this.firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);

    }
}
