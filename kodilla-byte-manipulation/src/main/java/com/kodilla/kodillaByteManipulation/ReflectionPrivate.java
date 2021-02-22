package com.kodilla.kodillaByteManipulation;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionPrivate {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Book book = new Book("Title", "Signature", 2003);
        Field signatureField = Book.class.getDeclaredField("signature");
        System.out.println(signatureField.isAccessible());

        signatureField.setAccessible(true);
        System.out.println(signatureField.isAccessible());


        String value = (String) signatureField.get(book);
        System.out.println(value);

        Method rentBookMethod = Book.class.getDeclaredMethod("rentBook");
        rentBookMethod.setAccessible(true);
        boolean result = (boolean) rentBookMethod.invoke(book);
        System.out.println(result);

        Method setDetailsMethod
                = Book.class.getDeclaredMethod("setDetails", String.class, int.class);

        setDetailsMethod.setAccessible(true);
        setDetailsMethod.invoke(book, "new Signature", 1990);
        System.out.println(book.getSignature());
        System.out.println(book.getYear());
    }
}
