package finexam;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 Name of programmer :
 Purpose of programming :
 */
public class Main {
    /* Put the code for the main method here */
    /* ... Put necessary codes here (e.g. method header for the run method)...*/
    public static void main(String[] args) {
        Main execute = new Main();
        execute.run();
    }
    public void run(){
        List<Employee> employees = doRequirement1("res/data.csv");
        for(Employee employee: employees)
            System.out.println(employee);
//        doRequirement2(employees);
    }
    /**
     * Converts employee data file into an array
     * @param fileName
     * @return
     */
    public List<Employee> doRequirement1(String fileName){
        List<Employee> employeeList = new ArrayList<>();
        String line = "";
        try {
            BufferedReader scan = new BufferedReader(new FileReader(fileName));
            while((line = scan.readLine()) != null){
                String[] temp = line.split(",");
                String id = temp[0];
                String name = temp[1];
                String dep = temp[4];
                char gender = temp[2].charAt(0);
                int age = Integer.parseInt(temp[3]);
                boolean employment;
                if (temp[7].compareToIgnoreCase("permanent") == 0){
                    employment = true;
                } else { employment = false; }
                double salary = Double.parseDouble(temp[6]);
                int duration = Integer.parseInt(temp[5]);
                Employee employee = new Employee(id, name, dep, gender, age, employment,salary, duration);
                employeeList.add(employee);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    return employeeList;
    }

//    /**
//     * Creates a file with a list of permanent male and female employees and their average salaries
//     * @param employeeList
//     */
//    public void doRequirement2(List<Employee> employeeList){
//        double maleTotal = 0, femaleTotal = 0;
//        int maleCounter = 0, femaleCounter = 0;
//
//        try {
//            PrintWriter outputWriter = new PrintWriter(new FileWriter("res/req2.txt"));
//            for (Employee e: employeeList){
//                if(e.getGender() == 'M' && e.isPermanent()){
//                    maleTotal += e.getSalary();
//                    outputWriter.println(e);
//                    maleCounter++;
//                }
//            }
//
//            outputWriter.println("\nThe average salary for a permanent male employee is : " + maleTotal/maleCounter);
//            outputWriter.println("");
//
//            for (Employee e: employeeList){
//                if(e.getGender() == 'F' && e.isPermanent()){
//                    femaleTotal += e.getSalary();
//                    outputWriter.println(e);
//                    femaleCounter++;
//                }
//            }
//            outputWriter.println("\nThe average salary for a permanent female employee is : " + maleTotal/maleCounter);
//            outputWriter.close();
//        } catch (Exception exception){
//            exception.printStackTrace();
//        }
//    }
//
//    public void dorequirement3(){
//
//    }


}
