package org.example.service;

import org.springframework.stereotype.Service;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Service
public class SortService {
    public List<Integer> SortService(List<Integer> input) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println();
        System.out.println("testing inside sort service file");
        System.out.println();
//        int[] input = {5,4,2,-6,-4,0};

        List<Integer> output = Swapsort.swap(input);

//        System.out.print("Sorted Output: [");
//        for (int i = 0; i < output.length; i++){
//            System.out.print(output[i]);
//            if(i != output.length-1){
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");
//        System.out.println();
        return output;
    }
}
