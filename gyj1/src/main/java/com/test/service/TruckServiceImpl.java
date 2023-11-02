package com.test.service;

import com.test.entity.Truck;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckServiceImpl implements TruckService {

    @Override
    public List<String> getTacoTruckNames() {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            String path = this.getClass().getClassLoader().getResource("Mobile_Food_Facility_Permit.csv").getPath();
            String file = path;
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line = br.readLine();

            List<Truck> truckList = new ArrayList<>();
            while (line != null) {
                Truck truck = new Truck();
                truck.setFoodItems(line.split(",")[11]);
                truck.setApplicant(line.split(",")[1]);
                truckList.add(truck);
                line = br.readLine();
            }
            truckList = truckList.stream().filter(item -> item.getFoodItems().contains("taco") ||
                    item.getFoodItems().contains("Taco") ||
                    item.getFoodItems().contains("tacos") ||
                    item.getFoodItems().contains("Tacos")).collect(Collectors.toList());
            return truckList.stream().map(Truck::getApplicant).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
