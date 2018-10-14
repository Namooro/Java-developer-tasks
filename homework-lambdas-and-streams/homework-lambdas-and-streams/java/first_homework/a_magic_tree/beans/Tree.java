package first_homework.a_magic_tree.beans;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Tree {

    private int value;

    private List<Tree> children = new LinkedList<>();

    public Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public Tree(int value, Tree... children) {
        this(value, asList(children));
    }

    private int getValue() {
        return value;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public List<Integer> getAllValues() {
        return this.flattened()
                .map(Tree::getValue)
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenValues() {
        return this.flattened()
                .map(Tree::getValue)
                .filter(this::isEven)
                .collect(Collectors.toList());
    }

    private Stream<Tree> flattened() {
        return Stream.concat(
                Stream.of(this), children.stream()
                        .flatMap(Tree::flattened));
    }

    public Boolean isContains13() {
        return flattened()
                .anyMatch(n -> n.getValue() == 13);
    }

    public Optional<Integer> sumOfEvenValues() {
        return flattened()
                .map(Tree::getValue)
                .reduce(Integer::sum);
    }

    private boolean isEven(Integer i) {
        return i % 2 == 0;
    }

    @Override
    public String toString() {
        return value + " ";
    }
}