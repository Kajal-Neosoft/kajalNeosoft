package com.neosoft.factorydesigndemo;

public class PolygonFactory {

    public static Polygon getInstance(int sides)
    {
        Polygon polygon = null;

        switch (sides)
        {
            case 3:
                polygon = new Triangle();
                break;

            case 4:
                polygon = new Square();
                break;

            case 5:
                polygon = new Pentagon();
                break;

            case 6:
                polygon = new Octagon();
                break;

            default:
                break;
        }

        return polygon;
    }
}
