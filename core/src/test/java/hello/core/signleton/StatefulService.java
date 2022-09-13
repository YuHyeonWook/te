package hello.core.signleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드 (가격이라는 필드)

    public void order(String name, int price) {
        System.out.println("name= " + name + "price"+ price);
        this.price = price; // 여기서 문제가 발생함
    }

    public int getPrice() {
        return price;
    }
}
