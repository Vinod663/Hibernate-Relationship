package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // AUTO- hibernate decide auto value
    //IDENTITY- database generate auto value
    // for custom value don't use @GeneratedValue
    //auto hari identity hari danawanm aniwaren int ekk wenna one
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "nic_number") //@JoinColumn → Defines a foreign key column.
    private IDCard idCard;// idCard eka tama foreign key eka widihata ganne eke name eka joinColumn eken customize karanawa
}
