package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserController {

    @RequestMapping(value = "/user/register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    ResponseEntity<GenericResponse> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) throws JsonProcessingException;

//    @RequestMapping(value = "/category/getAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//    ResponseEntity<GenericResponse> getAllMangaCategory();
//
//    @RequestMapping(value = "/category/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//    ResponseEntity<GenericResponse> getMangaCategoryById(@PathVariable("id") Long id);
//
//    @RequestMapping(value = "/category/get", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//    ResponseEntity<GenericResponse> getMangaCategoryByIdParam(@RequestParam("id") Long id);
//
//    @RequestMapping(value = "/category/getByName", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//    ResponseEntity<GenericResponse> getMangaCategoryByName(@RequestParam("name") String name);
//
//    @RequestMapping(value = "/category/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
//    ResponseEntity<GenericResponse> updateMangaCategoryById(@PathVariable("id") Long id, @RequestBody CategoryDTO categoryDTO) throws JsonProcessingException;
//
//    @RequestMapping(value = "/category/updateByName", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
//    ResponseEntity<GenericResponse> updateMangaCategoryByName(@RequestParam("name") String name, @RequestBody CategoryDTO categoryDTO) throws JsonProcessingException;
//
//    @RequestMapping(value = "/category/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
//    ResponseEntity<GenericResponse> deleteMangaCategoryById(@PathVariable("id") Long id);
//
//    @RequestMapping(value = "/category/deleteByName", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
//    ResponseEntity<GenericResponse> deleteMangaCategoryByName(@RequestParam("name") String name);
}
