package lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import lab5.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{

}
