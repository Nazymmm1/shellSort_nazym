package algorithms;

import metrics.PerformanceTracker;

public class ShellSort {
    //Thats like options for gaps...
    public enum GapSequence{
        SHELL,
        KNUTH,
        SEDGEWICK,
    }

    //main sorting
    public static void sort(int[] arr, PerformanceTracker tracker, GapSequence sequence){
        //for empty arr
        if(arr==null){
            throw new IllegalArgumentException("Array can not be null");
        }

        if (arr.length == 0) {
            System.out.println("Damn, you’re sending me an empty array!");
            return;
        }
        int n= arr.length;
        int[] gaps= generateGaps(n, sequence);

        if(tracker != null) tracker.start();
        // For ex I have an arr of 16 el. And if my gaps={8,4,2,1} 1st gap=8
        for (int gap:gaps){
            //i=8 and less than 16
            for(int i=gap;i<n;i++){
                //range of temp and i: [8;15]
                int temp= arr[i];
                int j=i;
                //8>=8 correct here and compare arr[0] and arr[8] check if arr[0] is more or less than temp
                while (j>=gap && compare(arr[j-gap],temp,tracker)>0){
                    //if their spot aint correct then swap
                    arr[j]=arr[j-gap];
                    //its literally insertion sort but with bigger gaps
                    j-=gap;
                    if(tracker != null) tracker.incrementSwaps();
                }
                arr[j]=temp;
            }
        }
        if(tracker != null) tracker.stop();
    }

    private static int compare(int a,int b, PerformanceTracker tracker){
        if (tracker != null) tracker.incrementComparisons();
        return Integer.compare(a,b);
    }

    public static int[] generateGaps(int n, GapSequence sequence){
        switch (sequence){
            case KNUTH -> {
                return knuthGaps(n);
            }
            case SHELL -> {
                return shellGaps(n);
            }
            case SEDGEWICK -> {
                return sedgewickGaps(n);
            }
            default -> {
                return shellGaps(n);
            }
        }
    }
    //shell
    private static int[] shellGaps(int n){
        int k=(int) (Math.log(n)/Math.log(2)); // Okay whats going on here. (int) is return type.
        //(Math.log(n)/Math.log(2))- if my n was 16 for ex log(16)/log(2)=4 so k is 4.
        int[] gaps= new int[k];
        int gap=n/2; //n is length so if n is 16 gap is 8

        for(int i=0;i<k;i++){ //if n=16 then the gaps={8, 4, 2, 1}
            gaps[i]=gap;
            gap/=2;
        }
        return gaps;
    }
    //Knuth
    private static int[] knuthGaps(int n){
        int h=1;
        while (h< n/3){
            h=h*3+1; //thats just a formula
        }

        int temp=h;
        int k=0;

        while (temp>0){
            k++;
            temp=(temp-1)/3;
        }

        int[] gaps= new int[k];

        for (int i=0;i<k;i++){
            gaps[i]=h;
            h=(h-1)/3;
        }
        return gaps;
    }
    //sedgewick
    private static int[] sedgewickGaps(int n){
        int[] temp= new int[40];
        int count=0;
        int k=0;

        while (true){
            int gap;
            if (k % 2 == 0) {
                gap = 9 * ((1 << k) - (1 << (k / 2))) + 1;
            } else {
                gap = 8 * (1 << k) - 6 * (1 << ((k + 1) / 2)) + 1;
            }

            if(gap>n) break;
            temp[count++]=gap;
            k++;
        }
        int[] gaps = new int[count];
        for (int i = 0; i < count; i++) {
            gaps[i] = temp[count - i - 1];
        }
        return gaps;

    }
}