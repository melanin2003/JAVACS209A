package lab02;

import java.util.*;

public class lab02 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1L, "John");
        Employee e2 = new Employee(1L, "John");
        Employee e3 = new Employee(2L, "Mary");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        Map<Employee, Integer> map = new HashMap<>();
        Integer count;
        for (Employee e : employeeList) {
            if ((count = map.get(e)) == null) {
                map.put(e, 1);
            } else {
                map.put(e, 1 + count);
            }
        }
        System.out.println(map);
        e3.setId(3L);
        map.put(new Employee(3L, "Mary"), 3);
        System.out.println(map);
    }
}
//Q1:
//{lab02.Employee@52cc8049=1, lab02.Employee@12edcd21=1, lab02.Employee@34c45dca=1}
//没写hashcode():地址相关的hashcode
//Q2:
//{lab02.Employee@23514a=1, lab02.Employee@23514a=1, lab02.Employee@247b39=1}
//写了hashcode()，没写equals()，key相同但是 不相等,添加新节点
//Q3:
//{lab02.Employee@27d6c5e0=1, lab02.Employee@7ef20235=1, lab02.Employee@16b98e56=1}
//key不相同
//Q4:
//{lab02.Employee@23514a=2, lab02.Employee@247b39=1}
//hashcode相同和并且equals判断相同