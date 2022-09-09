package main;

/**
 *
 * @author npc
 */
import data.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static int opsi;
    private static String opsiStr;
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<City> cities = new ArrayList<>();

    public static void main(String[] args){
        boolean loop = true;
        while(loop) {
            System.out.println("===================");
            System.out.println("=== Kelola Data ===");
            System.out.println("===================\n");
            System.out.println("1. Data Restaurant");
            System.out.println("2. Data Menu");
            System.out.println("3. Data City");
            System.out.println("4. Exit\n");
            opsi = inputInt("pilih : ");
            input.nextLine();
            System.out.println();

            switch(opsi) {
                case 1:
                    dataRestaurant();
                    break;
                case 2:
                    dataMenu();
                    break;
                case 3:
                    dataCity();
                    break;
                case 4:
                    loop = false;
                    break;
                default :
                    System.out.println("Pilihan tidak tersedia ulangi lagi");
                    pressEnter();
                    break;
            }
        } 
    }

    private static void dataCity() {
        boolean loop = true;
        while(loop){
            System.out.println("=== Kelola Data City ===\n");
            if(cities.isEmpty()) System.out.println("Daftar City Kosong");
            else System.out.println("Daftar nama City (Jumlah Restaurant) : ");
            for(int i = 0; i < cities.size(); i++) {
                System.out.println(
                    (i + 1) + ". " + cities.get(i).getName() +
                    "(" + cities.get(i).getRestaurantCount() + ")"
                );
            }

            System.out.println(
                "\nOption \n[t] Tambah \n[e] Edit \n[h] Hapus "
                + "\n[x] Kembali ke Menu Utama");
            System.out.print("Pilih : ");
            opsiStr = input.nextLine();
            System.out.println();

            City city;
            String nama;
            int i;

            switch(opsiStr) {
                case "t":
                    System.out.print("Masukkan nama city : ");
                    nama = input.nextLine();
                    city = new City();
                    city.setName(nama);
                    cities.add(city);
                    break;
                case "e":
                    if(cities.isEmpty()) {
                        System.out.println("Data Masih Kosong!");
                        pressEnter();
                    } else {
                        i = inputInt("Pilih City : ");
                        input.nextLine();
                        if(i <= cities.size() && i > 0){
                            System.out.print("Masukkan nama city baru : ");
                            nama = input.nextLine();
                            city = cities.get(i-1);
                            city.setName(nama);
                            cities.set(i-1, city);
                        } else {
                            System.out.println("City tidak Ada!");
                            pressEnter();
                        }
                    }
                    break;
                case "h":
                    if(cities.isEmpty()) {
                        System.out.println("Data Masih Kosong!");
                        pressEnter();
                    } else {
                        i = inputInt("Pilih City : ");
                        input.nextLine();
                        if(i <= cities.size() && i > 0) cities.remove(i-1);
                        else {
                            System.out.println("City tidak Ada!");
                            pressEnter();
                        }
                    }
                    break;
                case "x":
                    loop = false;
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia ulagi lagi");
                    pressEnter();
                    break;
            }
        }
        
    }

    private static void dataRestaurant() {
        boolean loop = true;
        while(loop) {
            System.out.println("=== Kelola Data Restaurant ===\n");
            if(cities.isEmpty()) {
                System.out.println("Daftar City Kosong, Tambahkan City Terlebih dahulu");
                pressEnter();
                loop = false;
            }
            else {
                System.out.println("Daftar nama City (Jumlah Restaurant) : ");
                for(int i = 0; i < cities.size(); i++) {
                    System.out.println(
                        (i+1) + ". " + cities.get(i).getName() +
                        "(" + cities.get(i).getRestaurantCount() + ")"
                    );
                }

                opsi = inputInt("\nPilih City : ") - 1;
                input.nextLine();
                System.out.println();
                
                if(opsi+1 <= cities.size() && opsi+1 > 0){
                    City city = cities.get(opsi);
                    
                    List<Restaurant> restaurants = city.getAllRestaurant();
                    if(restaurants.isEmpty()) System.out.println("Daftar Restaurant Kosong");
                    else System.out.println("Daftar Restaurant (Alamat) : ");
                    for(int i = 0; i < restaurants.size(); i++) {
                        System.out.println(
                                (i+1) + ". " + restaurants.get(i).getName() + 
                                " (" + restaurants.get(i).getAddress() + ")");
                    }

                    System.out.println(
                        "\nOption \n[t] Tambah Restaurant \n[m] Tambah Menu "
                        + "\n[e] Edit \n[h] Hapus \n[x] Kembali ke Menu Utama"
                    );
                    System.out.print("Pilih : ");
                    opsiStr = input.nextLine();
                    System.out.println();

                    String name, address;
                    int price;
                    Restaurant restaurant;
                    Menu menu;

                    switch(opsiStr) {
                        case "t":
                            System.out.print("Masukkan nama restaurant : ");
                            name = input.nextLine();
                            System.out.print("Masukkan alamat restaurant : ");
                            address = input.nextLine();
                            restaurant = new Restaurant();
                            restaurant.setName(name);
                            restaurant.setAddress(address);
                            city.addRestaurant(restaurant);
                            break;
                        case "m":
                            if(restaurants.isEmpty()){
                                System.out.println("Data Masih Kosong!");
                                pressEnter();
                            } else {
                                opsi = inputInt("Pilih Restaurant : ") - 1;
                                input.nextLine();
                                System.out.println();
                                if(opsi+1 <= city.getAllRestaurant().size() & opsi+1 > 0) {
                                    restaurant = city.getAllRestaurant().get(opsi);
                                    System.out.print("Masukkan nama menu : ");
                                    name = input.nextLine();
                                    price = inputInt("Masukkan harga menu : ");
                                    input.nextLine();
                                    menu = new Menu();
                                    menu.setName(name);
                                    menu.setPrice(price);
                                    restaurant.addMenu(menu);
                                }else{
                                    System.out.println("Restaurant Tidak Ada!");
                                    pressEnter();
                                }
                            }

                            break;
                        case "e":
                            if(restaurants.isEmpty()){
                                System.out.println("Data Masih Kosong!");
                                pressEnter();
                            } else {
                                opsi = inputInt("Pilih restaurant : ");
                                input.nextLine();
                                if(opsi <= city.getAllRestaurant().size() & opsi > 0) {
                                    System.out.print("Masukkan nama restaurant baru : ");
                                    name = input.nextLine();
                                    System.out.print("Masukkan alamat restaurant baru : ");
                                    address = input.nextLine();
                                    restaurant = city.getAllRestaurant().get(opsi - 1);
                                    restaurant.setName(name);
                                    restaurant.setAddress(address);
                                    city.updateRestaurant(opsi-1, restaurant);
                                }else{
                                    System.out.println("Restaurant Tidak Ada!");
                                    pressEnter();
                                }
                            }
                            break;
                        case "h":
                            if(restaurants.isEmpty()){
                                System.out.println("Data Masih Kosong!");
                                pressEnter();
                            } else {
                                opsi = inputInt("Pilih restaurant : ");
                                if(opsi <= city.getAllRestaurant().size() & opsi > 0) {
                                    city.deleteRestaurant(opsi-1);
                                }else{
                                    System.out.println("Restaurant Tidak Ada!");
                                    pressEnter();
                                }
                            }
                            break;
                        case "x":
                            loop = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak tersedia ulagi lagi");
                            pressEnter();
                            break;
                    }
                } else {
                    System.out.println("City tidak Ada!");
                    pressEnter();
                }
            }
        }
    }

    public static void dataMenu() {
        boolean loop = true;
        while(loop) {
            System.out.println("=== Kelola Data Menu ===\n");
            if(cities.isEmpty()) {
                System.out.println("Daftar City Kosong, Tambahkan City Terlebih dahulu");
                pressEnter();
                loop = false;
            }
            else {
                System.out.println("Daftar nama City (Jumlah Restaurant) : ");
                for(int i = 0; i < cities.size(); i++) {
                    System.out.println(
                        (i+1) + ". " + cities.get(i).getName() +
                        "(" + cities.get(i).getRestaurantCount() + ")"
                    );
                }
                
                opsi = inputInt("\nPilih City : ") - 1;
                input.nextLine();
                System.out.println();
                
                if(opsi+1 <= cities.size() && opsi+1 > 0) {
                    City city = cities.get(opsi);
                    
                    List<Restaurant> restaurants = city.getAllRestaurant();
                    if(restaurants.isEmpty()) {
                        System.out.println("Daftar Restaurant Kosong, Tambahkan Restaurant Terlebih dahulu");
                        pressEnter();
                        loop = false;
                    } else {
                        System.out.println("Daftar Restaurant (Alamat) : ");
                        for(int i = 0; i < restaurants.size(); i++) {
                            System.out.println(
                                (i+1) + ". " + restaurants.get(i).getName() + 
                                " (" + restaurants.get(i).getAddress() + ")"
                            );
                        }

                        opsi = inputInt("\nPilih Restaurant : ") - 1;
                        input.nextLine();
                        System.out.println();

                        if(opsi+1 <= city.getAllRestaurant().size() && opsi+1 > 0) {
                            Restaurant restaurant = city.getAllRestaurant().get(opsi);

                            List<Menu> menus = restaurant.getAllMenu();
                            if(menus.isEmpty()) System.out.println("Daftar Menu Kosong");
                            else System.out.println("Daftar Menu (Harga): ");
                            for(int i = 0; i < menus.size(); i++) {
                                System.out.println(
                                    (i+1) + ". " + menus.get(i).getName() 
                                    + " (Rp " + menus.get(i).getPrice() + ")"
                                );
                            }

                            System.out.println(
                                "\nOption \n[t] Tambah \n[e] Edit \n[h] Hapus "
                                + "\n[x] Kembali ke Menu Utama"
                            );
                            System.out.print("Pilih : ");
                            opsiStr = input.nextLine();
                            System.out.println();

                            String name;
                            int price;
                            Menu menu;

                            switch(opsiStr) {
                                case "t":
                                   System.out.print("Masukkan nama menu : ");
                                   name = input.nextLine();
                                   price = inputInt("Masukkan harga menu : ");
                                   input.nextLine();
                                   menu = new Menu();
                                   menu.setName(name);
                                   menu.setPrice(price);
                                   restaurant.addMenu(menu);
                                   break;
                                case "e":
                                    if(menus.isEmpty()){
                                        System.out.println("Data Masih Kosong!");
                                        pressEnter();
                                    } else {
                                        opsi = inputInt("Pilih menu : ");
                                        input.nextLine();
                                        if(opsi <= restaurant.getAllMenu().size() & opsi > 0) {
                                            System.out.print("Masukkan nama menu baru : ");
                                            name = input.nextLine();
                                            price = inputInt("Masukkan harga menu baru : ");
                                            input.nextLine();
                                            menu = restaurant.getAllMenu().get(opsi - 1);
                                            menu.setName(name);
                                            menu.setPrice(price);
                                            restaurant.updateMenu(opsi-1, menu);
                                        }else{
                                            System.out.println("Menu Tidak Ada!");
                                            pressEnter();
                                        }   
                                    }
                                   break;
                                case "h":
                                    opsi = inputInt("Pilih menu : ");
                                    if(opsi <= restaurant.getAllMenu().size() & opsi > 0) {
                                        restaurant.deleteMenu(opsi-1);
                                    } else {
                                        System.out.println("Menu Tidak Ada!");
                                        pressEnter();
                                    }
                                    break;
                                case "x":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("Pilihan tidak tersedia ulagi lagi");
                                    pressEnter();
                                    break;
                            }
                        } else {
                            System.out.println("Restaurant tidak Ada!");
                            pressEnter();
                        }
                    }
                } else {
                    System.out.println("City tidak Ada!");
                    pressEnter();
                }
            }
        }
    }

    public static int inputInt(String text){
        int temp = 0;
        boolean error = true;
        while(error) {
            try {
                System.out.print(text);
                temp = Integer.parseInt(input.next());
                error = false;
            } catch (NumberFormatException e) {
                System.out.println("Input salah coba lagi\n");
            } 
        }
        return temp;
    }
    
    public static void pressEnter(){
        System.out.print("Tekan Enter untuk melanjutkan");
        input.nextLine();
        System.out.println();
    }
}