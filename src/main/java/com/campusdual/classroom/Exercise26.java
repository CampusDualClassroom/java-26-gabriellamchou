package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {

        Contact c1 = new Contact("Javier", "López", "111");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "222");
        Contact c3 = new Contact("Jose Manuel", "Soria", "333");
        Contact c4 = new Contact("Santiago", "Fernández Rocha", "444");
        Contact c5 = new Contact("Esteban", "Serrano del Río", "555");
        Contact c6 = new Contact("Fernando Miguel", "Juan de los Santos Requejo León", "666");

        Phonebook listin = new Phonebook();

        listin.addContact(c1);
        listin.addContact(c2);
        listin.addContact(c3);
        listin.addContact(c4);
        listin.addContact(c5);
        listin.addContact(c6);

        listin.phonebookMenu();
    }
}
