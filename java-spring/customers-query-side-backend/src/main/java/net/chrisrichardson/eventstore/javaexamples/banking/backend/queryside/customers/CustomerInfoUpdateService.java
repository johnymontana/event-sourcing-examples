package net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers;

import net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers.domain.QuerySideNeo4jCustomer;
import net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers.repository.QuerySideCustomerNeo4jRepository;
import net.chrisrichardson.eventstore.javaexamples.banking.common.customers.CustomerInfo;
import net.chrisrichardson.eventstore.javaexamples.banking.common.customers.ToAccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * Created by Main on 04.02.2016.
 */
public class CustomerInfoUpdateService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private QuerySideCustomerRepository accountInfoRepository;
    @Autowired
    QuerySideCustomerNeo4jRepository repo;

    public CustomerInfoUpdateService(QuerySideCustomerRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }

    public void create(String id, CustomerInfo customerInfo) {
        try {
            accountInfoRepository.save(new QuerySideCustomer(id,
                            customerInfo.getName(),
                            customerInfo.getEmail(),
                            customerInfo.getSsn(),
                            customerInfo.getPhoneNumber(),
                            customerInfo.getAddress(),
                            Collections.<String, ToAccountInfo>emptyMap()
                    )
            );
            logger.info("Saved in mongo");
        } catch (Throwable t) {
            logger.error("Error during saving: ", t);
            throw new RuntimeException(t);
        }

        try {
            QuerySideNeo4jCustomer customer = new QuerySideNeo4jCustomer(customerInfo.getName().getFirstName(),
                    customerInfo.getEmail(),
                    customerInfo.getSsn(),
                    customerInfo.getPhoneNumber(),
                    customerInfo.getAddress().getStreet1(),
                    customerInfo.getAddress().getStreet2(),
                    customerInfo.getAddress().getCity(),
                    customerInfo.getAddress().getState(),
                    customerInfo.getAddress().getZipCode());
            repo.save(customer);
        } catch (Throwable t) {
            logger.error("Error duing saving to Neo4j: ", t);
            throw new RuntimeException(t);
        }
    }

    public void addToAccount(String id, ToAccountInfo accountInfo) {
        QuerySideCustomer customer = accountInfoRepository.findOne(id);
        customer.getToAccounts().put(accountInfo.getId(), accountInfo);
        accountInfoRepository.save(customer);
    }

}
