use project;
CREATE TABLE Customer(
  `id_customer` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `identity_card_number` int(11) NOT NULL,
  `personal_numerical_code` varchar(15) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id_customer`));
  CREATE TABLE Employee(
  `id_employee` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `hire_date` date not null,
  PRIMARY KEY (`id_employee`));
   CREATE TABLE Car(
  `id_car` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `make` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `horse_power` int(11) NOT NULL,
  `fuel_consumption` float(11) NOT NULL,
  `price` float(11) not null,
  PRIMARY KEY (`id_car`));
  CREATE TABLE Contract (
  `id_contract` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `date` date not null,
  `id_car`  int(11) unsigned NOT NULL,
  `id_customer` int(11) unsigned NOT NULL,
  `id_employee` int(11) unsigned NOT NULL,
  `details` varchar(100) not null,
  PRIMARY KEY (`id_contract`),
  FOREIGN KEY (`id_car`) REFERENCES car(`id_car`),
  FOREIGN KEY (`id_customer`) REFERENCES customer(`id_customer`),
  FOREIGN KEY (`id_employee`) REFERENCES employee(`id_employee`));
CREATE TABLE User (
  `id_user` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` varchar(45) not null,
  PRIMARY KEY (`id_user`));
  drop table customer;
  INSERT INTO Customer(id_customer,name,username,identity_card_number,personal_numerical_code,address)
  VALUES('1','Florin Radu','florinradu','346622','1950304124568','str Ciocarliei nr 6'),
		 ('2','Alina Raluca','alinaraluca','234312','2980912568124','str Papura nr 99'),
         ('3','Alin Tomos','alintomos','458790','1901203567312','str Ghencea nr 44');
  INSERT INTO user(id_user,username,password,type)
  VALUES('1','alintomos','abecedar','customer'),
		 ('2','mihneavlad','seful','administrator'),
         ('3','lauramarc','floaredetei','employee'),
         ('4','raulpop','lollol','employee'),
         ('5','florinradu','parola','customer'),
         ('6','alinaraluca','alina','customer');
         drop table employee;
  INSERT INTO Employee(id_employee,name,username,genre,hire_date)
  VALUES('1','Laura Marc','lauramarc','female','1980-02-02'),
		 ('2','Raul Pop','raulpop','male','1981-03-03');
  INSERT INTO Car(id_car,make,model,year,horse_power,fuel_consumption,price)
  VALUES('1','Volskwagen','Passat','2010','140','6.4','9800'),
		 ('2','Audi','A8','2013','170','6.0','12000'),
         ('3','Fiat','Punto','2001','60','4.6','3100'),
         ('4','Ford','Focus','2010','120','6.7','9050');
         drop table contract;
  INSERT INTO Contract(id_contract,date,id_car,id_customer,id_employee)
  VALUES('1','2017-02-15','1','1','1',''),
		 ('2','2017-03-03','2','3','2','');
 

               