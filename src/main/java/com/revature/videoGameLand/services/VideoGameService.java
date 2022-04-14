package com.revature.videoGameLand.services;

import com.revature.videoGameLand.daos.VideoGameDAO;
import com.revature.videoGameLand.daos.ShoppingCartDAO;
import com.revature.videoGameLand.models.ShoppingCart;

import java.util.List;
//import com.revature.videoGameLand.models.VideoGame;

//import java.util.List;

public class VideoGameService {
    private final VideoGameDAO videoGameDAO;

    public VideoGameService(VideoGameDAO videoGameDAO) {
        this.videoGameDAO = videoGameDAO;
    }

    public VideoGameDAO getVideoGameDAO() {
        return videoGameDAO;
    }
}
