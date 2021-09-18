package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class TestStreamAPI3 {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(100, "张三", 25, 2563.23));
        list.add(new Employee(200, "Tom", 26, 2000.23));
        list.add(new Employee(400, "王五", 26, 10000.23));
        list.add(new Employee(400, "赵柳", 12, 12033.23));
        list.add(new Employee(500, "马奇", 45, 8555.23));
        list.add(new Employee(600, "张三图", 45, 5620.23));

        // 只要有一个满足条件即可
        boolean flag = list.stream().anyMatch(x -> {
            return x.getName().contains("张");
        });
        System.out.println(flag);
        System.out.println("--------------------------------");

        // 必须所有的满足
        boolean flag2 = list.stream().allMatch(x -> {
            return x.getAge() > 200;
        });
        System.out.println(flag2);
        System.out.println("--------------------------------");

        // 计算总数
        long count = list.stream().count();
        System.out.println(count);
        System.out.println("--------------------------------");

        // 不能有null值
        // 不能有key重复
        // Map<Integer, String> map = list.stream()
        // .collect(Collectors.toMap(Employee::getId, Employee::getName));
        // System.out.println(JSON.toJSONString(map));

        Map<Integer, String> map =
            list.stream().collect(HashMap::new, (m, v) -> m.put(v.getId(), v.getName()), HashMap::putAll);
        System.out.println(JSON.toJSONString(map));

        Map<Integer, String> map2 = list.stream()
            .collect(Collectors.toMap(Employee::getId, Employee::getName, (old, news) -> news, HashMap::new));
        System.out.println(JSON.toJSONString(map2));
        System.out.println("--------------------------------");

        // 映射
        list.stream().map((emp) -> emp.getName() + "---").forEach(System.out::println);
        list.stream().map(emp -> emp.getName()).forEach(System.out::println);
        System.out.println("--------------------------------");
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        strList.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

        // 归约
        System.out.println("--------------------------------");
        Optional<Double> op = list.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());
        System.out.println("--------------------------------");

        // 收集
        HashSet<String> hashMap = list.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println(JSON.toJSONString(hashMap));

        Double salary = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(salary);

        Optional<Employee> max =
            list.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println(max.get());
        System.out.println("--------------------------------");

        // 分组
        Map<Integer, List<Employee>> groupEmp = list.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(JSON.toJSON(groupEmp));

        // 多级分组
        Map<Integer, Map<String, List<Employee>>> groupEmp2 =
            list.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy((x) -> {
                if (x.getSalary() < 3000) {
                    return "码农";
                } else if (x.getSalary() > 3000 && x.getSalary() < 10000) {
                    return "SWE";
                } else {
                    return "SE";
                }
            })));
        System.out.println(JSON.toJSON(groupEmp2));
        System.out.println("--------------------------------");

        // 分区
        Map<Boolean, List<Employee>> empBoolean =
            list.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.out.println(JSON.toJSONString(empBoolean));

        // 收集
        DoubleSummaryStatistics dss = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());

        System.out.println("--------------------------------");
        String str = list.stream().map(Employee::getName).collect(Collectors.joining(",", "=", "==="));
        System.out.println(str);
    }

}
