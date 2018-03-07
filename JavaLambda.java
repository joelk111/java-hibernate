package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalTime;

/**
 * LAMBDA EXPRESSIONS AND STREAMS: PART III
 * 
 * 
 * Todays lunch and learn goals:
 * 
 * 1. review part II
 * 2. go over map, reduce, filter and paraell
 * 3. Java only - Function and UnaryOperator
 * 
 * 
 * @author HKass
 *
 */


public class JavaLambda {
	
static Function<Integer, Integer> times2 = e -> e * 2;
static Function<Integer, Integer> squared = e -> e * e;	

Function<Integer,Integer> add1 = x -> x + 1;
Function<String,String> concat = x -> x + 1;
Function<Integer,Integer> mul3 = x -> x * 3;
 
UnaryOperator<String> concat1 = s -> s + 1;
Function<Integer, UnaryOperator<Integer>> sum = x -> y -> x + y;
UnaryOperator<Integer> sum10 = sum.apply(10);


//define a function that receives a string value and parses it as an integer:

Function<String,Integer> numAsString = s -> Integer.valueOf(s);

	





/**
 * LUNCH AND LEARN LAB
 * @param args
 * 
 * 
 *     x,y  -> System.out.print(x)
 *     
 *    
 *     
 *     Employee x
 *     Employee y
 *     
 *     lx.y(ylx.y) //beta reduction.
 * @throws InterruptedException 
 *     
 *     
 */

public static void main(String[] args) throws InterruptedException {
	
	
	
	int [] arr= new int[]{1,2,3,4,5};
	//Arrays.stream(arr).distinct()
	
	Stack stack = new Stack();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	
	
	
	
	
	
	//review from part II. Create a comparator in just one line!
	
		JavaLambda emp = new JavaLambda();
		List<Employee> employees  = emp.getEmployees();
		
		//Sort all employees by first name
		employees.sort(Comparator.comparing(e -> e.getId()));
		
		//OR you can use below
		employees.sort(Comparator.comparing(Employee::getFirstName));
		
		
		
		//you can use the toCollection in the Collector to support datatypes not covererd
		 ArrayList<String> usernames2 = employees.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toCollection(ArrayList::new));
		
		
		//Let's print the sorted list
		System.out.println(employees);	
		
		



		
		
		/*
		 * 
		 * STREAMS
		 * 
		 * Rules of the Road:
		 * 
		 * 1.Java 8 streams cannot be reused. As soon as you call any terminal operation the stream is closed
		 * 2. You can encapulate lambds into functions.
		 * 3. a higher order function is basicly a function that creates or returns another function
		 * 4. Lambda Calculus reminder - lambda expression- lx.e where l is the function, x is teh argument and e is teh method body.
		 */
		
		
		List<String> list = new ArrayList<>();
		list.add("Joel");
		list.add("Praveen");
		list.add("Feliks");
		list.add("Abijad");
		list.add("Ahmad");
		list.add("Dan");
		list.add("Kamal");
		list.add("John");
	
		
		//lets filter our data based on names taht start with 'J', sort them by natural sorting (A-Z)
		
		list.stream() .filter(s -> s.startsWith("J")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
		//we can use all the strnig operations on the string object, or any methdo native to that class.
		list.stream() .filter(s -> s.contains("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
		
		//we can programatically add to the lambdas by using a multi-line '}'
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		

	// C1
	// C2
	
	/**
	 * FILTER
	 */
		
		list.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);   // "aaa2", "aaa1"
		
		
		
		list.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);   // "aaa2", "aaa1"
		
		
		
		
		
	

		
		
		
		//remember that the stream does not impact the list collection itself, only the stream.
		System.out.println(list);
		
		
		List newList =list.stream().sorted().filter((s) -> s.startsWith("a")).collect(Collectors.toList()); //use collectors to create a list
		
		
		/**MAP
		 * 
		 * map converts each element into another object via the given function. 
		 * The following example converts each string into an upper-cased string. 
		 * But you can also use map to transform each object into another type. 
		 * 
		 * The generic type of the resulting stream depends on the generic type of the function you pass to map.
		 */
		
		
		
		list.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		
		// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
		
		//String:: toUpperCase is an example of a Java8 method reference. It is class:: method
		
		
		//note here we are passing in a custom copmarator into our sort method
		
		
		/** MATCH
		 * 
		 * matching operations can be used to check whether a certain predicate matches the stream. 
		 * All of those operations are terminal and return a boolean result.
		 * 
		 */
		
		                                      //.all matches
		                                      //.none matches
		boolean anyStartsWithA = list.stream().anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA);      // true
		
		
	
		
		
		//COUNT
		
		long startsWithB =
			    list .stream().filter((s) -> s.startsWith("b")).count();

			System.out.println(startsWithB);    // 3
			
			
			/**
			 * REDUCE
			 * 
			 * This terminal operation performs a reduction on the elements of the stream with the given function. 
			 * The result is an Optional holding the reduced value.
			 * 
			 */
			
			
			
			
			Optional<String> reduced =
				    list
				        .stream()
				        .sorted() 
				        .reduce((s1, s2) -> s1 + "#" + s2);

				reduced.ifPresent(System.out::println);
				// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
				
				
				
				
				
				
				
				
			/**
			 * 
			 * PARALLEL STREAMS	
			 * 
			 * Uses a fork join pool- divide and conqure for recursive tasks
			 * 
			 * 1. seperate(fork) each large task into smaller tasks
			 * 2. process each task in a sepeate thread
			 * 3. join the results
			 * 
			 * Similar to a mergeSort
			 * 
			 * depending on the number of threads availabe on the machine, could hurt performance.
			 */
				
				
				ForkJoinPool commonPool = ForkJoinPool.commonPool();
				int totalThreads =commonPool.getParallelism(); //returns 3 on my system
				System.out.println("the fork join pool will attempt to use:   "+ totalThreads);
				
				//create a large list of unique elements
				
				int max = 1000000;  //one million UIDS!
				List<String> values = new ArrayList<>(max);
				for (int i = 0; i < max; i++) {
				    UUID uuid = UUID.randomUUID();
				    values.add(uuid.toString());
				}
				
				
			//using a regular sort
				
				long t0 = System.nanoTime();

				long count = values.stream().sorted().count();
				System.out.println(count);

				long t1 = System.nanoTime();

				long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
				System.out.println(String.format("sequential sort took: %d ms", millis));

				// sequential sort took: 899 ms
				
				
				
				
				//parallel stort
				
				long tt0 = System.nanoTime();

			//	long tcount = values.parallelStream().sorted().count();
				
				
				//If you execute it as a task in a fork-join pool, it stays there and does not use the common one.
				
				//we can customize the forkJoin thread pool by simply adding teh following
				
				/**
				 * The trick is based on ForkJoinTask.fork which specifies: "Arranges to asynchronously execute this task in the 
				 * pool the current task is running in, if applicable, or using the ForkJoinPool.commonPool() if not inForkJoinPool()"
				 */
				
/*				System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
				
			   ForkJoinPool customThreadPool = new ForkJoinPool(4);
				     ForkJoinTask<?> actualTotal = customThreadPool.submit(
				      () -> list.parallelStream().sorted().forEach(s -> {
				            System.out.println(LocalTime.now() + " - value: " + s +
		                            " - thread: " + Thread.currentThread().getName());;
				
		                            
		                            try {
		                                Thread.sleep(200);
		                            } catch (InterruptedException e) {
		                                e.printStackTrace();
		                            }
		                        }));;              
		                            
		                          
						

			values.parallelStream().sorted().forEach(s -> { System.out.println(LocalTime.now() + " - value: " + s +
																" - thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });;*/
			 
				
/*				values.parallelStream().sorted().forEach(s -> { System.out.println(LocalTime.now() + " - value: " + s +
						" - thread: " + Thread.currentThread().getName());
				
				
		        try {
		            Thread.sleep(200);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    });;	
				*/
				
				
				
			//	System.out.println(tcount);

				long tt1 = System.nanoTime();

				long tmillis = TimeUnit.NANOSECONDS.toMillis(tt1 - tt0);
				System.out.println(String.format("parallel sort took: %d ms", tmillis));

				// parallel sort took: 472 ms
				
				
				
				
				
				
				
				
				ForkJoinPool forkJoinPool = new ForkJoinPool(3);
			ForkJoinPool forkJoinPool2 = new ForkJoinPool(3);
				
				/**
				 * you should see this:
				 * 
				 * Loop 1 : Thread[ForkJoinPool-1-worker-1,5,main]
					Loop 1 : Thread[ForkJoinPool-1-worker-0,5,main]
				 */
				Thread thread1 = new Thread(() -> forkJoinPool.submit(() -> {
					values.parallelStream().forEach(n -> {
						try {
							Thread.sleep(1);
							System.out.println("Loop 1 : " + Thread.currentThread());
						} catch (InterruptedException e) {

						}
					});
				}).invoke());
				
				thread1.start();
				
				
				Thread thread2 = new Thread(() -> forkJoinPool2.submit(() -> {
					values.parallelStream().forEach(n -> {
						try {
							Thread.sleep(1);
							System.out.println("Loop 1 : " + Thread.currentThread());
						} catch (InterruptedException e) {

						}
					});
				}).invoke());
				
				thread2.start();	
				thread1.join();
				
				
				
				
				
				
/*				   ForkJoinPool customThreadPool = new ForkJoinPool(4);
				     ForkJoinTask<?> actualTotal = customThreadPool.submit(
				      () -> list.parallelStream().sorted().forEach(s -> {
				            System.out.println(LocalTime.now() + " - value: " + s +
		                            " - thread: " + Thread.currentThread().getName());;
				
		                            
		                            try {
		                                Thread.sleep(200);
		                            } catch (InterruptedException e) {
		                                e.printStackTrace();
		                            }
		                        }));;  	
				
		                        customThreadPool.execute(actualTotal);
				
				
				/**
				 * 
				 * MAPS DATASTRUCTURE
				 * 
				 * - maps dont support streams, but there are many more options to use
				 */
				
				
				HashMap map1 = new HashMap();
			map1.entrySet().stream().distinct();
				
				
				Map<Integer, String> map = new HashMap<>();

				for (int i = 0; i < 10; i++) {
				    map.putIfAbsent(i, "val" + i);  //putIfAbsent prevents us from writing additional if null checks
				}

				map.forEach((id, val) -> System.out.println(val));
				
				
				map.computeIfPresent(3, (num, val) -> val + num);
				map.get(3);             // val33

				map.computeIfPresent(9, (num, val) -> null);
				map.containsKey(9);     // false

				map.computeIfAbsent(23, num -> "val" + num);
				map.containsKey(23);    // true

				map.computeIfAbsent(3, num -> "bam");
				map.get(3);             // val33
				
				
				
			/**
			 * COMPOSING FUNCTIONS
			 * 
			 * As you can see, the difference between compose and andThen is the order they execute the functions. 
			 * While the compose function executes the caller last and the parameter first, 
			 * the andThen executes the caller first and the parameter last.
			 * 
			 * 
			 * 
			 * 	
			 */
				
				
				times2.compose(squared).apply(4);  
				// Returns 32

				times2.andThen(squared).apply(4);  
				// Returns 64	
				
				

	}

	
	
	
	public static List<Employee> getEmployees(){
		List<Employee> employees  = new ArrayList<>();
		employees.add(new Employee(1,"Joel", "Kass", 79));
		employees.add(new Employee(2,"Praveen", "Murgen", 28));
		employees.add(new Employee(3,"Kamal", "Valblahblah", 52));
		employees.add(new Employee(4,"James", "Hedge", 72));
		employees.add(new Employee(5,"David", "Kameron", 19));
		employees.add(new Employee(6,"Feliks", "Test", 25));
		employees.add(new Employee(7,"Daya", "tester", 59));
		employees.add(new Employee(8,"Barak", "Obama", 88));
		employees.add(new Employee(9,"Gal", "Gidot", 33));
		employees.add(new Employee(10,"Bob", "Hope", 60));
		return employees;
	}
	
	static <T> void replaceIf(List<T> list, Predicate<? super T> pred, UnaryOperator<T> op) {
	    list.replaceAll(t -> pred.test(t) ? op.apply(t) : t);
	}
}
