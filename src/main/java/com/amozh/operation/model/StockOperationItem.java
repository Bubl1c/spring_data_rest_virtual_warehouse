package com.amozh.operation.model;

import com.amozh.item.model.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Andrii Mozharovskyi on 06.04.2016.
 */
@Entity
@Table(name="mb_stock_operation_item")
@Data
public class StockOperationItem {
    @Id
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @GeneratedValue(generator = "uuid2")
//    @Column(columnDefinition="uniqueidentifier")
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.TABLE)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    private UUID uuid;
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "operation_id", columnDefinition="uniqueidentifier")
    @JoinColumn(name = "operation_id")
    @JsonBackReference
    private StockOperation operation;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private BigDecimal amount;

    @JsonView(OperationsList.class)
    private BigDecimal price;

    private BigDecimal amountAfter;

    public interface OperationsList {}

}