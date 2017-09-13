/*
    Code obtained from : http://www.cs.columbia.edu/~gskc/Code/AdvancedInternetServices/MinimalSpanningTree/

    Code modified by : Kasun Gamage
 */

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class Kruskal {

    private final int MAX_NODES = 21;
    private HashSet nodes[];               // Array of connected components
    private TreeSet allEdges;              // Priority queue of Edge objects
    private Vector allNewEdges;            // Edges in Minimal-Spanning Tree

    public static void main(String args[]) {
        System.out.println("Running [Kruskal]\n");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Graph data file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showSaveDialog(null);

        Kruskal k = new Kruskal();

        k.readInGraphData(fileChooser.getSelectedFile());
        k.performKruskal();
        k.printFinalEdges();
    }

    Kruskal() {
        // Constructor
        nodes = new HashSet[MAX_NODES];      // Create array for components
        allEdges = new TreeSet(new Edge());  // Create empty priority queue
        allNewEdges = new Vector(MAX_NODES); // Create vector for MST edges
    }

    private void readInGraphData(File fileR) {
        try {
            FileReader file = new FileReader(fileR);
            BufferedReader buff = new BufferedReader(file);
            String line = buff.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line, " ");
                int from = Integer.parseInt(tok.nextToken());
                int to = Integer.parseInt(tok.nextToken());
                int cost = Integer.parseInt(tok.nextToken());
                boolean mandatory = tok.hasMoreElements() && tok.nextToken().equals("*");

           ///     if (mandatory) {
//                    System.out.println("fsgdf");
//                    HashSet src, dst;
//                    int dstHashSetIndex;
//                    // have to transfer all nodes including curEdge.from
//                    src = nodes[dstHashSetIndex = from];
//                    dst = nodes[to];
//
//                    Object srcArray[] = src.toArray();
//                    int transferSize = srcArray.length;
//                    for (int j = 0; j < transferSize; j++) {
//                        // move each node from set: src into set: dst
//                        // and update appropriate index in array: nodes
//                        if (src.remove(srcArray[j])) {
//                            dst.add(srcArray[j]);
//                            nodes[((Integer) srcArray[j])] = nodes[dstHashSetIndex];
//                        } else {
//                            // This is a serious problem
//                            System.out.println("Something wrong: set union");
//                            System.exit(1);
//                        }
//                    }
//                    allNewEdges.add(new Edge(from, to, cost, mandatory));
               // } else {
               
                    allEdges.add(new Edge(from, to, cost, mandatory));  // Update priority queue
                    if (nodes[from] == null) {
                        // Create set of connect components [singleton] for this node
                        nodes[from] = new HashSet(2 * MAX_NODES);
                        nodes[from].add(from);
                    }

                    if (nodes[to] == null) {
                        // Create set of connect components [singleton] for this node
                        nodes[to] = new HashSet(2 * MAX_NODES);
                        nodes[to].add(to);
                    }
              //  }

                line = buff.readLine();
            }
            buff.close();
        } catch (IOException e) {
            //
        }
    }

    private void performKruskal() {
        int size = allEdges.size();

        for (int i = 0; i < size; i++) {
            Edge curEdge = (Edge) allEdges.first();
            if (allEdges.remove(curEdge)) {
//                if(curEdge.mandatory){
//                    allNewEdges.add(curEdge); continue;
//                }
                // successful removal from priority queue: allEdges
//                System.out.println("ECHO " + (curEdge.from + " to " + curEdge.to) + " " + curEdge.mandatory);
                    
                if (nodesAreInDifferentSets(curEdge.from, curEdge.to) || curEdge.mandatory) {
                    // System.out.println("Nodes are in different sets ...");
//                    System.out.println(nodesAreInDifferentSets(curEdge.from, curEdge.to) + " || " + curEdge.mandatory);
                    HashSet src, dst;
                    int dstHashSetIndex;

                    if (nodes[curEdge.from].size() > nodes[curEdge.to].size()) {
                        // have to transfer all nodes including curEdge.to
                        src = nodes[curEdge.to];
                        dst = nodes[dstHashSetIndex = curEdge.from];
                    } else {
                        // have to transfer all nodes including curEdge.from
                        src = nodes[curEdge.from];
                        dst = nodes[dstHashSetIndex = curEdge.to];
                    }

                    Object srcArray[] = src.toArray();
                    int transferSize = srcArray.length;
                    for (int j = 0; j < transferSize; j++) {
                        // move each node from set: src into set: dst
                        // and update appropriate index in array: nodes
                        if (src.remove(srcArray[j])) {
                            dst.add(srcArray[j]);
//                            System.out.println(nodes[((Integer) srcArray[j])] + " = " + nodes[dstHashSetIndex]);
                            nodes[((Integer) srcArray[j])] = nodes[dstHashSetIndex];
                        }
                    }

                    allNewEdges.add(curEdge);
                    // add new edge to MST edge vector
                } else {
                    // System.out.println("Nodes are in the same set ... nothing to do here");
                }

            } else {
                // This is a serious problem
                System.out.println("TreeSet should have contained this element!!");
            }
        }
    }

    private boolean nodesAreInDifferentSets(int a, int b) {
        // returns true if graph nodes (a,b) are in different
        // connected components, ie the set for 'a' is different
        // from that for 'b'
        return (!nodes[a].equals(nodes[b]));
    }

    private void printFinalEdges() {
        System.out.println("The minimal spanning tree generated by\nKruskal's algorithm is: ");
        int totalCost = 0;
        while (!allNewEdges.isEmpty()) {
            // for each edge in Vector of MST edges
            Edge e = (Edge) allNewEdges.firstElement();
            totalCost += e.cost;
            System.out.println("Nodes: (" + e.from + ", " + e.to + ") with cost: " + e.cost);
            allNewEdges.remove(e);
        }
        System.out.println("Total cost is : " + totalCost);
    }

    class Edge implements Comparator {
        // Inner class for representing edge+end-points

        public int from, to, cost;
        public boolean mandatory;

        public Edge() {
            // Default constructor for TreeSet creation
        }

        public Edge(int f, int t, int c, boolean mandatory) {
            // Inner class constructor
            from = f;
            to = t;
            cost = c;
            this.mandatory = mandatory;
        }
        
        @Override
        public int compare(Object o1, Object o2) {
            // Used for comparisions during add/remove operations
            int cost1 = ((Edge) o1).cost;
            int cost2 = ((Edge) o2).cost;
            int from1 = ((Edge) o1).from;
            int from2 = ((Edge) o2).from;
            int to1 = ((Edge) o1).to;
            int to2 = ((Edge) o2).to;

//            System.out.println(((Edge) o1).from + " " +  ((Edge) o1).to + " " +  ((Edge) o1).mandatory + 
//                    " " + ((Edge) o2).from + " " +  ((Edge) o2).to + " " +  ((Edge) o2).mandatory);
//            
//            int result = 0;
            if(((Edge) o1).mandatory && !(((Edge) o2).mandatory)) return (-1);
            if(((Edge) o2).mandatory && !(((Edge) o1).mandatory)) return (1);
//            if(((Edge) o2).mandatory && (((Edge) o1).mandatory)) return (0);
//            
//            System.out.println("result" + result);
            
            if (cost1 < cost2) {
                return (-1);
            } else if (cost1 == cost2 && from1 == from2 && to1 == to2) {
                return (0);
            } else if (cost1 == cost2) {
                return (-1);
            } else if (cost1 > cost2) {
                return (1);
            } else {
                return (0);
            }
        }

        @Override
        public boolean equals(Object obj) {
            // Used for comparisions during add/remove operations
            Edge e = (Edge) obj;
            return (cost == e.cost && from == e.from && to == e.to);
        }
    }
}
