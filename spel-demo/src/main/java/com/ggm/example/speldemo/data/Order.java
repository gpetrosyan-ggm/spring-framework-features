package com.ggm.example.speldemo.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Component("order")
public class Order {

    @Value("#{100.55 + 500.75 + 400.66}")
    private double amount;

    @Value("#{order.amount >= 1000 ? order.amount * 5 / 100 : 0}")
    private double discount;

    @Value("#{user.country == 'US' and user.timeZone == 'America/New_York' ? 3 : 14}")
    private int daysToDeliver;

    @Value("#{user.country}")
    private String origin;

    @Value("#{T(java.text.NumberFormat).getCurrencyInstance().format(order.amount)}")
    private String formattedAmount;

    @Value("#{shipping.locationsByCountry[user.country]}")
    private List<City> shippingLocations;

    @Value("#{order.shippingLocations.?[isCapital != true]}")
    private List<City> nonCapitalShippingLocations;

    @Value("#{shipping.locationsByCountry.?[key == 'UK' or key == 'US' or key == 'DK']}")
    private Map<String, List<City>> westernShippingLocations;

    @Value("#{order.shippingLocations.?[shipping < 10].size()}")
    private Integer noOfCheapShippingLocations;

    @Value("#{user.name} your order total is #{order.formattedAmount} and the payable amount with 5% discount is #{order.amount - order.discount}")
    private String orderSummary;

}
