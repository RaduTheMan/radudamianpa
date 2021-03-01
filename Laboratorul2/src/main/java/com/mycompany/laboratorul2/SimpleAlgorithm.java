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

    /**
     * solve indica implementarea concreta a algoritmului pentru a rezolva
     * problema
     *
     * @return Solution
     */
    @Override
    public Solution solve() {
        for (int j = 0; j < demandTemp.length; ++j) {
            boolean satisfiedDemand = false;
            for (int i = 0; i < supplyTemp.length && !satisfiedDemand; ++i) {
                if (demandTemp[j] >= supplyTemp[i]) {
                    demandTemp[j] -= supplyTemp[i];
                    x[i][j] = supplyTemp[i];
                    supplyTemp[i] = 0;
                } else {
                    supplyTemp[i] -= demandTemp[j];
                    x[i][j] = demandTemp[j];
                    demandTemp[j] = 0;

                }
                if (demandTemp[j] == 0) {
                    satisfiedDemand = true;
                }
            }
        }
        Solution solution = new Solution(x, pb);
        return solution;
    }

    /**
     * Constructor pentru a initializa input-ul necesar algoritmului
     *
     * @param pb problema ce se doreste a fi rezolvata
     */
    public SimpleAlgorithm(Problem pb) {
        this.pb = pb;
        this.supplyTemp = new int[pb.getNrSources()];
        this.demandTemp = new int[pb.getNrDestinations()];

        for (int i = 0; i < supplyTemp.length; ++i) {
            supplyTemp[i] = pb.getSupply()[i];
        }
        for (int i = 0; i < demandTemp.length; ++i) {
            demandTemp[i] = pb.getDemand()[i];
        }

        this.x = new int[pb.getNrSources()][pb.getNrDestinations()];
    }

}
