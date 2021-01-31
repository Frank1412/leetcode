package com.bonc.data_structure;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-01-31 21:36
 */
public class MaxHeap {
    private int capacity;
    private int size;
    private int[] array;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int getLeftChildIndex(int curIndex) {
        return curIndex * 2 + 1;
    }

    public int getRightChildIndex(int curIndex) {
        return curIndex * 2 + 2;
    }

    public int getParentIndex(int curIndex) {
        return (curIndex - 1) / 2;
    }

    public Boolean hasParent(int curIndex) {
        return getParentIndex(curIndex) < 0;
    }

    public Boolean hasLeftChild(int curIndex) {
        return getLeftChildIndex(curIndex) < this.size;
    }

    public Boolean hasRightChild(int curIndex) {
        return getRightChildIndex(curIndex) < this.size;
    }

    public int leftChild(int curIndex) {
        return this.array[getLeftChildIndex(curIndex)];
    }

    public int rightChild(int curIndex) {
        return this.array[getRightChildIndex(curIndex)];
    }

    public int parent(int curIndex) {
        return this.array[getParentIndex(curIndex)];
    }

    public void insert(int value){
        if (this.size==this.capacity){
            capacity = capacity*2;
            this.array = Arrays.copyOf(array, capacity);
        }
        this.array[size] = value;
        size++;
        heapUp();
    }

    public void heapUp(){
        int curIndex = size-1;
        while (hasParent(curIndex)){
            if (parent(curIndex) >= this.array[curIndex]){
                break;
            } else{
                int tmp = this.array[curIndex];
                this.array[curIndex] = parent(curIndex);
                this.array[getParentIndex(curIndex)] = tmp;
                curIndex = getParentIndex(curIndex);
            }
        }
    }

    public void poll(){
        if (this.size==0) {
            throw new NoSuchElementException();
        }else{
            this.array[0] = this.array[size-1];
            size--;
            heapDown();
        }
    }

    public void heapDown(){
        int curIndex = 0;
        while (hasLeftChild(curIndex)){
            if (hasRightChild(curIndex)){
                if (Math.max(leftChild(curIndex), rightChild(curIndex)) >= array[curIndex]){
                    break;
                }else{
                    int tmp = this.array[curIndex];
                    if (leftChild(curIndex) > rightChild(curIndex)){
                        this.array[curIndex] = leftChild(curIndex);
                        this.array[getLeftChildIndex(curIndex)] = tmp;
                        curIndex = getLeftChildIndex(curIndex);
                    } else {
                        this.array[curIndex] = rightChild(curIndex);
                        this.array[getRightChildIndex(curIndex)] = tmp;
                        curIndex = getRightChildIndex(curIndex);
                    }
                }
            }
        }
    }

    public int peek(){
        if (size==0){
            throw new NoSuchElementException();
        }
        return array[0];
    }

}
