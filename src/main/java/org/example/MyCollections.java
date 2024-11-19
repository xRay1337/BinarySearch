package org.example;

import java.util.Comparator;
import java.util.List;

public class MyCollections {
    public static <T> int binarySearch(List<? extends T> list, T key) {
        return binarySearch(list, key, null);
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        int fromIndex = 0;
        int toIndex = list.size();

        while (fromIndex < toIndex) {
            int mid = (fromIndex + toIndex) / 2;
            T midVal = list.get(mid);
            int cmp = (c == null) ? ((Comparable<? super T>) midVal).compareTo(key) : c.compare(midVal, key);
            if (cmp < 0) {
                fromIndex = mid + 1;
            } else if (cmp > 0) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }
}