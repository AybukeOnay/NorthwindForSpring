package com.etiya.northwind.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T>{
    int recordCount;
    int totalPages;
    int pageNumber;
    int totalData;
    T response;

    public APIResponse(int recordCount, T response) {
        super();
        this.recordCount = recordCount;
        this.response = response;
    }
}
