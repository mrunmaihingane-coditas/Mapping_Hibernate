package model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;


    @Entity
    @Table(name = "Person_CommenJoin")
    public class Person_CommenJoin implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "person_id")
        private Long id;

        @Column(name = "name")
        private String name;

        @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinTable(name = "person_address",
                joinColumns = @JoinColumn(name = "person_id"),
                inverseJoinColumns = @JoinColumn(name = "address_id"))
        private Address_CommenJoin address;

        // getters and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address_CommenJoin getAddress() {
            return address;
        }

        public void setAddress(Address_CommenJoin address) {
            this.address = address;
        }
    }


