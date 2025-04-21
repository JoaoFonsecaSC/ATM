# 💵 Simple Java ATM Simulator

This is a simple ATM simulator built in Java, designed to practice fundamental programming concepts such as conditionals, loops, user input handling, and basic validation logic.

---

## 🧠 Features

- 🔐 Password-protected login system with a 3-attempt limit
- 💰 View account balance
- ➖ Withdraw funds with balance validation
- ➕ Deposit funds with input validation
- 🔁 Interactive menu that loops until user exits
- 📉 Input validation to prevent negative or invalid values

---

## 🧾 Technologies Used

- Java (JDK 17 or later recommended)
- Scanner class for user input
- `if`, `for`, `do...while`, and `switch` control structures
- `printf` for output formatting

---

## 🚀 How to Run

1. Clone this repository or download the source files.
2. Open the project in IntelliJ, Eclipse, or any Java IDE.
3. Compile and run the `Main.java` file.

Or via terminal:

```bash
javac Main.java
java Main
📌 Example
pgsql
Copiar
Editar
Welcome to the ATM!
Enter your 4-digit password: 1111
Incorrect password.
Enter your 4-digit password (2 attempt(s) left): 1234

==============================
What would you like to do?
1. Check Balance
2. Withdraw
3. Deposit
4. Exit
Enter your choice: 2
Enter the amount you wish to withdraw: $100
Withdrawal of $100.00 successful.
Current balance: $900.00
📈 Learning Goals
This project was built to practice:

Conditionals (if, else)

Loops (for, do...while)

Nested control structures (switch inside loops)

User input and console interaction

Simple logic for financial transactions

🧑‍💻 Author
Developed by João Fonseca — learning Java one project at a time!
Feel free to contribute ideas, improvements, or feedback.
