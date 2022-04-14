package com.revature.videoGameLand.ui;

import com.revature.videoGameLand.models.Customer;
import com.revature.videoGameLand.models.VideoGame;
import com.revature.videoGameLand.services.ShoppingCartService;
import com.revature.videoGameLand.services.VideoGameService;

import java.util.List;
import java.util.Scanner;

public class VideoGameMenu implements IMenu {
    private final Customer customer;
    private final VideoGameService videoGameService;

    public VideoGameMenu(Customer customer, VideoGameService videoGameService) {
        this.customer = customer;
        this.videoGameService = videoGameService;
    }

    //CrudDAO<VideoGame> crudDAO = new VideoGameDAO();
    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to Video Game Section, " + customer.getUserName() + "!");
            System.out.println("[1] View all video games");
            // Optional video game creation code
            /*if (customer.isManager()) {
                System.out.println("[3] Create new video game");
            }*/
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);
            switch (input) {
                case '1':
                    viewAllVideoGames();
                    break;
                case '2':
                    break;
                //case '3':
                    // Optional video game creation code
                    /*if (customer.isManager()) {
                        createGame();
                    } else {
                        System.out.println("\nCannot add new games to the database.");
                        System.out.println("\nOnly managers are allowed to add game inventory!");
                    }*/
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }

    }
    private void createGame() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        VideoGame game = new VideoGame();

        while (!exit) {
            System.out.print("\nEnter in name of new game: ");
            game.setName(scan.nextLine().toLowerCase());
            scan = new Scanner(System.in);

            System.out.print("\nEnter in amount of game in stock: ");
            game.setStock(scan.nextInt());
            scan.nextLine();

            System.out.print("\nEnter in price of new game: ");
            game.setPrice(scan.nextFloat());
            scan.nextLine();

            System.out.println("\nEnter in console version of the game: ");
            game.setConsoleVersion(scan.nextLine().toLowerCase());
            scan = new Scanner(System.in);

            System.out.println("\nEnter in ID number of the store holding the game: ");
            game.setDept_id(scan.nextInt());

            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)");
                System.out.println(game);

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        videoGameService.getVideoGameDAO().save(game);
                        //crudDAO.save(game);
                        System.out.println("Video game created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }

            }

        }
    }

    private void viewAllVideoGames() {
        int input;
        char yesno = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);

        // former place for videoGameList = crudDAO.findAll()
        List<VideoGame> videoGameList = videoGameService.getVideoGameDAO().findAll();
        //List<VideoGame> videoGameList = crudDAO.findAll();
        System.out.println();
        if (videoGameList.isEmpty()) {
            System.out.println("No video games in database.");
        }
        else {
            while (!exit) {
                System.out.println("\n=======================================================");
                for (int i = 0; i < videoGameList.size(); i++) {
                    System.out.println("\n[" + (i + 1) + "] " + videoGameList.get(i).getName());
                }
                System.out.println("\nType a video game index number to view amount in stock");
                System.out.println("\n[0] Exit");
                input = scan.nextInt();
                scan.nextLine();
                if (((input - 1) >= videoGameList.size()) || (input - 1) < -1) {
                    System.out.println("Invalid input.");
                } else {
                    if ((input - 1) == -1) {
                        exit = true;
                    } else {
                        while (!confirm) {
                            System.out.println(videoGameList.get(input - 1));
                            System.out.println("\nAdd to shopping cart?");
                            System.out.println("[y]: Yes");
                            System.out.println("[n]: No");
                            System.out.println("Enter in y or n:");
                            yesno = scan.next().charAt(0);
                            if (yesno == 'y') {

                                confirm = true;

                            }
                            else if (yesno == 'n') {
                                confirm = true;
                            }
                            else {
                                System.out.println("\nInvalid input.");
                            }
                        }
                        confirm = false;
                    }
                }
            }
        }
    }
}
