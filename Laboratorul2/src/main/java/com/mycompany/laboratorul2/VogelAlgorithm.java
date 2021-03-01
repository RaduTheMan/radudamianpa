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

    @Override
    public Solution solve() {
        boolean satisfied = false;
        while (!satisfied) {
            computeDiff(rowDiff, pb.getNrSources(), pb.getNrDestinations(), 'L');
            computeDiff(colDiff, pb.getNrDestinations(), pb.getNrSources(), 'C');
            int indexLine, indexCol;
            int vMax[] = new int[1];
            vMax[0] = -1;

            indexLine = computeMaxDiff(rowDiff, pb.getNrSources(), vMax);
            indexCol = computeMaxDiff(colDiff, pb.getNrDestinations(), vMax);

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

            if (!ok) {
                satisfied = true;
            }
        }
        Solution solution = new Solution(x, pb);
        return solution;
    }

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
