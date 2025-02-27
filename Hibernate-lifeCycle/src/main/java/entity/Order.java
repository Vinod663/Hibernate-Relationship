package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
/*@ToString*/

@AllArgsConstructor
@NoArgsConstructor
/*@Data*/ //data eke getter setter and to string kiyana 3 ma tiyenawa
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
