package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ShellSortTest {
    @Test
    public void testEmptyArray() {
        int[] arr1 = {};
        ShellSort.sort(arr1, null, ShellSort.GapSequence.SHELL);
        assertArrayEquals(new int[]{}, arr1);
    }

    @Test
    public void testRegularArray(){
        int[] arr2 ={2,9,0,-1};
        int[] expected={-1,0,2,9};
        ShellSort.sort(arr2, null, ShellSort.GapSequence.KNUTH);
        System.out.println(Arrays.toString(arr2));
        assertArrayEquals(expected, arr2);
    }

    @Test
    public void testSingleElementArray(){
        int[] arr3={1};
        int[] expected={1};
        ShellSort.sort(arr3,null,ShellSort.GapSequence.SEDGEWICK);
        assertArrayEquals(arr3,expected);
    }
    @Test
    public void testSortedArray(){
        int[] arr4={1,2,3,4,5};
        int[] expected=arr4.clone();
        ShellSort.sort(arr4,null,ShellSort.GapSequence.SHELL);
        assertArrayEquals(arr4,expected);
    }
    @Test
    public void testReversedArray(){
        int[] arr={5,4,3,2,1};
        int[] expected={1,2,3,4,5};
        ShellSort.sort(arr,null,ShellSort.GapSequence.KNUTH);
        assertArrayEquals(arr,expected);
    }
    @Test
    public void testDuplicateArray(){
        int[] arr={3,2,1,3,4,1};
        int[] expected={1,1,2,3,3,4};
        ShellSort.sort(arr,null,ShellSort.GapSequence.SEDGEWICK);
        assertArrayEquals(arr,expected);
    }
    //Yixes, success everywhere!
}