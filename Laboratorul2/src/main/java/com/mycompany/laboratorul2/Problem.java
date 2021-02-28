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
public class Problem {

    private Source[] sources;
    private Destination[] destinations;

    private int supply[];
    private int demand[];
    private int cost[][];

    private int nrSources;
    private int nrDestinations;

    public Problem(int nrSourcesMax, int nrDestinationsMax) {
        sources = new Source[nrSourcesMax];
        destinations = new Destination[nrDestinationsMax];
        nrSources = 0;
        nrDestinations = 0;
    }

    public void addSource(Source source) {
        if (nrSources + 1 <= sources.length) {
            boolean ok = false;
            for (int i = 0; i < nrSources && !ok; ++i) {
                if (sources[i].equals(source)) {
                    ok = true;
                }
            }

            if (!ok) {
                sources[nrSources++] = source;
            } else {
                System.out.println("The source with name: " + source + " already exists!");
            }
        } else {
            System.out.println("The maximum number of sources allowed was reached!");
        }
    }

    public void addDestination(Destination destination) {
        if (nrDestinations + 1 <= destinations.length) {
            boolean ok = false;
            for (int i = 0; i < nrDestinations && !ok; ++i) {
                if (destinations[i].equals(destination)) {
                    ok = true;
                }
            }
            if (!ok) {
                destinations[nrDestinations++] = destination;
            } else {
                System.out.println("The destination with name: " + destination + " already exists!");
            }
        } else {
            System.out.println("The maximum number of destinations allowed was reached!");
        }
    }

    public void setSupply(int[] supply) {
        if (supply.length == nrSources) {
            this.supply = supply;
        } else {
            System.out.println("Number of supplies is not equal with the number of sources of the problem");
        }
    }

    public void setDemand(int[] demand) {
        if (demand.length == nrDestinations) {
            this.demand = demand;
        } else {
            System.out.println("Number of demands is not equal with the number of destinations of the problem");
        }
    }

    public void setCost(int[][] cost) {
        if (cost.length == nrSources) {
            if (cost.length == 0) {
                if (nrDestinations == 0) {
                    this.cost = cost;
                }
            } else {
                if (cost[0].length == nrDestinations) {
                    this.cost = cost;
                } else {
                    System.out.println("The cost matrix doesn't have the coresponding number of sources/destinations of the problem");
                }

            }
        } else {
            System.out.println("The cost matrix doesn't have the coresponding number of sources/destinations of the problem");
        }

    }

    @Override
    public String toString() {
        if(supply != null && demand != null)
        if (nrSources == supply.length && nrDestinations == demand.length) {
            if (cost.length == nrSources) {
                if (cost.length == 0) {
                    return "-1";
                }
                if (cost[0].length == nrDestinations) {
                    //returning corresponding string
                    var s = new StringBuilder();
                    s.append("Sources: ");
                    for (int i = 0; i < nrSources; ++i) {
                        s.append(sources[i] + " ");
                    }
                    s.append("\n");

                    s.append("Supply: ");
                    for (int i = 0; i < nrSources; ++i) {
                        s.append(supply[i] + " ");
                    }
                    s.append("\n");

                    s.append("Destinations: ");
                    for (int i = 0; i < nrDestinations; ++i) {
                        s.append(destinations[i] + " ");
                    }
                    s.append("\n");

                    s.append("Demand: ");
                    for (int i = 0; i < nrDestinations; ++i) {
                        s.append(demand[i] + " ");
                    }
                    s.append("\n");

                    s.append("Cost matrix:\n");
                    for (int i = 0; i < nrSources; ++i) {
                        for (int j = 0; j < nrDestinations; ++j) {
                            s.append(cost[i][j] + " ");
                        }
                        s.append("\n");
                    }

                    return s.toString();
                }
            }
        }
        return "-1";
    }

}
