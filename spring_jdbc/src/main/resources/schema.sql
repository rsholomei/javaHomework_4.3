CREATE TABLE Car(
                Car_ID   INT NOT NULL AUTO_INCREMENT,
                NameCar VARCHAR (20) NOT NULL,
                Wheels_ID INT (20) NOT NULL,
                Engine_ID INT (20) NOT NULL,
                PRIMARY KEY (Car_ID)
        );

CREATE TABLE Engine(
                Engine_ID   INT NOT NULL AUTO_INCREMENT,
                EngineСapacity DOUBLE (20) NOT NULL,
                PRIMARY KEY (Engine_ID)
        );

CREATE TABLE Tyres(
                Tyres_ID   INT NOT NULL AUTO_INCREMENT,
                SizeTyres INT (20) NOT NULL,
                NameTyres VARCHAR (20) NOT NULL,
                PRIMARY KEY (Tyres_ID)
        );

CREATE TABLE Wheels(
                Wheels_ID   INT NOT NULL AUTO_INCREMENT,
                Tyres_ID VARCHAR (20),
                PRIMARY KEY (Wheels_ID)
        );