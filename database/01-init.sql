-- Script pour base du TP 1
CREATE TABLE CUSTOMER (
   CUSTOMER_ID INTEGER PRIMARY KEY NOT NULL,
   DISCOUNT_CODE CHARACTER(1) NOT NULL,
   ZIP VARCHAR(10) NOT NULL,
   NAME VARCHAR(30),
   ADDRESSLINE1 VARCHAR(30),
   ADDRESSLINE2 VARCHAR(30),
   CITY VARCHAR(25),
   STATE CHARACTER(2),
   PHONE CHARACTER(12),
   FAX CHARACTER(12),
   EMAIL VARCHAR(40),
   CREDIT_LIMIT INTEGER ) ;

INSERT INTO CUSTOMER
values(
1,'N','95117','Jumbo Eagle Corp','111 E. Las Olivas Blvd','Suite 51','Fort Lauderdale','FL','305-555-0188','305-555-0189','jumboeagle@example.com',100000
);
INSERT INTO CUSTOMER
values(
2,'M','95035','New Enterprises','9754 Main Street','P.O. Box 567','Miami','FL','305-555-0148','305-555-0149','www.new.example.com',50000
);
INSERT INTO CUSTOMER
values(
25,'M','85638','Wren Computers','8989 Red Albatross Drive','Suite 9897','Houston','TX','214-555-0133','214-555-0134','www.wrencomp.example.com',25000
);
INSERT INTO CUSTOMER
values(
3,'L','12347','Small Bill Company','8585 South Upper Murray Drive','P.O. Box 456','Alanta','GA','555-555-0175','555-555-0176','www.smallbill.example.com',90000
);
INSERT INTO CUSTOMER
values(
36,'H','94401','Bob Hosting Corp.','65653 Lake Road','Suite 2323','San Mateo','CA','650-555-0160','650-555-0161','www.bobhostcorp.example.com',65000
);
INSERT INTO CUSTOMER
values(
106,'L','95035','Early CentralComp','829 E Flex Drive','Suite 853','San Jose','CA','408-555-0157','408-555-0150','www.centralcomp.example.com',26500
);
INSERT INTO CUSTOMER
values(
149,'L','95117','John Valley Computers','4381 Kelly Valley Ave','Suite 77','Santa Clara','CA','408-555-0169','408-555-0167','www.johnvalley.example.com',70000
);
INSERT INTO CUSTOMER
values(
863,'N','94401','Big Network Systems','456 444th Street','Suite 45','Redwood City','CA','650-555-0181','650-555-0180','www.bignet.example.com',25000
);
INSERT INTO CUSTOMER
values(
777,'L','48128','West Valley Inc.','88 Northsouth Drive','Building C','Dearborn','MI','313-555-0172','313-555-0171','www.westv.example.com',100000
);
INSERT INTO CUSTOMER
values(
753,'H','48128','Zed Motor Co','2267 NE Michigan Ave','Building 21','Dearborn','MI','313-555-0151','313-555-0152','www.parts@ford.example.com',5000000
);
INSERT INTO CUSTOMER
values(
722,'N','48124','Big Car Parts','52963 Notouter Dr','Suite 35','Detroit','MI','313-555-0144','313-555-0145','www.bparts.example.com',50000
);
INSERT INTO CUSTOMER
values(
409,'L','10095','Old Media Productions','4400 527th Street','Suite 562','New York','NY','212-555-0110','212-555-0111','www.oldmedia.example.com',10000
);
INSERT INTO CUSTOMER
values(
410,'M','10096','Yankee Computer Repair Ltd','9653 211th Ave','Floor 4','New York','NY','212-555-0191','212-555-0197','www.nycompltd@repair.example.com',25000
);

CREATE TABLE DISCOUNT (
   CODE CHARACTER(1) PRIMARY KEY  NOT NULL,
   RATE DECIMAL(4,2) ) ;

INSERT INTO DISCOUNT (
CODE, RATE )
VALUES
('H',16),
('M',11),
('L',7),
('N',0)
;

CREATE TABLE MICRO_MARKET (
   ZIP_CODE VARCHAR(10) PRIMARY KEY  NOT NULL,
   RADIUS FLOAT(26),
   AREA_LENGTH DOUBLE PRECISION,
   AREA_WIDTH DOUBLE PRECISION ) ;

INSERT INTO MICRO_MARKET (
ZIP_CODE, RADIUS, AREA_LENGTH, AREA_WIDTH )
VALUES
('95051',2.5559E2,6.89856E2,4.78479E2),
('94043',1.57869E2,3.85821E2,1.47538E2),
('85638',7.58648E2,3.28963E2,4.82164E2),
('12347',4.75965E2,3.85849E2,1.46937E2),
('94401',3.68386E2,2.85848E2,1.73794E2),
('95035',6.83396E2,4.72859E2,3.79757E2),
('95117',7.55778E2,5.47967E2,4.68858E2),
('48128',6.84675E2,4.75854E2,4.08074E2),
('48124',7.53765E2,4.87664E2,4.56632E2),
('10095',1.987854E3,9.75875E2,8.65681E2),
('10096',1.876766E3,9.55666E2,9.23556E2)
;

ALTER TABLE CUSTOMER ADD CONSTRAINT FOREIGNKEY_DISCOUNT FOREIGN KEY
( DISCOUNT_CODE )
        REFERENCES DISCOUNT ( CODE ) ON UPDATE no action
ON DELETE no action;

ALTER TABLE CUSTOMER ADD CONSTRAINT FOREIGNKEY_ZIP FOREIGN KEY ( ZIP )
        REFERENCES MICRO_MARKET ( ZIP_CODE ) ON UPDATE no action ON
DELETE no action;

