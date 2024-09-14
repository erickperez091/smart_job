package com.example.prueba_smart_job.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "number")
    private String number;

    @Column(name = "cityCode")
    private String cityCode;

    @Column(name = "countryCode")
    private String countryCode;

    @ManyToOne
    @JoinColumn( name = "user_id", nullable = false, updatable = false )
    @JsonIgnoreProperties( { "phones" } )
    private User user;

    public Phone() {
    }

    public Phone( String number, String cityCode, String countryCode ) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode( String cityCode ) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Phone phone = (Phone) o;
        return Objects.equals( id, phone.id ) && Objects.equals( number, phone.number ) && Objects.equals( cityCode, phone.cityCode ) && Objects.equals( countryCode, phone.countryCode );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, number, cityCode, countryCode );
    }

    @Override
    public String toString() {
        return new StringJoiner( ", ", Phone.class.getSimpleName() + "[", "]" )
                .add( "id='" + id + "'" )
                .add( "number='" + number + "'" )
                .add( "cityCode='" + cityCode + "'" )
                .add( "countryCode='" + countryCode + "'" )
                .toString();
    }
}
