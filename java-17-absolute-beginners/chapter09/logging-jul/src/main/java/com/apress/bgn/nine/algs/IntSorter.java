package com.apress.bgn.nine.algs;

/**
 * Interface {@code IntSorter} is an interface that needs to be implemented
 * by classes that provide a method to sort an array of {@code int} values. <p>
 *
 * {@code int[]} was chosen as a type because this type
 * of values are always sortable. ({@link Comparable})
 *
 * @author Iuliana Cosmina
 * @since 1.0
 */
public interface IntSorter {

    /**
     * Sorts {@code arr}
     *
     * @param arr int array to be sorted
     * @param low lower limit of the interval to be sorted
     * @param high higher limit of the interval to be sorted
     */
    void sort(int[] arr, int low, int high);

    /**
     * Implement this method to provide a sorting solution that does not require pivots.
     * @deprecated As of version 0.1, because the
     *             {@link #sort(int[], int, int) ()} should be used instead.<p>
     * To be removed in version 3.0.
     * @param arr int array to be sorted
     */
    @Deprecated (since= "0.1", forRemoval = true)
    default void sort(int[] arr) {
        System.out.println("Do not use this! This is deprecated!!");
    }

}
