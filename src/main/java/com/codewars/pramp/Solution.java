package com.codewars.pramp;

/**
 * @author Sergey Golitsyn
 * created on 10.08.2023
 */

class Solution {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

  /*
  DFS

  create minValue

  if(node is null){
    minValue = min(minValue, localMin)
  }

  localMin += curVal

  for(Node n : children){
    bfs(n, localMin)
  }

  Time O(N)
  Space O(1)

  */

    static class SalesPath {

        public static int min = Integer.MAX_VALUE;

        int getCheapestCost(Node rootNode) {
            // your code goes here
            min = Integer.MAX_VALUE;
            dfs(rootNode, 0);
            return min;
        }

        private void dfs(Node node, int localCost) {
            if (node.children == null) {
                min = Math.min(min, localCost + node.cost);
            } else {
                localCost += node.cost;
                for (Node child : node.children) {
                    dfs(child, localCost);
                }
            }
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(5);
        Node c = new Node(3);
        Node d = new Node(6);

        a.children = new Node[]{b, c, d};

        Node e = new Node(4);
        Node f = new Node(2);
        Node g = new Node(0);
        Node h = new Node(1);
        Node i = new Node(5);

        Node z = new Node(1);
        Node x = new Node(10);
        Node w = new Node(1);

        b.children = new Node[]{e};
        c.children = new Node[]{f, g};
        d.children = new Node[]{h, i};
        f.children = new Node[]{z};
        g.children = new Node[]{x};
        z.children = new Node[]{w};

        SalesPath s = new SalesPath();
        s.getCheapestCost(a);
        System.out.println(SalesPath.min);
    }
}
