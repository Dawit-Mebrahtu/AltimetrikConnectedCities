package com.altimetrik.connectedcities.connectedcities.serviceimpl;

import com.altimetrik.connectedcities.connectedcities.ConnectedcitiesApplication;
import com.altimetrik.connectedcities.connectedcities.service.CitiesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesServiceImplementation implements CitiesService {

    @Override
    public boolean isConnected(String origin, String destination) {
        List<List<String>> result = new ArrayList<>();

        for(List<String> pair: ConnectedcitiesApplication.connectedCities){
            if(pair.contains(origin)){
                result.add(pair);
                int index = pair.indexOf(origin)==0?1:0;
                List<String> res = search(pair.get(index));
                if( res != null)
                    result.add(res);
            }
        }

        for (List<String> pair: result){
            if(pair.contains(destination))
                return true;
        }
        return false;
    }

    private List<String> search(String connected){
        for(List<String> pair: ConnectedcitiesApplication.connectedCities) {
            if (pair.contains(connected))
                return pair;
        }
        return null;
    }
}
