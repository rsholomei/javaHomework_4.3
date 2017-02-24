CREATE TABLE Car(
                Car_ID   INT NOT NULL AUTO_INCREMENT,
                Wheels_ID INT (20),
                Engine_ID INT (20),
                PRIMARY KEY (Car_ID)
        );

CREATE TABLE Engine(
                Engine_ID   INT NOT NULL AUTO_INCREMENT,
                EngineСapacity DOUBLE (20) NOT NULL,
                PRIMARY KEY (Engine_ID)
        );

CREATE TABLE SummerTyres(
                SummerTyres_ID   INT NOT NULL AUTO_INCREMENT,
                SizeTyres INT (20) NOT NULL,
                NameTyres VARCHAR (20) NOT NULL,
                PRIMARY KEY (SummerTyres_ID)
        );

CREATE TABLE WinterTyres(
                WinterTyres_ID   INT NOT NULL AUTO_INCREMENT,
                SizeTyres INT (20) NOT NULL,
                NameTyres VARCHAR (20) NOT NULL,
                PRIMARY KEY (WinterTyres_ID)
        );

CREATE TABLE Wheels(
                Wheels_ID   INT NOT NULL AUTO_INCREMENT,
                WinterTyres_ID INT (20),
                SummerTyres_ID INT (20),
                PRIMARY KEY (Wheels_ID)
        );