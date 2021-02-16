package com.company;

public class Lab1 {
//Damian Radu
    private String languages[];
    private int n;
    public static void main(String[] args) {

        Lab1 obj = new Lab1();
        obj.compulsory();
    }
    public void compulsory()
    {
        System.out.println("Hello world!");
        languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += 0b10101;
        n += 0xFF;
        n *= 6;
        
    }

}
