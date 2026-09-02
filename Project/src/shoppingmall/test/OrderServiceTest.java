package shoppingmall.test;

import shoppingmall.exceptions.InvalidOrderException;
import shoppingmall.exceptions.OrderNotFoundException;
import shoppingmall.model.Customer;
import shoppingmall.model.OrderDetails;
import shoppingmall.model.Shop;
import shoppingmall.repository.IOrderRepository;
import shoppingmall.repository.OrderRepositoryImpl;
import shoppingmall.service.IOrderService;
import shoppingmall.service.OrderServiceImpl;

import java.time.LocalDateTime;

public class OrderServiceTest {

    public static void main(String[] args) {
        System.out.println("Starting OrderService Tests...");
        int passed = 0;
        int failed = 0;

        try { testAddOrderSuccessfully(); passed++; } catch (Exception e) { failed++; System.err.println("testAddOrderSuccessfully failed: " + e.getMessage()); }
        try { testSearchExistingOrder(); passed++; } catch (Exception e) { failed++; System.err.println("testSearchExistingOrder failed: " + e.getMessage()); }
        try { testSearchNonExistingOrder(); passed++; } catch (Exception e) { failed++; System.err.println("testSearchNonExistingOrder failed: " + e.getMessage()); }
        try { testUpdateOrderSuccessfully(); passed++; } catch (Exception e) { failed++; System.err.println("testUpdateOrderSuccessfully failed: " + e.getMessage()); }
        try { testCancelExistingOrder(); passed++; } catch (Exception e) { failed++; System.err.println("testCancelExistingOrder failed: " + e.getMessage()); }
        try { testCancelNonExistingOrder(); passed++; } catch (Exception e) { failed++; System.err.println("testCancelNonExistingOrder failed: " + e.getMessage()); }
        try { testInvalidNullOrder(); passed++; } catch (Exception e) { failed++; System.err.println("testInvalidNullOrder failed: " + e.getMessage()); }
        try { testDuplicateOrderId(); passed++; } catch (Exception e) { failed++; System.err.println("testDuplicateOrderId failed: " + e.getMessage()); }

        System.out.println("Tests completed. Passed: " + passed + ", Failed: " + failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new RuntimeException("Expected " + expected + " but got " + actual);
        }
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new RuntimeException("Expected true but got false");
        }
    }

    private static IOrderService getService() {
        IOrderRepository repo = new OrderRepositoryImpl();
        return new OrderServiceImpl(repo);
    }

    private static void testAddOrderSuccessfully() {
        IOrderService service = getService();
        OrderDetails order = new OrderDetails(1, LocalDateTime.now(), 100.0f, new Customer(1, "Alice"), "Card", new Shop(1, "Store"));
        OrderDetails created = service.addOrder(order);
        assertEquals(1L, created.getId());
    }

    private static void testSearchExistingOrder() {
        IOrderService service = getService();
        OrderDetails order = new OrderDetails(1, LocalDateTime.now(), 100.0f, new Customer(1, "Alice"), "Card", new Shop(1, "Store"));
        service.addOrder(order);
        OrderDetails found = service.searchOrder(1L);
        assertEquals(1L, found.getId());
    }

    private static void testSearchNonExistingOrder() {
        IOrderService service = getService();
        try {
            service.searchOrder(99L);
            throw new RuntimeException("Should have thrown OrderNotFoundException");
        } catch (OrderNotFoundException e) {
            // Expected
        }
    }

    private static void testUpdateOrderSuccessfully() {
        IOrderService service = getService();
        OrderDetails order = new OrderDetails(1, LocalDateTime.now(), 100.0f, new Customer(1, "Alice"), "Card", new Shop(1, "Store"));
        service.addOrder(order);

        OrderDetails updateReq = new OrderDetails();
        updateReq.setId(1L);
        updateReq.setTotal(150.0f);
        updateReq.setPaymentMode("Cash");

        OrderDetails updated = service.updateOrder(updateReq);
        assertEquals(150.0f, updated.getTotal());
        assertEquals("Cash", updated.getPaymentMode());
    }

    private static void testCancelExistingOrder() {
        IOrderService service = getService();
        OrderDetails order = new OrderDetails(1, LocalDateTime.now(), 100.0f, new Customer(1, "Alice"), "Card", new Shop(1, "Store"));
        service.addOrder(order);

        boolean result = service.cancelMall(1L);
        assertTrue(result);

        try {
            service.searchOrder(1L);
            throw new RuntimeException("Should have thrown OrderNotFoundException");
        } catch (OrderNotFoundException e) {
            // Expected
        }
    }

    private static void testCancelNonExistingOrder() {
        IOrderService service = getService();
        try {
            service.cancelMall(99L);
            throw new RuntimeException("Should have thrown OrderNotFoundException");
        } catch (OrderNotFoundException e) {
            // Expected
        }
    }

    private static void testInvalidNullOrder() {
        IOrderService service = getService();
        try {
            service.addOrder(null);
            throw new RuntimeException("Should have thrown InvalidOrderException");
        } catch (InvalidOrderException e) {
            // Expected
        }
    }

    private static void testDuplicateOrderId() {
        IOrderService service = getService();
        OrderDetails order1 = new OrderDetails(1, LocalDateTime.now(), 100.0f, new Customer(1, "Alice"), "Card", new Shop(1, "Store"));
        service.addOrder(order1);

        OrderDetails order2 = new OrderDetails(1, LocalDateTime.now(), 200.0f, new Customer(2, "Bob"), "Cash", new Shop(2, "Store2"));
        try {
            service.addOrder(order2);
            throw new RuntimeException("Should have thrown InvalidOrderException");
        } catch (InvalidOrderException e) {
            // Expected
        }
    }
}
