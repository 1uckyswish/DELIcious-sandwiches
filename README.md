# Capstone 2 - Delicious Sandwiches


Welcome to my second capstone project, where I bring to life the pillars of Java Object-Oriented Programming (OOP) that I've spent several weeks learning. This project serves as a culmination of my journey in mastering Java OOP principles. Through this project, I'll demonstrate the practical application of key OOP concepts including encapsulation, polymorphism, inheritance, abstraction, and interfaces. It's an opportunity for me to showcase my understanding and proficiency in implementing these fundamental concepts in a real-world scenario.
## Overview
This project aims to automate the order process for DELI-cious, a growing sandwich shop. With this application, customers can easily place their orders, customize their sandwiches, and even add drinks, chips, and cookies to their orders. Let's explore the features and functionality of our application:

## Features
- **Order Customization**: Customers can fully customize their sandwich orders by choosing the size, type of bread, toppings, meats, cheeses, and sauces.
- **Multiple Sizes**: Sandwiches are available in three sizes: 4", 8", and 12".
- **Premium Toppings**: Premium toppings such as meats and cheeses come at an additional cost.
- **Toasting Option**: Customers can choose whether they want their sandwich toasted.
- **Add-ons**: Customers can enhance their orders by adding drinks, chips, and cookies.
- **Cookie Selection**: Customers can choose between a sugar cookie or chocolate chip cookie to complement their order.
- **Order Summary**: Before finalizing the order, customers can review their selections and verify that the order is correct.
- **Checkout**: Once the order is confirmed, the application displays the total cost of the order.

## Signature Sandwiches
To streamline the ordering process, we've created several Signature Sandwiches that serve as templates for customer orders. Customers can choose from these Signature Sandwiches and then customize the toppings according to their preferences. Here are a couple of examples:

### BLT
- **Bread**: 8" white bread
- **Toppings**: Bacon, Cheddar, Lettuce, Tomato
- **Sauce**: Ranch
- **Toasted**: Yes

### Philly Cheese Steak
- **Bread**: 8" white bread
- **Toppings**: Steak, American Cheese, Peppers
- **Sauce**: Mayo
- **Toasted**: Yes

Customers can modify these Signature Sandwiches by adding or removing toppings to suit their taste.

## Screens

### Main Class (Home)

Welcome to our Delicious Sandwiches project! This is the heart of our sandwich ordering application. The Main class orchestrates all the functionalities, allowing customers to customize their sandwiches and add delicious sides. Check out the project structure to see how everything is organized.

<img width="1440" alt="Screenshot 2024-05-06 at 8 41 05 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/35d30fbb-7ec2-4f41-b262-b165a17c0fac">

### Home Screen
- Provides options to start a new order or exit the application.

<img width="1440" alt="Screenshot 2024-05-06 at 8 42 47 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/af777028-61c8-4b8b-b9e3-71ea439ee1de">

### Order Screen
- Options include adding a sandwich, drink, chips, cookie, proceeding to checkout, or canceling the order.

<img width="1440" alt="Screenshot 2024-05-06 at 8 43 39 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/c4eba7fa-0f1a-4ff5-803d-e960306447ce">

### Add Sandwich Screen
- Guides the user through selecting bread type, sandwich size, toppings (with the option to add extras), meats, cheeses, sauces, and toasting preference.

<img width="1440" alt="Screenshot 2024-05-06 at 8 44 37 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/6563c61e-0fdb-422e-b70e-85d5d80f8e9b">

<img width="1440" alt="Screenshot 2024-05-06 at 8 45 34 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/68ce9a53-adfe-47a3-ba45-27105504be96">

<img width="1440" alt="Screenshot 2024-05-06 at 8 46 36 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/f404c46e-b2cc-4973-b804-69d97c7b21d6">

### Add Drink Screen
- Allows the user to select the drink size and flavor.
- 
<img width="1440" alt="Screenshot 2024-05-06 at 8 47 12 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/b099398f-ca11-425d-a618-1648121589f4">

### Add Chips Screen
- Enables the user to select the type of chips they'd like to add to their order.

<img width="1440" alt="Screenshot 2024-05-06 at 8 47 43 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/bdb18dd8-dca8-427f-b55e-459a5e6e20ac">

### Add Cookie Screen
- Allows the user to choose between a sugar cookie or chocolate chip cookie to add to their order.

<img width="1440" alt="Screenshot 2024-05-06 at 8 48 22 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/26958ddd-65c7-45c9-8e4c-20e17bb78a5f">

### Checkout Screen
- Displays the order details including sandwich customizations, drink selection, chip type, cookie choice, and total cost.
- Offers the option to confirm the order and return to the home screen.

<img width="1440" alt="Screenshot 2024-05-06 at 8 49 00 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/0ffb43b7-4463-4f91-98fa-54a9bdeabdff">

<img width="1440" alt="Screenshot 2024-05-06 at 8 49 06 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/fec3bdf1-b2dd-4a8e-8e9b-d81edf639e5d">

<img width="1440" alt="Screenshot 2024-05-06 at 8 49 47 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/a8b1d8c7-2543-4fa8-98fc-a2f1cd4cf449">


## Saving Orders
- Each order is saved to a file named by the date and time it was placed (e.g., YYYYMMdd-hhmmss.txt).

<img width="1440" alt="Screenshot 2024-05-06 at 8 50 49 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/1b396f36-655f-4ef1-bcde-9fa6d14e48cb">

<img width="1440" alt="Screenshot 2024-05-06 at 8 51 15 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/c6cb2ace-4d78-4ccc-b805-679d50d747e6">

<img width="1440" alt="Screenshot 2024-05-06 at 8 51 21 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/cf8ddc6c-8e6b-404d-91dd-83ed7ed5f635">

## Object Oriented Analysis and Design
- The application utilizes Object-Oriented Programming concepts extensively to ensure modularity, scalability, and maintainability.
<img width="1440" alt="Screenshot 2024-05-06 at 8 51 58 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/5fc9c51e-8f82-47c2-b354-596ed7ad3931">

<img width="1440" alt="Screenshot 2024-05-06 at 8 52 05 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/1d8041a5-9950-428a-8b4a-25e7c45fa4bd">

<img width="1440" alt="Screenshot 2024-05-06 at 8 52 15 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/546ea51d-d2ab-4212-9d7c-f2eb571e9111">

<img width="1440" alt="Screenshot 2024-05-06 at 8 53 06 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/da351acb-253e-46c5-a1fd-f2d7db3312c3">

## Interesting Section of code
This code snippet introduces a unique feature where the user is informed that going back to the home screen will reset their cart. To implement this functionality, every time the Main class is instantiated, the cart object is created anew, ensuring that any previous cart contents are discarded. This prevents unintended persistence of items in the cart across sessions.

By providing a message to the user, they are informed of the consequence of proceeding, enabling them to make an informed decision. This design choice ensures a seamless user experience while maintaining the integrity of the ordering process.

<img width="1440" alt="Screenshot 2024-05-06 at 8 54 59 PM" src="https://github.com/1uckyswish/DELIcious-sandwiches/assets/107442415/f4f27db0-d6d9-4d61-8070-10dd27ee2db7">



## Repository Contents
- Class diagram depicting the object relationships and interactions.
- Source code files implementing the application logic.
- Sample order files demonstrating the saved orders.

Thank you for choosing DELI-cious for your sandwich needs!
