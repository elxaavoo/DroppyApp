package es.ieslavereda.droppyapp.Utils;

import java.util.UUID;

public class Generator {
    public static String generateImageName(){
        String uniqueID = UUID.randomUUID().toString();
        return "image_" + uniqueID + ".txt";
    }
    public static String generateClothId(){
        String uniqueID = UUID.randomUUID().toString();
        return "cloth_" + uniqueID;
    }
    public static String generateBasketId(){
        String uniqueID = UUID.randomUUID().toString();
        return "basket_" + uniqueID;
    }
    public static String generateBrandId(){
        String uniqueID = UUID.randomUUID().toString();
        return "brand" + uniqueID;
    }
    public static String generateCategoryId(){
        String uniqueID = UUID.randomUUID().toString();
        return "category" + uniqueID;
    }
    public static String generateDiscountId(){
        String uniqueID = UUID.randomUUID().toString();
        return "discount" + uniqueID;
    }
    public static String generateDropId(){
        String uniqueID = UUID.randomUUID().toString();
        return "drop" + uniqueID;
    }
    public static String generatePostId(){
        String uniqueID = UUID.randomUUID().toString();
        return "post" + uniqueID;
    }

}
