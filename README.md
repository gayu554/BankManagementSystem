# Bank Management System

This is my first Java + MySQL based project.
The project is a simple Bank Management System that allows users to
create an account, deposit money, and check balance.

---

## 🔧 Technologies Used
- Java (Core Java)
- MySQL
- JDBC
- Swing (for GUI)

---

## 📌 Features
- Create new bank account
- Deposit money
- Check account balance
- Console + GUI based interaction

---

## 🗄️ Database Details

Database Name: `bankdb`

Table: `customer`

```sql
CREATE DATABASE bankdb;
USE bankdb;

CREATE TABLE customer (
    cid INT PRIMARY KEY,
    name VARCHAR(50),
    mobile VARCHAR(15),
    account_no VARCHAR(20),
    balance DOUBLE
);
