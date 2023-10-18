package com.marie.butterflymxserver.domain.resident.services;

import com.marie.butterflymxserver.domain.core.exceptions.ResourceCreationException;
import com.marie.butterflymxserver.domain.core.exceptions.ResourceNotFoundException;
import com.marie.butterflymxserver.domain.resident.models.Resident;
import com.marie.butterflymxserver.domain.resident.repos.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ButterflyMxServiceImpl implements ButterflyMxService{
    private ResidentRepository residentRepository;

    @Autowired
    public ButterflyMxServiceImpl(ResidentRepository residentRepository){this.residentRepository =  residentRepository;}

    @Override
    public Resident create(Resident resident) throws ResourceCreationException {
        Optional<Resident> optional = residentRepository.findByEmail(resident.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Resident with email exists" + resident.getEmail());
        resident = residentRepository.save(resident);
        return resident;
    }

    @Override
    public Resident getById(Long Id) throws ResourceCreationException {
        Resident resident = residentRepository.findById(Id)
                .orElseThrow(()->new ResourceNotFoundException("No Resident with id: " + Id));
        return resident;
    }

    @Override
    public Resident getByEmail(String email) throws ResourceNotFoundException {
        Resident resident = residentRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("No Resident with email: " + email));
        return resident;
    }

    @Override
    public List<Resident> getAll() {
        return residentRepository.findAll();
    }

    @Override
    public Resident update(Long Id, Resident residentDetail) throws ResourceNotFoundException {
        Resident resident = getById(Id);
        resident.setFirstName(residentDetail.getFirstName());
        resident.setLastName(residentDetail.getLastName());
        resident.setEmail(residentDetail.getEmail());
        resident = residentRepository.save(resident);
        return resident;
    }

    @Override
    public void delete(Long Id) {
        Resident resident = getById(Id);
        residentRepository.delete(resident);

    }
}
