package com.neosoft.singletondemo;

import com.neosoft.singletondemo.entity.MySingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonDesignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonDesignDemoApplication.class, args);
		MySingleton instance1 = MySingleton.getInstance();
		MySingleton instance2 = MySingleton.getInstance();

		instance1.printHashCode();
		instance2.printHashCode();

		// Compare the hash codes of the two instances
		if (instance1.hashCode() == instance2.hashCode()) {
			System.out.println("Only one instance of MySingleton is created.");
		} else {
			System.out.println("Multiple instances of MySingleton are created.");
		}
	}

}

// the real life example for this is database connection pooling , logger , print etc.
