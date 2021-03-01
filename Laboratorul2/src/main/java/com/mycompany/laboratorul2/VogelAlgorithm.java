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
public class VogelAlgorithm extends Algorithm {

    int cost[][];
    int rowDiff[];
    int colDiff[];

    /**
     *
     * @param diff vectorul care retine pentru fiecare linie/coloana diferenta
     * in modul intre cel mai mic cost si al doilea cel mai mic cost pe
     * linia/coloana respectiva
     * @param n numarul de surse/destinatii in functie de parametrul type
     * @param m idem.
     * @param type caracter ce indica unde se calculeaza vectorul diff ( linie
     * sau coloana)
     */
    private void computeDiff(int diff[], int n, int m, char type) {
        for (int i = 0; i < n; ++i) {
            if (diff[i] != -1) {
                int min1 = -1;
                int min2 = -1;
                for (int j = 0; j < m; ++j) {
                    int x = i, y = j;
                    if (type == 'C') {
                        x = j;
                        y = i;
                    }

                    if (cost[x][y] != -1) {
                        if (min1 == -1) {
                            min1 = cost[x][y];
                            continue;
                        } else if (min2 == -1) {
                            min2 = cost[x][y];
                            int aux;
                            if (min2 < min1) {
                                aux = min2;
                                min2 = min1;
                                min1 = aux;
                            }
                            continue;

                        } else if (cost[x][y] < min1) {
                            min2 = min1;
                            min1 = cost[x][y];
                            continue;
                        } else if (cost[x][y] < min2) {
                            min2 = cost[x][y];
                            continue;
                        }
                    }
                }
                if (min2 == -1) {
                    diff[i] = min1;
                } else {
                    diff[i] = Math.abs(min1 - min2);
                }
            }
        }
    }

    /**
     *
     * @param diff vectorul care retine pentru fiecare linie/coloana diferenta
     * in modul intre cel mai mic cost si al doilea cel mai mic cost pe
     * linia/coloana respectiva
     * @param nr numarul de surse/destinatii
     * @param vMax un vector cu un element care retine diferenta maxima
     * @return int indicele liniei/coloanei unde se afla diferenta maxima
     */
    private int computeMaxDiff(int diff[], int nr, int vMax[]) {
        int index = -1;
        for (int i = 0; i < nr; ++i) {
            if (diff[i] != -1 && diff[i] > vMax[0]) {
                vMax[0] = diff[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * solve indica implementarea concreta a algoritmului lui Vogel pentru a
     * rezolva problema
     *
     * @return Solution
     */
    @Override
    public Solution solve() {
        boolean satisfied = false;
        while (!satisfied) {
            computeDiff(rowDiff, pb.getNrSources(), pb.getNrDestinations(), 'L'); //se calculeaza diferentele parcurgand liniile, apoi coloanele
            computeDiff(colDiff, pb.getNrDestinations(), pb.getNrSources(), 'C');
            int indexLine, indexCol;
            int vMax[] = new int[1];
            vMax[0] = -1;

            indexLine = computeMaxDiff(rowDiff, pb.getNrSources(), vMax); //se calculeaza indicele liniei/coloanei unde se afla diferenta maxima
            indexCol = computeMaxDiff(colDiff, pb.getNrDestinations(), vMax);

            //se determina cea mai mica diferenta de pe linia/coloana calculata anterior  si se va retina pozitia in matrice a acestei valori
            if (indexCol == -1) {
                int min = -1;
                for (int j = 0; j < pb.getNrDestinations(); ++j) {
                    if (cost[indexLine][j] != -1) {
                        if (min == -1) {
                            min = cost[indexLine][j];
                            indexCol = j;
                        } else if (cost[indexLine][j] < min) {
                            min = cost[indexLine][j];
                            indexCol = j;
                        }
                    }
                }
            } else {
                int min = -1;
                for (int i = 0; i < pb.getNrSources(); ++i) {
                    if (cost[i][indexCol] != -1) {
                        if (min == -1) {
                            min = cost[i][indexCol];
                            indexLine = i;
                        } else if (cost[i][indexCol] < min) {
                            min = cost[i][indexCol];
                            indexLine = i;
                        }
                    }
                }

            }

            //se actualizeaza demand, supply si matricea solutie x
            if (demandTemp[indexCol] >= supplyTemp[indexLine]) {
                x[indexLine][indexCol] = supplyTemp[indexLine];
                demandTemp[indexCol] -= supplyTemp[indexLine];
                supplyTemp[indexLine] = 0;
                for (int j = 0; j < pb.getNrDestinations(); ++j) {
                    cost[indexLine][j] = -1;
                }
                rowDiff[indexLine] = -1;
                if (demandTemp[indexCol] == 0) {
                    colDiff[indexCol] = -1;
                }

            } else {
                x[indexLine][indexCol] = demandTemp[indexCol];
                supplyTemp[indexLine] -= demandTemp[indexCol];
                demandTemp[indexCol] = 0;
                for (int i = 0; i < pb.getNrSources(); ++i) {
                    cost[i][indexCol] = -1;
                }
                colDiff[indexCol] = -1;
            }

            //se "blocheaza" liniile/coloanele care au demand/supply epuizat(egal cu 0)
            boolean ok = false;
            for (int i = 0; i < pb.getNrSources() && !ok; ++i) {
                if (rowDiff[i] != -1) {
                    ok = true;
                }
            }
            for (int i = 0; i < pb.getNrDestinations() && !ok; ++i) {
                if (colDiff[i] != -1) {
                    ok = true;
                }
            }
            
            //se verifica daca conditia de oprire este satisfacuta(daca nu mai exista linii/coloane disponibile)
            if (!ok) {
                satisfied = true;
            }
        }
        Solution solution = new Solution(x, pb);
        return solution;
    }

    /**
     * Constructor pentru a initializa input-ul necesar algoritmului lui Vogel
     *
     * @param pb problema ce se doreste a fi rezolvata
     */
    public VogelAlgorithm(Problem pb) {
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
        this.cost = new int[pb.getNrSources()][pb.getNrDestinations()];
        for (int i = 0; i < pb.getNrSources(); ++i) {
            this.cost[i] = pb.getCost()[i].clone();
        }

        this.rowDiff = new int[pb.getNrSources()];
        this.colDiff = new int[pb.getNrDestinations()];
    }

}
