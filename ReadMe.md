# CS611-Assignment 4
## Monsters & Heroes
---------------------------------------------------------------------------
- Name: Prathmesh Sonawane
- Email: prsona@bu.edu
- Student ID: U39215370

## Files
---------------------------------------------------------------------------

**Main.java**: This class is responsible for simply creating a gameController object and starting it.

**GameController.java**: This class allows us to collect user information, like names, and allows users to choose and start a specific game (Monster and Heroes) and then choose and start other games (Order and Chaos) once they finish their prior game.

**BoardGame.java**: This class serves as a superclass to more specific types of games, like Monster and Chaos, and holds the state of a board game like the actual board, players, and other state.

**BoardPiece.java**: This class is responsible for being the building block (or tile) of a board game and houses information specific to each piece such as ID and gamePiece currently on it, if applicable. 

**GamePiece.java**: This class is responsible for the actual game pieces put on our game board, such as Xs, Os, or Pawns. These pieces are put on BoardPieces (the above class). 

**Player.java**: This class is responsible for creating players for the board game and houses information specific to each player.

**Team.java**: This class is responsible for adding players to teams and stores relevant information about each team. This class is also responsible for allowing chosen players from each team to be different during new rounds of a game.

**Armor.java**: Concrete Class representing a piece of armour.

**ArmorFactory.java**: A Factory that creates random pieces of armor!

**AttackStrategy.java**: Responsible for the Attack Battle Strategy A Hero inflicts on a Monster.

**Battle.java:** This class is responsible for managing the battle sequence between heroes and monsters and handling each round of combat.

**BattleStrategy.java**: Defines an interface that all battle strategies must implement.

**Dragon.java**: Concrete Class to create a dragon

**DragonFactory.java**: A factory class responsible for creating instances of the Dragon monster.

**EquipStrategy.java**: A class responsible for handling the Equip Item strategy in battle, allowing heroes to equip items during their turn.

**Exoskeleton.java**: Concrete Class to create an Exoskeleton

**ExoskeletonFactory.java**: A factory class responsible for creating instances of the Exoskeleton monster.

**Hero.java**: This abstract class is responsible for helping creat any Hero for our HeroesAndMonsters Game through subclasses.

**HeroFactory.java**: An interface responsible for declaring the function to create instances of Hero.

**HeroFactoryManager.java**: A manager class responsible for overseeing and managing the creation and handling of multiple Hero instances.

**Item.java**: A base class for items that can be used by characters, such as weapons, armor, or potions.

**ItemFactory.java**: An interface responsible for declaring the function to create instances of items.

**MarketBoardTile.java**: This class extends BoardPiece and represents a merchant board piece. In addition to capturing BoardPiece state, this clas includes merchant state as well.

**Monster.java**: This class is responsible for helping create any Monster for our HeroesAndMonsters Game through subclasses.

**MonsterFactory.java**: An interface responsible for declaring the function to create instances of Monsters.

**MonsterFactoryManager.java**: A manager class responsible for overseeing and managing the creation and handling of multiple Monsters instances.

**MonstersAndHeroes.java**: The main class that starts a Heroes and Monsters Game, managing gameplay elements and interactions between Heroes and Monsters.

**MonstersAndHeroesPlayer.java**: This class is responsible for creating players for the board game MonstersAndHeroes and houses information specific to each player for that game, such as the player's location.

**Paladin.java**: A concrete class representing a Paladin hero type with unique abilities and attributes.

**PaladinFactory.java**: A factory class responsible for creating instances of Paladin

**Potion.java**: A concrete class representing a consumable potion that can affect a character’s attributes, like health or mana.

**PotionFactory.java**: A factory class responsible for creating instances of Potion with randomized effects.

**PotionStrategy.java**: A class responsible for handling the Use Potion strategy in battle, allowing heroes to consume potions to restore health or other attributes.

**ScannerSingleton.java**: A singleton class that manages a single instance of Scanner to handle user input throughout the program.

**Sorcerer.java**: A concrete class representing a Sorcerer hero type with magical abilities.

**SorcererFactory.java**: A factory class responsible for creating instances of Sorcerer.

**Spell.java**: A class representing magical spells that heroes can cast, with different types and effects.

**SpellFactory.java**: A factory class responsible for creating instances of Spell, managing the different types of spells like fire, ice, and lightning.

**SpellStrategy.java**: A class responsible for handling the Cast Spell strategy in battle, allowing heroes to use magical attacks against monsters.

**Spirit.java**: A concrete class representing a spirit-type monster with unique attributes and behaviors.

**SpiritFactory.java**: A factory class responsible for creating instances of Spirit with randomized attributes.

**Util.java**: A utility class providing helper functions and common methods that can be used across various classes, like accepting strings from files.

**Warrior.java**: A concrete class representing a Warrior hero. 

**WarriorFactory.java**: A factory class responsible for creating instances of Warrior.

**Weapon.java**: Concrete Class representing a weapon.

**WeaponFactory.java**: Concrete Factory creating a Weapon

**Inventory.java**: A class to represent an inventory of a given hero which contains objects of type item. 

**Legends of Valor**: The main class that starts a Legends of Valor Game, managing gameplay elements and interactions between Heroes and Monsters within the game.

## Notes (Design Decisions/Cool Features!)
---------------------------------------------------------------------------

### New Design Decisions:

1. (Factory Pattern) In Monsters and Heroes, I used the Factory pattern to manage the creation of different character and monster types. By implementing a HeroFactory and MonsterFactory, each class is responsible for creating specific types of entities with appropriate stats and abilities. This choice simplifies adding new types of characters or monsters, as we only need to adjust the factory without changing other parts of the code. This approach reduces redundancy in the instantiation process and promotes scalability, allowing the game to introduce new characters or monster variations seamlessly. 
<br>
<br>
2. (Strategy Pattern) In Monsters and Heroes, I used the Strategy pattern to handle the different actions a heroes might perform, specifically Attack, Equip, Spell, and Potion actions. By defining each action as a separate strategy, I allowed characters to dynamically select and execute behaviors based on the current context, such as using a specific spell or equipping new armor. This pattern helps keep the code flexible and modular, as each action is encapsulated in its own strategy class, making it easy to add new actions or modify existing ones without impacting the core character logic. Overall, the Strategy pattern enhances reusability and adaptability, allowing for a more varied and dynamic gameplay experience.
   <br>
   <br>
3. (Singleton Pattern) In my Monsters and Heroes game, I implemented a singleton scanner pattern (SingletonScanner.java) to handle user input consistently throughout the game. By creating a single instance of the Scanner class and using it globally within the game, I ensured that input handling is streamlined and centralized. This pattern eliminates the need for multiple Scanner instances, preventing potential issues such as resource leaks or inconsistent input handling. Additionally, it enhances performance by reusing the same object, reducing overhead. The singleton scanner approach also makes the code more maintainable, as all user input logic is tied to a single point, making it easier to modify or extend in the future.
<br>
<br>
4. In my project, I designed nearly 40 classes, each following the Single Responsibility Principle (SRP) to ensure that every class has one clear responsibility. This approach not only made the codebase more organized and modular but also greatly enhanced its maintainability and scalability. For example, classes like GameController are dedicated solely to managing the flow of the game, while classes such as BoardPiece and Player focus on their specific aspects, like representing tiles and players respectively. By adhering to SRP, I ensured that each class could be easily understood, tested, and modified without affecting others. This separation of concerns allowed for better collaboration and quicker debugging, as changes in one part of the game wouldn't risk breaking unrelated functionality. Furthermore, this structure made it easier to extend the game in the future, whether adding new features or creating new game modes.

### Cool Features:

1. My Heroes and Monsters board size is scalable! You can have size of 5x5 or even 9x9!
   <br>
   <br>
2. The number of heroes a user chooses is also scalable! A user can choose to play with one hero or even 3!
   <br>
   <br>
3. During many states of the game, you will see color output. This has been used to make the sections of the game (Ex. Battle vs Market) more clear.
   <br>
   <br>
4. As I was (falsely) anticipating the idea of an extension project involving teams, I created a Team class that would be easily used for my Heroes and Monsters game later on. 

## How to compile and run
---------------------------------------------------------------------------

1. Navigate to the directory "/MonstersAndHeroes/src" after unzipping the files
2. Run the following instructions:
   javac *.java
   java Main

3. Note: If this does not work, just run the main() in Main.java. 

## Input/Output Example
---------------------------------------------------------------------------
```
OUTPUT:
Welcome to our digital arcade! If at any time you would like to quit, please type and enter "quit" when prompted to enter a string. 
Please enter the number of players playing: 
1
Enter the name of player 1: 
Prathmesh

Here is a list of playable games: 
0 : Monsters And Heroes (Single-Player)
Please type the integer associated with the game you would like to play!
0

Welcome to Legends: Monsters and Heroes! The game board is a square grid of three types of tiles: common spaces, market tiles, and inaccessible spaces.
Common spaces are empty and serve as areas where battles with monsters may occur.
Market tiles, marked with a blue 'M,' allow heroes to buy and sell items to aid them in battle.
Inaccessible spaces, marked with a red 'X,' cannot be entered by heroes.

Heroes move across the board to fight monsters, gather gold, and gain experience.
When heroes enter a common space, there's a chance of encountering monsters.
Battles are turn-based, where heroes can attack, cast spells, use items, or equip new gear.
Each hero has unique stats that influence their actions, and heroes gain experience to level up and strengthen their skills.

The objective of the game is to defeat monsters, level up, and survive the challenges of the world.
Enjoy the adventure and aim to make your heroes as powerful as possible!


Please type the size of the board you would like to play on from [5,10] inclusive (Ex. 3): 
8

Please type the number of heroes you would like to play with from [1,3] inclusive (Ex. 3): 
3
**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     1200       6          5                    100        660        500        440        2500                                    
Warrior    Undefeated_Yoj       800        4          7                    400        880        440        700        2500                                    
Warrior    Eunoia_Cyn           600        3          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
1      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
2      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Breastplate        Armor      350.0      175.0         3                                 600                               5                                     
1      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
2      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

[YOU] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

s

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[YOU] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

m
Attempting to enter a market.


Welcome to the Market! Below are things you can buy!


Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
2      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
3      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
4      Magic_Potion       Potion     350.0      175.0         2                                                   100             1                 Mana                
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Garl_Glittergold?

Please type (y/n)

y

Please select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.

1

You have bought the item! Here is the updated Market!:

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
2      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
3      Magic_Potion       Potion     350.0      175.0         2                                                   100             1                 Mana                
********************************************************************************************************************************************************************************

Please select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.

-1





Time to sell!

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     1200       6          5                    100        660        500        440        2250                                    
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
1      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
2      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
3      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
********************************************************************************************************************************************************************************

Next, would you like to sell any of Garl_Glittergold's items?

Please type (y/n)

n

Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
2      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
3      Magic_Potion       Potion     350.0      175.0         2                                                   100             1                 Mana                
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Undefeated_Yoj?

Please type (y/n)

n





Time to sell!

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Undefeated_Yoj       800        4          7                    400        880        440        700        2500                                    
***********************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************

Next, would you like to sell any of Undefeated_Yoj's items?

Please type (y/n)

n

Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
2      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
3      Magic_Potion       Potion     350.0      175.0         2                                                   100             1                 Mana                
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Eunoia_Cyn?

Please type (y/n)

n





Time to sell!

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Eunoia_Cyn           600        3          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Breastplate        Armor      350.0      175.0         3                                 600                               5                                     
1      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
2      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Next, would you like to sell any of Eunoia_Cyn's items?

Please type (y/n)

n


 Now leaving the market!


[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[YOU] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

e
Garl_Glittergold's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

y

Please select the index of a weapon from the table to equip it or type -1 to stop or -2 for hero information.

0

Would you like to Equip your chosen one-handed weapon in both hands of the hero?

Please type (y/n)

y

Weapon has been Equipped!
No more Weapons to look at!

Garl_Glittergold's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
Garl_Glittergold's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

y

Please select the index of an armor from the table to equip it or type -1 to stop or -2 for hero information.

0
Garl_Glittergold has equipped Platinum_Shield as their armor.
No more Armor to look at!

Garl_Glittergold's Equipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to unequip your armor?

Please type (y/n)

n
Undefeated_Yoj's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Undefeated_Yoj's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

n
No more Armor to look at!

Eunoia_Cyn's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Eunoia_Cyn's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Breastplate        Armor      350.0      175.0         3                                 600                               5                                     
1      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

y

Please select the index of an armor from the table to equip it or type -1 to stop or -2 for hero information.

0
Eunoia_Cyn has equipped Breastplate as their armor.
Eunoia_Cyn's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

n
No more Armor to look at!

Eunoia_Cyn's Equipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Breastplate        Armor      350.0      175.0         3                                 600                               5                                     
********************************************************************************************************************************************************************************

Would you like to unequip your armor?

Please type (y/n)

n

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[YOU] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

d

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [YOU] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

m
Attempting to enter a market.


Welcome to the Market! Below are things you can buy!


Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
1      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
2      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
3      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
4      Snow_Cannon        Spell      500.0      250.0         2                                                   650             1                 Ice                 
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Garl_Glittergold?

Please type (y/n)

n





Time to sell!

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     1200       6          5                    100        660        500        440        2250  Dagger     Dagger     Platinum_Shield
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
1      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
********************************************************************************************************************************************************************************

Next, would you like to sell any of Garl_Glittergold's items?

Please type (y/n)

n

Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
1      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
2      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
3      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
4      Snow_Cannon        Spell      500.0      250.0         2                                                   650             1                 Ice                 
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Undefeated_Yoj?

Please type (y/n)

y

Please select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.

0

You have bought the item! Here is the updated Market!:

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
2      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
3      Snow_Cannon        Spell      500.0      250.0         2                                                   650             1                 Ice                 
********************************************************************************************************************************************************************************

Please select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.

-1





Time to sell!

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Undefeated_Yoj       800        4          7                    400        880        440        700        2000                                    
***********************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
3      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
********************************************************************************************************************************************************************************

Next, would you like to sell any of Undefeated_Yoj's items?

Please type (y/n)

n

Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
2      Arctic_Storm       Spell      700.0      350.0         6                                                   800             1                 Ice                 
3      Snow_Cannon        Spell      500.0      250.0         2                                                   650             1                 Ice                 
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Eunoia_Cyn?

Please type (y/n)

n





Time to sell!

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Eunoia_Cyn           600        3          6                    400        770        880        600        2500                        Breastplate 
***********************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
1      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Next, would you like to sell any of Eunoia_Cyn's items?

Please type (y/n)

n


 Now leaving the market!


[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [YOU] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

e
No more Weapons to look at!

Garl_Glittergold's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
No more Armor to look at!

Garl_Glittergold's Equipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to unequip your armor?

Please type (y/n)

n
Undefeated_Yoj's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

y

Please select the index of a weapon from the table to equip it or type -1 to stop or -2 for hero information.

1

Would you like to Equip your chosen one-handed weapon in both hands of the hero?

Please type (y/n)

y

Weapon has been Equipped!
Undefeated_Yoj's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Undefeated_Yoj's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
Undefeated_Yoj's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

n
No more Armor to look at!

Eunoia_Cyn's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

m
Please enter a valid response (y/n)
n
No more Weapons to look at!

Eunoia_Cyn's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

y

Please select the index of an armor from the table to equip it or type -1 to stop or -2 for hero information.

0
Eunoia_Cyn has equipped Platinum_Shield as their armor.
No more Armor to look at!

Eunoia_Cyn's Equipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Platinum_Shield    Armor      150.0      75.0          1                                 200                               5                                     
********************************************************************************************************************************************************************************

Would you like to unequip your armor?

Please type (y/n)

n

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [YOU] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

s

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [YOU] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

d

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [YOU] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

s

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [YOU] [   ] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

d

A fierce battle has begun! Heroes are facing off against monsters...

Garl_Glittergold (Hero) vs Igneel (Monster)

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
i

Here is some information about your match-up:

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     1200       6          5                    100        660        500        440        2250  Dagger     Dagger     Platinum_Shield
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
1      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
********************************************************************************************************************************************************************************
***************************************************************Monster Information*********************************************************************
Type            Name                 HP              Level           Base Damage     Defense         Dodge Ability  
Dragon          Igneel               1200            6               660             400             60             
*******************************************************************************************************************************************************

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your hero Garl_Glittergold did 400.0 damage to monster Igneel's defence!


Your hero Garl_Glittergold did 560.0 damage to monster Igneel's HP!

-----------------------------------------------------------------------------------------

----------------------------------Monster's Turn--------------------------------------------
The monster Igneel did 200 damage to hero Garl_Glittergold's armor!


The monster Igneel did 460.0 damage to hero Garl_Glittergold's HP!


Your armour has broke and will no longer be usable next round!

--------------------------------------------------------------------------------------------

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your hero Garl_Glittergold did 0.0 damage to monster Igneel's defence!


Your hero Garl_Glittergold did 960.0 damage to monster Igneel's HP!


The Monster has been defeated as it has lost all of its HP!

-----------------------------------------------------------------------------------------
Garl_Glittergold (Hero) vs Rakkshasass (Monster)

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
i

Here is some information about your match-up:

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     740        6          5                    100        660        500        440        2250  Dagger     Dagger                 
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
1      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
********************************************************************************************************************************************************************************
***************************************************************Monster Information*********************************************************************
Type            Name                 HP              Level           Base Damage     Defense         Dodge Ability  
Spirit          Rakkshasass          1800            4               550             600             38             
*******************************************************************************************************************************************************

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your main weapon has broke and will no longer be usable next round!


Your hero Garl_Glittergold did 600.0 damage to monster Rakkshasass's defence!


Your hero Garl_Glittergold did 360.0 damage to monster Rakkshasass's HP!

-----------------------------------------------------------------------------------------

----------------------------------Monster's Turn--------------------------------------------
The monster Rakkshasass did 550.0 damage to hero Garl_Glittergold's HP!

--------------------------------------------------------------------------------------------

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
i

Here is some information about your match-up:

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     190        6          5                    100        660        500        440        2250                                    
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
1      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
********************************************************************************************************************************************************************************
***************************************************************Monster Information*********************************************************************
Type            Name                 HP              Level           Base Damage     Defense         Dodge Ability  
Spirit          Rakkshasass          1440            4               550             0               38             
*******************************************************************************************************************************************************

--------------------------------------------------------------
Choose an action for Garl_Glittergold:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your hero Garl_Glittergold had no equipped weapon! They just stared at the monster!

-----------------------------------------------------------------------------------------

----------------------------------Monster's Turn--------------------------------------------
The monster Rakkshasass did 550.0 damage to hero Garl_Glittergold's HP!


The Hero has fainted as it has lost all of its HP!

--------------------------------------------------------------------------------------------
Undefeated_Yoj (Hero) vs Rakkshasass (Monster)

--------------------------------------------------------------
Choose an action for Undefeated_Yoj:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
i

Here is some information about your match-up:

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Undefeated_Yoj       800        4          7                    400        880        440        700        2000  Sword      Sword                  
***********************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************
***************************************************************Monster Information*********************************************************************
Type            Name                 HP              Level           Base Damage     Defense         Dodge Ability  
Spirit          Rakkshasass          1440            4               550             0               38             
*******************************************************************************************************************************************************

--------------------------------------------------------------
Choose an action for Undefeated_Yoj:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your hero Undefeated_Yoj did 0.0 damage to monster Rakkshasass's defence!


Your hero Undefeated_Yoj did 1840.0 damage to monster Rakkshasass's HP!


The Monster has been defeated as it has lost all of its HP!

-----------------------------------------------------------------------------------------
Undefeated_Yoj (Hero) vs Phaarthurnax (Monster)

--------------------------------------------------------------
Choose an action for Undefeated_Yoj:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
i

Here is some information about your match-up:

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Undefeated_Yoj       800        4          7                    400        880        440        700        2000  Sword      Sword                  
***********************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************
***************************************************************Monster Information*********************************************************************
Type            Name                 HP              Level           Base Damage     Defense         Dodge Ability  
Dragon          Phaarthurnax         1200            3               660             700             60             
*******************************************************************************************************************************************************

--------------------------------------------------------------
Choose an action for Undefeated_Yoj:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your hero Undefeated_Yoj did 700.0 damage to monster Phaarthurnax's defence!


Your hero Undefeated_Yoj did 1140.0 damage to monster Phaarthurnax's HP!

-----------------------------------------------------------------------------------------

----------------------------------Monster's Turn--------------------------------------------
The monster Phaarthurnax did 660.0 damage to hero Undefeated_Yoj's HP!

--------------------------------------------------------------------------------------------

--------------------------------------------------------------
Choose an action for Undefeated_Yoj:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
i

Here is some information about your match-up:

**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Warrior    Undefeated_Yoj       140        4          7                    400        880        440        700        2000  Sword      Sword                  
***********************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************
***************************************************************Monster Information*********************************************************************
Type            Name                 HP              Level           Base Damage     Defense         Dodge Ability  
Dragon          Phaarthurnax         60              3               660             0               60             
*******************************************************************************************************************************************************

--------------------------------------------------------------
Choose an action for Undefeated_Yoj:
A: Attack with equipped weapon (Make sure its equipped!)
S: Cast a spell from your inventory
P: Use a potion from your inventory
E: Equip a new item (weapon/armor)
I: Display stats (hero or monster)
Q: Quit
--------------------------------------------------------------
a
----------------------------------Hero's Turn--------------------------------------------
Your main weapon has broke and will no longer be usable next round!


Your hero Undefeated_Yoj did 0.0 damage to monster Phaarthurnax's defence!


Your hero Undefeated_Yoj did 1840.0 damage to monster Phaarthurnax's HP!


The Monster has been defeated as it has lost all of its HP!

-----------------------------------------------------------------------------------------

----------------------------------After The Battle!------------------------------------
Hero Garl_Glittergold has been revived with half their max HP/MP.
Hero Undefeated_Yoj was victorious in the battle and gained 1300 gold and 13 experience points.
Undefeated_Yoj has leveled up 2 times due to winning the battle and have gained boosted stats!
Hero Eunoia_Cyn was victorious in the battle and gained 1300 gold and 13 experience points.
Eunoia_Cyn has leveled up 1 times due to winning the battle and have gained boosted stats!

--------------------------------------------------------------------------------------
[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [YOU] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

i
Hero Information: 
**********************************************************************Hero Information*********************************************************************
Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
Paladin    Garl_Glittergold     600        6          5                    600        660        500        440        2250                                    
Warrior    Undefeated_Yoj       880        6          0                    400        968        484        770        3300                                    
Warrior    Eunoia_Cyn           630        4          9                    400        808        924        630        3800                        Platinum_Shield
***********************************************************************************************************************************************************

Inventory of Garl_Glittergold:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Electric_Arrows    Spell      550.0      275.0         5                                                   650             1                 Lightning           
1      Ice_Blade          Spell      250.0      125.0         1                                                   450             1                 Ice                 
********************************************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
1      Guardian_Angel     Armor      1000.0     500.0         10                                1000                              5                                     
2      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
********************************************************************************************************************************************************************************

[   ] [   ] [   ] [  X] [  M] [  X] [  X] [  M] 
[  M] [  M] [  X] [  X] [  M] [   ] [   ] [   ] 
[  X] [   ] [   ] [   ] [   ] [  X] [   ] [   ] 
[  X] [   ] [   ] [YOU] [   ] [   ] [   ] [  X] 
[   ] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[  M] [   ] [   ] [   ] [   ] [   ] [   ] [   ] 
[   ] [  X] [  M] [  M] [  M] [   ] [   ] [  M] 
[   ] [   ] [   ] [  M] [  X] [  X] [  X] [   ] 

Please Select an Option: (W , A , S , D , Q (quit), I (information) , M (market), P (Consume Potion), E (Equip), MAP) and hit enter. 

q
The program has quit. Thank you for playing!

Process finished with exit code 0


```