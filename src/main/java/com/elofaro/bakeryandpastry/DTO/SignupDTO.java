package com.elofaro.bakeryandpastry.DTO;

import lombok.Data;

@Data
public class SignupDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmation;
    private String address;

    public SignupDTO() {
    }

    public SignupDTO(String firstname, String lastname,
                     String email, String password,
                     String confirmation, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmation = confirmation;
        this.address = address;
    }
}
