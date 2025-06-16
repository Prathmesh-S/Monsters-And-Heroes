package factories;

import models.Item;

//This interface lays the common functionality for all item factories
public interface ItemFactory {
    Item createItem();
}
