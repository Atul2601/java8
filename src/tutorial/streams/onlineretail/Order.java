package tutorial.streams.onlineretail;

import java.time.LocalDate;
import java.util.List;

class Order {
    private Consumer consumer;
    private List<Item> items;
    private LocalDate date;
    private int finalOrderValue;

    public int getFinalOrderValue() {
        return finalOrderValue;
    }

    public void setFinalOrderValue(int finalOrderValue) {
        this.finalOrderValue = finalOrderValue;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void printReceipt() {
        System.out.println("order total amount: " + finalOrderValue);
    }

    @Override
    public String toString() {
        return "{date=" + date + ", finalOrderValue=" + finalOrderValue +'}';
    }

    public int getZip(){
        return this.getConsumer().getAddress().getCity().getZipCode();
    }
}
