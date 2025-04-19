package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public void registerDriver(Driver driver) {
        if (driver != null && driver.getDriverId() > 0) {
            driverRepository.addDriver(driver);
        } else {
            System.out.println(" Invalid Driver Details. Cannot Register.");
        }
    }

    public List<Driver> fetchAllDrivers() {
        return driverRepository.getAllDrivers();
    }

    public void modifyDriver(Driver driver) {
        if (driver != null && driver.getDriverId() > 0) {
            driverRepository.updateDriver(driver);
        } else {
            System.out.println(" Invalid Driver Details. Cannot Update.");
        }
    }

    public void removeDriver(int driverId) {
        if (driverId > 0) {
            driverRepository.deleteDriver(driverId);
        } else {
            System.out.println("Invalid Driver ID. Cannot Delete.");
        }
    }
}



