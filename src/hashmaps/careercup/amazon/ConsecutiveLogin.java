package hashmaps.careercup.amazon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Sibendu Dey on 4/25/2017.
 * This is a solution to the problem
 * https://www.careercup.com/question?id=5140007057620992
 */

class Employee  {
    String id;
    Date lastLogin;
    int consecutiveDays;

    static final int SECONDS_IN_DAY = 24*60*60*1000;

    public Employee(String id, Date date) {
        this.id = id;
        lastLogin = date;
    }

    public void incrementConsecutiveDays(Date date)  {
        if ( consecutiveDays == 3)
            return;

        if ( (date.getTime() - lastLogin.getTime()) <= SECONDS_IN_DAY)  {
            consecutiveDays++;
        }
        else    {
            consecutiveDays = 1;
        }
        lastLogin = date;
    }

    public boolean isConsecutive()  {
        return consecutiveDays == 3 ? true : false;
    }

}
public class ConsecutiveLogin {

    public static void main( String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();
        HashMap<String , Employee> list = new HashMap<>();
        for ( int i = 0 ; i < input ; i++)  {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String line = sc.nextLine();
                System.out.println(line);
                String values[] = line.split("/t");
                String dateValue = values[0];

                Date date = sdf.parse(dateValue);

                String employeeID = values[1];

                Employee employee = null;
                if ( list.containsKey(employeeID))  {
                    employee = list.get(employeeID);
                    employee.incrementConsecutiveDays(date);
                }
                else    {
                    employee = new Employee(employeeID, date);
                    list.put(employeeID , employee);
                    employee.incrementConsecutiveDays(date);
                }

          } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        findEmployeeWithConsecutiveLogin(list);
    }

    private static void findEmployeeWithConsecutiveLogin(HashMap<String, Employee> list) {

        for (Map.Entry<String , Employee > entry : list.entrySet())   {
            Employee employee  = entry.getValue();
            if ( employee.isConsecutive())  {
                System.out.println( entry.getKey());
            }
        }

    }
}
