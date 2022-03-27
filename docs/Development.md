# [Karthikeya T] Microservices Masterclass with Spring Boot and Spring Cloud [ENG, 2020...2022]

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

### 09. CreatingProductList

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

<br/><br/>

---

<br/>

**Marley**

Any questions in english: <a href="https://javadev.org/chat/">Telegram Chat</a>  
Любые вопросы на русском: <a href="https://javadev.ru/chat/">Телеграм чат</a>
