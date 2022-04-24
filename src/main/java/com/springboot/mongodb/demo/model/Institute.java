package com.springboot.mongodb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection = "institute")
@Data
@Builder
@AllArgsConstructor
public class Institute {
    @Id
    private String instituteId;

    @NotNull(message = "Institute Name Cannot be Null")
    private String instituteName;

    @NotNull(message = "Institute Email Cannot be Null")
    @Email(message = "Invalid Institute Email")
    @Indexed(unique = true)
    private String instituteEmail;

    @NotNull(message = "Institute Address Cannot be Null")
    private String instituteAddress;
}
