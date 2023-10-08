SELECT product_name FROM netology.customers JOIN netology.orders
ON customers.id = orders.customer_id where name ILIKE :name;