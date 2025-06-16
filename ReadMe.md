# Monsters and Heroes Game Collection

A comprehensive Java-based terminal gaming suite featuring two immersive RPG experiences: **Monsters and Heroes** and **Legends of Valor**. Built with software engineering principles and design patterns.

## Games Overview

### Monsters and Heroes
A classic turn-based RPG where heroes venture through procedurally generated worlds, engaging in strategic combat with monsters while managing inventory, equipment, and character progression.

**Key Features:**
- Scalable board size (5x5 to 9x9)
- Flexible party composition (1-3 heroes)
- Dynamic market system
- Strategic combat with multiple action types
- Character progression and inventory management

### Legends of Valor
An advanced variant extending Monsters and Heroes with lane-based tactical gameplay on an 8x8 grid battlefield.

**Key Features:**
- Three-lane strategic battlefield
- Terrain-based bonuses (Bush/Cave/Koulou)
- Advanced hero abilities (Recall, Teleportation)
- Nexus-based victory conditions
- Enhanced tactical depth

## Architecture and Design Patterns

This codebase demonstrates enterprise software engineering principles through clean architecture and proven design patterns:

### Core Design Patterns
- **Factory Pattern**: Modular creation of heroes, monsters, and items with dedicated factories
- **Strategy Pattern**: Flexible combat actions (Attack, Spell, Potion, Equip strategies)
- **Singleton Pattern**: Centralized input handling via `ScannerSingleton`

### Architectural Principles
- **Single Responsibility Principle**: 40+ focused classes, each with clear responsibilities
- **Package-based Organization**: Logical separation into models, controllers, strategies, factories, ui, and utils
- **Inheritance Hierarchy**: Strategic use of abstract classes and interfaces for code reuse
- **Scalable Design**: Configurable game parameters and extensible framework

### Package Structure
```
├── controllers/     # Game logic and flow control
├── models/         # Core game entities (Hero, Monster, Player, etc.)
├── factories/      # Factory pattern implementations
├── strategies/     # Strategy pattern for combat actions
├── ui/            # Board and game piece representations
├── utils/         # Utility classes and helpers
└── resources/     # Game data files
```

## Getting Started

### Prerequisites
- Java 8 or higher
- Terminal/Command line access

### Build and Run
```bash
# Navigate to project root
cd /path/to/Monsters-And-Heroes

# Compile all Java files
find . -name "*.java" > sources.txt && javac @sources.txt

# Run the game
java controllers.Main
```

### Alternative (IDE)
Run the `main()` method in `controllers/Main.java`

## Additional Resources

For comprehensive implementation details, advanced features documentation, and complete gameplay mechanics, see the [Extended README](ExtendedReadMe.md).

## Contributors

- **Prathmesh Sonawane** - prsona@bu.edu
- **Haixi Zhang** - haixi23@bu.edu

---

This project demonstrates professional software engineering practices including design patterns, clean architecture, and scalable code organization.

