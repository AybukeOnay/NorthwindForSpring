package com.etiya.northwind.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    @NotNull
    @Min(1)
    private int employeeId;

    @NotNull
    @Min(1)
    private int cityId;

    @NotNull
    @Min(1)
    private int countryId;

    @NotNull
    private Integer reportTo;

    @NotNull
    @NotBlank(message = "First name is mandatory")
    @Size(min=2 ,message = "First name must be 2 characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "First Name must be of characters")
    private String firstName;

    @NotNull
    @NotBlank(message = "Last name is mandatory")
    @Size(min=2 ,message = "Last name must be 2  characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "Last name must be of characters")
    private String lastName;

    @NotNull
    @NotBlank
    private String title;


}
