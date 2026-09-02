package shoppingmall.service;

import shoppingmall.exceptions.InvalidOrderException;
import shoppingmall.exceptions.OrderNotFoundException;
import shoppingmall.model.Item;
import shoppingmall.model.OrderDetails;
import shoppingmall.repository.IOrderRepository;

import java.time.LocalDateTime;

public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDetails addOrder(OrderDetails order) {
        if (order == null) {
            throw new InvalidOrderException("Order cannot be null.");
        }
        if (order.getCustomer() == null) {
            throw new InvalidOrderException("Order must have a customer.");
        }
        if (order.getShop() == null) {
            throw new InvalidOrderException("Order must have a shop.");
        }
        if (order.getTotal() < 0) {
            throw new InvalidOrderException("Order total cannot be negative.");
        }
        
        OrderDetails existing = orderRepository.searchOrder(order.getId());
        if (existing != null) {
            throw new InvalidOrderException("Order with ID " + order.getId() + " already exists.");
        }

        if (order.getDateOfPurchase() == null) {
            order.setDateOfPurchase(LocalDateTime.now());
        }

        return orderRepository.addOrder(order);
    }

    @Override
    public OrderDetails updateOrder(OrderDetails order) {
        if (order == null) {
            throw new InvalidOrderException("Order cannot be null.");
        }
        OrderDetails existingOrder = orderRepository.searchOrder(order.getId());
        if (existingOrder == null) {
            throw new OrderNotFoundException("Cannot update. Order with ID " + order.getId() + " not found.");
        }
        
        // Allowed updates
        existingOrder.setPaymentMode(order.getPaymentMode());
        existingOrder.setTotal(order.getTotal());
        
        return orderRepository.updateOrder(existingOrder);
    }

    @Override
    public OrderDetails searchOrder(long id) {
        OrderDetails order = orderRepository.searchOrder(id);
        if (order == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found.");
        }
        return order;
    }

    @Override
    public boolean cancelMall(long id) {
        OrderDetails order = orderRepository.searchOrder(id);
        if (order == null) {
            throw new OrderNotFoundException("Cannot cancel. Order with ID " + id + " not found.");
        }
        OrderDetails deleted = orderRepository.deleteOrder(id);
        return deleted != null;
    }

    @Override
    public Item addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        // In a real application, this would probably interact with an ItemRepository.
        // As per the Order module scope, returning the item.
        return item;
    }
}
