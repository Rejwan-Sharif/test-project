package com.test.ecommerce.Address;




import com.test.ecommerce.customers.Customers;
import com.test.projectionsTesting.CustomerPrimaryDataService;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "GS_ADDRESS")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_add_seq_gen")
    @SequenceGenerator(name = "customer_add_seq_gen", sequenceName = "address_seq",allocationSize = 1)
    @Column(name = "ADDRESS_ID", nullable = false)
    private Long id;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "AREA", nullable = false)
    private String area;

    @Column(name = "THANA")
    private String thana;

    @Column(name = "POSTAL_CODE",nullable = false)
    private String zip;

    @Column(name = "CITY",nullable = false)
    private String city;

//    @OneToOne(mappedBy="address")

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Set<Customers> customer = new HashSet<>();


}
