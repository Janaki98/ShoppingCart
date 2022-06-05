	create table PRODUCTS
	(
	  productId int AUTO_INCREMENT PRIMARY KEY,
	  productName VARCHAR(255) not null,
	  price float not null,
	  CartId int,
	  id int,
	  FOREIGN KEY (CartId) REFERENCES Cart(CartId),
	  FOREIGN KEY (id) REFERENCES Books(id)
	);
	CREATE TABLE Cart (
		    CartId int NOT NULL,
		    productId int,
		    PRIMARY KEY (CartId),
		    FOREIGN KEY (productId) REFERENCES products(productId)
		);

		Create table Books(
	id INT NOT NULL auto_increment,
	genre VARCHAR(255),
	author VARCHAR(255) NOT NULL,
	publications VARCHAR(255) NOT NULL,
                productId int,
                PRIMARY KEY (id),
	FOREIGN KEY (productId) REFERENCES products(productId)
);


INSERT INTO `products` (`productId`, `productName`, `price`, `productQnty`, `bookId`)
VALUES
	('success',150,'50',2);

