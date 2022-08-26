package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    List<Contact> list=List.of(
            new Contact(1L,"vinisha2000@gmail.com","Vinisha",1311L),
            new Contact(2L,"akshita2001@gmail.com","Akshita",1311L),
            new Contact(3L,"abhishek1998@gmail.com","Abhishek",1312L),
            new Contact(4L,"sandesh2000@gmail.com","Sandesh",1314L)
    );
    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
