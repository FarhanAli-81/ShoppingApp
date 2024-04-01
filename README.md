# Shopping App (Spring Boot)

## Overview
This project is a Shopping App built using Spring Boot. All requests are properly handled (GET, POST), and the code is well-commented for easy understanding.

## Project Structure (Packages)
### 1. Controller
- `ShopController`

### 2. Entity
- `Coupon`
- `Stock`
- `UserDetails`
- `Orders` (for transactions)

### 3. Service
- `CouponService` (interface)
- `CouponServiceImp`
- `StockService` (interface)
- `StockServiceImp`
- `UserService` (interface)
- `UserServiceImp`
- `OrdersService` (interface)
- `OrdersServiceImp`

### 4. Repository
- `CouponRepository`
- `StockRepository`
- `UserRepository`
- `OrdersRepository`

### 5. Helper
- `Availability`
- `EliminateColumns`
- `Order`
- `OrderRequest`

### 6. Error (Exception Handling)
- `ErrorMessage`
- `ErrorMessageQuantity`
- `ErrorTransactionMessage`
- `InvalidCoupon`
- `InvalidQuantity`
- `OrderIdNotFoundException`
- `RestResponseEntityExceptionHandler`
- `TransactionFailedException`

## Resources
- **Static**
    - [Class Diagram](https://github.com/FarhanAli-81/ShoppingApp/assets/123290113/6d351f7f-65bc-447e-93c9-eca9cbaf2824)
## Database
   'h2 database' --> Application Properties
