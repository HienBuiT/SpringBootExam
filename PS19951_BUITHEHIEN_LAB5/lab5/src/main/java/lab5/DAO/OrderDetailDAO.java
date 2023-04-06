package lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import lab5.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{

}
