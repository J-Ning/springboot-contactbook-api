package org.example.service;

import java.util.List;

public class Swapsort {

    /*
    This is a function that sorts list through swapping
    */
    static public List<Integer> swap(List<Integer> input) {
        int min = input.get(0);
        int mark = 0;

        for (int i = 0; i < input.size() - 1; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Actions.StartDebugger"/>
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            min = input.get(i);
            mark = i;
            for (int y = i; y < input.size(); y++) {

                if (input.get(y) < min) {
                    min = input.get(y);
                    mark = y;
                }
            }
            int temp = input.get(i);
            input.set(i, min);
            input.set(mark, temp);
        }
        return input;
    }
}
