package tutorial.streams.onlineretail;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RetailAnalytics {
    public static void main(String[] args) {
        RetailAnalytics analytics = new RetailAnalytics();
        analytics.display();
        System.out.println("done");
    }

    private void display() {

        List<Order> orders = fetchOrders();
        int threshold = 8000;
//        threshold = 9000; // Uncomment to visualize lamda's final or effectively final requirement

        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate friday = monday.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));

        Predicate<Order> placedDuringWeekend = order -> order.getDate().isAfter(friday) && order.getDate().isBefore(monday);

        Map<Integer, Integer> ordersByCityZipCode = orders.stream()
                .filter(placedDuringWeekend)
                .filter(o -> o.getFinalOrderValue() > threshold)
                .collect(Collectors.groupingBy(Order::getZip, Collectors.summingInt(Order::getFinalOrderValue)));


        ordersByCityZipCode.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach((entry) -> {
                    System.out.println("Orders from city: " + entry.getKey() + " amounted to:" + entry.getValue());
                });

    }


    private List<Order> fetchOrders() {
        return createRandomOrders();    // or fetch orders from orders database and return
    }


    private List<Order> createRandomOrders() {
        /**
         * POP QUIZ Is this a good code?
         * Why?
         */

        Random random = new Random();

        IntStream zipStream = random.ints(1, 200).limit(5000);

        Stream<City> cityStream = zipStream.mapToObj(zipCode -> new City("CityName" + zipCode, zipCode));

        List<Order> orders = new ArrayList<>();

        cityStream.forEach(city -> {
            Address address = new Address();
            address.setCity(city);
            Consumer consumer = new Consumer();
            consumer.setAddress(address);


            LocalDate today = LocalDate.now();
            LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate saturday = monday.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY));

            long minDay = saturday.toEpochDay();
            long maxDay = monday.toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);


            Order order = new Order();
            order.setFinalOrderValue(random.nextInt(10000));
            order.setConsumer(consumer);
            order.setDate(randomDate);
            orders.add(order);
        });
        Collections.shuffle(orders);
        return orders;
    }
}
