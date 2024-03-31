package com.tenth.Shopping.Controller;

import com.tenth.Shopping.Entity.Coupon;
import com.tenth.Shopping.Entity.Orders;
import com.tenth.Shopping.Entity.Stock;
import com.tenth.Shopping.Entity.UserDetails;
import com.tenth.Shopping.Error.InvalidCoupon;
import com.tenth.Shopping.Error.InvalidQuantity;
import com.tenth.Shopping.Error.OrderIdNotFoundException;
import com.tenth.Shopping.Error.TransactionFailedException;
import com.tenth.Shopping.Helper.Availability;
import com.tenth.Shopping.Helper.EliminateColumns;
import com.tenth.Shopping.Helper.Order;
import com.tenth.Shopping.Helper.OrderRequest;
import com.tenth.Shopping.Service.CouponService;
import com.tenth.Shopping.Service.OrdersService;
import com.tenth.Shopping.Service.StockService;
import com.tenth.Shopping.Service.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private UserService userService;
    @Autowired
    private StockService stockService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private OrdersService ordersService;



    @Autowired
    public ShopController(UserService userService, StockService stockService,
                          CouponService couponService, OrdersService ordersService) {
        this.userService = userService;
        this.stockService = stockService;
        this.couponService = couponService;
        this.ordersService = ordersService;

        insertIntoDataBase(); // insert into database
    }
    //------------------------------------------------------------------------------------------------------------------------------
    public void insertIntoDataBase(){
        Stock st1=Stock.builder().price(140).name("biryani").itemId(1).available(10).build();
        Stock st2=Stock.builder().price(60).name("noodles").itemId(2).available(15).build();

        Coupon c1=Coupon.builder().discount("off20").percentage(20).build();
        Coupon c2=Coupon.builder().discount("off50").percentage(50).build();

        UserDetails u1= UserDetails.builder().userId(1).address("hyderabad").mobile("8886842479").name("Farhan").coupon(c1).build();
        UserDetails u2= UserDetails.builder().userId(2).address("Mumbai").mobile("9999999999").name("Ali").coupon(c2).build();

        Orders o1=Orders.builder().orderId(2).amount(187).coupon("off50").date(LocalDate.parse("2024-03-29")).status("successfull").transactionId("tran010100001").build();
        Orders o2=Orders.builder().orderId(1).amount(250).coupon("off50").date(LocalDate.parse("2024-03-29")).status("successfull").transactionId("tran010100002").build();
        Orders o3=Orders.builder().orderId(2).amount(187).coupon("off20").date(LocalDate.parse("2024-03-29")).status("failed").transactionId("tran010100007").build();



        stockService.save(st1);
        stockService.save(st2);
        ordersService.save(o1);
        ordersService.save(o2);
        ordersService.save(o3);
        couponService.save(c1);
        couponService.save(c2);
        userService.save(u1);
        userService.save(u2);
    }

//--------------------------------------------------------------------------------------------------------------

    // displaying all the users
    @GetMapping("/fetchUsers")
    public List<UserDetails> fetchUsers(){
        List<UserDetails> users=userService.fetchUsers();
        return users;
    }


//--------------------------------------------------------------------------------------------------------------

    /*
       sending data in the request
       extracting data using @RequestParameter
       EXCEPTIONS----
                   if invalid coupon -- raise invalid coupon EXCEPTION
                   if invalid quantity -- raise invalid quantity EXCEPTION
       Order class used to return the data in appropriate format
    */
    @PostMapping("/{userId}/order")
    public Order doOrder(
            @PathVariable("userId") int userId,
            @RequestBody OrderRequest orderRequest
    ) throws InvalidQuantity, InvalidCoupon, TransactionFailedException {


        /*                          To Run (Postman)
        --------------------------------------------------------------------------------------------
           method  : POST
           url     : /1/order
           body    :
                        {
                           "quantity": 10,
                           "coupon": "off20"
                        }

                        {
                           "quantity": 0,
                           "coupon": "off20"
                        }

                        {
                           "quantity": 10,
                           "coupon": "off100"
                        }

             --------------------------------------------------------
             please fire the above bodies
             for invalid orderId exception--> please make changes in 'mock_orderId' below



         */

        int quantity=orderRequest.getQuantity();
        String coupon=orderRequest.getCoupon();


        // returning object
        Order o=new Order();
        Stock stock=stockService.findById(2);


        // Exception Handling -- Quantity
        if(stock.getAvailable()<quantity || quantity<1){
            throw new InvalidQuantity("Invalid quantity");
        }


        // Exception Handling -- Coupon
        UserDetails userDetails=userService.findById(userId);
        if(!userDetails.getCoupon().getDiscount().equals(coupon)){
            throw new InvalidCoupon("Invalid coupon");
        }



        // No exception
        else {
            int mock_orderId=3;                 // CHANGE the values for verifying exception handling
            o.setOrderId(mock_orderId);
            o.setUserId(userId);
            o.setQuantity(quantity);


            // calculating AMOUNT
            int amount = 0;
            if (coupon.equals("off50")) {                   // if coupon -- off50
                amount = stock.getPrice() * quantity / 2;
                o.setAmount(amount);
            }
            if (coupon.equals("off20")) {                   // if coupon -- off20
                amount = stock.getPrice() * quantity / 5;
                o.setAmount(amount);
            }

            o.setCoupon(coupon);





            /* saving the transaction history
               save in orders table
               here transactionId is the primary key
               kindly vary the transaction id for verifying
             */

            Orders os=new Orders();
            if(mock_orderId==3){   // mocking for failed transactions
                os = Orders.builder().orderId(mock_orderId).date(LocalDate.now()).amount(amount).status("failed").coupon(coupon).transactionId("tran010100006").build();
                throw new TransactionFailedException("Payment Failed due to invalid order id", mock_orderId, LocalDate.now(), amount, "failed", coupon, "tran010100006", userId);
            }
            else{
                os = Orders.builder().orderId(mock_orderId).date(LocalDate.now()).amount(amount).status("successfull").coupon(coupon).transactionId("tran010100004").build();
            }

            ordersService.save(os);
        }

        return o;
    }


//--------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/inventory/{qty}")
    public Availability checkQuantity(@PathVariable("qty") int quantiy){


//                 from Object of stock - get available quantity, price
//                  Availability is class to return


        Stock stock=stockService.findById(1);
        Availability av=new Availability();
        av.setAvailable(stock.getAvailable()-quantiy);
        av.setPrice(stock.getPrice());
        av.setOrdered(quantiy);
        return av;
    }


//--------------------------------------------------------------------------------------------------------------
    // FETCHING ALL COUPONS FROM COUPON TABLE
    @GetMapping("/fetchCoupons")
    public List<Coupon>findAll(){
        return couponService.fetchCoupons();
    }

//----------------------------------------------------------------------------------------------------


    // to view all orders with all order ids
    @GetMapping("/orders")
    public List<EliminateColumns> allOrders(){
        return ordersService.allOrders();
    }

//-----------------------------------------------------------------------------------------------------





    // to view orders with GIVEN ORDERiD
    @GetMapping("/orders/{orderId}")
    public List<Orders> ordersWithGivenId( @PathVariable("orderId") int orderId) throws OrderIdNotFoundException {
         return ordersService.findAllOrdersById(orderId);
    }

//------------------------------------------------------------------------------------------------------------


}
