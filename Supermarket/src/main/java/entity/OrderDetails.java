package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {
    /*@Id
    private int id;*/
    @EmbeddedId//composite id
    private OrderDetailsId id;
    /*@EmbeddedId private OrderDetailsId id;

    The OrderDetails table has a composite key (OrderDetailsId), meaning its ID is made up of multiple values.
    this would include both orderId and itemId.*/

    @ManyToOne
    @MapsId("orderId")//Instead of creating a separate orderId field, it reuses the orderId inside OrderDetailsId.
    @JoinColumn(name="order_id")//@JoinColumn → Defines a foreign key column.
    private Order order;

    @ManyToOne
    @MapsId("itemId")////Instead of creating a separate itemId field, it reuses the itemId inside OrderDetailsId.
    @JoinColumn(name = "item_id")
    private Item item;

    private int qty;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;
    /*12345678.99 ✅
    9999999999.99 ❌ (too many digits)
    1234.567 ❌ (too many decimal places)*/
}
