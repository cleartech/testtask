package db;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumbersDataHolder {

    private HashMap<Integer, ArrayList<String>> numbersData = new HashMap<>();

    public PhoneNumbersDataHolder() {
    }

    public void addNumber(int employeeId, ArrayList<String> number) {
        numbersData.put(employeeId, number);
    }

    public HashMap<Integer, ArrayList<String>> getNumbersData() {
        return numbersData;
    }
}
