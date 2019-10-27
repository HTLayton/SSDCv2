package com.example.gorgeous.pomeranian.dto;

import lombok.Getter;

@Getter
public class PurchaseDto {
    private InventoryDto[] items;
    private double orderTotal;
    private String username;
    private String address;
    public String toHTMLString(){
        String temp = "<h1>Thank you for your purchase</h1><table><tr><th>Name</th><th>Quantity</th>";
        for (InventoryDto item : items) {
            temp += item.toHTMLString();
        }
        temp += "</table><h3>Total cost: $" + orderTotal + "</h3>";
        temp += "<p>Delivery to: " + address + " for user: " + username + "</p>";
        return temp;
    }
}
