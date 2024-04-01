Hellow this is Shopping App (spring Boot)
All requests are properly handled(get, post)
Code is explained by appropriate comments
The project Structure be like : (packages)
    1. Controller
        -ShopController
    2. Entity
        - Coupon
        - Stock
        - UserDetails
        - Orders  ---> for transactions
   3. Service
        - CouponService  (interface)
        - CouponServiceImp
        - StockService  (interface)
        - StockServiceImp
        - UserService    (interface)
        - UserServiceImp
        - OrdersService  (interface)
        - OrdersServiceImp
  3. Repository
        - CouponRepository
        - StockRepository
        - UserRepository
        - OrdersRepository
  4. Helper   ---> used to return json objects with specific data
        - Availability
        - EliminateColumns
        - Order
        - OrderRequest
  5. Error  ---> ExceptionHandling
        - ErrorMessage
        - ErrorMessageQuantity
        - ErrorTransactionMessage
        - InvalidCoupon
        - InvalidQuantity
        - OrderIdNotFoundException
        - RestResponseEntityExceptionHandler
        - TransactionFailedException

  Resources --> static ---> class diagram.jpg

![Class diagram](https://github.com/FarhanAli-81/ShoppingApp/assets/123290113/6d351f7f-65bc-447e-93c9-eca9cbaf2824)
