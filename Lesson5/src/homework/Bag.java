package homework;

import java.util.ArrayList;

public class Bag {


    int maxWeight;
    int bestPrice;
    ArrayList<Item> bestItemsPack = null;

    public Bag(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calculateWeight(ArrayList<Item> items) {
        int weightSum = 0;
        for (Item i :
                items) {
            weightSum += i.weight;
        }
        return weightSum;
    }

    private int calculatePrice(ArrayList<Item> items) {
        int priceSum = 0;
        for (Item i :
                items) {
            priceSum += i.price;
        }
        return priceSum;
    }

    private void compareSets(ArrayList<Item> items) {
        if (bestItemsPack == null) {
            if (calculateWeight(items) <= maxWeight) {
                bestItemsPack = items;
                bestPrice = calculatePrice(items);
            }
        } else {
            if (calculateWeight(items) <= maxWeight && calculatePrice(items) > bestPrice){
                bestItemsPack = items;
                bestPrice = calculatePrice(items);
            }
        }
    }

    private void makeAllSets(ArrayList<Item> items){
        if(items.size()>0){
            compareSets(items);
        }
        for (int i = 0; i < items.size(); i++) {
            ArrayList<Item> newList = new ArrayList<>(items);
            newList.remove(i);
            makeAllSets(newList);
        }
    }

    private ArrayList<Item> getBestSet()
    {
        return bestItemsPack;
    }
    private void info(ArrayList<Item> items){
        int sum=0;
        for (Item i : items)
        {
            sum+=i.price;
            System.out.println("Цена : "+i.price+" руб // Вес : "+i.weight+" гр");
        }
        System.out.println("<--------------------------->");
        System.out.println("Общая ценность рюкзака : "+sum);

    }

    public static void main(String[] args) {
        Bag bag = new Bag(10);

        Item item1 = new Item(100, 5);
        Item item2 = new Item(200, 5);
        Item item3 = new Item(300, 5);
        Item item4 = new Item(400, 5);
        Item item5 = new Item(500, 5);

        ArrayList<Item> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        bag.makeAllSets(items);
        ArrayList<Item> answer = bag.getBestSet();
        if(answer == null)
        {
            System.out.println("Ни один предмет не влезет в такую маленькую сумку");
        }
        else {
            bag.info(answer);
        }

    }
}
