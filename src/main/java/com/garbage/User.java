package com.garbage;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.*;
import java.util.jar.JarFile;

/**
 * machine word - 8 byte
 * empty user has size
 * heading User - 16 byte;
 * String name - 8 byte;
 * String adress - 8 byte;
 * int salary - 4 byte;
 * result for empty user - 16 + 8 + 8 + 4 + 4(multiplicity factor to machine word) = 40 byte;
 */

public class User {

    private String name;
    private String adress;
    private int salary;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("destroying " + this);
        super.finalize();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public static void main(String[] args) throws Exception {

        Runtime runtime = Runtime.getRuntime();
        /**
         * String object consist from :
         * heading - 16 byte;
         * private final byte[] value - 8 byte;
         * private final byte coder - 1 byte;
         * private int hash - 4 byte;
         * value :
         * heading - 16 byte + 4 (array.length);
         * result for value = 9 * 2 + 20 + 2(multiplicity factor to machine word) = 40 byte;
         * result for String - 16 + 8 + 40 + 1 + 4 + 3(multiplicity factor to machine word) = 72 byte;
         * first_guy - 72 + 40 = 112 byte
         */
        User first_guy = new User("first guy");
        /**
         * put eden size
         * VM option -XX:NewSize=1m
         * after eden was filled method finalize is evoked
         */
        long before = runtime.freeMemory();
        while (before > 112) {
            User user = new User("first guy");
            user = null;
            before -= 112;
        }
    }

}
