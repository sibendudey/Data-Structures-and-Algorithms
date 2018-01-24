package hash.tables.leetcode;

import java.util.*;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class Boomerangs {
    public static void main(String args[])  {

    }
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {

        employees.stream().forEach( e -> employeeMap.put(e.id , e));

        return sum(employeeMap.get(id));

    }

    private int sum(Employee employee) {
        int total = employee.importance;
        for ( int i : employee.subordinates)    {
            total += sum(employeeMap.get(i));
        }

        return total;
    }
}
