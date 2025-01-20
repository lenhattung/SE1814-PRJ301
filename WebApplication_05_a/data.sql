-- Tạo cơ sở dữ liệu
CREATE DATABASE Web_05_a;
GO

-- Sử dụng cơ sở dữ liệu
USE Web_05_a;
GO

-- Tạo bảng product
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(50),
    stock_quantity INT DEFAULT 0
);
GO

-- Thêm dữ liệu mẫu
INSERT INTO products (product_id, product_name, price, category, stock_quantity) VALUES
(1, 'Điện thoại iPhone 14', 24990000, 'Điện thoại', 50),
(2, 'Laptop Dell XPS 13', 32900000, 'Laptop', 30),
(3, 'Tai nghe AirPods Pro', 4990000, 'Phụ kiện', 100),
(4, 'Samsung Galaxy S23', 21990000, 'Điện thoại', 45),
(5, 'iPad Air 2022', 15990000, 'Máy tính bảng', 60),
(6, 'Chuột không dây Logitech', 890000, 'Phụ kiện', 150),
(7, 'MacBook Pro M2', 35990000, 'Laptop', 25),
(8, 'Bàn phím cơ Gaming', 1890000, 'Phụ kiện', 80),
(9, 'Màn hình Dell 27"', 7990000, 'Màn hình', 40),
(10, 'Loa Bluetooth JBL', 2490000, 'Âm thanh', 70);
GO