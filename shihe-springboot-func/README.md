## 函数式接口

java8定义的五种类型函数式接口

```js
Predicate：有输入，输出布尔值的函数；
Function：有输入有输出的函数；
Consumer：有输入无输出的函数；
Supplier：无输入有输出的函数；
Operator：输入输出为相同类型的函数；
```

### Predicate接口

- 调用test()方法返回Boolean值。

- Predicate组合：negate（取反）、and（取并）、和or（取或）方法，可以重用已有的Predicate并组成复杂的Predicate。

- 对于基本数据类型，java8提供了IntPredicate、DoublePredicate等。

### Function接口

- 调用apply()方法，接收任意类型参数T，返回类型R
```js
Function<String,Integer> lengthFunction = str -> str.length();
```

- 组合Function：andThen、compose
```
// Function andThen 第一个函数的输出作为第二个函数的输入
Function<Integer,Integer> plusFunction = x -> x + x;
Function<Integer,Integer> multipleFunction = x -> x * x;

Function<Integer, Integer> andThenFunction = plusFunction.andThen(multipleFunction);
Integer apply = andThenFunction.apply(2);
System.out.println(apply);

// Function compose 第二个函数的输出作为第一个函数的输入
Function<Integer, Integer> compose = plusFunction.compose(multipleFunction);
Integer apply1 = compose.apply(2);
System.out.println(apply1);
```
- 基本数据类型Function-分三类

一、入参固化为函数接口，只定义返回值类型R
> IntFunction、LongFunction、DoubleFunction
>IntFunction<Integer> intPlusFunction = x -> x + x ;

二、返回值固化为函数接口，只定义入参T的类型
>ToIntFunction、ToLongFunction、ToDoubleFunction
>
>ToIntFunction<String> toIntFunction = str -> str.length();
 System.out.println(toIntFunction.applyAsInt("www"));

三、入参和返回值都固化
```js
IntToLongFunction：入参为int，返回值为long。
IntToLongFunction intToLongFunction = i -> i;
System.out.println(intToLongFunction.applyAsLong(1));

IntToDoubleFunction：入参为int，返回值为double。
LongToIntFunction：入参为long，返回值为int。
LongToDoubleFunction：入参为long，返回值为double。
DoubleToIntFunction：入参为double，返回值为int。
DoubleToLongFunction：入参为double，返回值为long。
```
- 两个入参的Function BiFunction
```js
    // BiFunction
        BiFunction<String,String,Integer> totallength = (str1,str2) -> str1.length()+str2.length();
        Integer apply2 = totallength.apply("zs", "lisi");
        System.out.println(apply2);
```
基本数据类型BiFunction
```js
ToIntBiFunction：返回值为int型。
ToLongBiFunction：返回值为long型。
ToDoubleBiFunction：返回值为double型。
```

### Consumer-消费者接口
- 调用accept(),接收任意类型参数，无返回值
```js
// Consumer
Consumer<String> helloConsumer = str -> System.out.println("hello "+str);
helloConsumer.accept("zhangsan");
```
- 基本数据类型
```js
IntConsumer：入参为int。
LongConsumer：入参为long。
DoubleConsumer：入参为double。
```
- BiConsumer
```js
ObjIntConsumer：第一个入参为任意类型T，第二个入参为int。
ObjLongConsumer第一个入参为任意类型T，第二个入参为long。
ObjDoubleConsumer：第一个入参为任意类型T，第二个入参为double。
```

### Supplier-提供者

- 调用get()不接受参数，返回值T
```js
// Supplier
Supplier<Long> systemTime = () -> System.currentTimeMillis();
System.out.println(systemTime.get());

```
- 基本数据类型接口-返回类型
```js
IntSupplier：返回值是int型。
LongSupplier：返回值是long型。
DoubleSupplier：返回值是double型。
BooleanSupplier：返回值是boolean型。
```
### Operator-操作者
Operator其实是一种特殊的Function,它的输入和返回值都是同一种类型。

 - UnaryOperator
UnaryOperator继承了Function接口，如定义：
```js
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T>
```
UnaryOperator接受一个入参T，返回值也是类型T。

- 基本数据类型的函数接口：
```js
IntUnaryOperator：入参返回值都为int型。
LongUnaryOperator：入参返回值都为long型。
DoubleUnaryOperator：入参返回值都为double型。
```

- BinaryOperator
BinaryOperator继承了Function接口，如定义：
```js
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T>
```
BinaryOperator接受的两个入参类型都为T，返回值类型也是T。

- 基本数据类型的函数接口：
```js
IntBinaryOperator：两个入参和一个返回值都是int型。
LongBinaryOperator：两个入参和一个返回值都是long型。
DoubleBinaryOperator：两个入参和一个返回值都是double型。
```
### Comparator
```js
Comparator<Person> byWeightComparatorUsingLambda =
        (person1, person2) -> person1.getWeight().compareTo(person2.getWeight());
```

### Method Reference - 方法引用
::
构造器方法引用： 类名::new
静态方法引用：类名::静态方法

