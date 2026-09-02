package orderdetails;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailsService {

    private final OrderDetailsRepository repo;

    OrderDetailsService(OrderDetailsRepository repo) {
        this.repo = repo;
    }

    public List<Order> listAll() {
        return repo.findAll();
    }

    public void save(Order orderdetails) {
        repo.save(orderdetails);
    }

    public Order get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
