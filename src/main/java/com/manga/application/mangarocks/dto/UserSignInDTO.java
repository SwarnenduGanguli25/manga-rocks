package com.manga.application.mangarocks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manga.application.mangarocks.annotation.Mask;
import com.manga.application.mangarocks.validation.UserSignInRequestValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSignInDTO {

    @JsonProperty("user_identifier")
    @NotBlank(message = "Please provide username or email", groups = {UserSignInRequestValidation.class})
    @Mask
    private String userIdentifier;

    @JsonProperty("password")
    @NotBlank(message = "Please provide password", groups = {UserSignInRequestValidation.class})
    @Mask
    private String password;
}
