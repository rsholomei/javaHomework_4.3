package com.geekhub;

import com.geekhub.config.AppConfig;
import com.geekhub.dao.CarDao;
import com.geekhub.dao.EngineDao;
import com.geekhub.dao.TyresDao;
import com.geekhub.dao.WheelsDao;
import com.geekhub.model.Car;
import com.geekhub.model.Engine;
import com.geekhub.model.Tyres;
import com.geekhub.model.Wheels;
import org.junit.After;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringJdbcTest {

    @Autowired
    private CarDao carDao;
    @Autowired
    private EngineDao engineDao;
    @Autowired
    private TyresDao tyresDao;
    @Autowired
    private WheelsDao wheelsDao;

    private Car car;
    private Engine engine;
    private Tyres tyres;
    private Wheels wheels;

    @Before
    public void init(){
        tyres = new Tyres(23, "Matador");
        wheels = new Wheels(1L);
        engine = new Engine(5D);
        car = new Car("BMW", 1L, 1L);
    }

    @After
    public void tearDown(){
        tyres = null;
        wheels = null;
        engine = null;
        car = null;
    }

    @Test
    public void сar_dao_test(){
        carDao.saveCar(car);
        Car car1 = new Car();
        car1.setNameCar("Volvo");
        carDao.saveCar(car1);
        assertEquals("BMW", carDao.findCarById(1).getNameCar());
        carDao.updateCar(1, 7, 5);
        assertEquals(7L, (long)carDao.findCarById(1).getWheelId());
        assertEquals(1, carDao.getAllCar().size());
        assertNotNull(carDao.getAllCar());
        assertTrue(1 == carDao.getAllCar().size());
    }

    @Test
    public void EngineDaoTest(){
        engineDao.saveEngine(engine);
        assertTrue(5 == engineDao.findEngineById(1).getEngineСapacity());
        engineDao.updateEngineById(1, new Engine(7D));
        assertTrue(7 == engineDao.findEngineById(1).getEngineСapacity());
        assertEquals(1, engineDao.getAllEngine().size());
        assertNotNull(engineDao.getAllEngine());
        assertTrue(1 == engineDao.getAllEngine().size());
    }

    @Test
    public void TyresDaoTest(){
        tyresDao.saveTyres(tyres);
        assertEquals("Matador", tyresDao.findTyresById(1).getName());
        tyresDao.updateTyres(1, "Barum");
        assertEquals("Barum", tyresDao.findTyresById(1).getName());
        assertEquals(1, tyresDao.getAllTyres().size());
        assertNotNull(tyresDao.getAllTyres());
        assertTrue(1 == tyresDao.getAllTyres().size());
    }

    @Test
    public void WheelsDaoTest(){
        wheelsDao.saveWheels(wheels);
        assertTrue(1 == wheelsDao.findWheelsById(1).getTyresId());
        assertEquals(1, wheelsDao.getAllWheels().size());
        assertNotNull(wheelsDao.getAllWheels());
        assertTrue(1 == wheelsDao.getAllWheels().size());
    }
}
