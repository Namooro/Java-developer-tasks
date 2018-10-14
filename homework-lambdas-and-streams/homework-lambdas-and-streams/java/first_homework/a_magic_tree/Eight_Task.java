package first_homework.a_magic_tree;

import first_homework.a_magic_tree.beans.Tree;

import java.util.Arrays;
import java.util.Collections;

public class Eight_Task {
    public static void main(String[] args) {
        Tree tree = new Tree(0, Arrays.asList(
                new Tree(1, Arrays.asList(new Tree(11, Collections.emptyList()), new Tree(12, Collections.emptyList()))),
                new Tree(2, Arrays.asList(new Tree(21, Collections.emptyList()), new Tree(22, Collections.emptyList())))
        ));
        //tree.flattened().forEach(System.out::print);
        //tree.getAllValues().forEach(System.out::println);
        //tree.getEvenValues().forEach(System.out::println);
        //System.out.println(tree.isContains13());
    }
}