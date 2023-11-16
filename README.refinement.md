# Sūpāmāketto Kata

## Introduction 

In the new way Coding Dojo we aim to not only cover the basics and small examples but also a real project. What I have prepared is an extension to the supermarket kata.  

## How it works? 

We provide the developers with the TTD knowledge and now it is team to simulate the real life project and how to tackle a project by following TDD. In all sessions we will start with reading the User stories and comprehend them. If it is needed or if they have any ambiguity they have to ask it from the sensei. In the Coding Dojo sensei has the role of PO as well. 

1 .In this katas we are not just practicing TDD, we try to Making the stories as clear as possible and following SOLID principles  

## Project Definition and user stories 

We are trying to build an online store called MediaMarktPlus.   

#### Roles 

- Customer: the end user who use this system to buy electronics. For this sprint we assume we will have just one customer. 

- Employee: people who work for MediaMarktplus, for this sprint Authentication and Authorization is not needed 

#### Project Architecture: 

![architecture description](mediamarkapi.png)

## User Stories 

### User story 1

The users should be able to get the products information by calling an API endpoint. 

The request should be a Get Method with no parameter and should return a list of products. 

response:
```json
{ 
    "status": string = "success"/"error",
    "message": string = "" on success, error_message on error.
    "result": [
        { 
            "product_id": int, 
            "name": string, 
            "price": float, 
            "description": string, 
            "is_available": bool 
        }, 
        ... 
    ]
} 
```
#### **More info:**
- The route for this request should be should be https://example.com/api/product/List (GET)
- Implementing the routing is not a part of this story.

#### **Prerequisits:**
- all responsese are wraped in an object and converted to Json, We need to have a method to generate this wrapper object.

```json
{ 
    "status": string = "success"/"error",
    "message": string = "" on success, error_message on error.
    "result": [
        { 
            ...
        }, 
        ... 
    ]
} 
```
- A database/Static Datasource is needed to store the product data.

#### **Tasks:**
- Create the Get Method which Calls the Database/Static Datasource, pass the result to the wrapper and return the JSON result.

#### **DOD:**
- when the database/Static Datasource is empty the result list is also empty.
- when the database/Static Datasource has one product it should return that one product.
- when the database/Static Datasource has two products it should return that two products.

---

### User story 2: 

Customers should be able to send a request to the server and add an item to cart. 

Customer should send the `product_id:int` and `quantity:int` to the endpoint and will get `true`/`false` from server.

#### **More info:**
- The route for this request should be should be https://example.com/api/Cart/Add (POST)
- Implementing the routing is not a part of this story.

#### **Prerequisits:**
- A database/Static Datasource is needed to store the cart data and ProductData.
- Geting Items from Cart should have been implemented first.

#### **Tasks:**
- Create the AddToCart Method with the given description. the result should be wrapped into the response result structur(JSON format).

#### **DOD:**
- The Cart database/Static Datasource shold be empty first.
- when Cart database/Static Datasource has one product it should return that one product with the same QTY.
- when Cart database/Static Datasource has two products it should return that two productswith the same QTYs.
- If the request parameters is should not accept null.
- If the productID doent exists in the Product DataBase/Data Source, it should return error with message "The product you want to add to cart is not correct".
- When the QTY the request is less than 1, it should return error with message "You need to atleast ad one item to the Cart".

---

### User story 3: 

Customers should be able to remove an item from the cart and get `true`/`false` from server as response.

#### **More info:**
- In this sprint by deleting an Item re remove it regardless of the QTY. 
- The route for this request should be should be https://example.com/api/Cart/Remove/{Id} (DELETE)
- Implementing the routing is not a part of this story.

#### **Prerequisits:**
- A database/Static Datasource is needed to store the cart data and ProductData.
- Geting Items from Cart should have been implemented first.

#### **Tasks:**
- Create the RemoveFromCart Method with the given description. the result should be wrapped into the response result structur(JSON format).

#### **DOD:**
- The Cart database/Static Datasource shold be empty first.
- After adding an Item to the Cart database/Static Datasource, it should have one product in Cart.
- After adding an Item to the Cart database/Static Datasource, and then delete it, it should be empty.
- After adding two Item to the Cart database/Static Datasource, and then delete one of them, the cart should have one item and exatly the one item we didnt delete.
- when Cart database/Static Datasource is empty, by trying to delete, is should return false with this error message "The cart is empty".
- when trying to delete from the cart with ProductId doesnt exist in the cart,is should return false with this erroR message "This item doent exist on yout cart".

---

### User story 4: 

Customers should be able to get the list of items he has in the cart. 

response: 
```json
{ 
    "status": string = "success"/"error",
    "message": string = "" on success, error message on error.
    "result": { 
        "total_price": float,
        "total_quantity": int,
        "products": [
            { 
                "product_id": int, 
                "name": string,
                "quantity": int, 
                "total_price": float 
            },
            ... 
        ]
    }
}
```

#### **More info:**
- The route for this request should be should be https://example.com/api/Cart/List (GET)
- Implementing the routing is not a part of this story.

#### **Prerequisits:**
- A database/Static Datasource is needed to store the cart data and ProductData.

#### **Tasks:**
- Create the GetCartList Method with the given description. the result should be wrapped into the response result structur(JSON format).

#### **DOD:**
- All DOD for Add and Delete

---

### User story 5: 

Customers should be able to request an order to buy all the item. System should check if all items exist in the store first and then process the request. No Payment needed for this sprint. On success the cart should be emptied. 

response: 
```json
{ 
    "status": string = "success"/"error",
    "message": string = "" on success, error message on error.
    "result": { 
        "total_price": float,
        "total_quantity": int,
        "products": [
            { 
                "product_id": int, 
                "name": string,
                "quantity": int, 
                "total_price": float 
            },
            ... 
        ]
    }
}
```

#### **More info:**
- The route for this request should be should be https://example.com/api/Order/Confirm (POST)
- Implementing the routing is not a part of this story.

#### **Prerequisits:**
- A database/Static Datasource is needed to store the cart data and ProductData.
- Stories related to Product should be done first.
- Stories related to Cart should be done first.

#### **Tasks:**
- Create the Order Method with the given description. the result should be wrapped into the response result structur(JSON format).
- If Any of the product Items isnet available it should return the following response: 
```json
{ 
    "status": string = "error",
    "message": string = "The following items Arte not available anymore please remove them from your cart and try again."
    "result": { 
        "total_price": float,
        "total_quantity": int,
        "products": [
            { 
                "product_id": int, 
                "name": string,
                "quantity": int, 
                "total_price": float 
            },
            ... 
        ]
    }
}

```

#### **DOD:**
- If the cart is empty it should rewurt an error with message "You need to add item to your cart first, then order it!"
- When the Cart has 1 item and it is not available it should return the error with correct TotalPrice and TodatQTY for the unavailable item. 
- When the Cart has 2 items and 1 of them is not available it should return the error with correct TotalPrice and TodatQTY for the unavailable item. 
- When the Cart has 3 items and 2 of them is not available it should return the error with correct TotalPrice and TodatQTY for the unavailable items. 
- When the Cart has 1 item and it is  available it should return the response with correct TotalPrice and TodatQTY for the the item. 
- When the Cart has 2 items both are available it should return the response with correct TotalPrice and TodatQTY for all items. 

---

### User story 6: 

After processing an order, System should automatically send a request to the Company if any item’s quantity goes bellow a threshold.

- this story needs to refine again.


#### **More info:**

#### **Prerequisits:**

#### **Tasks:**

#### **DOD:**

---

### User story 7: 

Employees should be able to Add/Edit products. The products should have a threshold for ordering automatically. If the `quantity` of a product goes below the threshold system should send a rest request to server to order.

suggested end point names: 

- https://example.com/api/ItemManagement/Add
- https://example.com/api/ItemManagement/edit
- https://example.com/api/ItemManagement/List
- https://example.com/api/product/List
- https://example.com/api/Cart/Add
- https://example.com/api/Cart/Remove/{Id}
- https://example.com/api/Cart/List
- https://example.com/api/Order/Confirm


#### **More info:**
- the threshold related is not clear and need to be refined.
- he route for this request should be should be https://example.com/api/ItemManagement/Add (Post)
- he route for this request should be should be https://example.com/api/ItemManagement/Edit (Put)
- Implementing the routing is not a part of this story, we need another story for it. story should have one main objective not more.


#### **Prerequisits:**
- A database/Static Datasource is needed to store the cart data and ProductData.

#### **Tasks:**
- Add product method should accept a product object and return the productID.
```json
{ 
    "name": string, 
    "price": float, 
    "description": string, 
    "is_available": bool 
}

- Edit product method should accept a product object and return the true or false.
```json
{ 
    "product_id": int, 
    "name": string, 
    "price": float, 
    "description": string, 
    "is_available": bool 
}
```

#### **DOD:**
For Add:
- if the product name is duplicated it shoyuld return an error with message "You have entered a duplicate name for this product, please check it again"

For Edit:
- it the productid doent exist it should return error with message "The product Id doesnt exists".
- if the new name is duplicated with other product names it should retun an erro rwith message "You have entered a duplicate name for this product, please check it again"

For both:
- all properties in the product object are not nullable.
- the price should me greater that 1, otherwise it should return erro rwith message "The QTY should be at lease 1."

---

## Plan For Sessions 

### Session 0 

As Bart suggested it would be nice to have a preparation session before the first session to check the connectivity, development environment, etc. 

### Session 1 

Talking about the basics of Coding dojo, and TDD. Then start with Stake kata. 

### Session 2 

Start working on the project and setup the project structure.  

Read the user stories and change the order.  

1. ItemManagement endpoints 
2. Product Endpoint 
3. Cart Endpoint 
4. Order Endpoint 

Start developing ItemManagement, save and edit files from an static object. 

### Session 3 

Start with Explaining how to Mock against ORMs. 

Change the static object to ORM. 

Complete the development of ItemManagement and Product endpoint if it is possible. 

### Session 4 

Continue working on the Cart endpoint. 

Think about the options how to Mock Http clients and try to continue with the code.

### Session 5 

Complete the project and do the refactoring. 

### Session 6 

Create a service layer and move the code from the controller to the service layer. 

### Session 7 

Cover mutation testing and write one Integration testing using in memory hosts such as WebApplicationFactory 

 