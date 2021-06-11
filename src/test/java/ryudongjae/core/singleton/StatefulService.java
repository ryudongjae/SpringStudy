package ryudongjae.core.singleton;

public class StatefulService {

    //private int price; //상태 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        //this.price = price; //문제점

        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
