package com.manga.application.mangarocks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manga.application.mangarocks.validation.CategoryCreateRequestValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    @JsonProperty("manga_category_name")
    @NotBlank(message = "manga_category_name received is null or blank", groups = {CategoryCreateRequestValidation.class})
    private String mangaCategoryName;

    @JsonProperty("category_description")
    @NotBlank(message = "category_description received is null or blank", groups = {CategoryCreateRequestValidation.class})
    private String categoryDescription;
}
