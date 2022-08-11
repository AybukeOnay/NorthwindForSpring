package com.etiya.northwind.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {

    @NotNull
    @Min(1)
    private int employeeId;

    @NotNull
    private int cityId;

    @NotNull
    private int countryId;

    @NotNull
    private int reportTo;

    @NotNull
    @NotBlank(message = "First Name is mandatory")
    @Size(min=2 ,message = "First Name must be 2  characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "First Name must be of characters")
    private String firstName;

    @NotNull
    @NotBlank(message = "First Name is mandatory")
    @Size(min=2 ,message = "First Name must be 2  characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "First Name must be of characters")
    private String lastName;

    @NotNull
    @NotBlank
    private String title;
}
