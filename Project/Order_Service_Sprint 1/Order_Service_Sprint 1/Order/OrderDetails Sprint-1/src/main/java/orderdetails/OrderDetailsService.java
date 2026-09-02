package orderdetails;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailsService {

    private final OrderDetailsRepository repo;

    // Constructor
    OrderDetailsService(OrderDetailsRepository repo) {
        this.repo = repo;
    }

    // Get All List of Data
    public List<Order> listAll() {
        return repo.findAll();
    }

    // Create / Update the data
    public void save(Order orderdetails) {
        repo.save(orderdetails);
    }

    // Get data by ID
    public Order get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    // Delete the data
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}