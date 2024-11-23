package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = createCode(name, surnames);
    }

    @Override
    public void callMyNumber() {
        System.out.println("Te estás llamando a ti mismo. Nombre:  " + this.getName()
                + ". Apellidos: " + this.getSurnames()
                + "Teléfono: " + this.phone + ".");
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Estás llamando al " + number
                + ". Nombre:  " + this.getName()
                + ". Apellidos: " + this.getSurnames() + ".");
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + this.name
                + ". Apellidos: " + this.surnames
                + ". Teléfono: " + this.phone
                + ". Código: " + this.getCode());
    }

    private String createCode(String name, String surnames) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.toLowerCase().charAt(0));
        String[] apellidos = surnames.split(" ");
        if (apellidos.length == 1) {
            sb.append(removeAccents(surnames.toLowerCase()));
        } else {
            sb.append(removeAccents(String.valueOf(surnames.toLowerCase().charAt(0))));
            for (int i = 1; i < apellidos.length; i++) {
                sb.append(removeAccents(apellidos[i].toLowerCase()));
            }
        }
        return sb.toString();
    }

    private static String removeAccents(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    public void contactMenu() {
        int userOption = 0;

        while (userOption != 4) {
            userOption = Utils.integer("Seleccione una acción: \n" +
                    "1- Llamar a un contacto\n" +
                    "2- Llamarme a mí mismo/a\n" +
                    "3- Detalles\n" +
                    "4- Salir\n");

            switch (userOption) {
                case 1:
                    String phone = Utils.string("Número: ");
                    callOtherNumber(phone);
                    break;
                case 2:
                    callMyNumber();
                    break;
                case 3:
                    showContactDetails();
                    break;
                case 4:
                    break;
            }
        }
    }
}
