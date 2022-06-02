public class part3{
    public static void swap(Integer[] array, int i1, int i2){
        int hold = array[i1];
        array[i1] = array[i2];
        array[i2] = hold;
    }

    public static int partition(Integer[] array, int low, int high) {
        int index = high - 1;
        int num = array[index];
        int smallerBefore = low;
        int largerAfter = high - 2;
        while (smallerBefore < largerAfter) {
            if (array[smallerBefore].compareTo(num) < 0) {
                smallerBefore += 1;
            }else {
                swap(array, smallerBefore, largerAfter);
                largerAfter -= 1;
            }
            for(int i=0; i<array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        if (array[smallerBefore].compareTo(num) < 0) {
            swap(array, smallerBefore + 1, index);
            return smallerBefore + 1;
        } else {
            swap(array, smallerBefore, index);
            return smallerBefore;
        }
    }

    public static int partition2(Integer[] nums, int low, int high){
        int cur = low;
        int pivot = nums[high];
        for(int i = low; i < high; i++){
            if(nums[i] < pivot){
                swap2(nums, cur++, i);
            }
        }
        swap2(nums, cur, high);
        return cur;
    }
    
    private static void swap2(Integer[] nums, int i, int j){
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {6, 9, 3, 8, 11, 7, 2, 4};
        System.out.println(partition2(array, 0, 7));
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }



    }
}