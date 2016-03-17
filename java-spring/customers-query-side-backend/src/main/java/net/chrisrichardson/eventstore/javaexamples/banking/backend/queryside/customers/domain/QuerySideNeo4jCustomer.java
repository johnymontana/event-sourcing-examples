package net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers.domain;

import net.chrisrichardson.eventstore.javaexamples.banking.common.customers.Name;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.Random;

/**
 * Created by lyonwj on 2/26/16.
 */
@NodeEntity
public class QuerySideNeo4jCustomer {
    // FIXME: just annotate QuerySideCustomer

    @GraphId
    private Long id;

    @Property(name="name")
    private String name;

    @Property(name="email")
    private String email;

    @Property(name="ssn")
    private String ssn;

    @Property(name="phoneNumber")
    private String phoneNumber;

    @Property(name="street1")
    private String street1;

    @Property(name="street2")
    private String street2;



    @Property(name="city")
    private String city;

    @Property(name="state")
    private String state;

    @Property(name="zipCode")
    private String zipCode;

    public QuerySideNeo4jCustomer(String name, String email, String ssn, String phoneNumber, String street1, String street2, String city, String state, String zipCode) {
        this.name = name;
        this.email = email;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

        this.id = (new Random()).nextLong(); // FIXME
    }

    public QuerySideNeo4jCustomer() {

    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }




}
