package com.example.paralleldataprocessingandparallelstreams.parallel_stream;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {

        long start, end, parallelStart, parallelEnd = 0 ;
//        start = System.currentTimeMillis();
//        IntStream.range(1,100).forEach(System.out::println);
//        end = System.currentTimeMillis();
//        System.out.println("Plain stream took time: "+(end-start));
//        System.out.println("================");
//        parallelStart = System.currentTimeMillis();
//        IntStream.range(1,100).parallel().forEach(System.out::println);
//        parallelEnd = System.currentTimeMillis();
//        System.out.println("Parallel stream took time: "+(parallelEnd-parallelStart));
//
//        IntStream.range(1,10).forEach(x->
//                {
//                        System.out.println("Thread: "+Thread.currentThread().getName()+" : "+x);
//                }
//        );
//        IntStream.range(1,10).parallel().forEach(x->
//                {
//                    System.out.println("Thread: "+Thread.currentThread().getName()+" : "+x);
//                }
//        );

        List<Employee> employeeList = EmployeeDataBase.getEmployees();
        start = System.currentTimeMillis();
        double salaryWithStream = employeeList.stream().map(employee -> employee.getSalary()).mapToDouble(i->i).average().getAsDouble();
        end = System.currentTimeMillis();

        System.out.println("Normal stream execution time : "+(end-start)+" Avg Salary: "+salaryWithStream);

        start = System.currentTimeMillis();
        double salaryWithParallelStream = employeeList.parallelStream().map(employee -> employee.getSalary()).mapToDouble(i->i).average().getAsDouble();
        end = System.currentTimeMillis();

        System.out.println("Parallel stream execution time : "+(end-start)+" Avg Salary: "+salaryWithStream);
    }
}
