package com.neosoft.factorydesigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryDesignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryDesignDemoApplication.class, args);

		Polygon polygon = PolygonFactory.getInstance(3);
		System.out.println(polygon.getType());

		Polygon square = PolygonFactory.getInstance(4);
		System.out.println(square.getType());

		Polygon pentagon = PolygonFactory.getInstance(5);
		System.out.println(pentagon.getType());

		Polygon octagon = PolygonFactory.getInstance(6);
		System.out.println(octagon.getType());

	}

}

//	When the implementation of an interface or an abstract class is expected to change frequently.
//		The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class. This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.
//		The lifetime management of the generated objects must be centralized to ensure consistent behavior within the application.
//		Advantage: The factory design pattern provides an approach to code for interface rather than implementation.
//		Advantage: The factory pattern removes the instantiation of actual implementation classes from the client code. The factory pattern makes our code more robust, less coupled and easy to extend.
