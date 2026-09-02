package shoppingmall.repository;

import shoppingmall.model.OrderDetails;
import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements IOrderRepository {
    
    // In-memory database
    private final Map<Long, OrderDetails> orderDatabase = new HashMap<>();

    @Override
    public OrderDetails addOrder(OrderDetails order) {
        orderDatabase.put(order.getId(), order);
        return order;
    }

    @Override
    public OrderDetails updateOrder(OrderDetails order) {
        if (orderDatabase.containsKey(order.getId())) {
            orderDatabase.put(order.getId(), order);
            return order;
        }
        return null;
    }

    @Override
    public OrderDetails searchOrder(long id) {
        return orderDatabase.get(id);
    }

    @Override
    public OrderDetails deleteOrder(long id) {
        return orderDatabase.remove(id);
    }
}
