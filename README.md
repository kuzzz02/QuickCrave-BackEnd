# QuickCrave-BackEnd

## Environments
- Springboot
- MYSQL
- Docker (an option for packaging back-end codes)


## Back-End File Structure
```
|- src
|   |- main
|       |- java
|           |- config
|           |- model
|           |- mapper
|           |- service
|           |- controller
|           |- middleware
|           |- utility
|           |- QuickCraveBackEndApplication
|       |- resources
|           |- mapper
|           |- sql
|           |- static
|           |- application.properties
|- .gitignore
|- compose.yaml
|- Pom.xml
```

- `src`: source code
- `main`: main development
- `config`: config, mainly databaseConfig
- `model`: database tables model
- `mapper`: mapping model control to mapper.xml
- `service`: smallest unit to control a model
- `controller`: forward requests from front-end to service
- `middleware`: middleware, mainly AliPayController
- `utility`: utility, mainly Response widget used in Controllers
- `resources`: static resources
- `sql`: sql files
- `static`: images
- `QuickCraveBackEndApplication`: main application
- `application.properties`: root config of main application
- `.gitignore`: git ignore unnecessary files
- `compose.yaml`: MYSQL settings integrated with Docker
- `Pom.xml`: Dependency config and management


## MYSQL configuration

- create database
```
create database qcdb;
create user 'qc'@'%' identified by 'qc123456';
grant all on qcdb.* to 'qc'@'%';
```

- initialize database
```
mysql -u qc -p
```

- data directory
```
sql files  -> QuickCrave-BackEnd/src/main/resources/sql
static images  -> QuickCrave-BackEnd/src/main/resources/static
```

- initialize tables
```
source *.sql
```


## Start Back-End 

- start project
```
mvn package
java -jar QuickCrave-BackEnd-1.0.0.jar
```
- if any dependency problems occurred
```
mvn dependency:resolve
```

## Cloud Server address
- https://8.130.37.157:12581/

---

## Database Design

Database designing follows rule of **Try best to abstract and handle every possible property in models**


- `user`,`vendor`,`delivery`: three models all extend a `base` model  
    1. id
    2. name
    3. password
    4. email
    5. phone
    6. address
    7. state
    8. date
    9. portrait
    10. description
    11. image
- special for `vendor` model  
    1. category
    2. time (business time)
    3. fee (delivery fee)
    4. quantity (sales score)  


- `goods`: goods model  
    1. id
    2. name
    3. description
    4. image
    5. number (remaining goods number)
    6. price
    7. discount
    8. vendor_id (foreign key)


- `orders`: orders model  
    1. id
    2. orders_id (unique id for every order)
    3. goods_id
    4. user_id
    5. vendor_id
    6. delivery_id
    7. state
    8. date
    9. address
    10. phone
    11. payment
    12. total


## Interface Design

Interfaces designing follows rule of **model -> mapper -> service -> controller**  
You can use `Postman` or other tools to test interfaces if needed.


- Common Controllers
    1. selectAll: `/selectAll`  
       * @type: `GET`
    2. selectByName: `/selectByName`  
       * @type: `GET`
       * @param {String} name
    3. selectById: `/selectById`  
       * @type: `GET`
       * @param {Long} id
    4. deleteAll: `/deleteAll`
       * @type: `DELETE`
    5. delete: `/delete`  
       * @type: `DELETE`
       * @param {Long} id
    6. updateXXX: `/updateXXX`  
       * @type: `PUT`
       * @param {Long} id
       * @param {String} XXX  (update functions for every single property, so please change XXX if needed)


- `user`,`vendor`,`delivery`: similiar models introduce similiar methods
  interface address: `/user`,`/delivery`  
    1. insert: `/insert`  
        * @type: `POST`
        * @param {String} name
        * @param {String} password
    2. login: `/login`  
        * @type: `POST`  
        * @BODY {String} name
        * @BODY {String} password
    3. singup: `/signup`  
        * @type: `POST`  
        * @BODY {String} name
        * @BODY {String} password
        * @BODY {String} phone
        * @BODY {String} address


- `/vendor`
  interface address: `/vendor`
    1. insert: `/insert`  
       * @type: `POST`
       * @param {String} name
       * @param {String} password
       * @param {String} phone
       * @param {String} address
       * @param {String} portrait
       * @param {String} description
       * @param {String} image
       * @param {String} category
    2. login: `/login`  
        * @type: `POST`
        * @BODY {String} name
        * @BODY {String} password
    3. singup: `/signup`  
        * @type: `POST`
        * @BODY {String} name
        * @BODY {String} password
        * @BODY {String} phone
        * @BODY {String} address
        * @BODY {String} portrait
        * @BODY {String} description
        * @BODY {String} image
        * @BODY {String} category


- `goods`  
  interface address: `/goods`
    1. insert: `/insert`
       * @type: `POST`
       * @param {String} name
       * @param {String} description
       * @param {String} image
       * @param {String} number
       * @param {String} price
       * @param {String} discount
       * @param {Long} vendor_id


- `orders`  
  interface address: `/orders`
    1. insert: `/insert`  
       * @type: `POST`
       * @param {String} orders_id
       * @param {String} goods_id
       * @param {long} user_id
       * @param {Long} vendor_id
       * @param {Long} delivery_id
       * @param {String} state
       * @param {String} date
       * @param {String} address
       * @param {String} phone
       * @param {String} payment
       * @param {String} total
    2. selectByOrdersID : `/selectByOrdersID`  
       * @type: `GET`
       * @param {String} orders_id


- `image`  
  interface address: `/image`  
  * @type: `GET`  
  * @param {String} imageName
    1. getVendorimage: `/vendor`
    2. getGoodsimage: `/goods`
    3. getUserimage: `/user`
    4. getDeliveryimage: `/delivery`


- `fileupload`  
  interface address: `/files`  
  * @type: `POST`  
  * @param {file} file
    1. uploadVendorimage: `/vendor`
    2. uploadGoodsimage: `/goods`
    3. uploadUserimage: `/user`
    4. uploadDeliveryimage: `/delivery`


## TODO
   1. Params -> JSON Body
   2. Authentication-token
   3. Authorization-RoleController(admin,user,guest)
   4. NOSQL: MongoDB, Redis -> Concurrent control
   5. Docker deployment
   6. CI/CD

