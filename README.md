# Product Sales Java App

A desktop Java Swing application for managing product sales, built with NetBeans and MySQL.

## Features

- Add item-based or weight-based products
- View all sales or filter by product type
- Update product prices by percentage
- MySQL database integration via JDBC

## Technologies

- Java 8
- Swing GUI (NetBeans GUI Builder)
- MySQL (via XAMPP)
- JDBC (MySQL Connector/J)

## Project Structure

src/ <br>
├── model/ → Product classes <br>
├── data/ → Database access <br>
├── controller/ → Logic layer <br>
├── exceptions/ → Custom exceptions <br> 
├── gui/ → MainForm.java (GUI) <br>
└── Main.java # Entry point

## How to Run

1. Clone the repo  <br>
  ```bash
git clone https://github.com/vukona-dev/product-sales-java.git
```
2. Open in NetBeans
3. Add MySQL Connector/J
   - Download from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
   - Add the .jar file to your project’s Libraries
4. Set Up the Database
   - Start MySQL via XAMPP
   - Open MySQL Workbench or phpMyAdmin
   - Run the SQL script below
5. Run the App
   - Open MainForm.java
   - Click Run to launch the GUI

## Database Setup

Run this SQL script to create and populate the database:
```sql
CREATE DATABASE productsaledb;
USE productsaledb;

CREATE TABLE tblproduct (
  Barcode_No INT(8) PRIMARY KEY,
  Product_Name VARCHAR(18) NOT NULL,
  Product_Category VARCHAR(4) NOT NULL,
  Manufacturer VARCHAR(10),
  Weight INT(11),
  Unit_Price INT(11) NOT NULL,
  Amount_Paid DOUBLE NOT NULL
);

INSERT INTO tblproduct VALUES
(16783234, 'Tuna', 'IBP', 'I & L', NULL, 1500, 17.25),
(17803064, 'Milk 1L', 'IBP', 'Clover', NULL, 1500, 17.25),
(26782561, 'Rump steak', 'WBP', NULL, 250, 12500, 35.94),
(51343424, 'Bananas', 'WBP', NULL, 450, 4300, 22.25),
(68900456, 'Boniato', 'WBP', NULL, 446, 4699, 24.09); 
```

## Screenshots

coming soon


## 🙋‍♂️ Author

**VJ MARITZ**  
📍 Gauteng, South Africa   
🔗 [LinkedIn](https://www.linkedin.com/in/vukona-jubby-maritz)  



