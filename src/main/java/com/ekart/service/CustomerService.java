package com.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.dao.ICustomerRepository;
import com.ekart.dto.CustomerData;
import com.ekart.exception.NoIdFoundException;
import com.ekart.model.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	// DTO=>Entity
	private Customer getCustomerEntity(CustomerData customerData) {
		Customer customer = new Customer();
		customer.setCustomerId(customerData.getCustomerId());
		customer.setCustomerName(customerData.getCustomerName());
		customer.setCustomerEmail(customerData.getCustomerEmail());
		customer.setCustomerAddress(customerData.getCustomerAddress());
		customer.setCustomerUserName(customerData.getCustomerPassword());
		customer.setCustomerPassword(customerData.getCustomerPassword());
		return customer;
	}

//	Entity=>DTO
	private CustomerData getCustomerData(Customer customer) {
		CustomerData customerData = new CustomerData();
		customerData.setCustomerId(customer.getCustomerId());
		customerData.setCustomerName(customer.getCustomerName());
		customerData.setCustomerEmail(customer.getCustomerEmail());
		customerData.setCustomerAddress(customer.getCustomerAddress());
		customerData.setCustomerUserName(customer.getCustomerUserName());
		customerData.setCustomerPassword(customer.getCustomerPassword());

		return customerData;

	}

	@Override
	public List<CustomerData> findAll() {

		List<CustomerData> customerDataList = new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		customers.forEach(customer -> {
			customerDataList.add(getCustomerData(customer));
		});

		return customerDataList;
	}

	@Override
	public CustomerData findById(Long id) throws NoIdFoundException {
		Customer customer = customerRepository.findById(id).orElse(null);
		if(customer!=null) {
			return getCustomerData(customer);
			

		}
		else {
			throw new NoIdFoundException ("Custpmer id not found"+id);
		}
	}

	@Override
	public CustomerData create(CustomerData customerData) {
		Customer customer = getCustomerEntity(customerData);

		return getCustomerData(customerRepository.save(customer));
	}

	@Override
	public boolean delete(Long id) {

		Customer customer = customerRepository.findById(id).get();
		if (customer != null) {
			customerRepository.deleteById(id);
			return true;

		} else {
			return false;
		}

	}

	public boolean update(CustomerData customerData, Long productId) {
		Customer customer = customerRepository.findById(productId).get();
		if (customer != null) {
			customer.setCustomerName(customerData.getCustomerName());
			customer.setCustomerEmail(customerData.getCustomerEmail());
			customer.setCustomerAddress(customerData.getCustomerAddress());
			customer.setCustomerUserName(customerData.getCustomerUserName());
			customer.setCustomerPassword(customerData.getCustomerPassword());
			customerRepository.save(customer);

			return true;
		} else {
			return false;
		}

	}

}
