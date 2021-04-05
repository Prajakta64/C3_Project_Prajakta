//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class RestaurantTest {
    LocalTime openingTime = LocalTime.of(10,30,00);
    LocalTime closingTime = LocalTime.of(22,00,00);
    Restaurant restaurant = new Restaurant("Amelie's cafe", "Chennai", this.openingTime, this.closingTime);

    RestaurantTest() {
    }

    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time() {
        Restaurant restaurant1 =Mockito.spy(restaurant);
        LocalTime currentTime1 = LocalTime.of(18,00,00);
        //Mockito.when(restaurant1.getCurrentTime()).thenReturn(currentTime1);
        Mockito.doReturn(currentTime1).when(restaurant1).getCurrentTime();
        boolean status=restaurant1.isRestaurantOpen();
        Assertions.assertTrue(status);

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time() {
        Restaurant restaurant1 =Mockito.spy(restaurant);
        LocalTime currentTime1 = LocalTime.of(23,00,00);
        //Mockito.when(restaurant1.getCurrentTime()).thenReturn(currentTime1);
        Mockito.doReturn(currentTime1).when(restaurant1).getCurrentTime();
        boolean status=restaurant1.isRestaurantOpen();
        Assertions.assertFalse(status);
    }

    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1() {
        this.restaurant = new Restaurant("Amelie's cafe", "Chennai", this.openingTime, this.closingTime);
        this.restaurant.addToMenu("Sweet corn soup", 119);
        this.restaurant.addToMenu("Vegetable lasagne", 269);
        int initialMenuSize = this.restaurant.getMenu().size();
        this.restaurant.addToMenu("Sizzling brownie", 319);
        Assertions.assertEquals(initialMenuSize + 1, this.restaurant.getMenu().size());
    }

    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        this.restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        this.restaurant.addToMenu("Sweet corn soup", 119);
        this.restaurant.addToMenu("Vegetable lasagne", 269);
        int initialMenuSize = this.restaurant.getMenu().size();
        this.restaurant.removeFromMenu("Vegetable lasagne");
        Assertions.assertEquals(initialMenuSize - 1, this.restaurant.getMenu().size());
    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        this.restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        this.restaurant.addToMenu("Sweet corn soup", 119);
        this.restaurant.addToMenu("Vegetable lasagne", 269);
        Assertions.assertThrows(itemNotFoundException.class, () -> {
            this.restaurant.removeFromMenu("French fries");
        });
    }
    @Test
    public void get_total_cost_of_2_items_is_200(){
        int total=restaurant.getTotal("Biryani","Chole");
        Assertions.assertEquals(200,total);
    }
}
