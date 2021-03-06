package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.time.LocalTime;

public class Tachograph {
    private Long key = 0L;
    private Table<Long, Integer, Integer> table = TreeBasedTable.create();

    void add(Integer joystickPosition, Integer referenceSpeed) {
        LocalTime currentTime = LocalTime.now();
        table.put(key, 0, currentTime.toSecondOfDay());
        table.put(key, 1, joystickPosition);
        table.put(key, 2, referenceSpeed);
        key++;
    }

    Boolean isEmpty(){
        return table.isEmpty();
    }
}
