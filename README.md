## A simple KV Storage support Transaction 

High level idea: 

- hashmap to maintain the kv storage
- a local hashmap and a list to support functionaility of session
- static field to make sure Transaction

Drawback
- low Isolation Level: READ COMMIITED



![alt text](/images/image.png)
![alt text](/images/image2.png)

![alt text](/images/image-1.png)

![alt text](/images/image3.png)