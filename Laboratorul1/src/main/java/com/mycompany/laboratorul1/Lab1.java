/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul1;
import java.util.*;


/**
 *
 * @author Radu
 */
public class Lab1 {
//Damian Radu
    private String languages[];
    private int n;
    private int dimension;
    private boolean [][] graf;
    private boolean [][] partialTree;
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
              obj.bonus(nr);
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
    private void buildMatrix()
    {
        graf = new boolean[dimension][dimension];
        for(int i=0;i<dimension;++i)
            for(int j=i;j<dimension;++j)
                if(i==j)
                    graf[i][j] = false;
                else
                {
                    int esteMuchie=(int)(Math.random()*2);
                    if(esteMuchie==1)
                    {
                       graf[i][j] = true;
                       graf[j][i] = true;
                    }
                    else
                    {
                        graf[i][j] = false;
                        graf[j][i] = false;
                    }
                }
    }
    private void buildPartialTree()
    {
        partialTree = new boolean[dimension][dimension];
        int cntr=1, nodes[] = new int[dimension];
        boolean viz[] = new boolean[dimension];
        nodes[0] = 0;
        viz[0] = true;
        while(cntr < dimension)
        {
            for(int i=0;i<cntr;++i)
                for(int j=0;j<dimension;++j)
                    if(graf[nodes[i]][j] == true && viz[j] == false)
                    {
                        viz[j] = true;
                        nodes[cntr++] = j;
                        partialTree [nodes[i]][j] = true;
                        partialTree [j][nodes[i]] = true;
                        break;
                    }
        }
    }
    private void printMatrix(boolean [][] graf)
    {
        char x ='\u25A0';
        char y = '\u25A1';
        System.out.println("Matrix size: "+dimension+"x"+dimension);
        for(int i=0;i<dimension;++i)
        {
           for(int j=0;j<dimension;++j)
                if(graf[i][j] == true)
                  System.out.print(x);
                else
                  System.out.print(y);
            System.out.println("");
        }
    }
    private boolean isConnected()
    {
        int queue[] = new int[dimension], cntr=1;
        int ic=0, sc=0, aux;
        boolean viz[] = new boolean[dimension], ok = false;
        for(int i=0;i<dimension;++i)
        {
        if(viz[i] == false)
        {
        viz[i] = true;
        ic = sc = 0; cntr=1;
        queue[ic] = i;
        while(ic<=sc)
        {
            aux = queue[ic++];
            for(int j=0;j<dimension;++j)
                if(graf[aux][j] == true && viz[j] == false)
                {
                    viz[j] = true;
                    queue[++sc] = j;
                    cntr++;
                }
        }
        if(cntr==dimension)
        {
            System.out.println("This graph is connected");
            return true;
        }
        if(ok == false)
        {
            System.out.println("This graph is not connected. The connected components are:");
            ok = true;
        }
        for(int j=0;j<=sc;++j)
                System.out.print(queue[j]+" ");
            System.out.println("");
        }
        }
        return false;
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
        dimension = nr;
        long startTime = System.nanoTime();
        long endTime;
        this.buildMatrix();
        if(nr<=15)
          this.printMatrix(graf);
        if( this.isConnected() == true )
        {
            this.buildPartialTree();
            if(nr<=15)
            {
               System.out.print("Partial tree - ");
               this.printMatrix(partialTree);
            }
            endTime = System.nanoTime();
        }
        else
        {
            endTime=System.nanoTime();
        }
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: "+timeElapsed);
    }    
    public void bonus(int nr)
    {
        int rootedTree[] = new int[nr], currentParent = 0, nodesLeft = nr - 1, nextNode = 1, childs, indice;
        Set <Integer> availableParents = new HashSet<Integer>();
        availableParents.add(0);
        rootedTree[0] = -1;
        while(nodesLeft > 0)
        {
            childs = (int) (Math.random() * nodesLeft) + 1;
            for(int i=nextNode; i<=nextNode+childs-1; ++i)
                rootedTree[i] = currentParent;
            nodesLeft -= childs;
            availableParents.remove(currentParent);
            for(int i=nextNode; i<=nextNode+childs-1;++i)
                availableParents.add(i);
            indice = (int) (Math.random() * availableParents.size());
            currentParent = Integer.parseInt(availableParents.toArray()[indice].toString());
            nextNode += childs;
        }
        currentParent = 0;
        System.out.println("Random rooted tree with "+nr+" nodes");
        System.out.println("node0");
        for(int i=1;i<nr;++i)
        {
            if(rootedTree[i] == currentParent)
                System.out.print(currentParent + "node"+i+" ");
            else
            {
                currentParent = rootedTree[i];
                System.out.println("");
                System.out.print(currentParent + "node"+i+" ");
            }
        }
        
    }

}
