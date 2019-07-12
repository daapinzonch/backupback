package com.redcampo.app.Controller;

import com.redcampo.app.Entity.Deal;
import com.redcampo.app.Entity.Product;
import com.redcampo.app.Entity.User;
import com.redcampo.app.Service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apideal")
public class DealController {

    private final DealService deCon;

    @GetMapping()
    public String msg(){
        return "DEALS AVAIABLE";
    }

    @PostMapping(path = "/insertdata", consumes = "application/json")
    public ResponseEntity<Deal> create(User user, Product product, Deal deal){
        long price = deal.getDealQuantity()*product.getProductPrice();
        deal.setDealPrice(price);
        deal.setProduct(product);
        deal.setUser(user);
        //deCon.create(deal);
        //return new ResponseEntity<>("DEAL CREATED ", HttpStatus.ACCEPTED);
        return new ResponseEntity<Deal>(deal,HttpStatus.CREATED);
        /*try {
            long price = 110*product.getProductPrice();
            Deal deal = new Deal();
            deal.setDealQuantity(quantity);
            deal.setDealPrice(price);
            deal.setProduct(product);
            deal.setUser(user);
            deCon.create(deal);
            return new ResponseEntity<>("DEAL CREATED "+ quantity, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("SOMETHING WRONG HAPPENED", HttpStatus.BAD_REQUEST);
        }*/
    }
}
