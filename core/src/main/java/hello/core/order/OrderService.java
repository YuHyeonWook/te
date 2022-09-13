package hello.core.order;

public interface OrderService {
    // 1.주문 생성요청 (회원 id , 상품명, 상품가격)
    Order createOrder(Long memberId, String itemName, int itemPrice);

}

