package com.notfound.bookstore.model.dto.response.addressResponse;


import java.util.UUID;

public class AddressResponse {
    private UUID id;
    private String recipientName;
    private String phoneNumber;
    private String street;
    private String city;
    private String district;
    private Boolean isDefault;
}