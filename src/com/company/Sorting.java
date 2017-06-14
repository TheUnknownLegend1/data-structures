package com.company;

import java.util.Arrays;

public class Sorting {
    public static void print(int[] x) {
        for (int i : x)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void StraightInsertion(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int h = x[i], j = i;
            while (j > 0 && x[j - 1] > h) {
                x[j--] = x[j];
            }
            x[j] = h;
        }
    }

    public static void ShellInsertion(int[] x) {
        for (int pow = x.length / 2; pow > 0; pow /= 2) {
            for (int i = pow; i < x.length; i++) {
                int h = x[i], j = i;
                while (j >= pow && x[j - pow] > h) {
                    x[j] = x[j - pow];
                    j -= pow;
                }
                x[j] = h;
            }
        }
    }

    public static void StraightSelection(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < x.length; j++)
                minIndex = x[minIndex] < x[j] ? minIndex : j;
            int temp = x[minIndex];
            x[minIndex] = x[i];
            x[i] = temp;
        }
    }

    public static void HeapSort(int[] x) {

        for (int i = x.length / 2 - 1; i >= 0; i--)
            settle(x, i, x.length);

        for (int i = x.length - 1; i > 0; i--) {
            int t = x[i];
            x[i] = x[0];
            x[0] = t;
            settle(x, 0, i);
        }
    }

    private static void settle(int[] x, int i, int n) {
        int tosettle = x[i];
        for (i = 2 * i + 1; i < n; i = 2 * i + 1) {
            if (i + 1 < n && x[i] < x[i + 1])
                i++;
            if (x[i] > tosettle)
                x[(i - 1) / 2] = x[i];
            else
                break;
        }
        x[(i - 1) / 2] = tosettle;
    }

    public static void radixSort(int[] arr) {
        int m = arr[0];
        for(int i = 1; i < arr.length; i++){
            m = m > arr[i] ? m : arr[i];
        }
        for (int exp = 1; m/exp > 0; exp *= 10) {
            int output[] = new int[arr.length];
            int buckets[] = new int[10];
            for (int i = 0; i < arr.length; i++)
                buckets[(arr[i] / exp) % 10]++;
            for (int i = 1; i < 10; i++)
                buckets[i] += buckets[i - 1];
            for (int i = arr.length - 1; i > -1; i--) {
                output[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }
            for (int i = 0; i < arr.length; i++)
                arr[i] = output[i];
        }
    }

    public static void bubbleSort(int[] x){
        for(int i = 0; i < x.length - 1; i++){
            boolean sorted = true;
            for(int j = 0; j < x.length - i - 1; j++){
                if(x[j] > x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                    sorted = false;
                }
            }
            if(sorted)
                break;
        }
    }

    public static void quickSort(int[] x){
        quickSort(x,0,x.length-1);
    }
    private static void quickSort(int[] x, int start, int end){
        int pivot = x[start];
        int left = start;
        int right = end;
        while(left <= right){
            while(x[left] < pivot)
                left++;
            while (x[right] > pivot)
                right--;
            if(left <= right){
                int temp = x[left];
                x[left] = x[right];
                x[right] = temp;
                left++;
                right--;
            }
        }
        
    }
}