package shoppingmall.service;

import shoppingmall.model.Item;
import shoppingmall.model.OrderDetails;

public interface IOrderService {
    OrderDetails addOrder(OrderDetails order);
    OrderDetails updateOrder(OrderDetails order);
    OrderDetails searchOrder(long id);
    boolean cancelMall(long id); // Matches specification name, means cancelOrder
    Item addItem(Item item); // Matches specification name
}
