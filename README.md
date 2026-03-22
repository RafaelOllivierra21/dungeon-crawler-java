# Dungeon Crawler - Java Terminal Game

A **terminal-based dungeon crawler** game implemented in Java. Explore rooms, battle enemies, collect loot, and survive the dungeon! This project demonstrates **object-oriented programming (OOP)** concepts such as **inheritance**, **polymorphism**, **abstraction**, and **encapsulation**.  

---

## Features

- Turn-based combat system  
- Multiple enemy types: Goblins & Bosses  
- Lootable items that automatically affect the player  
- Inventory system with Health Potions and Swords  
- Room-based dungeon progression with enemies and loot  
- Clear win/loss conditions  

---

## Game Structure

### **Entities**
- `Entity` – Abstract base class for all characters.  
- `Player` – Hero controlled by the user, maintains inventory.  
- `Enemy` – Base enemy class.  
- `Goblin` – Weak enemy with preset health & attack.  
- `Boss` – Strong enemy dealing double damage.  

### **Items**
- `Item` – Abstract class for all items.  
- `Lootable` – Interface for items that can affect the player.  
- `HealthPotion` – Restores player health.  
- `Sword` – Boosts player attack power.  

### **Dungeon**
- `Room` – Contains enemies and loot; tracks whether cleared.  
- `Dungeon` – Manages the player, rooms, combat, looting, and game progression.  

---

## How to Play

Follow these steps to run and play the game:

### 1) Clone the repository
```bash
git clone https://github.com/YourUsername/dungeon-crawler-java.git
cd dungeon-crawler-java
```
### 2) Compile All Java Files
```bash
javac *.java
```
### 3) Start the Game
```bash
java GameRunner
```
## Author

Rafael Ollivierra  
Computer Science and Management Undergraduate. 
Object-Oriented Programming


