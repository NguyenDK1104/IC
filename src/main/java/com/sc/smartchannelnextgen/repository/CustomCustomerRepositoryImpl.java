package com.sc.smartchannelnextgen.repository;

import com.sc.smartchannelnextgen.dto.CustomerDto;
import com.sc.smartchannelnextgen.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CustomCustomerRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Object createCus(CustomerDto cus) {
        Customer customer = new Customer();
        customer.setName(cus.getName());
        customer.setAge(cus.getAge());
        customer.setCity(cus.getCity());
        entityManager.persist(customer);
        return "SUCCESS";
    }

    @Override
    public List<CustomerDto> getCusById(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.query("select a.name,a.age from customer a where a.id = :id", params, (rs, i) -> convertSearchToDto(rs));
    }

    private CustomerDto convertSearchToDto(ResultSet rs) throws SQLException {
        CustomerDto dto = new CustomerDto();
        dto.setName(rs.getString("NAME"));
        dto.setAge(rs.getString("AGE"));
        return dto;
    }
}
