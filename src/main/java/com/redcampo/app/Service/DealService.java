package com.redcampo.app.Service;

import com.redcampo.app.Entity.Deal;
import com.redcampo.app.Repository.DealRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealService {
    private final DealRepo dealRepo;

    public List<Deal> findAll(){
        return dealRepo.findAll();
    }

    public Deal create(Deal de){
        return dealRepo.save(de);
    }

    public void delete(Deal de) { dealRepo.delete(de); }
}
