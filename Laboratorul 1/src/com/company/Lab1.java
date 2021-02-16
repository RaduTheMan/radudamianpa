package com.company;

public class Lab1 {
//Damian Radu
    private String languages[];
    private int n;
    public static void main(String[] args) {

        Lab1 obj = new Lab1();
        obj.compulsory();
    }
    private void modifyN()
    {
        n *= 3;
        n += 0b10101;
        n += 0xFF;
        n *= 6;
    }
    private int digitN()
    {
        int sum=n, aux, digit;
        while(sum > 9)
        {
            aux = sum;
            sum = 0;
            while(aux != 0)
            {
                digit = aux % 10;
                aux /= 10;
                sum += digit;
            }
        }
        return sum;
    }
    public void compulsory()
    {
        System.out.println("Hello world!");
        languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        n = (int) (Math.random() * 1_000_000);
        //System.out.println(n);
        this.modifyN();
        //System.out.println(n);
        System.out.println(this.digitN());
        System.out.println("Willy-nilly, this semester I will earn " + languages[this.digitN()]);
    }

}
