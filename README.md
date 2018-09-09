# Spring Boot with Redis as Database and Cache

Redis is an open source in-memory data structure store, used as a database, cache and message broker

It supports data structures such as strings, hashes, lists, sets, sorted sets, etc

# Prerequisites

    Install Redis and Start Redis Server(https://redis.io/download)

# Redis Database

    For the Database, this example uses HashOperations. It is a redis construct, which can be used for reds hash operations. 
    If you would like to see what are the different operations provided by spring data redis, 
    please a look at the spring data redis documentation

# Redis Cache

 - @EnableCaching - Enable Caching on Spring Boot Application
 - @Cacheable - Cache the select operation queries. Used with @GetMapping
 - @CachePut - Update the Cache. Used with @PutMapping
 - @CacheEvict - Delete the Cache. Used with @DeleteMapping
