package com.ggm.example.speldemo.controller;

import com.ggm.example.speldemo.data.City;
import com.ggm.example.speldemo.data.Order;
import com.ggm.example.speldemo.data.Shipping;
import com.ggm.example.speldemo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/order")
@RestController
public class OrderController {

    @Autowired
    private Order order;

    @Autowired
    private User user;

    @Autowired
    private Shipping shipping;

    @Autowired
    private City city;

    @GetMapping(path = "/customer")
    public String getCustomer() {
        return user.getName();
    }

    @GetMapping(path = "/amount")
    public double getOrderAmount() {
        return order.getAmount();
    }

    @GetMapping(path = "/discount")
    public double getDiscount() {
        return order.getDiscount();
    }

    @GetMapping(path = "/origin")
    public String getOrigin() {
        return order.getOrigin();
    }

    @GetMapping(path = "/deliver")
    public int getDaysToDeliver() {
        return order.getDaysToDeliver();
    }

    @GetMapping(path = "/amount/formatted")
    public String getFormattedOrderAmount() {
        return order.getFormattedAmount();
    }


    @GetMapping(path = "/shipping/locations")
    public List<City> getShippingLocations() {
        return order.getShippingLocations();
    }

    @GetMapping(path = "/shipping/locations/noncapital")
    public List<City> getNonCapitalShippingLocations() {
        return order.getNonCapitalShippingLocations();
    }

    @GetMapping(path = "/shipping/locations/western")
    public Map<String, List<City>> getWesternShippingLocations() {
        return order.getWesternShippingLocations();
    }

    @GetMapping(path = "/shipping/locations/cheap")
    public Integer getCheapShippingLocations() {
        return order.getNoOfCheapShippingLocations();
    }

    @GetMapping(path = "/summary")
    public String getOrderSummary() {
        return order.getOrderSummary();
    }

}
