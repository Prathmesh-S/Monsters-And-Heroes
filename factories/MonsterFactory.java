package factories;

import models.Monster;

// An interface responsible for declaring the function to create instances of Monsters.
public interface MonsterFactory  {
    Monster createCharacter();
}