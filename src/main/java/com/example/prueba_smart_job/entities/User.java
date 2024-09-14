package com.example.prueba_smart_job.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Entity
@Table(name = "USER_")
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnoreProperties( { "user" } )
    private Set<Phone> phones;

    @Column(name = "created", columnDefinition = "TIMESTAMP")
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss", iso = DATE_TIME )
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonDeserialize( using = LocalDateTimeDeserializer.class )
    @JsonSerialize( using = LocalDateTimeSerializer.class )
    private LocalDateTime created;

    @Column(name = "modified")
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss", iso = DATE_TIME )
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonDeserialize( using = LocalDateTimeDeserializer.class )
    @JsonSerialize( using = LocalDateTimeSerializer.class )
    private LocalDateTime modified;

    @Column(name = "last_login")
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss", iso = DATE_TIME )
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonDeserialize( using = LocalDateTimeDeserializer.class )
    @JsonSerialize( using = LocalDateTimeSerializer.class )
    private LocalDateTime last_login;

    @Column(name = "token")
    private String token;

    @Column(name = "active")
    private boolean active;

    public User() {
    }

    public User( String name, String email, String password, Set< Phone > phones, LocalDateTime created, LocalDateTime modified, LocalDateTime last_login, String token, boolean active ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Set< Phone > getPhones() {
        return phones;
    }

    public void setPhones( Set< Phone > phones ) {
        this.phones = phones;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated( LocalDateTime created ) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified( LocalDateTime modified ) {
        this.modified = modified;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login( LocalDateTime last_login ) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken( String token ) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive( boolean active ) {
        this.active = active;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        User user = (User) o;
        return active == user.active && Objects.equals( id, user.id ) && Objects.equals( name, user.name ) && Objects.equals( email, user.email ) && Objects.equals( password, user.password ) && Objects.equals( created, user.created ) && Objects.equals( modified, user.modified ) && Objects.equals( last_login, user.last_login ) && Objects.equals( token, user.token );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name, email, password, created, modified, last_login, token, active );
    }

    @Override
    public String toString() {
        return new StringJoiner( ", ", User.class.getSimpleName() + "[", "]" )
                .add( "id='" + id + "'" )
                .add( "name='" + name + "'" )
                .add( "email='" + email + "'" )
                .add( "password='" + password + "'" )
                .add( "phones=" + phones )
                .add( "created=" + created )
                .add( "modified=" + modified )
                .add( "last_login=" + last_login )
                .add( "token='" + token + "'" )
                .add( "active=" + active )
                .toString();
    }
}
