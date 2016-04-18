package com.amozh.operation.model.impl;

import com.amozh.Api;
import com.amozh.operation.model.StockOperation;
import com.amozh.operation.model.StockOperationType;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Andrii Mozharovskyi on 12.04.2016.
 */
@Entity
@Table(name = StockOperationType.IN_OPERATION_NAME + "_operation")
@Data
@RestResource(rel = StockOperationType.IN_OPERATION_NAME, path = Api.RES_COLLECTION_STOCK_OPERATIONS)
public class InOperation extends StockOperation {

    @Column(length = 50)
    private String supplier;

    @Override
    public StockOperationType getType() {
        return StockOperationType.IN;
    }
}
