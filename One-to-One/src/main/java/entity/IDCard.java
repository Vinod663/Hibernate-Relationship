package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="nic_details")
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nicNumber;

    @OneToOne(mappedBy = "idCard") // customer laga tama tiyaganne dan foreign key eka, meya laga tiya gan naa map karala tiyenne anik pattata
    private Customer customer;

}
