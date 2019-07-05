/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicArray;

/**
 *
 * @author Ryan
 */
public class DArray<E> {
    private E[] data; 
    private int size; 
    
    public DArray(int n) {
        data = (E[])(new Object[n]);
        size = 0;
    }
    
    public void print() {
        if (size == 0)
            return;
        
        for (int n = 0; n < size - 1; n++) {
            System.out.print(data[n] + ",");
        }
        
        System.out.println(data[size - 1]);
    }
    
    public void increaseCapacity(int n) {
        E[] temp = (E[])(new Object[data.length + n]);
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        
        data = temp; 
    }
    
    public int size() {
        return size; // return the size of the array
    }
    
    public void add(E item) {
        add(item, size);
    }
    
    public void add(E item, int index) {
        if (size >= data.length) {
            // increase the capacity of the array by doubling it
            increaseCapacity(data.length);
        }
        
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        
        data[index] = item;
        size++;
    }
    
    public void remove(int index) {
        // remove an index from the array
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        
        size--; // decrement size
    }
    
    public int linearfind(E item) {
        Comparable comp = (Comparable) item;
        
        for (int i = 0; i < data.length; i++) {
            // iterate through the array linearly 
            if (comp.compareTo(data[i]) == 0) {
                // found
                return i;
            }
        }
        
        // not found 
        return -1;
    }
    
    public int bfind(int first, int last, E item) {
        Comparable comp = (Comparable) item;
        
        int mid = (first + last) / 2; // get mid
        while (first <= last) {
            Comparable midComp = (Comparable)data[mid];
            if (midComp.compareTo(comp) == 0) {
                // element is in the middle 
                return mid; 
            } 
            
            // element is smaller and needs the LEFT subarray
            else if (midComp.compareTo(comp) > 0) {
                last = mid - 1;
            }
            
            // else element needs RIGHT subarray
            else {
                first = mid + 1;
            }
        }
        
        return -1; // not found
    }
    
    public int binearysearch(E item) {
        return bfind(0, size, item);
    }
    
    public E get(int n) {
        return data[n];
    }
}
