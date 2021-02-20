/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul1;

/**
 *
 * @author Radu
 */
public class Lab1 {
//Damian Radu
    private String languages[];
    private int n;
    public static void main(String[] args) {

        Lab1 obj = new Lab1();
        obj.compulsory();
        if(args.length>=1)
        {
          String numar=args[0];
          int nr;
          if(obj.esteNumar(numar))
          {
              nr=Integer.parseInt(numar);
              obj.optional(nr);
          }
        }
            
    }
    public boolean esteNumar(String numar)
    {
        try{
        Integer.parseInt(numar);
        }
        catch(NumberFormatException aux)
        {
            return false;
        }
        return true;
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
        this.modifyN();
        System.out.println("Willy-nilly, this semester I will earn " + languages[this.digitN()]);
    }
    public void optional(int nr)
    {
        boolean [][] graf = new boolean[nr][nr];
        for(int i=0;i<nr;++i)
            for(int j=0;j<nr;++j)
                if(i==j)
                    graf[i][j] = false;
                else
                {
                    int esteMuchie=(int)(Math.random()*2);
                    if(esteMuchie==1)
                        graf[i][j] = true;
                    else
                        graf[i][j] = false;
                }
    }

}
