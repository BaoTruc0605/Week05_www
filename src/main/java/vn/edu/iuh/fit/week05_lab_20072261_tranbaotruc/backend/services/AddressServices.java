package vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.models.Address;
import vn.edu.iuh.fit.week05_lab_20072261_tranbaotruc.backend.repository.AddressRepository;

@Service
public class AddressServices {
    @Autowired
    private AddressRepository addressRepository;



    public void addAddress(Address address){
        addressRepository.save(address);
    }

}
