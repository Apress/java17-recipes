package org.java17recipes.chapter07.recipe07_01;


import java.util.Arrays;
 

public class BasicFieldType {

    public enum FieldType {

        PASSWORD, EMAIL_ADDRESS, PHONE_NUMBER, SOCIAL_SECURITY_NUMBER
    }

    public static void main(String[] args) {
        
        FieldType field = FieldType.EMAIL_ADDRESS;

        System.out.println("field.name(): " + field.name());
        System.out.println("field.ordinal(): " + field.ordinal());
        System.out.println("field.toString(): " + field.toString());
        System.out.println("field.isEqual(EMAIL_ADDRESS): " +
                            field.equals(FieldType.EMAIL_ADDRESS));
        System.out.println("field.isEqual(\"EMAIL_ADDRESS\"'): " + field.equals("EMAIL_ADDRESS"));

        System.out.println("field == EMAIL_ADDRESS: " + (field == FieldType.EMAIL_ADDRESS));
        // Won't compile - illustrates type safety of enum
        // System.out.println("field == \"EMAIL_ADDRESS\": " + (field == "EMAIL_ADDRESS"));

        System.out.println("field.compareTo(EMAIL_ADDRESS): " +
                            field.compareTo(FieldType.EMAIL_ADDRESS));
        System.out.println("field.compareTo(PASSWORD): " + field.compareTo(FieldType.PASSWORD));

        System.out.println("field.valueOf(\"EMAIL_ADDRESS\"): " + field.valueOf("EMAIL_ADDRESS"));

        try {
            System.out.print("field.valueOf(\"email_address\"): ");
            System.out.println(FieldType.valueOf("email_address"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

        System.out.println("FieldType.values(): " + Arrays.toString(FieldType.values()));

    }
}

