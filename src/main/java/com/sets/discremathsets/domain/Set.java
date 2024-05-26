package com.sets.discremathsets.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Set {
    private HashSet<String> set;

    public Set(HashSet<String> set) {
        this.set = new HashSet<>(set);
    }

    // Utility methods
    private HashSet<String> getSet() {
        return this.set;
    }

    public void add(String element) {
        this.set.add(element);
    }

    public boolean contains(String element) {
        return this.set.contains(element);
    }
    public int size() {
        return set.size();
    }

    //
    // SET OPERATIONS
    //

    public HashSet<String> union(Set setTwo) {
        HashSet<String> setUnion = new HashSet<>(this.set);
        setUnion.addAll(setTwo.getSet());
        return setUnion;
    }

    public HashSet<String> intersection(Set setTwo) {
        HashSet<String> setIntersection = new HashSet<>(this.set);
        setIntersection.retainAll(setTwo.getSet());
        return setIntersection;
    }

    public HashSet<String> difference(Set setTwo) {
        HashSet<String> setDifference = new HashSet<>(this.set);
        setDifference.removeAll(setTwo.getSet());
        return setDifference;
    }

    // Overloaded method to be used for complement() method
    public HashSet<String> difference(HashSet<String> setTwo) {
        HashSet<String> setDifference = new HashSet<>(this.set);
        setDifference.removeAll(setTwo);
        return setDifference;
    }

    public HashSet<String> complement(Set universalSet) {
        return universalSet.difference(this.set);
    }

    //
    // SET RELATIONS
    //

    public boolean isEqualTo(Set secondSet) {
        return this.set.equals(secondSet.getSet());
    }

    public boolean isEquivalentTo(Set secondSet) {
        return this.set.size() == secondSet.getSet().size();
    }

    public boolean isSubsetOf(Set secondSet) {
        if (this.set.size() > secondSet.getSet().size()) {
            return false;
        }

        return secondSet.getSet().containsAll(this.set);
    }

    public boolean isDisjoint(Set secondSet) {
        return intersection(secondSet).isEmpty();
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    // TODO Power Set of a given set
    public HashSet<HashSet<String>> powerSet() {
        return generateSubsets(new ArrayList<>(this.set), 0);
    }

    private HashSet<HashSet<String>> generateSubsets(List<String> elements, int index) {
        HashSet<HashSet<String>> allSubsets;

        // Base Case
        if (index == elements.size()) {
            allSubsets = new HashSet<>();
            allSubsets.add(new HashSet<>()); // add empty set
        } else {
            allSubsets = generateSubsets(elements, index + 1); // Recursive Case
            String element = elements.get(index);
            HashSet<HashSet<String>> moreSubsets = new HashSet<>();

            for (HashSet<String> subset : allSubsets) {
                HashSet<String> newSubset = new HashSet<>(subset);
                newSubset.add(element);
                moreSubsets.add(newSubset);
            }

            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    @Override
    public String toString() {
        StringBuilder setFormat = new StringBuilder();
        setFormat.append("{");
        setFormat.append(String.join(", ", set));
        setFormat.append("}");
        return setFormat.toString();
    }
}
