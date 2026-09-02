package com.shoppingmall.order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.order.model.OrderDetails;
import com.shoppingmall.order.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDetails> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderDetails addOrder(OrderDetails order) {
        if (order.getDateOfPurchase() == null) {
            order.setDateOfPurchase(LocalDateTime.now());
        }
        return orderRepository.save(order);
    }

    public OrderDetails getOrderById(Long id) {
        Optional<OrderDetails> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new RuntimeException("Order not found with id " + id);
        }
    }

    public OrderDetails updateOrder(Long id, OrderDetails updatedOrder) {
        OrderDetails existingOrder = getOrderById(id);
        
        if (updatedOrder.getPaymentMode() != null) {
            existingOrder.setPaymentMode(updatedOrder.getPaymentMode());
        }
        if (updatedOrder.getTotal() > 0) {
            existingOrder.setTotal(updatedOrder.getTotal());
        }
        
        return orderRepository.save(existingOrder);
    }

    public void cancelOrder(Long id) {
        OrderDetails existingOrder = getOrderById(id);
        orderRepository.delete(existingOrder);
    }
}
