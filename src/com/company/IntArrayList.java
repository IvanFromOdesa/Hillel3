package com.company;

import java.util.Arrays;

public class IntArrayList implements IntList {
    private int arr[]=new int[10];
    private int size=0;

    @Override
    public void add(int element){
        if(size>=arr.length){
            int tempSize=arr.length*10;
            int[] tempArr = new int[tempSize];
            for (int i = 0; i < size; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }
        arr[size]=element;
        size++;
    }
    @Override
    public boolean add(int index, int element){
        /*new array for the temporary storage of elements
        with index starting from the indicated one
         */
        int newArr[]= new int[arr.length];
        int y=0; //iterator for transferring values from arr to newArr
        int j=0; // iterator for transferring values from newArr back to the arr

        if(size>=arr.length){
            int tempSize=arr.length*10;
            int[] tempArr = new int[tempSize];
            for (int i = 0; i < size; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }

        /*Transferring values from arr to newArr*/
        for(int i=index; i<size;i++){
            newArr[y]=arr[i];
            y++;
        }
        size++;

        /*Pasting an element with the indicated index.Transferring values from newArr back to arr*/
        for(int i=index; i<=size+1;i++){
            arr[index]=element;
            if(i!=index){
                arr[i]=newArr[j];
                j++;
            }
        }
        if(index>arr.length||index<0||index>size){
            return false;
        }
        return true;
    }

    @Override
    public void clear(){
        size=0;
    };

    @Override
    public int get(int index){
        return arr[index];
    };

    @Override
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    };

    @Override
    public boolean remove(int index){
        int newArr[]=new int[arr.length-1];
        if(0<=index||index<size){
            System.arraycopy(arr,0, newArr, 0, index);
            System.arraycopy(arr, index+1, newArr, index, size-index-1);
            size--;
            arr=newArr;
            return true;
        }
        return false;
    };

    @Override
    public boolean removeByValue(int value){
        int newArr[]=new int[arr.length-1]; //at least 1 element may be deleted
        int count=0; // to count how many elements with the same value were deleted
        boolean flag=false;
        for(int i=0; i<size; i++){
            if(arr[i]==value){
                System.arraycopy(arr,0, newArr, 0, i);
                System.arraycopy(arr, i+1, newArr, i, size-i-1);
                arr=newArr;
                count++;
                flag=true;
            }
        }
        size=size-count;
        return flag;
    };

    @Override
    public boolean set(int index, int element){
        if(0<=index||index<size){
            arr[index]=element;
            return true;
        }
        return false;
    };

    @Override
    public int size(){
        return arr.length;
    };

    @Override
    public  IntArrayList subList(int fromIndex, int toIndex){
        IntArrayList newArr=new IntArrayList();
        if(fromIndex<toIndex||0<=fromIndex||toIndex<size){
            for(int i=fromIndex;i<=toIndex-fromIndex;i++){
                newArr.add(arr[i]);
            }
            return newArr;
        }
        return null;
    };

    @Override
    public int[] toArray(){
        int[] result = new int[size];
        for(int i=0; i<size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}
