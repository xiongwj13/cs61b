public class ArrayDeque<T> {
    private float usage;
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] Array;
    private static int RFACTOR = 2;

    public ArrayDeque(){
        Array = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(T p:Array){
            System.out.print(p+" ");
        }
    }

    public T get(int index){
        if(index > Array.length-1){
            return null;
        }else{
            return Array[(nextFirst + index + 1)%Array.length];
        }
    }

    private boolean checkUsage(){
        return (usage < 0.25) && (Array.length > 16);
    }

    public void resize(){
        if(checkUsage()){
            int target_size = Array.length/2;
            T[] new_array = (T[]) new Object[target_size];
            int start_index = 0;
            int end_index = 0;
            for(int i = 0;i<Array.length;i++){
                if(Array[i] == null && Array[i+1] != null){
                    start_index = i+1;
                }else if(Array[i] != null && Array[i+1] == null){
                    end_index = i;
                }
            }
            if(end_index > start_index){
                System.arraycopy(Array,start_index,new_array,1,end_index - start_index + 1);
            }else{
                System.arraycopy(Array,start_index,new_array,1,Array.length-start_index+end_index+1);
            }
            Array = new_array;
            nextFirst = 0;
            nextLast = size + 1;
        }
        if(size == Array.length){
            int target_size = Array.length*2;
            int start_index;
            if(nextFirst == Array.length-1){
                start_index = 0;
            }else{
                start_index = nextFirst + 1;
            }
            T[] new_array = (T[]) new Object[target_size];
            System.arraycopy(Array,start_index,new_array,1,size);
            Array = new_array;
            nextFirst = 0;
            nextLast = size + 1;
        }
    }

    public void addFirst(T some){
        if(size == Array.length){
            resize();
        }
        Array[nextFirst] = some;
        size += 1;
        if(nextFirst == 0){
            nextFirst = Array.length - 1;
        }else{
            nextFirst -= 1;
        }
    }

    public void addLast(T some){
        if(size == Array.length){
            resize();
        }
        Array[nextLast] = some;
        size += 1;
        if(nextLast == Array.length-1){
            nextLast = 0;
        }else{
            nextLast += 1;
        }
    }

    public T removeFirst(){
        T returnValue;
        if(nextFirst == Array.length - 1){
            nextFirst = 0;
            returnValue = Array[nextFirst];
            Array[nextFirst] = null;
        }else{
            nextFirst += 1;
            returnValue = Array[nextFirst];
            Array[nextFirst] = null;
        }
        resize();
        return returnValue;
    }

    public T removeLast(){
        T returnValue;
        if(nextLast == 0){
            nextLast = Array.length - 1;
            returnValue = Array[nextLast];
            Array[nextLast] = null;
        }else{
            nextLast -= 1;
            returnValue = Array[nextLast];
            Array[nextLast] = null;
        }
        resize();
        return returnValue;
    }

}
