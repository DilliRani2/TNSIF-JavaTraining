# 🛒 Shopping Mall Management System - Order Module

Yo! Welcome to the **Order Management Module** of our Shopping Mall Management System. 

Basically, this is the brain behind the checkout counter. When a customer adds some drip to their cart and is ready to check out, this module steps up to make sure their order is processed, tracked, and stored without a hitch. 

This is built as part of a Core Java training project, so we're keeping it clean, layered, and totally beginner-friendly. No heavy frameworks, just pure Java magic. ✨

## 🚀 What does it actually do?

This module handles all the heavy lifting when it comes to orders. Here’s the rundown:
- **Create an Order:** Locks in the purchase date, total cost, the shop they bought it from, and the payment mode.
- **Search for an Order:** Got an order ID? We can fetch the exact details instantly. 
- **Update an Order:** Need to change the payment mode or total? Easy peasy.
- **Cancel an Order:** Buyer's remorse? No sweat, you can cancel and delete an order from the system.
- **Add Items:** Passes items along the chain.

## 🛠️ Under the Hood (Tech Stack)

We kept the architecture super clean and layered, so it's easy to read and scale later:
- **Language:** Core Java (JDK 8+)
- **Architecture:** `Model` -> `Repository` -> `Service` -> `Test/UI`
- **Storage:** For right now, we're using a speedy in-memory `HashMap` database. It's fast, light, and does exactly what we need without having to spin up a whole SQL server.

## 📂 Project Structure

```text
src/shoppingmall/
├── exceptions/       # Custom error handling (OrderNotFound, InvalidOrder)
├── model/            # The blueprints (OrderDetails, Customer, Shop, Item)
├── repository/       # Data storage logic (Interfaces & Impls)
├── service/          # Business logic and validation (Interfaces & Impls)
└── test/             # Unit tests making sure everything works 100%
```

## 🎮 How to run it

We've got a custom test runner that makes sure everything is functioning flawlessly. 

1. Download or clone this repo.
2. Make sure you've got your Java JDK installed and ready to go.
3. Open it up in your favorite IDE (Eclipse, IntelliJ IDEA, VS Code).
4. Run the `OrderServiceTest.java` file.
5. If everything is golden, you'll see a sick output telling you all 8 tests passed! 🎉

---

