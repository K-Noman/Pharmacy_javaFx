


select * from sales;
select * from purchase;
select * from stock;
select * from company;




--call update price procedure 
CALL UPDATE_price(34,1);






-- inner join 

-- to check the profit per medicine
SELECT
    stock.PRODUCT_ID,purchase.p_name,purchase.selling_price - purchase.cost_price "Profit", purchase.company_id,stock.stock
FROM
    stock
INNER JOIN purchase ON
 stock.PRODUCT_ID = purchase.PRODUCT_ID;


--product left in stock 
--outere join

SELECT
    distinct sales.product_id ,sales.product_name,stock.stock"Product Stock Left"
FROM
    sales
LEFT  JOIN stock ON
    stock.product_id = sales.product_id;
    
    
-- number of product sold   Functions

SELECT  sales.product_id,sales.product_name , 
  
  SUM(sales.quantity)"PRODUCT SOLD"  
  
  FROM sales 
  
  GROUP BY  sales.product_id,
  sales.product_name
  
  order by  sales.product_id;
















-- EMPLOYEE TABLE

CREATE TABLE EMP 
   (	"EMPID" NUMBER, 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"MOBILE" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   )  ;

--SALES TABLE

  CREATE TABLE SALES 
   (	"PRODUCT_ID" VARCHAR2(50 BYTE), 
	"DOSE" VARCHAR2(20 BYTE) DEFAULT 1, 
	"QUANTITY" NUMBER(20,2), 
	"PRICE" NUMBER(10,2), 
	"AMMONT" NUMBER(30,2), 
	"PRODUCT_NAME" VARCHAR2(120 BYTE)
   ) ;
   

  CREATE OR REPLACE  TRIGGER SALE_SUCCESS 
AFTER INSERT ON SALES 
FOR EACH ROW 
BEGIN

UPDATE stock   
SET stock.stock = (stock.stock - :NEW.Quantity)
WHERE stock.Product_id =( :NEW.Product_id);


END;


---STOCK TABLE

  CREATE TABLE STOCK
   (	"PRODUCT_ID" VARCHAR2(20 BYTE), 
	"PRODUCT_NAME" VARCHAR2(20 BYTE), 
	"SELLING_PRICE" VARCHAR2(20 BYTE), 
	"COMPANY_ID" VARCHAR2(20 BYTE), 
	"STOCK" VARCHAR2(20 BYTE), 
	 CONSTRAINT "STOCK_PURCHASE_FK1" FOREIGN KEY ("PRODUCT_ID");
   
   
 -- purchase table
 
 
 
  CREATE TABLE PURCHASE
   (	"PRODUCT_ID" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"P_NAME" VARCHAR2(50 BYTE), 
	"COST_PRICE" NUMBER(20,2), 
	"SELLING_PRICE" NUMBER(20,2), 
	"EXPIRY_DATE" VARCHAR2(20 BYTE), 
	"PRODUCTION_DATE" VARCHAR2(20 BYTE), 
	"PLACE" VARCHAR2(20 BYTE), 
	"NO_PACK" NUMBER, 
	"Q_IN_ONEPACK" NUMBER, 
	"QUANTITY" VARCHAR2(20 BYTE), 
	"COMPANY_ID" NUMBER, 
	 CONSTRAINT "PURCHASE_PK" PRIMARY KEY ("PRODUCT_ID")
 
 	 CONSTRAINT "PURCHASE_COMPANY_FK1" FOREIGN KEY ("COMPANY_ID")
   );



  CREATE OR REPLACE  TRIGGER PURCHASE_SUCCESSFULL
AFTER UPDATE ON PURCHASE 
FOR EACH ROW 

DECLARE
 Valied NUMBER;
BEGIN
   select Count(product_ID) into Valied FROM stock where product_id= :NEW.Product_id;
   IF Valied > 0 THEN
   UPDATE stock
   SET stock.Stock= stock.stock + (:NEW.Quantity)
   WHERE Product_id= :NEW.Product_id;
   
ELSE
   INSERT INTO stock (PRODUCT_ID, PRODUCT_NAME, SELLING_PRICE, COMPANY_ID, STOCK) 
   VALUES (:NEW.product_ID,:NEW.P_NAME,:NEW.SELLING_PRICE,:NEW.COMPANY_ID ,:New.QUANTITY );

  
   END IF;
END;
/




ALTER TRIGGER PURCHASE_SUCCESSFULL ENABLE;

  CREATE OR REPLACE TRIGGER AFTER_INSERT_PURCHASE
AFTER insert ON PURCHASE 
FOR EACH ROW 

BEGIN
  
   INSERT INTO stock (PRODUCT_ID, PRODUCT_NAME, SELLING_PRICE, COMPANY_ID, STOCK) 
   VALUES (:NEW.product_ID,:NEW.P_NAME,:NEW.SELLING_PRICE,:NEW.COMPANY_ID ,:New.QUANTITY );

END;

ALTER TRIGGER AFTER_INSERT_PURCHASE ENABLE;





-- After insert Purchase 
create or replace 
TRIGGER AFTER_INSERT_PURCHASE
AFTER insert ON PURCHASE 
FOR EACH ROW 

BEGIN
  
   INSERT INTO stock (PRODUCT_ID, PRODUCT_NAME, SELLING_PRICE, COMPANY_ID, STOCK) 
   VALUES (:NEW.product_ID,:NEW.P_NAME,:NEW.SELLING_PRICE,:NEW.COMPANY_ID ,:New.QUANTITY );

END;



--PURCHASE_SUCCESSFULL 

create or replace 
TRIGGER PURCHASE_SUCCESSFULL 
AFTER UPDATE ON PURCHASE 
FOR EACH ROW 

DECLARE
 Valied NUMBER;
BEGIN
   select Count(product_ID) into Valied FROM stock where product_id= :NEW.Product_id;
   IF Valied > 0 THEN
   UPDATE stock
   SET stock.Stock= stock.stock + (:NEW.Quantity)
   WHERE Product_id= :NEW.Product_id;
   
ELSE
   INSERT INTO stock (PRODUCT_ID, PRODUCT_NAME, SELLING_PRICE, COMPANY_ID, STOCK) 
   VALUES (:NEW.product_ID,:NEW.P_NAME,:NEW.SELLING_PRICE,:NEW.COMPANY_ID ,:New.QUANTITY );
END IF;
END;


-- SALE_SUCCESS
create or replace 
TRIGGER SALE_SUCCESS 
AFTER INSERT ON SALES 
FOR EACH ROW 
BEGIN


UPDATE stock   
SET stock.stock = (stock.stock - :NEW.Quantity)
WHERE stock.Product_id =( :NEW.Product_id);
END;




   