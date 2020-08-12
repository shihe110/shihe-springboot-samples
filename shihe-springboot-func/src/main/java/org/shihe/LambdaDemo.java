package org.shihe;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.shihe.function.TriFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.zip.GZIPOutputStream;

/**
 * @ClassName LambdaDemo
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 13:52
 * @Version 1.0
 */
public class LambdaDemo {

    Comparator<Person> byWeightComparator = new Comparator<Person>() {
        public int compare(Person p1, Person p2) {
            return p1.getWeight().compareTo(p2.getWeight());
        }
    };
    Comparator<Person> byWeightComparatorUsingLambda =
            (Person person1, Person person2) -> person1.getWeight().compareTo(person2.getWeight());

    List<Person> people = Arrays.asList(new Person("zhangsan",Gender.MALE,10),
            new Person("lisi",Gender.MALE,20),
            new Person("wangwu",Gender.FEMALE,20));

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("zhangsan",Gender.MALE,10),
                new Person("lisi",Gender.MALE,20),
                new Person("wangwu",Gender.FEMALE,20));
        people.sort((p1,p2)->p1.getWeight().compareTo(p2.getWeight()));

        people.forEach(person -> System.out.println(person.getName()+", "+person.getGender()+","+person.getWeight()));

        Predicate<String> emptyPredicate = s -> s.isEmpty();
        boolean zhangsan = emptyPredicate.test("lis");
        System.out.println(zhangsan);

        Predicate<String> negate = emptyPredicate.negate();
        boolean zhansa = negate.test("zhansa");
        System.out.println(zhansa);

        Predicate<Integer> greaterThan0 = i -> i>0;
        Predicate<Integer> lessThan100 = i -> 1 < 100;
        Predicate<Integer> between0And100 = greaterThan0.and(lessThan100);

        boolean test = between0And100.test(10);
        System.out.println(test);

        Predicate<Integer> negate1 = between0And100.negate();
        boolean test1 = negate1.test(12);
        System.out.println(test1);

        Predicate<Integer> greaterThan0OrLessThan100 = greaterThan0.or(lessThan100);

        boolean test2 = greaterThan0OrLessThan100.test(23);
        System.out.println(test2);
        Predicate<Integer> negate2 = greaterThan0OrLessThan100.negate();
        boolean test3 = negate2.test(12);
        System.out.println(test3);

        // BiPredicate
        BiPredicate<String,Integer> isLongThanGivenLength = (str,len)->str.length()>len;
        System.out.println(isLongThanGivenLength.test("zhangsan",10));

        // Function
        Function<String,Integer> lengthFunction = (str)-> str.length();
        Integer zhangsan1 = lengthFunction.apply("zhangsan");
        System.out.println(zhangsan1);

        // Function andThen
        Function<Integer,Integer> plusFunction = x -> x + x;
        Function<Integer,Integer> multipleFunction = x -> x * x;

        Function<Integer, Integer> andThenFunction = plusFunction.andThen(multipleFunction);
        Integer apply = andThenFunction.apply(2);
        System.out.println(apply);

        // Function compose
        Function<Integer, Integer> compose = plusFunction.compose(multipleFunction);
        Integer apply1 = compose.apply(2);
        System.out.println(apply1);

        // BiFunction
        BiFunction<String,String,Integer> totallength = (str1,str2) -> str1.length()+str2.length();
        Integer apply2 = totallength.apply("zs", "lisi");
        System.out.println(apply2);

        // Consumer
        Consumer<String> helloConsumer = str -> System.out.println("hello "+str);
        helloConsumer.accept("zhangsan");

        IntConsumer plus = x -> System.out.println(x+x);
        plus.accept(5);

        // Supplier
        Supplier<Long> systemTime = () -> System.currentTimeMillis();
        System.out.println(systemTime.get());

        // Comparator
        Comparator<Person> byWeightComparatorUsingLambda =
                (person1, person2) -> person1.getWeight().compareTo(person2.getWeight());
        int compare = byWeightComparatorUsingLambda.compare(new Person("san", Gender.FEMALE, 100), new Person("lisi", Gender.MALE, 50));
        System.out.println(compare);

        Comparator<Person> comparing = Comparator.comparing(Person::getWeight);
        int compare1 = comparing.compare(new Person("san", Gender.FEMALE, 100), new Person("lisi", Gender.MALE, 50));
        System.out.println(compare1);

        // custom
        TriFunction<String,String,String,Integer> len = (str1,str2,str3) -> str1.length()+str2.length()+str3.length();

        Integer apply3 = len.apply("zs", "ls", "ww");
        System.out.println(apply3);


    }
}
