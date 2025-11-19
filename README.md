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
- JDBC

## Project Structure
src/ 
├── model/ → Product classes <br>
├── data/ → Database access <br>
├── controller/ → Logic layer <br>
├── exceptions/ → Custom exceptions <br> 
├── gui/ 


## How to Run
1. Clone the repo  
2. Open in NetBeans  
3. Create MySQL database `productsaledb`  
4. Run the SQL below to create and populate the table  
5. Run `MainForm.java` to launch the app

## Database Setup
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

## Screenshots
coming soon


