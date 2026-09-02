package shoppingmall.repository;

import shoppingmall.model.OrderDetails;

public interface IOrderRepository {
    OrderDetails addOrder(OrderDetails order);
    OrderDetails updateOrder(OrderDetails order);
    OrderDetails searchOrder(long id);
    OrderDetails deleteOrder(long id);
}
