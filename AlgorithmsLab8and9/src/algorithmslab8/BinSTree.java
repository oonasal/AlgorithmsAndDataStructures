package algorithmslab8;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Oona
 * @param <T>
 *
 */
public class BinSTree<T extends Comparable<T>> {

    private Node rootNode;

    public BinSTree() {
        rootNode = null;
    }

    //insert an item to the tree
    public boolean insertToTree(T item) {
        Node currentNode = rootNode;
        if (rootNode == null) {
            rootNode = new Node(item, null, null);
            return true;
        } else {
            while (true) {
                switch (item.compareTo(currentNode.data)) {
                    case 1:
                        if (currentNode.rightNode == null) {
                            currentNode.rightNode = new Node(item, null, null);
                            return true;
                        } else {
                            currentNode = currentNode.rightNode;
                            continue;
                        }
                    case -1:
                        if (currentNode.leftNode == null) {
                            currentNode.leftNode = new Node(item, null, null);
                            return true;
                        } else {
                            currentNode = currentNode.leftNode;
                            continue;
                        }
                    case 0:
                        return true;
                }
            }
        }
    }

    //check whether an item is in the tree or not
    public boolean isInTree(T item) {
        int comparisonsNeeded = 0;
        Node currentNode = rootNode;
        boolean endLoop = false;
        if (rootNode == null) {
            comparisonsNeeded++;
            System.out.println("Not found, " + comparisonsNeeded + " comparisons needed");
            return false;
        } else {
            while (!endLoop) {
                switch (item.compareTo(currentNode.data)) {
                    case 0:
                        comparisonsNeeded++;
                        //System.out.println("Found, " + comparisonsNeeded + " comparisons needed");
                        return true;
                    case -1:
                        comparisonsNeeded++;
                        if (currentNode.leftNode != null) {
                            currentNode = currentNode.leftNode;
                            break;
                        } else {
                            System.out.println("Given number wasn't in the tree! " + comparisonsNeeded + " comparisons needed");
                            return false;
                        }
                    case 1:
                        comparisonsNeeded++;
                        if (currentNode.rightNode != null) {
                            currentNode = currentNode.rightNode;
                            break;
                        } else {
                            System.out.println("Given number wasn't in the tree! " + comparisonsNeeded + " comparisons needed");
                            return false;
                        }
                }
            }
        }
        return false;
    }

    private class Node {

        private T data;
        private Node leftNode;
        private Node rightNode;

        public Node(T data, Node leftNode, Node rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    public static void main(String[] args) {

        BinSTree tree = new BinSTree();
        Scanner scanner = new Scanner(System.in);

        int randomInt;
        Random random = new Random();
        boolean addedInt = false;
        boolean foundInt = false;

        for (int i = 0; i < 10000; i++) {
            randomInt = random.nextInt(10000);
            addedInt = tree.insertToTree(randomInt);
            if (i % 1000 == 0) {
                System.out.println("random number: " + randomInt);
            }
        }

        while (true) {

            System.out.print("\nEnter a number: ");
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            foundInt = tree.isInTree(number);
        }

        //lab 9
        BinSTree binTree = new BinSTree();
        TreeSet treeSet = new TreeSet();
        Integer[] numbers = new Integer[100000];
        for (int i = 0; i < 1000000; i++) {
            randomInt = random.nextInt(1000000);
            addedInt = binTree.insertToTree(randomInt);
            addedInt = treeSet.add(randomInt);
            
        }
        System.out.println("added numbers to both trees");
        for (int i = 0; i < 100000; i++) {
            randomInt = random.nextInt(100000);
            addedInt = binTree.insertToTree(randomInt);
            numbers[i] = randomInt;
        }
        System.out.println("added numbers to array");
        long startTime1 = System.currentTimeMillis();
        for (Integer i : numbers) {
            foundInt = binTree.isInTree(i);
        }
        long stopTime1 = System.currentTimeMillis();
        long elapsedTime1 = stopTime1 - startTime1;
        System.out.println("elapsed time 1: " + elapsedTime1 + "ms");
        long startTime2 = System.currentTimeMillis();
        for (Integer i : numbers) {
            foundInt = treeSet.contains(i);
        }
        long stopTime2 = System.currentTimeMillis();
        long elapsedTime2 = stopTime2 - startTime2;
        System.out.println("elapsed time 2: " + elapsedTime2 + "ms");
    }
}
