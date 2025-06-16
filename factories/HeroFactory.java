package factories;

import models.Hero;

//An interface responsible for declaring the function to create instances of Hero.
public interface HeroFactory  {
    Hero createCharacter();
}