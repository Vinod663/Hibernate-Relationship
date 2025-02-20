package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    //owning side - foreign key eka tiyan inna eka
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderDate; //date string daana eka best practic newe

    @ManyToOne//order idn baladdi penne many to one widihata order eka
    private Customer customer;// order ekakata customer la ekkenai inne
}
