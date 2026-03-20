package com.dk.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.addCourse(new Course("Spring boot"));
        courseRepository.addCourse(new Course("Java"));
        courseRepository.addCourse(new Course("Microservices"));

        Iterator iterator = courseRepository.createIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
