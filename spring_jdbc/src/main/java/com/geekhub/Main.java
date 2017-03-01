package com.geekhub;

import com.geekhub.config.AppConfig;
import com.geekhub.dao.CarDao;
import com.geekhub.dao.WheelsDao;
import com.geekhub.model.Car;
import com.geekhub.model.Wheels;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = new Car();
        car.setWheelId(0);
        car.setEngineId(5);

        Car car1 = new Car();
        car1.setWheelId(1);
        car1.setEngineId(8);

        Car car2 = new Car();
        car2.setWheelId(0);
        car2.setEngineId(6);

        Wheels wheels = new Wheels();
        wheels.setTyres(8L);

        Wheels wheels2 = new Wheels();
        wheels2.setTyres(88L);

        CarDao service = ctx.getBean(CarDao.class);
        service.saveCar(car);
        service.saveCar(car1);
        service.saveCar(car2);

        WheelsDao wheelsDao = ctx.getBean(WheelsDao.class);
        wheelsDao.saveWheels(wheels);
        wheelsDao.saveWheels(wheels2);
        List<Car> list = service.getAllCar();
        for (Car myCar : list) {
            Wheels wheels1 = wheelsDao.getAllWheels().get(myCar.getWheelId());
            System.out.println(wheels1.toString());
            System.out.println(myCar.getEngineId());
        }

        ctx.close();
    }
}
