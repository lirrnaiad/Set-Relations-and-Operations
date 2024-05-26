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

    @Override
    public String toString() {
        StringBuilder setFormat = new StringBuilder();
        setFormat.append("{");
        setFormat.append(String.join(", ", set));
        setFormat.append("}");
        return setFormat.toString();
    }
}
