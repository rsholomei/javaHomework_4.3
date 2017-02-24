package com.geekhub;

import com.geekhub.config.AppConfig;
import com.geekhub.dao.CarDao;
import com.geekhub.model.Car;
import com.geekhub.model.Engine;
import com.geekhub.model.Tyres;
import com.geekhub.model.Wheels;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = new Car();
        car.setWheel(0);
        car.setEngine(0);

        CarDao service = ctx.getBean(CarDao.class);
        service.saveCar(new Car(0, 5));
        service.saveCar(new Car(0,6));
        List<Car> list = service.getAllCar();
        for (Car myCar : list) {
            System.out.print(myCar.getWheel() + " ");
            System.out.println(myCar.getEngine());
        }

        ctx.close();
    }
}
