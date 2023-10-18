package com.marie.butterflymxserver.domain.resident.services;

import com.marie.butterflymxserver.domain.core.exceptions.ResourceCreationException;
import com.marie.butterflymxserver.domain.core.exceptions.ResourceNotFoundException;
import com.marie.butterflymxserver.domain.resident.models.Resident;

import java.util.List;

public interface ButterflyMxService {
    Resident create (Resident resident) throws ResourceCreationException;
    Resident getById(Long Id) throws ResourceCreationException;
    Resident getByEmail (String email) throws ResourceNotFoundException;
    List<Resident> getAll();

    Resident update(Long Id, Resident resident) throws
            ResourceNotFoundException;

    void delete(Long Id);
}
