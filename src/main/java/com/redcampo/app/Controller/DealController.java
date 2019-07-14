package com.redcampo.app.Controller;

import com.redcampo.app.Service.DealService;
import com.redcampo.app.Service.ProductService;
import com.redcampo.app.Service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apideal")
public class DealController {

    private final DealService deCon;
    private final StoreService stCon;
    private final ProductService prCon;

    @GetMapping()
    public String msg(){
        return "DEALS AVAIABLE";
    }

    /*@PostMapping(path = "/insertdata", consumes = "application/json")
    public ResponseEntity<Deal> create(Long quantity, Long store, Long product){
        Deal deal = new Deal();
        try {
            deal.setDealPrice(product*quantity);
            deal.setProduct(prCon.ProductIdList(product).get(0));
            deal.setStore(stCon.StoreIdList(store).get(0));
            //deCon.create(deal);
            //return new ResponseEntity<>("DEAL CREATED ", HttpStatus.ACCEPTED);
            return new ResponseEntity<Deal>(deal,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Deal>(deal, HttpStatus.BAD_REQUEST);
        }
    }*/
}
