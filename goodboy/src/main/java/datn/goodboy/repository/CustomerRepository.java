package datn.goodboy.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import datn.goodboy.model.entity.Customer;
import datn.goodboy.model.response.CustomerResponse;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
  @Query(value = "SELECT new datn.goodboy.model.response.CustomerResponse(c.id, c.code, c.name, c.gender, c.birth_date, c.phone, c.address, c.city, c.country, c.status) FROM Customer c")
  Page<CustomerResponse> getPageNo(Pageable page);

  @Query(value = "SELECT new datn.goodboy.model.response.CustomerResponse(c.id, c.code, c.name, c.gender, c.birth_date, c.phone, c.address, c.city, c.country, c.status) FROM Customer c")
  List<CustomerResponse> getAllResponse();

  @Query(value = "SELECT cus FROM Customer cus WHERE cus.name= :name")
  Optional<Customer> getCounterCustomer(@Param("name") String name);

  @Query(value = "SELECT cus FROM Customer cus WHERE LOWER(cus.name) LIKE CONCAT('%', :searchText, '%') OR LOWER(cus.phone) LIKE CONCAT('%', :searchText, '%')")
  List<Customer> searchByText(@Param("searchText") String searchText);

  Optional<Customer> findByAccountId(UUID accountId);

}
