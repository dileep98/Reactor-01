package com.dk.iteratordesignpattern;

public class CourseIterator implements  Iterator{
    private int position  = 0;
    private Course[] courses;

    public CourseIterator(Course[] courses){
        this.courses = courses;
    }

    @Override
    public boolean hasNext() {
        return position < courses.length && courses[position] != null;
    }

    @Override
    public Object next() {
        return courses[position++];
    }
}
