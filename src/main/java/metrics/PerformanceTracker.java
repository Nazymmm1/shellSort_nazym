package metrics;

public class PerformanceTracker {
    //I have used here long bcs int might be overloaded
    private long comparisons;
    private long swaps;
    private long startTime;
    private long endTime;

    public void start(){
        //when I have a method start its going to fix the time
        startTime=System.nanoTime();
    }

    public void stop(){
        endTime=System.nanoTime();
    }

    public void incrementComparisons(){
        comparisons++;
    }
    public void incrementSwaps(){
        swaps++;
    }
    public double getElapsedTime(){
        return (endTime-startTime)/1_000_000.0;
    }
    public long getComparisons() {
        return comparisons;
    }
    public long getSwaps() {
        return swaps;
    }
    public void reset(){
        comparisons=swaps=0;
        endTime=startTime=0;
    }


}