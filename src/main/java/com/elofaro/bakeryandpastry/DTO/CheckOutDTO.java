package com.elofaro.bakeryandpastry.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckOutDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String address;

}
