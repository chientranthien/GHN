**Calculate order fee**
----
Forward the request to logistic vendors such as Giao Hang Nhanh or Giao Hang Tiet Kiem. Then response the estimated fee.
* **URL**
 /v1/orders/fee

* **Method:**
  `POST`
 

* **Data Params**

   ```
   {
    
    "pickupDistrictId': alphanumeric | NOT NULL,
    
    "dropDistrictId": alphanumeric | NOT NULL,
    
    "weight": integer | OPTIONAL | IN GRAM,
    
    "vendorId": integer | OPTIONAL
    
    }
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `{
                      "success": true,
                      "message": "",
                      "totalFee": 18000
                  }`
 

* **Sample Call:**

    ``` 
    curl -X POST \
      http://localhost:8080/v1/orders/fee \
      -H 'content-type: application/json' \
      -H 'postman-token: 1e0967c9-13c4-009c-b458-f4dda9a3cd09' \
      -d '{ "pickupDistrictId":"006", "dropDistrictId":"007"}'
* **Notes:**


**Book shipping pick up for order**
----
Create a booking for shipping based on new order with logistic vendor such as Giao Hang Nhanh or Giao Hang Tiet Kiem. Then store order into database
* **URL**
 /v1/orders

* **Method:**
  `PUT`
 

* **Data Params**

```{
 	"orderProducts": array | NOT NULL
 	[
 	 	{
 	 		"productId": integer | NOT NULL,
 	 		"quantity": integer | NOT NULL
 	 	}
 	 	
 	],
     "order": object | NOT NULL
     {
        "fromPerson": alphanumeric | NOT NULL,
        "pickupAddress": alphanumeric | NOT NULL,
        "pickupDistrictId": alphanumeric | NOT NULL,
        "pickupTel": alphanumeric | NOT NULL,
        "cod": integer | NOT NULL,
        "toPerson": alphanumeric | NOT NULL,
        "dropAddress": alphanumeric | NOT NULL,
        "dropDistrictId": alphanumeric | NOT NULL,
        "dropTel": alphanumeric | NOT NULL,
         
        "dropEmail":alphanumeric | OPTIONAL,
        "isFreeship": boolean | OPTIONAL,
        "vendorId": integer | OPTIONAL,
        "value": integer | OPTIONAL,
        "note": alphanumeric | OPTIONAL
     }
 }
 ```
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `{
                      "success": true,
                      "totalFee": 18000,
                      "vendorOrderId": "S78169.853420",
                      "supplierOrderMessage": ""
                  }`
 

* **Sample Call:**

    ``` 
    curl -X PUT \
      http://localhost:8080/v1/orders \
      -H 'cache-control: no-cache' \
      -H 'content-type: application/json' \
      -H 'postman-token: ca0c3874-3b2e-c272-a1d1-f5abc103740e' \
      -d '{
        "orderProducts":[
            {
                "productId":1,
                "quantity":1
            },
            {
                "productId":2,
                "quantity":3
            }
        ],
        "order": {
            "fromPerson": "Trần Thiện Chiến",
            "pickupAddress": "590 CMT8 P.11",
            "pickupDistrictId":"006",
            "pickupTel": "0911222333",
            "cod": 47000,
            "toPerson": "Chiến Trần THiện",
            "dropAddress": "123 nguyễn chí thanh",
            "dropDistrictId":"007",
            "dropTel": "0911222333",
            
            "dropEmail":"example@gmail.com",
            "isFreeship":true,
            "vendorId":1,
            "value": 3000000,
            "note": "Khối lượng tính cước tối đa: 1.00 kg"
        }
    }'
* **Notes:**


**GET ORDER STATUS**
----
Forward the request to logistic vendors such as Giao Hang Nhanh or Giao Hang Tiet Kiem. Then response the order status.
* **URL**
 /v1/orders/:vendorOrderId/status

* **Method:**
  `GET`
 

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `{
                      "orderId": 5,
                      "name": "Chưa tiếp nhận",
                      "lastUpdatedDate": "2017-08-05 18:19:01"
                  }`
 

* **Sample Call:**

    ``` 
    curl -X GET \
      http://localhost:8080/v1/orders/S78169.853420/status
* **Notes:**


**GET ALL PROVINCE**
----
* **URL**
 /v1/provinces

* **Method:**
  `GET`
 

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": "01",
                          "name": "Hà Nội"
                      },
                      {
                          "id": "02",
                          "name": "Hà Giang"
                      }...]`
 

* **Sample Call:**

    ``` 
    curl -X GET \
      http://localhost:8080/v1/provinces
* **Notes:**

**GET DISTRICTS BY PROVINCEID**
----
* **URL**
 /v1/districts

* **Method:**
  `GET`
 
* **Params:**
  `provinceId: alphanumeric`
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": "001",
                          "name": "Ba Đình"
                      },
                      {
                          "id": "002",
                          "name": "Hoàn Kiếm"
                      }...]`
 

* **Sample Call:**

    ``` 
    curl -X GET \
      'http://localhost:8080/v1/districts?provinceId=01'
* **Notes:**

**ACTIVATE ORDER**
----
* **URL**
 /v1/order/{id}/activate

* **Method:**
  `GET`
 

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `{
                          "success": true,
                          "message": "the Order was activated and forwarded to the vendor"
                   }
                     `
 

* **Sample Call:**

    ``` 
    curl -X GET \
      'http://localhost:8080/v1/order/1/activate'
* **Notes:**

**EDIT ORDER**
----
* **URL**
 /v1/order/{id}

* **Method:**
  `GET`
 

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `{
                          "success": true,
                          "message": "the Order was activated and forwarded to the vendor"
                   }
                     `
 

* **Sample Call:**

    ``` 
    curl -X GET \
      'http://localhost:8080/v1/order/1/activate'
* **Notes:**