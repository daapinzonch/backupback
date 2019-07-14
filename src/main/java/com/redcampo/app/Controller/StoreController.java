package com.redcampo.app.Controller;

import com.redcampo.app.Entity.Store;
import com.redcampo.app.Service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apistores")
public class StoreController {
    private final StoreService stCon;

    @GetMapping
    public String msg(){
        return "STORE AVAIABLE";
    }

    @GetMapping("/stores")
    public ResponseEntity<List<Store>> findAll(){
        return ResponseEntity.ok(stCon.findAll());
    }

    @PostMapping(path ="/insertdata", consumes = "application/json")
    public ResponseEntity<Long> createStore(@RequestBody Store store) {
        try{
            Long count=stCon.countStores(store.getStoreId());
            if (count==0) {
                stCon.create(store);
                return new ResponseEntity<>(count, HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(count,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>((long) -1,HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/deletedata/{id}")
    public ResponseEntity<Long> deleteStore(@PathVariable(value = "id") Long id) {
        Long count = stCon.countStores(id);
        try{
            if (count==1) {
                stCon.delete(stCon.getStore(id));
                return new ResponseEntity<>(count, HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity<>(count, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity<>((long)-1,HttpStatus.FORBIDDEN);
        }
    }
}
