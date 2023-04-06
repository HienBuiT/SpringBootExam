package lab5.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
	@Id
	String username;
	String email, fullname, password, photo;
	boolean activated = true, admin = false;
	@OneToMany(mappedBy = "accounts")
	List<Order> orders;
}

