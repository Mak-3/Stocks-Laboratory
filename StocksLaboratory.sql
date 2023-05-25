create database stocks_laboratory;
use stocks_laboratory;

CREATE TABLE users(
  id INT PRIMARY KEY auto_increment,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  profile_picture varchar(1024),
  balance bigint default 1000000
);

CREATE TABLE indian_stock_transaction(
  id INT PRIMARY KEY auto_increment,
  user_id INT NOT NULL,
  stock_symbol VARCHAR(10) NOT NULL,
  transaction_type ENUM('buy', 'sell') NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  shares INT NOT NULL,
  transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE american_stock_transaction(
  id INT PRIMARY KEY auto_increment,
  user_id INT NOT NULL,
  stock_symbol VARCHAR(10) NOT NULL,
  transaction_type ENUM('buy', 'sell') NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  shares INT NOT NULL,
  transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE indian_stock_portfolio (
  id INT PRIMARY KEY auto_increment,
  user_id INT NOT NULL,
  stock_symbol VARCHAR(10) NOT NULL,
  shares_owned INT NOT NULL,
  purchase_price DECIMAL(10,2) NOT NULL,
  current_price DECIMAL(10,2) NOT NULL,
  purchase_date DATE NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE american_stock_portfolio (
  id INT PRIMARY KEY auto_increment,
  user_id INT NOT NULL,
  stock_symbol VARCHAR(10) NOT NULL,
  shares_owned INT NOT NULL,
  purchase_price DECIMAL(10,2) NOT NULL,
  current_price DECIMAL(10,2) NOT NULL,
  purchase_date DATE NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE pending_order (
  id INT PRIMARY KEY auto_increment,
  user_id INT NOT NULL,
  stock_symbol VARCHAR(10) NOT NULL,
  order_type ENUM('buy', 'sell') NOT NULL,
  shares INT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  status ENUM('pending', 'filled') NOT NULL DEFAULT 'pending',
  created_at TIMESTAMP DEFAULT NOW(),
  FOREIGN KEY (user_id) REFERENCES users(id)
);
  
CREATE TABLE stock_watchlist (
    id INT primary key AUTO_INCREMENT,
    symbol VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by int,
    foreign key(created_by) references users(id)
);
       





