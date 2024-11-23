package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, Contact> contactList;

    public Phonebook() {
        this.contactList = new HashMap<>(); // Inicializa el mapa
    }

    public void addContact(Contact contact) {
        this.contactList.put(contact.getCode(), contact);
    }

    public void deleteContact(String code) {
        this.contactList.remove(code);
    }

    public Map<String, Contact> getData() {
        return this.contactList;
    }

    public void showPhonebook() {
        for (Contact contacto : this.contactList.values()) {
            System.out.println("Nombre: " + contacto.getName() +
                    ". Apellidos: " + contacto.getSurnames() +
                    ". Teléfono: " + contacto.getPhone() +
                    ". Código: " + contacto.getCode() + ".");
        }
    }

    public void phonebookMenu() {

        int userOption = 0;

        while (userOption != 5) {
            userOption = Utils.integer("Seleccione una acción: \n" +
                    "1- Añadir un contacto\n" +
                    "2- Mostrar contactos\n" +
                    "3- Seleccionar contacto\n" +
                    "4- Eliminar un contacto\n" +
                    "5- Salir\n");

            switch (userOption) {
                case 1:
                    String name = Utils.string("Nombre: ");
                    String surnames = Utils.string("Apellidos: ");
                    String phone = Utils.string("Teléfono: ");
                    Contact contact = new Contact(name, surnames, phone);
                    addContact(contact);
                    System.out.println("Contacto añadido!");
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    String contactToSelect = Utils.string("Introduzca el código: ");
                    this.contactList.get(contactToSelect).contactMenu();
                    break;
                case 4:
                    String contactToDelete = Utils.string("Introduzca el código: ");
                    this.contactList.remove(contactToDelete);
                    System.out.println("Contacto eliminado!");
                    break;
                case 5:
                    break;
            }
        }
    }

    public Map<String, Contact> getContactList() {
        return contactList;
    }
}
