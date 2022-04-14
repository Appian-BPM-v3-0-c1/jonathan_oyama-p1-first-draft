package com.revature.videoGameLand.daos;

import com.revature.videoGameLand.connection.DatabaseConnection;
import com.revature.videoGameLand.models.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO implements CrudDAO<ShoppingCart> {
    Connection con = DatabaseConnection.getCon();
    @Override
    public int save(ShoppingCart newObj) {
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO shopping_cart " +
                    "(cart_game_id, customer_id, quantity) VALUES " +
                    "(?, ?, ?)");
            ps.setInt(1, newObj.getCart_game_id());
            ps.setInt(2, newObj.getCustomer_id());
            ps.setInt(3, newObj.getQuantity());

            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> shoppingCartList = new ArrayList<>();

        try {PreparedStatement ps = con.prepareStatement("SELECT * FROM shopping_cart");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ShoppingCart shoppingCart = new ShoppingCart();

                shoppingCart.setId(rs.getInt("id"));
                shoppingCart.setCart_game_id(rs.getInt("cart_game_id"));
                shoppingCart.setCustomer_id(rs.getInt("customer_id"));
                shoppingCart.setQuantity(rs.getInt("quantity"));

                shoppingCartList.add(shoppingCart);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppingCartList;
    }

    @Override
    public ShoppingCart findById(String Id) {
        return null;
    }

    @Override
    public boolean update(ShoppingCart updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String Id) {
        return false;
    }
}
