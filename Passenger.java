package examples;

import java.io.Serializable;

public class Passenger implements Serializable {

    private static final long serialVersionUID = 3158440363150457327L;
    private String name;
    private String surname;
    private String phonenumber;
    private String mail;

    Passenger(String name, String surname, String phonenumber, String mail) {
        this.setName(name);
        this.setSurname(surname);
        this.setPhonenumber(phonenumber);
        this.setMail(mail);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Passenger [name=" + name + ", surname=" + surname + ", phonenumber=" + phonenumber + ", mail=" + mail + "]";
    }
}
