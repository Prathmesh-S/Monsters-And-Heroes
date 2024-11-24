# CS611-Assignment 5
## Legends of Valor
---------------------------------------------------------------------------
- Name: Prathmesh Sonawane
- Email: prsona@bu.edu
- Student ID: U39215370


- Name: 
- Email
- Student ID: 

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

**BoardPieceType.java**: Specifies the types of board pieces we have, such as obstacle and cave. 

## Notes (Design Decisions/Cool Features!)
---------------------------------------------------------------------------

### New Design Decisions:

1. (Factory Pattern) In Monsters and Heroes/Legends of Valor, I used the Factory pattern to manage the creation of different character and monster types. By implementing a HeroFactory and MonsterFactory, each class is responsible for creating specific types of entities with appropriate stats and abilities. This choice simplifies adding new types of characters or monsters, as we only need to adjust the factory without changing other parts of the code. This approach reduces redundancy in the instantiation process and promotes scalability, allowing the game to introduce new characters or monster variations seamlessly. 
<br>
<br>
2. (Strategy Pattern) In Monsters and Heroes/Legends of Valor, I used the Strategy pattern to handle the different actions a heroes might perform, specifically Attack, Equip, Spell, and Potion actions. By defining each action as a separate strategy, I allowed characters to dynamically select and execute behaviors based on the current context, such as using a specific spell or equipping new armor. This pattern helps keep the code flexible and modular, as each action is encapsulated in its own strategy class, making it easy to add new actions or modify existing ones without impacting the core character logic. Overall, the Strategy pattern enhances reusability and adaptability, allowing for a more varied and dynamic gameplay experience.
   <br>
   <br>
3. (Singleton Pattern) In my Monsters and Heroes/Legends of Valor game, I implemented a singleton scanner pattern (SingletonScanner.java) to handle user input consistently throughout the game. By creating a single instance of the Scanner class and using it globally within the game, I ensured that input handling is streamlined and centralized. This pattern eliminates the need for multiple Scanner instances, preventing potential issues such as resource leaks or inconsistent input handling. Additionally, it enhances performance by reusing the same object, reducing overhead. The singleton scanner approach also makes the code more maintainable, as all user input logic is tied to a single point, making it easier to modify or extend in the future.
<br>
<br>
4. Our team decided to extend Legends of Valor from our Monsters and Hero class as an instance of a Legends of Valor game was pretty much a Monsters vs Heroes game, just with a different map and additional functionality (Ex. Recall, Teleportation). For that reason, it made sense to extend our Legends of Valor game from Heroes vs Monsters to inherit base functionality and reuse already written code.
   <br>
   <br>
5. Rather than create a class for each type of board type, we simply decided to make the board type (with the exception of a Market Board Piece) a field in the general board piece class. Since each of the other board piece types, like cave and bush, did not require any state, it made sense to make a field to differentiate different board types rather than create classes which would hold no state. By doing so, we made our code more simple.
   <br>
   <br>
5. In my project, I designed nearly 40 classes, each following the Single Responsibility Principle (SRP) to ensure that every class has one clear responsibility. This approach not only made the codebase more organized and modular but also greatly enhanced its maintainability and scalability. For example, classes like GameController are dedicated solely to managing the flow of the game, while classes such as BoardPiece and Player focus on their specific aspects, like representing tiles and players respectively. By adhering to SRP, I ensured that each class could be easily understood, tested, and modified without affecting others. This separation of concerns allowed for better collaboration and quicker debugging, as changes in one part of the game wouldn't risk breaking unrelated functionality. Furthermore, this structure made it easier to extend the game in the future, whether adding new features or creating new game modes.

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
/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=60332:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/charsets.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/cldrdata.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/dnsns.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/jaccess.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/localedata.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/nashorn.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunec.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/zipfs.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jce.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jfr.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jsse.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/management-agent.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/resources.jar:/Users/prathmesh/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/rt.jar:/Users/prathmesh/IdeaProjects/Monsters-And-Heroes/out/production/286777292 (1) Main
Welcome to our digital arcade! If at any time you would like to quit, please type and enter "quit" when prompted to enter a string. 
Please enter the number of players playing: 
1
Enter the name of player 1: 
Prathmesh

Here is a list of playable games: 
0 : Monsters And Heroes (Single-Player)
1 : Legends Of Valor (Single-Player)
Please type the integer associated with the game you would like to play!
1

Welcome to Legends of Valor! The game board is an 8x8 grid, divided into three lanes with various types of spaces: Nexus, Inaccessible, Plain, Bush, Cave, and Koulou.
Each lane spans two columns, with impassable columns separating them. Heroes aim to reach the monsters' Nexus at the top, while monsters attempt to invade the heroes' Nexus at the bottom.

Spaces have different effects: Nexus spaces are spawning points and markets for heroes; Bush spaces boost hero dexterity; Cave spaces increase agility; and Koulou spaces enhance strength. 
Monsters receive no terrain bonuses.

Heroes control a team of three, with each hero occupying a lane. Heroes can perform actions such as moving, attacking, casting spells, using items, or teleporting to other lanes. 
They battle invading monsters, gathering gold and experience along the way.

Heroes and monsters act in rounds, with heroes going first. If a hero reaches the monster Nexus, they win. If a monster reaches the hero Nexus, the heroes lose.

The objective is to coordinate actions, use terrain to your advantage, and stop the monster invasion. Level up, strengthen your heroes, and protect the Nexus!


It is time to choose 3 heroes! Your i-th chosen hero will live in the i-th column of the game.

This is the remaining list of your possible heroes!
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Sehanine_Monnbow     600        3          8                    600        770        880        500        2500                                    
1          Paladin    Amaryllis_Astra      1400       7          5                    500        550        500        550        2500                                    
2          Warrior    Undefeated_Yoj       600        3          7                    400        880        440        700        2500                                    
3          Sorcerer   Rillifane_Rallathil  1000       5          9                    1300       750        495        550        2500                                    
4          Warrior    Eunoia_Cyn           1000       5          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Sehanine_Monnbow:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
2      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
2      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
1      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
2      Lightning_Dagger   Spell      400.0      200.0         1                                                   500             1                 Lightning           
********************************************************************************************************************************************************************************

Inventory of Rillifane_Rallathil:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
2      Lightning_Dagger   Spell      400.0      200.0         1                                                   500             1                 Lightning           
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

You must select 3 more heroes. Please choose the index of the next hero you would like to select!

Please type the chosen index of your next hero from [0,4] inclusive (Ex. 3): 
0

You have chosen a hero. 

This is the remaining list of your possible heroes!
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Paladin    Amaryllis_Astra      1400       7          5                    500        550        500        550        2500                                    
1          Warrior    Undefeated_Yoj       600        3          7                    400        880        440        700        2500                                    
2          Sorcerer   Rillifane_Rallathil  1000       5          9                    1300       750        495        550        2500                                    
3          Warrior    Eunoia_Cyn           1000       5          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
2      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
1      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
2      Lightning_Dagger   Spell      400.0      200.0         1                                                   500             1                 Lightning           
********************************************************************************************************************************************************************************

Inventory of Rillifane_Rallathil:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
2      Lightning_Dagger   Spell      400.0      200.0         1                                                   500             1                 Lightning           
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

You must select 2 more heroes. Please choose the index of the next hero you would like to select!

Please type the chosen index of your next hero from [0,3] inclusive (Ex. 3): 
0

You have chosen a hero. 

This is the remaining list of your possible heroes!
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Undefeated_Yoj       600        3          7                    400        880        440        700        2500                                    
1          Sorcerer   Rillifane_Rallathil  1000       5          9                    1300       750        495        550        2500                                    
2          Warrior    Eunoia_Cyn           1000       5          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Undefeated_Yoj:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Sword              Weapon     500.0      250.0         1        800      1                                                 3                                     
1      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
2      Lightning_Dagger   Spell      400.0      200.0         1                                                   500             1                 Lightning           
********************************************************************************************************************************************************************************

Inventory of Rillifane_Rallathil:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Ambrosia           Potion     1000.0     500.0         8                                                   150             1                 All                 
2      Lightning_Dagger   Spell      400.0      200.0         1                                                   500             1                 Lightning           
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

You must select 1 more heroes. Please choose the index of the next hero you would like to select!

Please type the chosen index of your next hero from [0,2] inclusive (Ex. 3): 
2

You have chosen a hero. 

All of your heroes have been selected! They are below:
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Sehanine_Monnbow     600        3          8                    600        770        880        500        2500                                    
1          Paladin    Amaryllis_Astra      1400       7          5                    500        550        500        550        2500                                    
2          Warrior    Eunoia_Cyn           1000       5          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Sehanine_Monnbow:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
2      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
2      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

--- Round 1 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[  H1] [   N] [XXXX] [  H2] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
e
Sehanine_Monnbow's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

y

Please select the index of a weapon from the table to equip it or type -1 to stop or -2 for hero information.

1

Weapon has been Equipped!
Sehanine_Monnbow's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Sehanine_Monnbow's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
Sehanine_Monnbow's Unequipped Armor:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Armor?

Please type (y/n)

n
No more Armor to look at!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[  H1] [   N] [XXXX] [  H2] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
i
Hero Information: 
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Sehanine_Monnbow     600        3          8                    600        770        880        500        2500  Bow        Bow                    
1          Paladin    Amaryllis_Astra      1400       7          5                    500        550        500        550        2500                                    
2          Warrior    Eunoia_Cyn           1000       5          6                    400        770        880        600        2500                                    
***********************************************************************************************************************************************************

Inventory of Sehanine_Monnbow:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
2      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
e
Amaryllis_Astra's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
1      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

y

Please select the index of a weapon from the table to equip it or type -1 to stop or -2 for hero information.

0

Weapon has been Equipped!
Amaryllis_Astra's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Amaryllis_Astra's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Bow                Weapon     300.0      150.0         2        500      2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
No more Armor to look at!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[  H1] [   N] [XXXX] [  H2] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
m
Attempting to enter a market.


Welcome to the Market! Below are things you can buy!


Time to Buy!

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
2      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
3      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
4      Flame_Tornado      Spell      700.0      350.0         4                                                   850             1                 Fire                
********************************************************************************************************************************************************************************

Would you like to buy any items for hero Eunoia_Cyn?

Please type (y/n)

y

Please select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.

2

You have bought the item! Here is the updated Market!:

**********************************************************************Market Information*******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
3      Flame_Tornado      Spell      700.0      350.0         4                                                   850             1                 Fire                
********************************************************************************************************************************************************************************

Please select the index of an item from the table to buy it or type -1 to stop or -2 for hero information.

-1





Time to sell!

**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Eunoia_Cyn           1000       5          6                    400        770        880        600        1950                                    
***********************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
2      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
3      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
********************************************************************************************************************************************************************************

Next, would you like to sell any of Eunoia_Cyn's items?

Please type (y/n)

n


Now leaving the market!


Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
e
Eunoia_Cyn's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
1      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
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
Eunoia_Cyn's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Eunoia_Cyn's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Axe                Weapon     550.0      275.0         5        850      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
No more Armor to look at!

-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 1 ---

--- Round 2 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [   M] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[  H1] [   N] [XXXX] [  H2] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [   M] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[  H1] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [  H2] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has entered a cave and has received extra agility.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [   M] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[  H1] [    ] [XXXX] [  H2] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
p
Eunoia_Cyn's Potions:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Mermaid_Tears      Potion     850.0      425.0         5                                                   100             1                 Health/Mana/Strength/Agility
1      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
********************************************************************************************************************************************************************************

Would you like to use a potion?

Please type (y/n)

y

Please select the index of potion from the table to use it or type -1 to stop or -2 for hero information.

0

Potion Consumed!
Eunoia_Cyn's Potions:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Strength_Potion    Potion     200.0      100.0         1                                                   75              1                 Strength            
********************************************************************************************************************************************************************************

Would you like to use a potion?

Please type (y/n)

y

Please select the index of potion from the table to use it or type -1 to stop or -2 for hero information.

0

Potion Consumed!
No more potions to look at for hero Eunoia_Cyn!
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 2 ---

--- Round 3 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [   M] [XXXX] [   K] [   M] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[  H1] [    ] [XXXX] [  H2] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
i
Hero Information: 
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Sehanine_Monnbow     600        3          8                    600        770        880        500        2500  Bow        Bow                    
1          Paladin    Amaryllis_Astra      1400       7          5                    605        550        550        550        2500  Bow        Bow                    
2          Warrior    Eunoia_Cyn           1000       5          6                    594        962        990        600        1950  Axe        Axe                    
***********************************************************************************************************************************************************

Inventory of Sehanine_Monnbow:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has entered a cave and has received extra agility.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [   M] [XXXX] [   K] [   M] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[  H1] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [  H2] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has left a cave and has lost its extra agility.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [   M] [XXXX] [   K] [   M] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[  H1] [    ] [XXXX] [  H2] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has entered a bush and has received extra dexterity.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 3 ---

--- Round 4 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [   M] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[  H1] [    ] [XXXX] [  H2] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
d

Your hero has left a cave and has lost its extra agility.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [   M] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   B] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [  H2] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [   M] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [  H2] [   B] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has left a bush and has lost its extra dexterity.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

The monster BigBad-Wolf did 150.0 damage to hero Amaryllis_Astra's HP!


A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 4 ---

--- Round 5 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [   M] [XXXX] [  H2] [   B] [XXXX] [    ] [   M] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (4, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your hero Sehanine_Monnbow did 715.0000000000001 damage to monster St-Shargaas's defence!


Your hero Sehanine_Monnbow did 654.9999999999999 damage to monster St-Shargaas's HP!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [   M] [XXXX] [  H2] [   B] [XXXX] [    ] [   M] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
t
Select a hero to teleport to:
0: Sehanine_Monnbow at (5, 1)
1: Amaryllis_Astra at (4, 3)
2: Eunoia_Cyn at (5, 6)

Please type the index of the hero you would like to teleport to. from [0,2] inclusive (Ex. 3): 
0

Select a position to teleport to (Row, Column), using zero-indexing:
0: (6, 1)
1: (5, 0)

Please type the index of the position you would like to teleport to. from [0,1] inclusive (Ex. 3): 
0
H2 successfully teleported to (6, 1).

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [   M] [XXXX] [    ] [   B] [XXXX] [    ] [   M] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [   M] [XXXX] [    ] [   B] [XXXX] [    ] [   M] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (4, 7)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your hero Eunoia_Cyn did 200.0 damage to monster Natsunomeryu's defence!


Your hero Eunoia_Cyn did 1782.5 damage to monster Natsunomeryu's HP!


The Monster has been defeated as it has lost all of its HP!

-------------------------------------------------------------
------------------------Monsters Turn ------------------------

The monster St-Shargaas did 550.0 damage to hero Sehanine_Monnbow's HP!


A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 5 ---

--- Round 6 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [   M] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (4, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your hero Sehanine_Monnbow did 0.0 damage to monster St-Shargaas's defence!


Your hero Sehanine_Monnbow did 1370.0 damage to monster St-Shargaas's HP!


The Monster has been defeated as it has lost all of its HP!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
a

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[  H2] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w
-------------------------------------------------------------
------------------------Monsters Turn ------------------------
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 6 ---

--- Round 7 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [  H3] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[  H2] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [  H1] [XXXX] [    ] [   M] [XXXX] [  H3] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[  H2] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
d

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [  H1] [XXXX] [    ] [   M] [XXXX] [  H3] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w
-------------------------------------------------------------
------------------------Monsters Turn ------------------------
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 7 ---

--- Round 8 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [    ] [XXXX] [  H3] [   C] 
[   O] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [    ] [XXXX] [  H3] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [  H2] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [    ] [XXXX] [  H3] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H2] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has entered a koulou and has received extra strength.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 8 ---

--- Round 9 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [   M] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [  H3] [    ] 
[   C] [  H1] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H2] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
a

Your hero has entered a cave and has received extra agility.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [   M] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [  H3] [    ] 
[  H1] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H2] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [   M] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [  H3] [    ] 
[  H1] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (1, 7)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

The monster Merrshaullk dodged your attack!

-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!

The monster Merrshaullk did 1000.0 damage to hero Eunoia_Cyn's HP!


The Hero has fainted as it has lost all of its HP!

-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.
Eunoia_Cyn has respawned at the Nexus.
--- End of Round 9 ---

--- Round 10 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [   M] 
[    ] [   M] [XXXX] [    ] [   M] [XXXX] [   K] [    ] 
[  H1] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (2, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your main weapon has broke and will no longer be usable next round!


Your hero Sehanine_Monnbow did 1100.0 damage to monster Exodia's defence!


Your hero Sehanine_Monnbow did 270.0 damage to monster Exodia's HP!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [   M] 
[    ] [   M] [XXXX] [    ] [   M] [XXXX] [   K] [    ] 
[  H1] [    ] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [   M] 
[    ] [   M] [XXXX] [    ] [   M] [XXXX] [   K] [    ] 
[  H1] [  H2] [XXXX] [    ] [    ] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has left a koulou and has lost its extra strength.

Your hero has entered a bush and has received extra dexterity.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

The monster Exodia did 1000.0 damage to hero Sehanine_Monnbow's HP!


The Hero has fainted as it has lost all of its HP!


A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------
Sehanine_Monnbow has respawned at the Nexus.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 10 ---

--- Round 11 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [    ] [XXXX] [   K] [   M] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[  H1] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
d

Your hero has left a cave and has lost its extra agility.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [    ] [XXXX] [   K] [   M] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [  H1] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (2, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your hero Amaryllis_Astra did 0.0 damage to monster Exodia's defence!


Your hero Amaryllis_Astra did 1150.0 damage to monster Exodia's HP!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [    ] [XXXX] [   K] [   M] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [  H1] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has left a bush and has lost its extra dexterity.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

The monster Exodia did 1000.0 damage to hero Amaryllis_Astra's HP!


A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 11 ---

--- Round 12 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [  H1] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [   M] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [  H1] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (2, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your hero Amaryllis_Astra did 0.0 damage to monster Exodia's defence!


Your hero Amaryllis_Astra did 1150.0 damage to monster Exodia's HP!


The Monster has been defeated as it has lost all of its HP!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [  H3] [   B] 
[    ] [  H1] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

The monster Merrshaullk did 1000.0 damage to hero Eunoia_Cyn's HP!


The Hero has fainted as it has lost all of its HP!

-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.
Eunoia_Cyn has respawned at the Nexus.
--- End of Round 12 ---

--- Round 13 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [  H1] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H2] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [  H2] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has entered a bush and has received extra dexterity.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 13 ---

--- Round 14 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [  H2] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [  H1] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [  H2] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[   B] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [  H3] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Your hero has left a bush and has lost its extra dexterity.
-------------------------------------------------------------
------------------------Monsters Turn ------------------------

The monster Merrshaullk did 1000.0 damage to hero Eunoia_Cyn's HP!


The Hero has fainted as it has lost all of its HP!

-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.
Eunoia_Cyn has respawned at the Nexus.
--- End of Round 14 ---

--- Round 15 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
i
Hero Information: 
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Sehanine_Monnbow     600        3          8                    600        770        880        500        2500                                    
1          Paladin    Amaryllis_Astra      585        7          5                    1400       550        499        550        2500  Bow        Bow                    
2          Warrior    Eunoia_Cyn           1000       5          6                    1000       962        990        600        1950  Axe        Axe                    
***********************************************************************************************************************************************************

Inventory of Sehanine_Monnbow:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
e
Amaryllis_Astra's Unequipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Would you like to Equip a certain Weapon?

Please type (y/n)

n
No more Weapons to look at!

Amaryllis_Astra's Equipped Weapons:
********************************************************************************************************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Bow                Weapon     300.0      150.0         2        500      2                                                 1                                     
********************************************************************************************************************************************************************************

Would you like to unequip a certain Weapon?

Please type (y/n)

n
No more Armor to look at!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[   B] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [  H3] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
i
Hero Information: 
**********************************************************************Hero Information*********************************************************************
Index      Type       Name                 HP         Level      Experience Points    Mana       Strength   Agility    Dexterity  Gold  Left Hand  Right Hand Armour      
0          Warrior    Sehanine_Monnbow     600        3          8                    600        770        880        500        2500                                    
1          Paladin    Amaryllis_Astra      585        7          5                    1400       550        499        550        2500  Bow        Bow                    
2          Warrior    Eunoia_Cyn           1000       5          6                    1000       962        990        600        1950  Axe        Axe                    
***********************************************************************************************************************************************************

Inventory of Sehanine_Monnbow:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Scythe             Weapon     1000.0     500.0         6        1100     2                                                 3                                     
1      Wizard_Shield      Armor      1200.0     600.0         10                                1500                              5                                     
********************************************************************************************************************************************************************************

Inventory of Amaryllis_Astra:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      Heat_Wave          Spell      450.0      225.0         2                                                   600             1                 Fire                
1      Dagger             Weapon     200.0      100.0         1        250      1                                                 3                                     
********************************************************************************************************************************************************************************

Inventory of Eunoia_Cyn:
**********************************************************************Item Information******************************************************************************************
Index  Name               ItemType   Buy Price  Sell Price    Level    Damage   Hands Required  Damage Reduction  Effect Amount   Available Uses    Attribute Affected  
0      TSwords            Weapon     1400.0     700.0         8        1600     2                                                 3                                     
********************************************************************************************************************************************************************************

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
t
Select a hero to teleport to:
0: Sehanine_Monnbow at (3, 1)
1: Amaryllis_Astra at (1, 1)
2: Eunoia_Cyn at (7, 6)

Please type the index of the hero you would like to teleport to. from [0,2] inclusive (Ex. 3): 
1

Select a position to teleport to (Row, Column), using zero-indexing:
0: (2, 1)
1: (1, 0)

Please type the index of the position you would like to teleport to. from [0,1] inclusive (Ex. 3): 
1
H3 successfully teleported to (1, 0).

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   M] [XXXX] [   N] [   M] 
[  H3] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   M] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus

-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

The monster BunsenBurner did 440.00000000000006 damage to hero Amaryllis_Astra's HP!


A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 15 ---

--- Round 16 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[  H3] [  H2] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Attack failed: No monsters to attack/spell in your area!.

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[  H3] [  H2] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (0, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your main weapon has broke and will no longer be usable next round!


Your hero Amaryllis_Astra did 500.0 damage to monster BunsenBurner's defence!


Your hero Amaryllis_Astra did 650.0 damage to monster BunsenBurner's HP!


Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   M] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[  H3] [  H2] [XXXX] [   B] [   M] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [    ] [    ] [XXXX] [   K] [    ] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   M] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [    ] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Eunoia_Cyn, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
attack

Select a monster position to attack/spell (Row, Column), using zero-indexing:
0: (0, 1)

Please type the index of the monster you would like to attack from [0,0] inclusive (Ex. 3): 
0

Your hero Eunoia_Cyn did 0.0 damage to monster BunsenBurner's defence!


Your hero Eunoia_Cyn did 1982.5 damage to monster BunsenBurner's HP!


The Monster has been defeated as it has lost all of its HP!

-------------------------------------------------------------
------------------------Monsters Turn ------------------------

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!

A monster has moved towards your nexus this round!
-------------------------------------------------------------

Sehanine_Monnbow has recovered HP and MP.

Amaryllis_Astra has recovered HP and MP.

Eunoia_Cyn has recovered HP and MP.
--- End of Round 16 ---

--- Round 17 ---
------------------------Hero Turn ------------------------

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[  H3] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [    ] [XXXX] [    ] [   M] [XXXX] [   K] [   M] 
[   C] [  H1] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [   M] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Sehanine_Monnbow, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[  H3] [  H2] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [  H1] [XXXX] [    ] [   M] [XXXX] [   K] [   M] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [   M] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Hero Amaryllis_Astra, it is your turn!

Please select an action by entering the corresponding letter:
(W,A,S,D): Move Up, Left, Down, Right
Q: Quit the Game
I: Show Hero Information
M: Enter the Market
P: Consume a Potion
E: Equip Weapons or Armor
R: Recall to Nexus
Attack: Attack a Monster near you!
Spell: Spell a Monster near you!
RO: Remove Obstacle (The O's on the map)
T: Teleport to Another Hero
MAP: Display the Game Map Again

Enter your choice: 
w

Legend:
XXXX - Inaccessible
H1 - Your hero : Sehanine_Monnbow
H2 - Your hero : Amaryllis_Astra
H3 - Your hero : Eunoia_Cyn
M - The monsters!
N - Nexus/Market
B - Bush (Dexterity Boost)
C - Cave (Agility Boost)
K - Koulou (Strength Boost)
O - Obstacle

                 Monster Nexus
[   N] [  H2] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
[  H3] [    ] [XXXX] [   B] [    ] [XXXX] [    ] [    ] 
[    ] [  H1] [XXXX] [    ] [   M] [XXXX] [   K] [   M] 
[   C] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [   C] 
[   O] [    ] [XXXX] [    ] [   M] [XXXX] [    ] [    ] 
[   C] [    ] [XXXX] [    ] [   O] [XXXX] [    ] [   B] 
[    ] [    ] [XXXX] [   C] [    ] [XXXX] [   B] [   M] 
[   N] [   N] [XXXX] [   N] [   N] [XXXX] [   N] [   N] 
                 Hero Nexus


Amaryllis_Astra has reached the monsters' Nexus! Heroes win!

Process finished with exit code 0


```