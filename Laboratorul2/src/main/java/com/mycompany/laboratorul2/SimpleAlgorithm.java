/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul2;

/**
 *
 * @author Radu
 */
public class SimpleAlgorithm extends Algorithm {
    
    @Override
    public Solution solve()
    {
        for(int j=0; j<demandTemp.length; ++j)
        {
            boolean satisfiedDemand = false;
            for(int i=0; i<supplyTemp.length && !satisfiedDemand; ++i)
            {
                if(demandTemp[j]>=supplyTemp[i])
                {
                   demandTemp[j] -= supplyTemp[i];
                   x[i][j] = supplyTemp[i];
                   supplyTemp[i] = 0;
                }
                else
                {
                    supplyTemp[i] -= demandTemp[j];
                    x[i][j] = demandTemp[j];
                    demandTemp[j] = 0;
                    
                }
                if(demandTemp[j] == 0)
                    satisfiedDemand = true;
            }
        }
        Solution solution = new Solution(x, pb);
        return solution;
    }
    public SimpleAlgorithm(Problem pb)
    {
        this.pb = pb;
        this.supplyTemp = pb.getSupply();
        this.demandTemp = pb.getDemand();
        this.x = new int[pb.getNrSources()][pb.getNrDestinations()];
    }
    
}
