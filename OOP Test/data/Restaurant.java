package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author npc
 */
public class Restaurant {
   private final ArrayList<Menu> menus = new ArrayList<>();
   private String name, address; 
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String address) {
      this.address = address;
   }
   
   public void addMenu(Menu menu) {
      menus.add(menu);
   }
   
   public int getMenuCount() {
      return menus.size();
   }

   public void deleteMenu(int index) {
      menus.remove(index);
   }
   
   public void updateMenu(int index, Menu menu) {
      menus.set(index, menu);
   }
   
   public List<Menu> getAllMenu() {
      return menus;
   }
}
