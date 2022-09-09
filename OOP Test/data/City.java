package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author npc
 */
public class City {
   private final ArrayList<Restaurant> restaurants = new ArrayList<>();
   private String name; 
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
    public void addRestaurant(Restaurant restaurant) {
      restaurants.add(restaurant);
   }
   
   public int getRestaurantCount() {
      return restaurants.size();
   }
   
   public void deleteRestaurant(int index) {
      restaurants.remove(index);
   }
   
   public void updateRestaurant(int index, Restaurant restaurant) {
      restaurants.set(index, restaurant);
   }
   
   public List<Restaurant> getAllRestaurant() {
      return restaurants;
   }
}
