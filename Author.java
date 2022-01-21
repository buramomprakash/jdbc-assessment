package com.dxc.assessment.modal;

public class Author {

    private int id;

    private String firstName;

    private String lastName;

    private String genre;

    private String email;

    public Author() {}

    public Author(int id, String firstName, String lastName, String genre, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
        this.email = email;
    }
    public Author(String firstName, String lastName, String genre, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Author [email=%s, firstName=%s, genre=%s, id=%s, lastName=%s]", email,
                firstName, genre, id, lastName);
    }


}
