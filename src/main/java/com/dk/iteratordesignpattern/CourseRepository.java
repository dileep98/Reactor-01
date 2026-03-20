package com.dk.iteratordesignpattern;

import java.util.Objects;

public class CourseRepository {

    private Course[] courses = new Course[10];
    private int index;

    public void addCourse(Course course){
        courses[index++] = course;
    }

    public Iterator createIterator(){
        // Seperate class implementation we need to pass Course[] to the CourseIterator class
        return new CourseIterator(courses);

        // If we want to implement iterator as an inner class
//        return new CourseIterator();
    }

    // using Inner class
//    private class CourseIterator implements  Iterator{
//        private int position  = 0;
//
//        @Override
//        public boolean hasNext() {
//            return position < courses.length && courses[position] != null;
//        }
//
//        @Override
//        public Object next() {
//            return courses[position++];
//        }
//    }
}
