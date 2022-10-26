package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsAdditionDecorator extends AbstractPizzaOrderDecorator{

    public MushroomsAdditionDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(3));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+"/d Additional Mushrooms";
    }
}
