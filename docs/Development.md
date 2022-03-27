# [Karthikeya T] Microservices Masterclass with Spring Boot and Spring Cloud [ENG, 2020...2022]


<br/>

## 02. 

<br/>

Eclipse + STS -> New -> Other -> Spring Boot -> Spring Starter Project

<br/>

https://projectlombok.org/setup/eclipse


https://projectlombok.org/setup/gradle


<br/>

![Application](/img/ch02-pic01.png?raw=true)


<br/>

![Application](/img/ch02-pic02.png?raw=true)


<br/>

### 08. CreatingProductService

<br/>

```
$ ./gradlew bootRun
```

<br/>

```
// GET
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8001/product/details/101 \
    | jq
```

<br/>

**response:**

```
{
  "productId": 101,
  "productName": "iPhone",
  "productDesc": "iPhone is damn expensive!",
  "productPrice": 999,
  "productStock": true
}
```

<br/>

### 09. CreatingProductList

<br/>

```
// GET http://localhost:8001/product/details/102
// GET http://localhost:8001/product/details/103
```

<br/>

### 10. CreatingPricingService

<br/>

```
// GET
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8002/price/101 \
    | jq
```

<br/>

**response:**

```
{
  "priceId": 201,
  "productId": 101,
  "originalPrice": 1999,
  "discountedPrice": 999
}
```

<br/>

### 11. CreatingInventoryService


<br/>

```
// GET
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8003/inventory/101 \
    | jq
```

<br/>

**response:**

```
{
  "inventoryId": 301,
  "productId": 101,
  "isStock": true
}
```

<br/>

### 12. MakingRestTemplateCalls

<br/>

```
// GET
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8001/product/details/102 \
    | jq
```

<br/>

**response:**

```
{
  "productId": 102,
  "productName": "Book",
  "productDesc": "Book is great!",
  "productPrice": 19,
  "productStock": true
}
```


<br/>

### 13. CurrencyExchangeService

<br/>

```
// GET
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8001/product/details/102 \
    | jq
```

<br/>

**response:**

```
{
  "productId": 102,
  "productName": "Book",
  "productDesc": "Book is great!",
  "productPrice": 1995,
  "productStock": true
}
```

<br/>

### 14.-15. FixingABug

<br/><br/>

---

<br/>

**Marley**

Any questions in english: <a href="https://javadev.org/chat/">Telegram Chat</a>  
Любые вопросы на русском: <a href="https://javadev.ru/chat/">Телеграм чат</a>
