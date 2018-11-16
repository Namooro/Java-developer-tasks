package first_homework.a_magic_tree;

import first_homework.a_magic_tree.beans.Tree;

import java.util.Arrays;
import java.util.Collections;

public class Eight_Task {
    /**
     * This class demonstrates usage of magic_tree
     */
    public static void main(String[] args) {
        Tree tree = new Tree(0, Arrays.asList(
                new Tree(1, Arrays.asList(new Tree(11, Collections.emptyList()), new Tree(12, Collections.emptyList()))),
                new Tree(2, Arrays.asList(new Tree(21, Collections.emptyList()), new Tree(22, Collections.emptyList())))
        ));
        System.out.println("Flattened:");
        tree.flattened().forEach(System.out::print);
        System.out.println("\nallValues:");
        tree.getAllValues().forEach(System.out::println);
        System.out.println("EvenValues:");
        tree.getEvenValues().forEach(System.out::println);
        System.out.printf("Does tree contains number 13: ");
        System.out.println(tree.isContains13());
    }
}