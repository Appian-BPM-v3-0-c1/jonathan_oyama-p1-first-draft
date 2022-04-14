package com.revature.videoGameLand.models;

public class ShoppingCart {
    private int id;
    private int cart_game_id;
    private int customer_id;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, int cart_game_id, int customer_id, int quantity) {
        this.id = id;
        this.cart_game_id = cart_game_id;
        this.customer_id = customer_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart_game_id() {
        return cart_game_id;
    }

    public void setCart_game_id(int cart_game_id) {
        this.cart_game_id = cart_game_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\n\n---------ShoppingCart---------" +
                "\nID: " + id +
                "\nCart game ID: " + cart_game_id +
                "\nCustomer ID: " + customer_id;
    }
}