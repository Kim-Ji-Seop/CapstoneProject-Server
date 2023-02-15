package Capstone.uou.domain.match.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String name; // 장소명
    private String street; // 도로명

    protected Address(){}

    public Address(String name, String street) {
        this.name = name;
        this.street = street;
    }
}
