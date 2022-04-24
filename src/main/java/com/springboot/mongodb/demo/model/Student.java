package com.springboot.mongodb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection = "student")
@Data
@Builder
@AllArgsConstructor
public class Student {

    @Id
    private String studentId;

    @NotNull(message = "Student Name cannot be Null or Empty")
    private String studentName;

    @NotNull(message = "Student Email cannot be Null or Empty")
    @Email(message = "Enter Valid Email")
    @Indexed(unique = true)
    private String studentEmail;

    @NotNull(message = "Student Address cannot be Null or Empty")
    private String studentAddress;

    @NotNull(message = "Student Age cannot be Null or Empty")
    private Long studentAge;

    @NotNull(message = "Student Mobile Number cannot be Null or Empty")
    @Indexed(unique = true)
    private String studentMobileNumber;

    @DBRef
    private Institute institute;
}
