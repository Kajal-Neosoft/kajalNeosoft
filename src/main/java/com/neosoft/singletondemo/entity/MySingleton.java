package com.neosoft.singletondemo.entity;

public class MySingleton {

    //private constructore to prevent direct instantiation
    private MySingleton(){};

    //The instance of the singleton class
    private static MySingleton instance;

    //Static method to get the singleton instance
    public static MySingleton getInstance(){
        if(instance == null)
        {
            instance = new MySingleton();
        }
        return instance;
    }

    public void doSomething()
    {
        System.out.println("singleton instance is doingSomething");
    }

    // Print the hash code of the instance
    public void printHashCode() {
        System.out.println("HashCode of the Singleton instance: " + System.identityHashCode(this));
    }

}
